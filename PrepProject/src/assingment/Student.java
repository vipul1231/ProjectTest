package assingment;

public class Student {
	private int rollno;
	private String name;
	private double marks;
	
	Student(int rollno, String name, double marks)
	{
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
	}
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
}
