package testPackage;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Student{
   private int token;
   private String fname;
   private double cgpa;
   public Student(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
}

/**
 * 
14
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 4.95 53
ENTER DAn 4.95 43 
ENTER Amit 3.95 43
SERVED

 *
 */
public class Solution {
	
	
	static Comparator<Student> cmp = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			if(o1.getCgpa() < o2.getCgpa())
			{
				return 1;
			}
			else if(o1.getCgpa() > o2.getCgpa())
			{
				return -1;
			}
			
			else if(o1.getCgpa()==o2.getCgpa())
			{
				if(o1.getFname().compareTo(o2.getFname()) > 0)
				{
					return 1;
				}
				else if(o1.getFname().compareTo(o2.getFname()) < 0)
				{
					return -1;
				}
				else if(o1.getFname().equals(o2.getFname()))
				{
					if(o1.getToken() < o2.getToken())
					{
					return -1;	
					}
					else if(o1.getToken() > o2.getToken())
					{
					return 1;	
					}
				}
			}
			return 0;
		}
		
	};
	
	static Queue<Student> student = new PriorityQueue<Student>(cmp);
    

    public static void main(String[] args) {	
      Scanner in = new Scanner(System.in);
      int totalEvents = Integer.parseInt(in.nextLine());
      while(totalEvents>0){
         String event = in.nextLine();
          String[] mainEvent = event.split(" ");
          
          String[] mainEvent1 = new String[4];
          int count = 0;
          
          for(int i=0;i<mainEvent.length;i++)
          {
        	  if(!mainEvent[i].equals(""))
        	  {
        		  mainEvent1[count] = mainEvent[i];
        		  count++;
        	  }
          }
          
          if(mainEvent[0].equals("ENTER"))
          {
        	  int number = Integer.parseInt(mainEvent[3]);
        	  Student obj = new Student(number,mainEvent[1],
        			  Double.parseDouble(mainEvent[2]));
              student.add(obj); 
          }
          else if(mainEvent[0].equals("SERVED"))
          {
        	  	if(!student.isEmpty())
        	  	{
        	  	Student students = student.poll();
        	  	System.out.println("Served Student:"+students.getFname()+" CGPA: "+students.getCgpa()+" Token: "+students.getToken());
        	  	}
          }
           //Complete your code
         totalEvents--;
      }
      in.close();
      System.out.println("Printing remaing element.");
      
      if(student.isEmpty())
      {
    	  System.out.println("EMPTY");
      }
      
      while(!student.isEmpty())
      {
    	  Student studentss = student.poll();
    			  System.out.println(studentss.getFname()+" CGPA: "+studentss.getCgpa()+" Token: "+studentss.getToken());
      }
    }
    
    

	
}

