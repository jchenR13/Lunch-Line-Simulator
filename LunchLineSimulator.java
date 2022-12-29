	/**
	 * The LunchLineSimulator class represents a simulation of two lunch lines: realityA and realityB.
	 * Each StudentLine has students on line having a name and a certain amount of money
	 * 
	 * @author Justin Chen
	 * 113097757
	 * justin.chen.1@stonybrook.edu
	 * HW assignment #1
	 * CSE-214
	 * R02 Daoqin Gao, Aiswariya Suresh 
	 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class LunchLineSimulator{
	private static StudentLine realityA;
	private static StudentLine realityB;

	/**
	 * 
	 * @param args
	 * Can be used to pass arguments into the main
	 */
	public static void main(String[] args){
		
		//Initializes realityA and realityB
		realityA = new StudentLine();
		realityB = new StudentLine();
		
		StudentLine temp = realityA;
		
		boolean whatReality = true;
		
		//Prints out the menu with the options below
		System.out.println("Welcome to the Middle School where you are the \n"
				+ "master of the lunch line, and you may subject your \n"
				+ "angsty kids to whatever form of culinary torture \n"
				+ "best fits your mood. You are in reality A" + "\n" 
				+ "\n" + "Menu: ");
		
		System.out.println("     " + "A) Add a student to the line at the end");
		System.out.println("     " + "C) Have a new student cut a friend");
		System.out.println("     " + "T) Have two students trade places");
		System.out.println("     " + "B) Have the bully remove a student");
		System.out.println("     " + "U) Update a student's money amount");
		System.out.println("     " + "S) Serve a student");
		System.out.println("     " + "P) Print the current reality's lunch line");
		System.out.println("     " + "O) Switch to the other reality");
		System.out.println("     " + "E) Check if the realities are equal");
		System.out.println("     " + "D) Duplicate this reality into the other reality");
		System.out.println("     " + "Q) Quit middle school and move on to real life. \n");
		
		Scanner input = new Scanner(System.in);
		String name;
		double money;
		int position;
		int position2;
		String hold = "";
		/**
		 * Keeps running the program until q or Q is entered
		 */
		while(!hold.toUpperCase().equals("Q")){
			
				/**
				 * If whatReality equals true then enters realityA. Sets temp to realityA
				 */
				if(whatReality == true){
					temp = realityA;
				}
				/**
				 * If whatReality equals false then enters realityB. Sets temp to realityB
				 */
				else{
					temp = realityB;
				}
				System.out.println("Please select an option: ");
				String end = input.nextLine();
				hold = end;
				switch(end.toUpperCase()){
				case "A":
					try {
						/**
						 * Asks the user for name and money and if they are valid then the student is added
						 * to the StudentLine in current reality
						 */
						System.out.println("Please enter Student name: ");
						name = input.nextLine();
						System.out.println("Please enter Money amount: ");
						money = input.nextDouble();
						/**
						 * Gives a message for negative money inputs continues otherwise
						 */
						if(money < 0){
							System.out.println("You can't have debt in middle school. \n" 
									+ "Please enter another Money amount: \n");
						}
						else{
							input.nextLine();
							Student putStudent = new Student(name, money);
							temp.addStudent(temp.numStudents(), putStudent);
							System.out.println(putStudent.getName() + " has been added to the line in"
									+ " position " + (temp.numStudents()) + ". Also "
									+ putStudent.getName() + " has $" 
									+ String.format( "%.2f", putStudent.getMoney()) + ". \n");
							System.out.println("");
						}
					}
					/**
					 * If there is an error one of these exceptions will be printed based on the error
					 * 
					 * ArrayIndexOutOfBoundsException- if the index is invalid
					 * InvalidArgumentException- if the index is too high and would create a hole in the array
					 * DeanException- if the array is full
					 * InputMismatchException- if the user inputs an incorrect input
					 */
					catch(ArrayIndexOutOfBoundsException e){
						System.out.println("You cannot add a student.\n"
								+ " Index is not valid.\n");
					}
					catch(InvalidArgumentException e){
						System.out.println("You cannot add a student.\n"
								+ " Index is not valid.\n");
					}
					catch(DeanException e){
						System.out.println("You cannot add a student.\n"
								+ "The line has reached max capacity \n");
					} 
					catch(InputMismatchException e){
						System.out.println("There was an error with the money input. Try again.\n");
					}

					break;
					
				case "C":
					try {
						/**
						 * Asks the user for name and money and if they are valid then the student cuts
						 * in front of the student at the index in current reality and moves everyone
						 * behind the cutter back 1 index
						 */
						System.out.println("Please enter Student name: ");
						name = input.nextLine();
						System.out.println("Please enter Money amount: ");
						money = input.nextDouble();
						/**
						 * Gives a message for negative money inputs continues otherwise
						 */
						if(money < 0){
							System.out.println("You can't have debt in middle school. \n" 
									+ "Please enter another Money amount: \n");
						}
						else{
							System.out.println("Please enter position: ");
							position = input.nextInt();
							Student putStudent = new Student(name, money);
							Student rStudent = temp.getStudent(position);
							input.nextLine();
							temp.addStudent(position-1, putStudent);
							System.out.println(putStudent.getName() + " has cut " + rStudent.getName()
								+ " and is now in position " + position + ". " + putStudent.getName()
								+ " has $" + String.format( "%.2f", putStudent.getMoney()) + ". " + "\n");
							}
					}
					/**
					 * If there is an error one of these exceptions will be printed based on the error
					 * 
					 * ArrayIndexOutOfBoundsException- if the index is invalid
					 * InvalidArgumentException- if the index is too high and would create a hole in the array
					 * DeanException- if the array is full
					 * InputMismatchException- if the user inputs an incorrect input
					 */
					catch(ArrayIndexOutOfBoundsException e){
						System.out.println("You cannot add/cut a student.\n"
								+ "Index is not valid.\n");
					}
					catch(InvalidArgumentException e){
						System.out.println("You cannot add/cut a student.\n"
								+ "Index is not valid.\n");
					}
					catch(DeanException e){
						System.out.println("You cannot add/cut a student.\n"
								+ "The line has reached max capacity \n");
					} 
					catch(InputMismatchException e){
						System.out.println("There was an error with the money input. Try again.\n");
					}				
					break;
					
				case "T":
					try{
						/**
						 * Asks the user for the indices of the two students they wish to switch.
						 * If the indices are valid then the students switch positions in current reality
						 */
						System.out.println("Please enter Student 1 position: ");
						position = input.nextInt();
						input.nextLine();
						System.out.println("Please enter Student 2 position: ");
						position2 = input.nextInt();
						input.nextLine();
						temp.swapStudents(position, position2);
						System.out.println(temp.getStudent(position2).getName() + " has switched "
								+ "places with " + temp.getStudent(position).getName() + "\n");
						
					}
					/**
					 * If one of the indices is invalid then it prints the messages provided by the
					 * ArrayIndexOutOfBoundsException
					 */
					catch(ArrayIndexOutOfBoundsException e){
						System.out.println("You cannot swap students \n"
								+ "Index(s) is not valid.\n");
					}
					break;
					
				case "B":
					try {
						/**
						 * Asks the user for the index they wish to remove the student. If the index
						 * is valid then it removes that student at given index in current reality
						 */
						System.out.println("Please enter Student index: ");
						position = input.nextInt();
						StudentLine replace = temp.clone();
						temp.removeStudent(position);
						input.nextLine();
						System.out.println("The bully has stolen " + replace.getStudent(position).getName() +
								"'s lunch money," + "\n" + "and " + replace.getStudent(position).getName()
								+ " has left, feeling hungry.");
						System.out.println("");
					}
					/**
					 * If there is an error one of these exceptions will be printed based on the error
					 * 
					 * ArrayIndexOutOfBoundsException- if the index is invalid
					 * EmptyLineException- if the line is empty
					 * InputMismatchException- if the user inputs an incorrect input
					 */
					catch(ArrayIndexOutOfBoundsException e){
						System.out.println("You cannot remove this student \n"
								+ "Index is not valid.\n");
					} catch(EmptyLineException e){
						System.out.println("You cannot remove a student." 
								+ "\nThere is no student on the line \n");
					}
					catch(InputMismatchException e){
						System.out.println("There was an error with the index input. Try again.\n");
					}
					
					break;
					
				case "U":
					try{
						/**
						 * Asks the user for the index of the student they wish to change and how much money
						 * they want to change the student to have. If given valid inputs the student will
						 * now have the new updated money in the current reality
						 */
						System.out.println("Please enter Student index: ");
						position = input.nextInt();
						System.out.println("Please enter New Money amount: ");
						money = input.nextDouble();
						/**
						 * Gives a message for negative money inputs continues otherwise
						 */
						if(money < 0){
							input.nextLine();
							System.out.println("You can't have debt in middle school. \n"
									+ "The lunch line was not updated.");
							System.out.println("");
							break;
						}
						else{
							temp.getStudent(position).setMoney(money);
							System.out.println("As a result of a shady transaction with the floor, " 
								+ temp.getStudent(position).getName() + " now has $" 
								+ String.format( "%.2f", temp.getStudent(position).getMoney()) + "\n");
							input.nextLine();
							break;
						}
					}
					/**
					 * If there is an error one of these exceptions will be printed based on the error
					 * 
					 * ArrayIndexOutOfBoundsException- if the index is invalid
					 * InputMismatchException- if the user inputs an incorrect input
					 */
					catch (ArrayIndexOutOfBoundsException e){
						System.out.println("You cannot update this student's money \n"
								+ "Index is not valid.\n");
					}
					catch(InputMismatchException e){
						System.out.println("There was an error with the money input. Try again.\n");
					}
					break;
					
				case "S":
					try{
						/**
						 * If there is a student at the front of the line serve that student
						 * in the current reality
						 */
						System.out.println(temp.getStudent(1).getName() + " has " 
								+ "been served today's special: Bouncy \"Chicken?\"\n"
								+ "Nuggets. We hope he lives to see another day!");
						temp.removeStudent(1);
						System.out.println("");
					}
					/**
					 * If there is an error one of these exceptions will be printed based on the error
					 * 
					 * ArrayIndexOutOfBoundsException- if the index is invalid
					 * EmptyLineException- if the line is empty
					 */
					catch (ArrayIndexOutOfBoundsException e){
						System.out.println("You can't serve a student." 
							+ "\nThere's no student on the line \n");
					} 
					catch (EmptyLineException e){
						System.out.println("You can't serve a student." 
								+ "\nThere is no student on the line \n");
					}
					break;
				case "P":
					try{
						/**
						 * If whatReality equals true then it prints out the Lunch Line from realityA
						 */
						if(whatReality == true){
							System.out.println("Lunch line in reality A:");
							temp.toString();
						}
						/**
						 * Else then it prints out the Lunch Line from realityB
						 */
						else{
							System.out.println("Lunch line in reality B:");
							temp.toString();
						}
					}
					/**
					 * Catches any possible errors and returns a message about the error
					 */
					catch (Exception e){
						e.printStackTrace();
					}
					break;
				case "O":
					try{
						/**
						 * If whatReality equals true then it switches to realityB and makes whatReality false
						 */
						if(whatReality == true){
							System.out.println("You are in Reality B. I reject your reality and substitute my own.\n");
							whatReality = false;
						}
						/**
						 * Else it switches to realityA and makes whatReality true
						 */
						else{
							System.out.println("You are in Reality A. I reject your reality and substitute my own.\n");
							whatReality = true;
						}
					}
					/**
					 * Catches any possible errors and returns a message about the error
					 */
					catch (Exception e){
						e.printStackTrace();
					}
					break;
				case "E":
					try{
						/**
						 * Checks the equality of realityA and realityB
						 */
						if(realityA.numStudents() == realityB.numStudents() && realityA.equals(realityB)){
							System.out.println("The realities are equal\n");
						}
						else{
							System.out.println("The realities are not equal\n");
						}
					}
					/**
					 * Catches any possible errors and returns a message about the error
					 */
					catch (Exception e){
						e.printStackTrace();
					}
					break;
				case "D":
					try {
						/**
						 * If in realityA then it copies realityA into realityB
						 */
						if(whatReality == true){
							realityB = realityA.clone();
							System.out.println("Reality A has been copied into Reality B. \n");
							
						}
						/**
						 * If in realityB then it copies realityB into realityA
						 */
						else{
							realityA = realityB.clone();
							System.out.println("Reality B has been copied into Reality A. \n");
						}
					}
					/**
					 * Catches any possible errors and returns a message about the error
					 */
					catch (Exception e){
						e.printStackTrace();
					}
					break;
				case "Q":
					/**
					 * Message printed after quitting the program
					 */
					System.out.println("You are now leaving the Middle School Lunch Line"
							+ " Simulator." + "\n" + "We congratulate you on your decision to do"
							+ " something more" + "\n" + "productive with your time.");
					break;
				default:
					/**
					 * Prints a message if there is an error that the above cases didn't catch
					 */
					input.nextLine();
					System.out.println("Some error had occured or this letter was not an option."
							+ "\nPlease try again.\n");
					break;
			}
		}
	}


}


