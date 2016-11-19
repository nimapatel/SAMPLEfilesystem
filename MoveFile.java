
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class MoveFile {

		public static void main(String[] args){
			
			System.out.println("What is the path of the file?");
			Scanner s = new Scanner(System.in); 
			String FileName = s.nextLine();
			File oFile = new File(FileName);
			System.out.println("What is the new path of the file?");
			Scanner c = new Scanner(System.in);
			String DirName = c.nextLine();
			File nFile = new File(DirName); 
			
			BufferedReader read;
			PrintWriter write;
			
			String line;
			
			try{
				if (nFile.createNewFile() || !nFile.createNewFile()){
					read = new BufferedReader(new FileReader(oFile));
					write = new PrintWriter(new FileWriter(nFile)); 
					
					while((line = read.readLine()) != null){
						write.println(line);
										
						
					}
					read.close();
					write.close();
				}
				
				oFile.delete();

			}catch(IOException ioEx){
				
				
				
			}
			
			
		}
}
