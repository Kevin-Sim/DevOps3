package com.napier.devops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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

	@Test
	void testGetCity()
	{
		City city = app.getCity(1);
		assertEquals("Kabul", city.getName());
		System.out.println("successfully retrieved " + city);
	}
}