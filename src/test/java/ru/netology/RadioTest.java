package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    public void shoudSwitchToNextRadioStation() {
        //Radio radio = new Radio(7); //set max radio station
        /*
         check next at max radio station
         */
        Radio radioMax = new Radio(5, 5, 1,1);
        radioMax.nextRadioStation(radioMax.getRadioStation());
        int actual = radioMax.getRadioStation();
        int expected = 0;
        assertEquals(expected, actual);

        /*
         check next in the middle radio station
         */
        Radio radioMiddle = new Radio(3,12,1,1);
        radioMiddle.nextRadioStation(radioMiddle.getRadioStation());
        actual = radioMiddle.getRadioStation();
        expected = 4;
        assertEquals(expected, actual);

        /*
         check next at min radio station
         */
        Radio radioMin = new Radio(0,4,1,1);
        radioMin.nextRadioStation(radioMin.getRadioStation());
        actual = radioMin.getRadioStation();
        expected = 1;
        assertEquals(expected, actual);

        /*
         check next under min radio station
         */
        Radio radio3 = new Radio(-2,200,1,1);
        radio3.setMaxRadioStation(0 -2);
        radio3.nextRadioStation(radio3.getRadioStation());
        actual = radio3.getRadioStation();
        expected = -2;
        assertEquals(expected, actual);

        /*
         check next over max radio station
         */
        Radio radio2 = new Radio(12,11,1,1);
        radio2.setMaxRadioStation(radio2.getMaxRadioStation() + 1);
        radio2.nextRadioStation(radio2.getRadioStation());
        actual = radio2.getRadioStation();
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shoudSwitchToPreviousRadioStation() {
        /*
         check next at max radio station
         */
        Radio radioMax = new Radio(13,13,1,1);
        int expected = radioMax.getRadioStation() - 1;
        radioMax.previousRadioStation(radioMax.getRadioStation());
        int actual = radioMax.getRadioStation();
        assertEquals(expected, actual);

      /*
         check next in the middle radio station
         */
        Radio radioMiddle = new Radio(3,14,1,1);
        radioMiddle.previousRadioStation(radioMiddle.getRadioStation());
        actual = radioMiddle.getRadioStation();
        expected = 2;
        assertEquals(expected, actual);

        /*
         check next at min radio station
         */
        Radio radioMin = new Radio(0,11,1,1);
        radioMin.previousRadioStation(radioMin.getRadioStation());
        actual = radioMin.getRadioStation();
        expected = radioMin.getMaxRadioStation();
        assertEquals(expected, actual);

        /*
         check next under min radio station
         */
        Radio radio2 = new Radio(-2,11,1,1);
        expected = radio2.getRadioStation();
        radio2.nextRadioStation(radio2.getRadioStation());
        actual = radio2.getRadioStation();
        assertEquals(expected, actual);

        /*
         check next over max radio station

         */
        Radio radio3 = new Radio(15,9,1,1);
        radio3.nextRadioStation(radio3.getRadioStation());
        actual = radio3.getRadioStation();
        expected = 15;
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
         */
        radio.setRadioStation(radio.getMaxRadioStation()+1);
        actual = radio.getRadioStation();
        assertEquals(expexted,actual);

           /*
        Set radio station under min
         */
        radio.setRadioStation(-1);
        actual = radio.getRadioStation();
        assertEquals(expexted,actual);
    }

    @Test
    public void shoudAddVolume() {
        /*
        check volume at max
         */
        Radio radiomax = new Radio(50,50);
        int expected = radiomax.getMaxVolume();
        radiomax.addSomeNoize(radiomax.getVolume());
        int actual = radiomax.getVolume();
        assertEquals(expected, actual);

          /*
        check volume in the middle
         */
        Radio radioMiddle = new Radio(50,200);
        expected = 51;
        radioMiddle.addSomeNoize(radioMiddle.getVolume());
        actual = radioMiddle.getVolume();
        assertEquals(expected, actual);

           /*
        check volume under min

         */
        Radio radio2 = new Radio(-1,100);
        expected = 0;
        radio2.addSomeNoize(radio2.getVolume());
        actual = radio2.getVolume();
        assertEquals(expected, actual);

         /*
        check volume at min

         */
        Radio radioMin = new Radio(0,150);
        expected = 1;
        radioMin.addSomeNoize(radioMin.getVolume());
        actual = radioMin.getVolume();
        assertEquals(expected, actual);

        /*
        check volume over max
         */
        Radio radio3 = new Radio(150,100);
        expected = 150;
        radio3.addSomeNoize(radio3.getVolume());
        actual = radio3.getVolume();
        assertEquals(expected,actual);
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
       expected = 48;
       radio.removeSomeNoize(radio.getVolume());
       actual = radio.getVolume();
       assertEquals(expected, actual);

           /*
        check volume at max

         */
       radio.setMaxVolume(100);
       radio.setVolume(radio.getMaxVolume());
       expected = radio.getMaxVolume() - 1;
       radio.removeSomeNoize(radio.getVolume());
       actual = radio.getVolume();
       assertEquals(expected, actual);

          /*
        check volume over max

         */
       radio.setVolume(radio.getMaxVolume() + 1);
       expected = 98;
       radio.removeSomeNoize(radio.getVolume());
       actual = radio.getVolume();
       assertEquals(expected, actual);

       /*
       check maxVolume under minVolume
        */
       Radio radio1 = new Radio();
       radio1.setMaxVolume(-2);
       expected = 0;
       radio1.removeSomeNoize(radio1.getVolume());
       actual = radio1.getVolume();
       assertEquals(expected,actual);

    }

}