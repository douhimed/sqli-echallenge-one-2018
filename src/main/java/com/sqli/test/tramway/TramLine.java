package com.sqli.test.tramway;

import java.util.ArrayList;
import java.util.List;

import com.sqli.test.tramway.config.Config;

public class TramLine {

	private List<Station> stations;

	{
		stations = new ArrayList<Station>();
		stations.add(new Station("Terminus"));
	}

	public void addStation(String stationName, String... passengers) {
		Station station = new Station(stationName);
		this.stations.add(station);
		addPassengers(station, passengers);
	}

	private void addPassengers(Station station, String... passengers) {
		for (String passenger : passengers) {
			String[] infos = Config.splitInfos(passenger);
			station.addPassenger(infos[Config.KET_NAME], Integer.parseInt(infos[Config.KET_VALUE]));
		}
	}

	public Station getCurentStation(int currentStation) {
		return this.stations.get(currentStation);
	}

}
