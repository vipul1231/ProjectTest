package org.com.main;

import java.util.Comparator;

import org.com.interfaces.Task;

/**
 * Utility class for comparators
 * 
 * @author vipult
 *
 */
public class ComparatorUtility {
	
	/**
	 * Return Comparator for Fee
	 * 
	 * @return
	 */
	public static Comparator<Task> returnCompOnFee()
	{
		Comparator<Task> compFee = new Comparator<Task>(){

			@Override
			public int compare(Task o1, Task o2) {
				// TODO Auto-generated method stub
				if(o1.getFee()> o2.getFee())
				{
					return -1;
				}
				else if(o1.getFee()< o2.getFee())
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
			
		};
		
		return compFee;
	}
	
	/**
	 * Return comparator for time
	 * 
	 * @return
	 */
	public static Comparator<Task> returnCompOnTime()
	{
		Comparator<Task> cmpTime = new Comparator<Task>(){

			@Override
			public int compare(Task o1, Task o2) {
				// TODO Auto-generated method stub
				if(o1.getTime()> o2.getTime())
				{
					return -1;
				}
				else if(o1.getTime()< o2.getTime())
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
			
		};
		return cmpTime;
	}

}
