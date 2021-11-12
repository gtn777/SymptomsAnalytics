package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomAnalyticsInAFile implements IOutputFileWriter {

	private String filePath;

	/**
	 * @param filePath is the path of the file where analytics will be write
	 * 
	 */
	public WriteSymptomAnalyticsInAFile(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void fillOutputFile(Map<String, Integer> dataMap) {

		if ((filePath != null) && (!dataMap.isEmpty())) {

			try {
				FileWriter writer = new FileWriter(filePath);
				System.out.println();

				// for each pair symptom/occurrence in the map,
				// a line is written in the output file
				Set<String> symptoms = dataMap.keySet();
				for (String symptom : symptoms) {
					writer.write(symptom + ": " + dataMap.get(symptom) + "\n");
				}
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// if file path is null or dataMap is empty, a message is logged
			System.out.println("output file or entry data is not available");
		}
	}
}
