package OSProject;

import java.io.File;
import java.util.Scanner;

public class CreateDirectory {
	  public static void main(String[] args) {
		  	System.out.println("Name your Directory. Remember to start with C:\\Root\\");
		  	Scanner s = new Scanner(System.in);
		  	String Folder = "";
	       	        
		 
		  		File files = new File(Folder=s.next());
		  	
	        if (!files.exists()) {
	            if (files.mkdirs()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Directory already exists!");
	            }
	        }

	        //loop needs to be added to do this as many times as user wants
	       
	        
	       
	        //after user ends the loop the user must pick if they are going to exit program or go back to main menu

	    }


	}
