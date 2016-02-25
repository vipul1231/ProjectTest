package org.com.interfaces;

/**
 * Task Interaface
 * 
 * @author vipult
 *
 */
public interface Task {
	
	/**
	 * Task Name
	 * 
	 * @return
	 */
	String getTaskName();
	
	/**
	 * Associated task Fees
	 * 
	 * @return
	 */
	int getFee();
	
	/**
	 * Time required to complete
	 * 
	 * @return
	 */
	int getTime();

}
