package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    public void shoudSwitchToNextRadioStation() {
        Radio radio = new Radio(7); //set max radio station
        /*
         check next at max radio station
         */
        radio.setRadioStation(radio.getMaxRadioStation());
        radio.nextRadioStation(radio.getRadioStation());
        int actual = radio.getRadioStation();
        int expected = 0;
        assertEquals(expected, actual);

        /*
         check next in the middle radio station
         */
        radio.setRadioStation(3);
        radio.nextRadioStation(radio.getRadioStation());
        actual = radio.getRadioStation();
        expected = 4;
        assertEquals(expected, actual);

        /*
         check next at min radio station
         */
        radio.setRadioStation(0);
        radio.nextRadioStation(radio.getRadioStation());
        actual = radio.getRadioStation();
        expected = 1;
        assertEquals(expected, actual);

        /*
         check next under min radio station
         Работает не корректно из-за возврата 0 в сетерах
         */
        radio.setRadioStation(-2);
        radio.nextRadioStation(radio.getRadioStation());
        actual = radio.getRadioStation();
        expected = 1;
        assertEquals(expected, actual);

        /*
         check next over max radio station
         Работает не корректно из-за возврата 0 в сетерах
         */
        radio.setRadioStation(radio.getMaxRadioStation() + 1);
        radio.nextRadioStation(radio.getRadioStation());
        actual = radio.getRadioStation();
        expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shoudSwitchToPreviousRadioStation() {
        Radio radio = new Radio(15); //set max radio station
        /*
         check next at max radio station
         */
        radio.setRadioStation(radio.getMaxRadioStation());
        int expected = radio.getRadioStation() - 1;
        radio.previousRadioStation(radio.getRadioStation());
        int actual = radio.getRadioStation();
        assertEquals(expected, actual);

      /*
         check next in the middle radio station
         */
        radio.setRadioStation(3);
        radio.previousRadioStation(radio.getRadioStation());
        actual = radio.getRadioStation();
        expected = 2;
        assertEquals(expected, actual);

        /*
         check next at min radio station
         */
        radio.setRadioStation(0);
        radio.previousRadioStation(radio.getRadioStation());
        actual = radio.getRadioStation();
        expected = radio.getMaxRadioStation();
        assertEquals(expected, actual);

        /*
         check next under min radio station
         Работает не корректно из-за возврата 0 в сетерах
         */
        radio.setRadioStation(-2);
        radio.nextRadioStation(radio.getRadioStation());
        actual = radio.getRadioStation();
        expected = radio.getMaxRadioStation();
        assertEquals(expected, actual);

        /*
         check next over max radio station
         Работает не корректно из-за возврата 0 в сетерах

         */
        radio.setRadioStation(radio.getMaxRadioStation() + 1);
        radio.nextRadioStation(radio.getRadioStation());
        actual = radio.getRadioStation();
        expected = radio.getMaxRadioStation();
        assertEquals(expected, actual);
    }

    @Test
    public void canSetRadioStation(){
        Radio radio = new Radio();

        /*
        Set radio station between min & max
         */

        radio.setRadioStation(5);
        int expexted = 5;
        int actual = radio.getRadioStation();
        assertEquals(expexted,actual);

        /*
        Set radio station over max
        Работает не корректно из-за возврата 0 в сетерах
         */
        radio.setRadioStation(radio.getMaxRadioStation());
        expexted = 0;
        actual = radio.getRadioStation();
        assertEquals(expexted,actual);

           /*
        Set radio station under min
        Работает не корректно из-за возврата 0 в сетерах
         */
        radio.setRadioStation(-1);
        expexted = 0;
        actual = radio.getRadioStation();
        assertEquals(expexted,actual);
    }

    @Test
    public void shoudAddVolume() {
        Radio radio = new Radio();
        /*
        check volume at max
         */
        radio.setVolume(radio.getMaxVolume());
        int expected = radio.getMaxVolume();
        radio.addSomeNoize(radio.getVolume());
        int actual = radio.getVolume();
        assertEquals(expected, actual);

          /*
        check volume in the middle
         */
        radio.setVolume(50);
        expected = 51;
        radio.addSomeNoize(radio.getVolume());
        actual = radio.getVolume();
        assertEquals(expected, actual);

           /*
        check volume under min

         */
        radio.setVolume(-1);
        expected = 1;
        radio.addSomeNoize(radio.getVolume());
        actual = radio.getVolume();
        assertEquals(expected, actual);

         /*
        check volume at min

         */
        radio.setVolume(0);
        expected = 1;
        radio.addSomeNoize(radio.getVolume());
        actual = radio.getVolume();
        assertEquals(expected, actual);
    }

   @Test
    public void shoudRemoveVolume() {
       Radio radio = new Radio();
        /*
        check volume at min
         */
       radio.setVolume(0);
       int expected = 0;
       radio.removeSomeNoize(radio.getVolume());
       int actual = radio.getVolume();
       assertEquals(expected, actual);

          /*
        check volume in the middle
         */
       radio.setVolume(50);
       expected = 49;
       radio.removeSomeNoize(radio.getVolume());
       actual = radio.getVolume();
       assertEquals(expected, actual);

           /*
        check volume under min

         */
       radio.setVolume(-1);
       expected = 0;
       radio.removeSomeNoize(radio.getVolume());
       actual = radio.getVolume();
       assertEquals(expected, actual);

           /*
        check volume at max

         */
       radio.setVolume(radio.getMaxVolume());
       expected = radio.getMaxVolume() - 1;
       radio.removeSomeNoize(radio.getVolume());
       actual = radio.getVolume();
       assertEquals(expected, actual);

          /*
        check volume over max

         */
       radio.setVolume(radio.getMaxVolume() + 1);
       expected = 0;
       radio.removeSomeNoize(radio.getVolume());
       actual = radio.getVolume();
       assertEquals(expected, actual);
    }

}