package com.sqli.test.tramway;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.sqli.test.tramway.config.Config;

public class Station {

	private String name;
	private Map<String, Integer> passengers;
	private boolean disturbed;

	{
		passengers = new HashMap<String, Integer>();
	}

	public Station(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPassenger(String key, int number) {
		if (key.equals(Config.DISTURBER))
			disturbed = true;
		this.passengers.put(key, number);
	}

	public boolean isDisturbed() {
		return disturbed;
	}

	public void setDisturbed(boolean disturbed) {
		this.disturbed = disturbed;
	}

	public Map<String, Integer> getPassengers() {
		return Collections.unmodifiableMap(passengers);
	}

	public int getPassengers(String type) {
		return passengers.containsKey(type) ? passengers.get(type) : 0;
	}

}
