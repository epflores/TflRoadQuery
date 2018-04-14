package com.epflores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator;
import java.util.Properties;

/**
 * @author Eugene Paul Flores
 *
 */
public class TflRoadQuery {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();
		Properties prop = new Properties();

		try {
			// for local debugging purposes only
			Boolean localDebug = false;

			// load a properties file
			String configFile = "/config.properties";
			InputStream input = TflRoadQuery.class.getResourceAsStream(configFile);
			prop.load(input);
			if(localDebug) {
				System.out.println(TflRoadQuery.class.getResourceAsStream(configFile)); // config found
			}
			String roadStr = null;
			BufferedReader br = null;
			// if args input provided
			if (args.length>0) { 
				roadStr = args[0]; // read first arg only
			} else {
				// prompt user input
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter Road: ");
				roadStr = br.readLine().trim();
			}

			String regexA = prop.getProperty("a_road_regex"); // A-roads have one, two, three or four digits;
			String regexB = prop.getProperty("b_road_regex"); // B-roads only have three or four digits to their numbers.
			if (localDebug) {
				if (roadStr.matches(regexA)) {
					System.out.println("A Road validated");
				}
				if (roadStr.matches(regexB)) {
					System.out.println("B Road validated");
				}
			}

			// input is a valid road name format
			if (roadStr.matches(regexA) || roadStr.matches(regexB)) {
				// build URL
				URL url = new URL("https://api.tfl.gov.uk/Road/" + roadStr + "?app_id=" + prop.getProperty("app_id")
						+ "&app_key=" + prop.getProperty("app_key"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				// process if http response code is either 200 or 404
				if (conn.getResponseCode() == 200 || conn.getResponseCode() == 404) {
					if (conn.getResponseCode() == 200) {
						br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
					}
					if (conn.getResponseCode() == 404) {
						br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
					}
					String output;
					if (localDebug) {
						System.out.println("Output from Server .... \n");
					}
					while ((output = br.readLine()) != null) {
						if (localDebug) {
							System.out.println(output + "\n");
						}
						try {
							if (conn.getResponseCode() == 200) { // jsonarray is returned if road is found
								// display road status information
								JSONArray jsonArray = (JSONArray) parser.parse(output);
								for (int i = 0; i < jsonArray.size(); i++) {
									if (localDebug) {
										System.out.println(
												"The " + i + " element of the array: " + jsonArray.get(i) + "\n");
									}
									Iterator<JSONObject> itr = jsonArray.iterator();
									while (itr.hasNext()) {
										JSONObject innerObj = (JSONObject) itr.next();
										System.out.println("\n" + innerObj.get("displayName") + "\n" + "Road Status: "
												+ innerObj.get("statusSeverity") + "\n" + "Road Status Description: "
												+ innerObj.get("statusSeverityDescription"));
									}
								}
							}
							if (conn.getResponseCode() == 404) { // jsonobject is returned if road is not found
								// display error message
								JSONObject jsonObject = (JSONObject) parser.parse(output);
								String message = (String) jsonObject.get("message");
								System.out.println("\n" + message);
							}

						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
				} else {
					throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
				}
				conn.disconnect();
			} else {
				// display message if input is not a valid road name format
				System.out.println("\nThe following road id is not valid: " + roadStr);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
