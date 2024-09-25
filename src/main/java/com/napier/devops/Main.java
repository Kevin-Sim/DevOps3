package com.napier.devops;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello world!");

		new File("./output/").mkdir();
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(new File("./output/report1.txt")));
		writer.write("Hello World");
		writer.close();
	}
}