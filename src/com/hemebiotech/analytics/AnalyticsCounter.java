package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static String inputFilePath = "symptoms.txt";
	private static String outputFilePath = "results.out";

	public static void main(String args[]) {

		// - 1 - extract data from input file with provided interface and class
		ISymptomReader newRead = new ReadSymptomDataFromFile(inputFilePath); // path: symptoms.txt
		List<String> rawDataList = newRead.getSymptoms();

		// - 2 - Analyze data and provide enhanced listing
		// Set sortedMap map as a tree map
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>();
		// For each symptom in the raw list,
		// If symptom is ever present inside sortedList, his occurrence is incremented
		// Else a new symptom key is created in the map
		for (String symptom : rawDataList) {
			if (sortedMap.containsKey(symptom)) {
				sortedMap.replace(symptom, sortedMap.get(symptom) + 1);
			} else {
				sortedMap.put(symptom, 1);
			}
		}

		// - 3 - Generate output:
		if ((outputFilePath != null) && (!sortedMap.isEmpty())) {
			try {
				FileWriter writer = new FileWriter(outputFilePath);
				System.out.println();
				Set<String> symptoms = sortedMap.keySet();
				for (String symptom : symptoms) {
					writer.write(symptom + ": " + sortedMap.get(symptom) + "\n");
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("output file or entry data is not available");
		}
	}
}
