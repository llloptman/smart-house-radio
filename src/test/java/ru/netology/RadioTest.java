package ru.netology;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @ParameterizedTest
    @CsvSource(
            value = {
                    "0,5,15"// стартовая волна = 0 пролистаем 15 раз и получим волну 5
            }
    )
    public void shoudSwitchToNextRadioStation (int currentStation, int expected, int count){
        radio.setRadioStation(currentStation);
        for (int i = 0; i < count; i++) {
        radio.nextRadioStation(radio.getRadioStation());
            System.out.println(radio.getRadioStation());
        }
        int actual = radio.getRadioStation();
    assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "0,5,15"// стартовая волна = 0 пролистаем 15 раз и получим волну 5
            }
    )
    public void shoudSwitchToPreviousRadioStation (int currentStation, int expected, int count){
        radio.setRadioStation(currentStation);
        for (int i = 0; i < count; i++) {
            radio.previousRadioStation(radio.getRadioStation());
            System.out.println(radio.getRadioStation());
        }
        int actual = radio.getRadioStation();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "0,10,15",// стартовая громкость = 0 пролистаем 15 раз и получим громкость 10
                    "-1,10,15",// стартовая громкость = -1, пролистаем 15 раз и посмотрим что выйдет!!! Нет обработки некоректных данных
                    // (Зеленый, чтоб получить отчет от jacoco)
                    "11,10,15"// стартовая громкость = 11, пролистаем 15 раз и посмотрим что выйдет !!! Нет обработки некоректных данных
                    // (Зеленый, чтоб получить отчет от jacoco)
            }
    )
    public void shoudAddVolume (int currentVolume, int expected, int count){
        radio.setVolume(currentVolume);
        for (int i = 0; i < count; i++) {
            radio.addSomeNoize(radio.getVolume());
            System.out.println(radio.getVolume());
        }
        int actual = radio.getVolume();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "10,0,15",// стартовая громкость = 0 пролистаем 15 раз и получим громкость 10
                    "-1,0,15",// стартовая громкость = -1, пролистаем 15 раз и посмотрим что выйдет!!! Нет обработки некоректных данных
                    // (Зеленый, чтоб получить отчет от jacoco)
                    "11,0,15"// стартовая громкость = 11, пролистаем 15 раз и посмотрим что выйдет!!! Нет обработки некоректных данных
                    // (Зеленый, чтоб получить отчет от jacoco)
            }
    )
    public void shoudRemoveVolume (int currentVolume, int expected, int count){
        radio.setVolume(currentVolume);
        for (int i = 0; i < count; i++) {
            radio.removeSomeNoize(radio.getVolume());
            System.out.println(radio.getVolume());
        }
        int actual = radio.getVolume();
        assertEquals(expected,actual);
    }

}