	/**
	 * The Student class represents a student which has a name and money 
	 *
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
public class Student{

	private String name; // The name of the Student object
	private double money; // The amount of money the Student object has
	
	/**
	 * The constructor used to create student
	 *
	 * @param name
	 * The name of the student
	 * @param money
	 * The amount of lunch money that the student brought to school
	 */
	public Student(String name, double money){
		this.name = name;
		this.money = money;
	}
	
	/**
	 * The default constructor for student
	 */
	public Student(){
		this.name = "";
		this.money = 0;
	}
	
	/**
	 * This method sets a new name to the student
	 * 
	 * @param n
	 * New name of the student
	 */
	public void setName(String n){
		name = n;
	}
	
	/**
	 * This method gets the name of the student
	 * 
	 * @return
	 * Returns the name of the student
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * This method sets the student's new balance
	 * 
	 * @param m
	 * Sets amount of money for the student
	 */
	public void setMoney(double m){
		money = m;
	}
	
	/**
	 * This method gets the amount of money the student has
	 * 
	 * @return
	 * Returns the amount of money the student has
	 */
	public double getMoney(){
		return money;
	}
	
	/**
	 * This method compares the equality of two Student objects
	 * 
	 * @param obj
	 * The Student object being compared to
	 * @return
	 * Returns true if the Student object is equal to this Student, returns false otherwise
	 */
	public boolean equals(Object obj){
		if(obj instanceof Student){
			Student kid = (Student) obj;
			if(this.name.equals(kid.name) && this.money == kid.money){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method makes a clone of the student
	 * 
	 * @return
	 * Returns a clone of the student
	 */
	public Student clone(){
		Student newStudent = new Student(this.name, this.money);
		return newStudent;
	}
	
	/**
	 * This method returns a string representation of student and their money
	 * 
	 * @return
	 * Returns a string representation of student and their money
	 */
	public String toString(){
		return "Name of Student: " + name + "\n" + 
					"Amount of Lunch Money: $" + money;
	}
}
