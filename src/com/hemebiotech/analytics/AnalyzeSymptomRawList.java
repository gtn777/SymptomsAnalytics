package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyzeSymptomRawList implements ISymptomAnalyzer {
	/*
	 * Analyze a symptom list and provide a sorted listing where duplicates are not
	 * allowed, and occurrence quantity of each symptom is specified
	 */
	private List<String> rawList;

	/*
	 * @param list is an unordered list of symptoms where duplicates are allowed
	 *
	 */
	public AnalyzeSymptomRawList(List<String> list) {
		this.rawList = list;
	}

	@Override
	public Map<String, Integer> getSortedDataMap() {

		// Set result map as a tree map
		Map<String, Integer> result = new TreeMap<String, Integer>();

		// For each symptom in the raw list,
		// If symptom is ever present inside result, it increments his occurrence
		// Else a new symptom key is created in the map
		for (String symptom : rawList) {
			if (result.containsKey(symptom)) {
				result.replace(symptom, result.get(symptom) + 1);
			} else {
				result.put(symptom, 1);
			}
		}

		return result;
	}

}
