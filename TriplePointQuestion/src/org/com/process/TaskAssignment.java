package org.com.process;

import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import org.com.constants.ApplicationConstants;
import org.com.interfaces.Employee;
import org.com.interfaces.Task;

/**
 * This class assign the task.
 * 
 * @author vipult
 *
 */
public class TaskAssignment implements Runnable{
	
	/**
	 * Employee object
	 */
	Employee employee;
	
	/**
	 * Priority queue for taking task on priority based on comparator
	 */
	Queue<Task> queueContainingTask = null;

	/**
	 * Constructor
	 * 
	 * @param emp
	 */
	public TaskAssignment(Employee emp) {
	this.employee = emp;
	}
	
	/**
	 * Initialize queue with provided comparator
	 * 
	 * @param aInCompartor
	 */
	public void initializeQueueForEmployee(Comparator<Task> aInCompartor)
	{
		queueContainingTask = new PriorityBlockingQueue<Task>(ApplicationConstants.QUEUESIZE, aInCompartor);
	}
	
	/**
	 * Add the Task to Queue
	 * 
	 * @param objectImpl
	 */
	public void assignTaskToQueue(Task objectImpl)
	{
		queueContainingTask.add(objectImpl);
	}
	
	/**
	 * Take the task from queue 
	 * 
	 * @return
	 */
	private Task pollTaskFromQueue()
	{
		return queueContainingTask.poll();
	}

	@Override
	public void run() {
		
		synchronized (this) {
			
			while(queueContainingTask.size()!=0)
			{
				Task task = pollTaskFromQueue();
				System.out.println("Processing task: "+employee.getEmpDesignation() +" "+employee.getEmpName()+
						" is doing "+task.getTaskName()+". Task Time :"+task.getTime()+"hr. Fee :"+task.getFee());
			}		
		}
	}
	
	public void setlTask(Queue<Task> lTask) {
		this.queueContainingTask = lTask;
	}
	
	public Queue<Task> getlTask() {
		return queueContainingTask;
	}
}
