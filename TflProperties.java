package com.epflores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class TflProperties {

	public static void main(String[] args) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {
			// properties
			output = new FileOutputStream("config.properties");
			prop.setProperty("name", "Eugene Flores's App");
			prop.setProperty("description", "Default application created on signup.");
			prop.setProperty("app_id", "a055b383");
			prop.setProperty("app_key", "4cabc676bd56dd4e9025f94aca65c351");
			prop.setProperty("a_road_regex", "^([aA0-9_-]){2,5}$"); // A-roads have one, two, three or four digits;
			prop.setProperty("b_road_regex", "^([bB0-9_-]){4,5}$"); // B-roads only have three or four digits to their numbers.
			
			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
