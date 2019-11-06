package com.sqli.test.tramway;

import java.util.Map;
import java.util.Set;

import com.sqli.test.tramway.config.Config;

public class Tram {

	private TramLine tramLine;
	private int duration;
	private int currentStationIndex;

	public Tram(TramLine assignedLine) {
		tramLine = assignedLine;
	}

	public String getCurrentStation() {
		return tramLine.getCurentStation(currentStationIndex).getName();
	}

	public int pickAndRun() {
		Station currentStation = tramLine.getCurentStation(currentStationIndex);
		if (currentStation.isDisturbed()) {
			duration += Config.calculDuration(Config.DISTURBER, currentStation.getPassengers(Config.DISTURBER));
			currentStation.setDisturbed(false);
		} else {
			calculDurationByPassengers(currentStation.getPassengers());
			currentStationIndex++;
		}
		return duration;
	}

	private void calculDurationByPassengers(Map<String, Integer> passengers) {
		passengers.keySet().stream().filter(key -> !key.equals(Config.DISTURBER))
				.forEach(key -> duration += Config.calculDuration(key, passengers.get(key)));
		duration += Config.calculDuration(Config.TRAM_TRIP);
	}

}
