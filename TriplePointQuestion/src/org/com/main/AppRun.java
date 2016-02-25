package org.com.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.com.constants.ApplicationConstants;
import org.com.impl.EmployeeImpl;
import org.com.impl.TaskImpl;
import org.com.interfaces.Employee;
import org.com.interfaces.Task;
import org.com.process.TaskAssignment;

/**
 * Main class to run the application.
 * 
 * @author vipult
 *
 */
public class AppRun extends ComparatorUtility{
	
	/**
	 * list containing all the task to execute
	 */
	List<TaskAssignment> executeTask = new ArrayList<>();

	/**
	 * Map containing all the task with task name as key 
	 */
	Map<String, Task> taskMap = new HashMap<>();
	
	/**
	 * Executor service
	 */
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(ApplicationConstants.QUEUESIZE);;
	
	/**
	 * Run the App
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		AppRun appRun = new AppRun();
		
		//Create the different task
		appRun.createTask(ApplicationConstants.CARWASH,100,2);
		appRun.createTask(ApplicationConstants.CARREPAIR,1000,5);
		appRun.createTask(ApplicationConstants.CARPAINT,1100,4);
		
		//Assign the task to employee
		appRun.assignTheTaskToEmployee(returnCompOnTime());
		
		//Submit the task to executor
		System.out.println("Processing task based on priority of time:");
		appRun.submitTheTaskToExecutor(1);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nProcessing task based on priority of fee:\n");
		appRun.assignNewPriortyForTask();
		appRun.submitTheTaskToExecutor(3);
		
		appRun.shutDownExecutorService();
	}
	
	/**
	 * Submit the task through executor
	 */
	private void submitTheTaskToExecutor(long aInDelay)
	{	
		Thread thread = null;
		for(int i=0;i<executeTask.size();i++)
		{
			thread = new Thread(executeTask.get(i));
			executor.schedule(thread, aInDelay, TimeUnit.SECONDS);;
		}	
	}
	
	/**
	 * Shutdown Executor service
	 */
	private void shutDownExecutorService()
	{
		try {
			executor.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!executor.isShutdown())
		{
			executor.shutdown();
		}
	}
	
	/**
	 * Assign new priority for task
	 */
	private void assignNewPriortyForTask()
	{
		executeTask.clear();
		assignTheTaskToEmployee(returnCompOnFee());
	}
	
	/**
	 * Assign task to employee
	 */
	private void assignTheTaskToEmployee(Comparator<Task> aInComparator)
	{
		//Assign task to employee 1
		TaskAssignment taskAssign1 = new TaskAssignment(createEmployee("Joe", "Trainee"));
		taskAssign1.initializeQueueForEmployee(aInComparator);
		taskAssign1.assignTaskToQueue(taskMap.get(ApplicationConstants.CARWASH));
		taskAssign1.assignTaskToQueue(taskMap.get(ApplicationConstants.CARREPAIR));
		taskAssign1.assignTaskToQueue(taskMap.get(ApplicationConstants.CARPAINT));
		executeTask.add(taskAssign1);
		
		//Assign task to employee 2
		TaskAssignment taskAssign2 = new TaskAssignment(createEmployee("Smith", "Expert"));
		taskAssign2.initializeQueueForEmployee(aInComparator);
		taskAssign2.assignTaskToQueue(taskMap.get(ApplicationConstants.CARREPAIR));
		executeTask.add(taskAssign2);
		
		//Assign task to employee 3
		TaskAssignment taskAssign3 = new TaskAssignment(createEmployee("Walker", "Employee"));
		taskAssign3.initializeQueueForEmployee(aInComparator);
		taskAssign3.assignTaskToQueue(taskMap.get(ApplicationConstants.CARPAINT));
		taskAssign3.assignTaskToQueue(taskMap.get(ApplicationConstants.CARREPAIR));
		executeTask.add(taskAssign3);
	}
	
	/**
	 * Create the task
	 * 
	 * @param aInTaskName
	 * @param aInFee
	 * @param aInTime
	 */
	public void createTask(String aInTaskName, int aInFee, int aInTime)
	{
		Task tsk1 = new TaskImpl(aInTaskName,aInFee,aInTime);
		taskMap.put(aInTaskName, tsk1);
	}
	
	/**
	 * Create Employee for doing task.
	 * 
	 * @param aInName
	 * @param aInDesignation
	 * @return
	 */
	public Employee createEmployee(String aInName, String aInDesignation)
	{
		return new EmployeeImpl(aInName, aInDesignation);
	}
	
	public List<TaskAssignment> getExecuteTask() {
		return executeTask;
	}

	public Map<String, Task> getTaskMap() {
		return taskMap;
	}
}
