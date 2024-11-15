package com.napier.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class App {

	/**
	 * Connection to MySQL database.
	 */
	private static Connection con = null;

	public static void main(String[] args) throws IOException {

		// Connect to database
		if (args.length < 1) {
			connect("localhost:33060", 0);
		} else {
			//connect via docker or actions
			connect(args[0], 10000);
			report2();
			//needed on actions else runs forever
			System.exit(-1);
		}

		SpringApplication.run(App.class, args);

	}

	@RequestMapping("cities")
	public ArrayList<City> getCities() {
		ArrayList<City> cities = new ArrayList<>();
		try {

			// Create an SQL statement
			Statement stmt = con.createStatement();
			// Create string for SQL statement
			String sql = "select * from city";
			// Execute SQL statement
			ResultSet rset = stmt.executeQuery(sql);
			//cycle
			while (rset.next()) {
				Integer id = rset.getInt("ID");
				String name = rset.getString("Name");
				String countryCode = rset.getString("CountryCode");
				String district = rset.getString("District");
				Integer population = rset.getInt("Population");
				City city = new City(id, name, countryCode, district, population);
				cities.add(city);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failed to get details");
			return null;
		}
		return cities;
	}

	@RequestMapping("city")
	public ArrayList<City> getCity(@RequestParam(value = "id") String id) {
		City city = null;
		ArrayList<City> cities = new ArrayList<>();
		try {

			// Create an SQL statement
			Statement stmt = con.createStatement();
			// Create string for SQL statement
			String sql = "select * from city where ID = " + id;
			// Execute SQL statement
			ResultSet rset = stmt.executeQuery(sql);
			//cycle
			if (rset.next()) {
				String name = rset.getString("Name");
				String countryCode = rset.getString("CountryCode");
				String district = rset.getString("District");
				Integer population = rset.getInt("Population");
				city = new City(Long.parseLong(id), name, countryCode, district, population);
				cities.add(city);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failed to get details");
			return null;
		}
		System.out.println(city);
		return cities;
	}

	public static void report2() {
		StringBuilder sb = new StringBuilder();
		try {
			// Create an SQL statement
			Statement stmt = con.createStatement();
			// Create string for SQL statement
			String sql = "select * from country";
			// Execute SQL statement
			ResultSet rset = stmt.executeQuery(sql);
			//cycle
			while (rset.next()) {
				String name = rset.getString("name");
				Integer population = rset.getInt("population");
				sb.append(name + "\t" + population + "\r\n");
			}
			new File("./output/").mkdir();
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./output/report1.txt")));
			writer.write(sb.toString());
			writer.close();
			System.out.println(sb.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Failed to get details");
			return;
		}
	}

	/**
	 * Connect to the MySQL database.
	 *
	 * @param conString Use db:3306 for docker and localhost:33060 for local or Integration Tests
	 * @param
	 */
	public static void connect(String conString, int delay) {
		try {
			// Load Database driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load SQL driver");
			System.exit(-1);
		}

		int retries = 10;
		for (int i = 0; i < retries; ++i) {
			System.out.println("Connecting to database...");
			try {
				// Wait a bit for db to start
				Thread.sleep(delay);
				// Connect to database
				//Added allowPublicKeyRetrieval=true to get Integration Tests
				// to work. Possibly due to accessing from another class?
				con = DriverManager.getConnection(
						"jdbc:mysql://" + conString + "/world?allowPublicKeyRetrieval=true&useSSL" + "=false", "root",
						"example");
				System.out.println("Successfully connected");
				break;
			} catch (SQLException sqle) {
				System.out.println("Failed to connect to database attempt " + Integer.toString(i));
				System.out.println(sqle.getMessage());
			} catch (InterruptedException ie) {
				System.out.println("Thread interrupted? Should not happen.");
			}
		}
	}

	/**
	 * Disconnect from the MySQL database.
	 */
	public static void disconnect() {
		if (con != null) {
			try {
				// Close connection
				con.close();
			} catch (Exception e) {
				System.out.println("Error closing connection to database");
			}
		}
	}

	public void printCityReport(ArrayList<City> cities) {
		if (cities == null) {
			System.out.println("No cities found");
			return;
		}
		for (City city : cities) {
			System.out.println(city);
		}
	}
}
