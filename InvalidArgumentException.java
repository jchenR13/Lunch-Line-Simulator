	/**
 	* The InvalidArgumentException class extends Exception and provides an exception 
 	* when the index is too high or if there are holes in the line
 	* 
 	* @author Justin Chen
 	* 113097757
 	* justin.chen.1@stonybrook.edu
 	* HW assignment #1
 	* CSE-214
 	* R02 Daoqin Gao, Aiswariya Suresh 
 	*/
public class InvalidArgumentException extends Exception{
	
	/**
	 * This method allows the parent constructor to provide a new error and message with that error
	 * 
	 * @param t
	 * Message that is printed when an error occurs
	 */
	public InvalidArgumentException(String t)
	{
		super(t);
	}
}
