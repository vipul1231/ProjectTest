package org.com.impl;

import org.com.interfaces.Task;

/**
 * Task Impl class
 * 
 * @author vipult
 *
 */
public class TaskImpl implements Task{
	
	/**
	 *Task Name
	 */
	String taskName;
	
	/**
	 * Fee applied for the task
	 */
	int fee;
	
	/**
	 * Time taken to do the task
	 */
	int time;
	
	/**
	 * Constructor
	 */
	public TaskImpl() {
		
	}
	
	/**
	 * Parameterized constructor
	 * 
	 * @param aInTaskName
	 * @param aInFee
	 * @param aInTime
	 */
	public TaskImpl(String aInTaskName, int aInFee, int aInTime) {
		this.taskName = aInTaskName;
		this.fee = aInFee;
		this.time = aInTime;
	}
	
	@Override
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
