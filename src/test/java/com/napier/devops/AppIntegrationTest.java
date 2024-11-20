package com.napier.devops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
	static App app;

	@BeforeAll
	static void init()
	{
		app = new App();
		app.connect("localhost:33060", 10000);

	}

	/**
	 * There are 4079 cities indexed by id 1 - 4049
	 */
	@Test
	void testGetCity()
	{
		ArrayList<City> cities = app.getCity(String.valueOf(1));
		assertEquals("Kabul", cities.get(0).getName());
		System.out.println("successfully retrieved " + cities.get(0));

		App.report2();
	}
}