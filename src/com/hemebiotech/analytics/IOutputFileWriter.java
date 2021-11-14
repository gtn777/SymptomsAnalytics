package com.hemebiotech.analytics;

import java.util.Map;

/**
 * 
 * Anything that receive an enhanced data collection and write analyze report in
 * a output file
 * 
 */

public interface IOutputFileWriter {

	/**
	 * 
	 * Write a file with data analyze results
	 * 
	 * @param dataMap is a data map ready to be reported in a file
	 * 
	 */

	public void getOutputFile(Map<String, Integer> dataMap);

}
