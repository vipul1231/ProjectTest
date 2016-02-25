/*package org.com.test;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.Map;
import java.util.Queue;

import org.com.interfaces.Employee;
import org.com.interfaces.Task;
import org.com.main.AppRun;
import org.com.process.TaskAssignment;
import org.junit.Test;

import junit.framework.Assert;

public class TestRunner {
	
	 AppRun app = new AppRun();
	
	 @Test
	 public void testJunitSetup() {
	      String str= "Junit Working";
	      assertEquals("Junit Working",str);
	 }
	 
	 *//**
	  * Test priority of queue on fee
	  *//*
	 @Test
	 public void testQueuePriortyOnFee()
	 {
		 app.createTask("Replace Tyre", 200, 2);
		 app.createTask("Clean Interior", 500, 3);
		  
		 Employee employee= app.createEmployee("Vipul", "Technical Mechanic");
		 Comparator<Task> cmp = AppRun.returnCompOnFee();
		 TaskAssignment task = new TaskAssignment(employee);
		 
		 Map<String, Task> lMap = app.getTaskMap();
		 
		 task.initializeQueueForEmployee(cmp);
		 
		 task.assignTaskToQueue(lMap.get("Replace Tyre"));
		 task.assignTaskToQueue(lMap.get("Clean Interior"));
		 
		 Queue<Task> lTask = task.getlTask();
		 
		 
		 Task currentTask = lTask.poll();
		 Assert.assertEquals(currentTask.getFee(), 500);
		 
		 currentTask = lTask.poll();
		 Assert.assertEquals(currentTask.getFee(), 200);		 
	 }
	 
	 *//**
	  * Test Priority of queue on time
	  *//*
	 @Test
	 public void testQueuePriortyOnTime()
	 {
		 app.createTask("Replace Tyre", 200, 2);
		 app.createTask("Clean Interior", 500, 3);
		  
		 Employee employee= app.createEmployee("Vipul", "Technical Mechanic");
		 Comparator<Task> cmp = AppRun.returnCompOnTime();
		 TaskAssignment task = new TaskAssignment(employee);
		 
		 Map<String, Task> lMap = app.getTaskMap();
		 
		 task.initializeQueueForEmployee(cmp);
		 
		 task.assignTaskToQueue(lMap.get("Replace Tyre"));
		 task.assignTaskToQueue(lMap.get("Clean Interior"));
		 
		 Queue<Task> lTask = task.getlTask();
		 
		 
		 Task currentTask = lTask.poll();
		 Assert.assertEquals(currentTask.getTime(), 3);
		 
		 currentTask = lTask.poll();
		 Assert.assertEquals(currentTask.getTime(), 2);		 
	 }
}
*/