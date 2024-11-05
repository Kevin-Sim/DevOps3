package com.napier.devops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AppTest {
	static App app;

	@BeforeAll
	static void init() {
		app = new App();
	}

	@Test
	void printCitiesTestNull() {
		app.printCityReport(null);
	}

	@Test
	void printCitiesTestEmpty() {
		ArrayList<City> cities = new ArrayList<City>();
		app.printCityReport(cities);
	}
	
	@Test
	void printCitiesTestNormal() {
		ArrayList<City> cities = new ArrayList<>();
		City city = new City(458, "Glasgow", "GBR", "Scotland", 619680);
		cities.add(city);
		city = new City(459, "Liverpool", "GBR", "England", 461000);
		cities.add(city);
		city = new City(460, "Edinburgh", "GBR", "Scotland", 450180);
		cities.add(city);
		app.printCityReport(cities);
	}
}