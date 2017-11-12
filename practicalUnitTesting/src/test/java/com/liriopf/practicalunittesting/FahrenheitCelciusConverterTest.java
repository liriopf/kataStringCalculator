package com.liriopf.practicalunittesting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest {
	
	public static Object[] getCelsiusValues(){
		return new Integer[][]{{0,32},{37,98},{100,212}};
	}
	
	public static Object[] getFahrenheitValues(){
		return new Integer[][]{{32,0},{98,37},{212,100}};
	}
	
	@Test
	@Parameters(method="getCelsiusValues")
	public void shouldConvertCelciusToFahrenheit(int celsius, int fahrenheit) {
		assertEquals(fahrenheit, FahrenheitCelciusConverter.toFahrenheit(celsius));
	}

	@Test
	@Parameters(method="getFahrenheitValues")
	public void shouldConvertFahrenheitToCelcius(int fahrenheit, int celsius) {
		assertEquals(celsius, FahrenheitCelciusConverter.toCelcius(fahrenheit));
	}
}
