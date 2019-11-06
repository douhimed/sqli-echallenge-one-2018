package com.sqli.test.tramway.config;

import java.util.HashMap;
import java.util.Map;


public abstract class Config {

	public static final String YOUNG_MAN = "youngMan";
	public static final String OLD_MAN = "oldMan";
	public static final String DISTURBER = "disturber";
	public static final String TRAM_TRIP = "trip";

	public static final int KET_NAME = 1;
	public static final int KET_VALUE = 0;

	public static final Map<String, Integer> RULES;

	static {
		RULES = new HashMap<String, Integer>();
		RULES.put(YOUNG_MAN, 1);
		RULES.put(OLD_MAN, 2);
		RULES.put(DISTURBER, 3);
		RULES.put(TRAM_TRIP, 2);
	}

	public static int calculDuration(String key, int number) {
		if (RULES.containsKey(key))
			return RULES.get(key) * number;
		return 0;
	}

	public static int calculDuration(String key) {
		return calculDuration(key, 1);
	}

	public static String[] splitInfos(String passenger) {
		if (passenger.contains(" "))
			return passenger.split(" ");
		return new String[]{ "1", passenger };
	}

}
