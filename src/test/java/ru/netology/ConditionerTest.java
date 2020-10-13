package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {
    @Test
public void shouldGetAndSet() {
    Conditioner conditioner = new Conditioner();
    String expected = "Кондишн";

    assertNull(conditioner.getName());
    conditioner.setName(expected);
    assertEquals(expected, conditioner.getName());
}
    @ParameterizedTest
    @CsvSource(
            value= {
                    "10,10,20,11,1",//curentTemp = minTemp
                    "15,10,20,20,6",//curentTemp = between min and max Temp/ 6 iterations
                    "21,10,20,0,1",//curentTemp = не описано в требованиях поведение, если current>max
                    "9,10,20,0,1",//curentTemp = не описано в требованиях поведение, если current<min
                    "20,10,20,20,1"//curentTemp = maxTemp
            }
    )
    void shouldIncreaseCurrentTemperature (int currentTemperature, int minTemperature, int maxTemperature, int expected, int count){
        Conditioner conditioner = new Conditioner();
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setMinTemperature(minTemperature);
        conditioner.setCurrentTemperature(currentTemperature);

        int actual=0;
        for (int i = 0; i < count; i++) {
            conditioner.increaseCurrentTemperature();
            actual = conditioner.getCurrentTemperature();
            System.out.println(actual);
        }


        assertEquals(expected,actual);

    }

@ParameterizedTest
@CsvSource(
            value= {
                    "10,10,20,10,1",//curentTemp = minTemp
                    "15,10,20,10,6",//curentTemp = between min and max Temp/ 6 iterations
                    "25,10,20,0,1",//curentTemp = не описано в требованиях поведение, если current>max
                    "9,10,20,0,1",//curentTemp = не описано в требованиях поведение, если current<min
                    "20,10,20,19,1",//curentTemp = maxTemp
            }
    )
void shouldDecreaseCurrentTemperature (int currentTemperature, int minTemperature, int maxTemperature, int expected, int count){
    Conditioner conditioner = new Conditioner();
    conditioner.setMaxTemperature(maxTemperature);
    conditioner.setMinTemperature(minTemperature);
    conditioner.setCurrentTemperature(currentTemperature);

    int actual=0;
    for (int i = 0; i < count; i++) {
        conditioner.decreaseCurrentTemperature();
        actual = conditioner.getCurrentTemperature();
        System.out.println(actual);
    }


    assertEquals(expected,actual);

}

}
