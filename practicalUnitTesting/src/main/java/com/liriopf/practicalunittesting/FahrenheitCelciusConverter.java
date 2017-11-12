package com.liriopf.practicalunittesting;

public class FahrenheitCelciusConverter {

	private static final int VARIATION = 32;
	private static final double FRACCION = 1.8;

	public static long toFahrenheit(int celsius) {
		return (long) ((celsius*FRACCION)+VARIATION);
	}

	public static long toCelcius(int fahrengheit) {
		return Math.round((fahrengheit- VARIATION) /FRACCION);
	}

}
