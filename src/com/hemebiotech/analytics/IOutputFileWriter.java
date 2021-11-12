package com.hemebiotech.analytics;

import java.util.Map;

/*
 * 
 * Anything that receive an enhanced data collection and write them in a output file
 * 
 */

public interface IOutputFileWriter {

	/*
	 * 
	 * Fill an existing file with data analyze results
	 * 
	 * @param dataMap a data map ready to be reported in a file
	 * 
	 */

	public void fillOutputFile(Map<String, Integer> dataMap) ;

}
