package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class MainAnalyticsCounter {

	static private String inputFilePath = "symptoms.txt"; // input data file path
	static private String outputFilePath = "results.out"; // output reporting file path
	static private List<String> rawList; // a raw list of symptoms
	static private Map<String, Integer> sortedMap; // a sorted data map ready to be report

	public static void main(String args[]) throws Exception {

//		read data from the input file according to inputFilePath and 
//		store them in rawList value where duplicates are allowed
		ISymptomReader newRead = new ReadSymptomDataFromFile(inputFilePath);
		rawList = newRead.getSymptoms();

//		analyze the symptom listing previously stored in rawList,
//		then a sorted symptom/occurrence data map is stored in sortedMap.
		ISymptomAnalyzer dataAnalyze = new AnalyzeSymptomRawList(rawList);
		sortedMap = dataAnalyze.getSortedDataMap();

// 		Creates an output file writer according to outputFilePath, 
//		then the file is written from sortedMap.
		IOutputFileWriter analyticsReport = new WriteSymptomAnalyticsInAFile(outputFilePath);
		analyticsReport.getOutputFile(sortedMap);

	}
}
