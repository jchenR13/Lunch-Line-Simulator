	/**
	 * The StudentLine class represents the Student lunch line with 
	 * each student on line having a name and money
	 * 
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
public class StudentLine
{
	private Student [] students; // The array used to store the Students in a line
	private int studentCount; // The number of students on the line
	final int CAPACITY = 20; // The max size of the line

	/**
	 * The constructor used to make the StudentLine
	 * 
	 */
	public StudentLine(){
		students = new Student[CAPACITY];
		studentCount = 0;
	}
	
	/**
	 * This method gives the amount of students on the line
	 * 
	 * @return
	 * Returns the amount of students on the line
	 */
	public int numStudents(){
		return studentCount;
	}
	
	/**
	 * This method gets the student at the index
	 * 
	 * @param index
	 * The index of the student
	 * @return
	 * Returns the student at the index
	 * @throws ArrayIndexOutOfBoundsException
	 * Gives an error if there is an invalid index
	 */
	public Student getStudent(int index) throws ArrayIndexOutOfBoundsException{
		if(index < 0 || index > studentCount){
			throw new ArrayIndexOutOfBoundsException("You cannot get this student. \n"
					+ "This index is not valid.");
		}
		return students[index-1];
	}
	/**
	 * This method removes the student at the given index
	 * 
	 * @param index
	 * Index of the student
	 * @return
	 * Removes the student at the index 
	 * @throws ArrayIndexOutOfBoundsException
	 * Gives an error if there is an invalid index
	 * @throws EmptyLineException
	 * Gives an error if there is no student on the line
	 */
	public Student removeStudent(int index) throws ArrayIndexOutOfBoundsException, EmptyLineException {
		if(index > CAPACITY || index<0 || index > studentCount) {
			throw new ArrayIndexOutOfBoundsException("You cannot remove a "
					+ "student. Index is invalid");
		}
		if(studentCount == 0){
			throw new EmptyLineException("You cannot remove a student."
					+ " There is no student on the line");
		}
		else 
		{
			Student temp = students[index-1];
			Student[] replacement = students.clone();
			if(index == studentCount){
				students[index-1]= null;
				studentCount--;
				return temp;
			}
			if(index == 18 || index == 19){
				students[index-1] = replacement[index];
				students[index] = null;
				studentCount--;
			}
			else{
				int j = index;
				for(int i = index; i < studentCount; i++)
				{
					students[i-1] = replacement[j];
					j++;
				}
				students[studentCount-1] = null;
				studentCount--;
			}
		return temp;

		}	
	}
	/**
	 * This method adds a student at the given index
	 * 
	 * @param index
	 * Index of the student
	 * @param student
	 * Student object being added to the line
	 * @throws InvalidArgumentException
	 * Gives an error if the index is negative
	 * @throws DeanException
	 * Gives an error if the line is full
	 */
	public void addStudent(int index, Student student) throws InvalidArgumentException, DeanException {
		
		if(index < 0 || studentCount==20){
			throw new InvalidArgumentException("You cannot add/cut a student.\n"
					+ " Index is not valid.");
		}
		if(index > CAPACITY-1 || studentCount == 20){
			throw new DeanException("You cannot add/cut a student.\n"
					+ " The line has reached max capacity \n");
		}
		studentCount++;
		Student[] temp = students.clone();
		if(index == 0){
			students[0] = student;
		}
		if(index == 18 || index == 19){
			students[index] = student;
		}
		else{
			students[index] = student;
			for(int i = index; i < studentCount+1; i++)
			{
				students[i+1] = temp[i];
			}
		}
	} 
	/**
	 * This method swaps student at index 1 with student at index 2
	 * 
	 * @param index1
	 * Index of student1
	 * @param index2
	 * Index of student2
	 * @throws ArrayIndexOutOfBoundsException
	 * Gives an error if either index1 or index2 is not valid
	 */
	public void swapStudents(int index1, int index2) throws ArrayIndexOutOfBoundsException {
		if((index1 > studentCount || index1 < 0) || (index2 > studentCount || index2 < 0)){
			throw new ArrayIndexOutOfBoundsException("You cannot swap "
					+ "students. Index(s) is invalid");
		}
		Student temp1 = students[index1-1].clone();
		Student temp2 = students[index2-1].clone();
		students[index2-1] = temp1;
		students[index1-1] = temp2;
	}
	/**
	 * This method clones a StudentLine object
	 * 
	 * @return
	 * Returns a clone of the StudentLine object
	 * \
	 */
	public StudentLine clone(){	
		StudentLine temp = new StudentLine();
		for(int i = 0; i < studentCount; i++){
			temp.students[i] = (Student)students[i].clone();
		}
		temp.studentCount = studentCount;
		return temp;
				
	}
	
	/**
	 * This method checks the equality of two StudentLine objects
	 * 
	 * @param o
	 * The StudentLine object being compared to
	 * @return
	 * Returns true if the StudentLine object is equal to this StudentLine, returns false otherwise
	 */
	public boolean equals(Object o){
		if(o instanceof StudentLine){
			StudentLine temp = (StudentLine) o;
			for(int i = 0; i < studentCount; i++){
				if((!students[i].getName().equals(temp.students[i].getName()))
					&& (students[i].getMoney() != temp.students[i].getMoney())){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns a list of the Students on StudentLine
	 * 
	 * @return
	 * Returns all the Students on the StudentLine
	 */
	public String toString(){
		if(studentCount == 0){
			System.out.println("There is no student on the Line.\n");
			return "";
		}
		int max = 0;
		for(int i = 0; i < studentCount; i++){
			if(max < students[i].getName().length()){
				max = students[i].getName().length();
			}
		}
		if(studentCount > 0){
			int counter = 1;
			for(int i = 0; i < studentCount; i++){
				if(counter < 10){
					System.out.print(counter + ".  " + students[i].getName());
					for(int j = students[i].getName().length(); j < max+4; j++){
						System.out.print(" ");
					}
					System.out.println(" $" + String.format( "%.2f", students[i].getMoney()));
				}
				else{
					System.out.print(counter + ". " + students[i].getName());
					for(int j = students[i].getName().length(); j < max+4; j++){
						System.out.print(" ");
					}
					System.out.println(" $" + String.format( "%.2f", students[i].getMoney()));
				}
				counter++;
			}
			System.out.println("");
			return "\n";
		}
		return "\n";
	}
}
