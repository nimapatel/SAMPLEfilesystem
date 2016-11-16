package OSProject;
import java.io.*;
import java.util.*;

public class CreateFile {
	


		public static void main(String[] args) throws Exception
		{
			
			Scanner c = new Scanner(System.in);
			String FileFolder ="";
		  	System.out.println("Where do you want to place your File?\n Remember to use C:\\Root\\Foldername to place file in folder\n");
		  	File f1 = new File(FileFolder=c.nextLine());
			System.out.println("Name your file");
			System.out.println("Specify the path using C:\\Root\\Foldername\\Filename\n");
		  	String FileName = "";
		  	File f2 = new File(FileName=c.nextLine());
		  	
		  	f1.mkdirs();
		  	f2.createNewFile();
		  	System.out.println("File was created");
		
				
				
			}
		//remember to create a Folder called Root in your C Drive

        //loop needs to be added to do this as many times as user wants and to create subfolders
       
        //You can create a file in multiple subfolders at once.
       
        //after user ends the loop the user must pick if they are going to exit program or go back to main menu
		
		
		}



	


