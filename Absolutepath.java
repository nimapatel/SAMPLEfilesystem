import java.io.File;
import java.util.Scanner;

public class Absolutepath {

	public static void main(String[] args){
		
		
		System.out.println("Name the File");
		
		
		Scanner s = new Scanner(System.in);
		String fileName= s.nextLine();
		File file = new File(fileName);
		String path = file.getAbsolutePath();
		System.out.println(path);
		
		
		
		
		
		
	}
	
	
}
