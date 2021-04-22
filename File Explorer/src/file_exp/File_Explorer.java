package file_exp;
import java.io.File;
import java.util.Scanner;

public class File_Explorer {
	

	public static void main(String[] args) {
		
		 System.out.println("--------------------Welcome to the File Explorer Application by Company Lockers Pvt. Ltd.------------------------------");
		 System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>This project is developed by : Saurabh Kawatra<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		 while(true)
		 {
			 int choice;
			 System.out.println("\nPlease choose from the below options:");
			 System.out.println("1. Enter the Directory Path");
			 System.out.println("2. Exit Application");
			 System.out.print("Enter your choice----->");
			 choice=integerchoice();
			 if(choice==0)continue;
			 System.out.println("You chose the option --> "+choice);
			 if(choice==1)
			 {
				 directory();
			 }
			 else if(choice==2)
			 {
				 System.out.println("\nThank you for using the Application");
				 System.exit(0);
			 }
			 else
			 {
				 System.out.println("Option doesn't exist! Please Try Again!");
			 }
			 
		 }
		        
	}
	static int integerchoice()
	{
		int i=0;
		Scanner sc=new Scanner(System.in);
		try {
			i=sc.nextInt();	
		}catch(Exception e) {
			System.out.println("Invalid Input! Please Enter a Numeric Choice and Try Again!");
		}
		return(i);
	}
	
	static String stringreader()
	{
		String input="";
		Scanner sc=new Scanner(System.in);
		try {
			input=sc.nextLine();
		}catch(Exception e)
		{
			System.out.println("Invalid Input");
		}
		return(input);
	}
	
	static void directory()
	{
		while(true)
		{
			String directory="";
			 File input_directory = null;
			 System.out.println("\nEnter the Directory Path you want to work in.");
			 System.out.print("Enter Here---->");
			 directory=stringreader();
			 input_directory=new File(directory);
			 if(input_directory.canRead())
			 {
				 MainMenu(input_directory);
			 }
			 else
			 {
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
