package com.hemebiotech.analytics;

import java.util.Map;

/**
 * 
 * Anything that analyze a raw data list and return a sorted data map where
 * duplicates are not allowed, and occurrence of each item is specified
 */

public interface ISymptomAnalyzer {
	/**
	 * If no data is available, return an empty map
	 * 
	 * @return a sorted data map where symptoms are keys and occurrence is the linked value
	 * 
	 */

	Map<String, Integer> getSortedDataMap();

}
