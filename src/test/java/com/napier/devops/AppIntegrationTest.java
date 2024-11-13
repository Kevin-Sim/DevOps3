package com.napier.devops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
	static App app;

	@BeforeAll
	static void init()
	{
		app = new App();
		app.connect("localhost:33060", 0);

	}

	@Test
	void testGetCities()
	{
		ArrayList<City> cities = app.getCities();
		City city = cities.get(0);
		assertEquals(city.getId(), 1);
		assertEquals(city.getName(), "Kabul");
	}
}