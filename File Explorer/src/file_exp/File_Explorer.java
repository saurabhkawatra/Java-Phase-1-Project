package file_exp;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Scanner;

public class File_Explorer {
	

	public static void main(String[] args) {
		
		 System.out.println("--------------------Welcome to the File Explorer Application by Company Lockers Pvt. Ltd.------------------------------");
		 System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>This project is developed by : Saurabh Kawatra<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 while(true)
		 {
			 String directory=null;
			 File input_directory = null;
			 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			 System.out.println("\nEnter the Directory Path you want to work in.");
			 System.out.print("Enter Here---->");
			 try {
				 directory=br.readLine();
				 System.out.println(directory);
				 input_directory = new File(directory);
			 }catch(Exception e) {
				 System.out.println("Invalid Input! Please try Again!");
				 continue;
			 }
			 
			 if(input_directory.canRead())
			 {
				 MainMenu(input_directory);
			 }
			 else
			 {
				 try {
				 System.out.println(br.ready());
				 }catch(Exception e) {
					 System.out.println("Ready catch");
				 }
				 System.out.println("\nThe directory path is Invalid or doesn't exist.");
				 System.out.println("Please Try Again!");
				 continue;
			 }
		 }
		        
	}
	static void MainMenu(File input_file)
	{
		//while(true)
		System.out.println("Welcome to Main Menu");
	}

}
