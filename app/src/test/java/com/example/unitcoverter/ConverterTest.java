package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterTest {
    @Test
    public void fahrenheit_conversion_isCorrect() {
        assertEquals(0.0, Converter.toCelcius(32),0.01);
    }

    @Test
    public void pounds_conversion_isCorrect(){
        assertEquals(0.45359237, Converter.toKG(1), 0.01);
    }

    @Test
    public void miles_to_kilometers_isCorrect(){
        assertEquals(1.60934, Converter.toKilom(1), 0.01);
    }

    @Test
    public void feet_to_meters_isCorrect(){
        assertEquals(0.3048, Converter.toMet(1), 0.01);
    }
}