package file_exp;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

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
			 System.out.print("Enter your Numeric choice----->");
			 choice=integerchoice();
			 if(choice==0)
			 {
				 System.out.println("Invalid Input! Please Enter a valid Numeric Input and Try Again!");
				 continue;
			 }	 
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
		String s="";
		Scanner sc=new Scanner(System.in);
		try {
			s=sc.nextLine();	
		}catch(Exception e) {
			return(0);
		}
		if(s.matches("[0-9]"))
		{
			i=Integer.valueOf(s);
			return(i);
		}
		else
		{
			return(0);	
		}
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
				 MainMenu(input_directory,directory);
			 }
			 else
			 {
				 System.out.println("\nThe directory path is either Invalid or doesn't exist.");
				 System.out.println("Please Try Again!");
				 continue;
			 }
		}
		
	}
	
	static void MainMenu(File input_file,String directory)
	{
		while(true)
		{
			int choice;
			System.out.println("\n--------------Welcome to Main Menu---------------\n");
			System.out.println("You are in Directory--> "+"[ "+input_file+" ]");
			System.out.println("Choose an option among the following to perform in this Directory\n");
			System.out.println("1. Display the files in this Directory in Ascending order");
			System.out.println("2. Add, Delete or Search a File in this Directory");
			System.out.println("3. Go to a Different Directory");
			System.out.println("4. Exit the Application");
			System.out.print("Enter your Numeric choice----->");
			choice=integerchoice();
			if(choice==0)
			{
				System.out.println("Invalid Input! Please Enter a valid Numeric Input and Try Again!");
				continue;
			}
			System.out.println("You chose the option --> "+choice);
			if(choice==1)
			{
				displayAscending(input_file,directory);
			}
			else if(choice==2)
			{
				operations(input_file,directory);
			}
			else if(choice==3)
			{
				break;
			}
			else if(choice==4)
			{
				System.out.println("\nThank you for using the Application!");
				System.exit(0);
			}
			else
			{				
				System.out.println("Option doesn't Exist! Please Try Again!");
			}
		}
		
		
	}
	static void displayAscending(File input_file,String directory)
	{
		String[] list_of_files = input_file.list();
		File temp;
		String fileloc="";
		Arrays.sort(list_of_files);
		int x=1;
		System.out.println("\nAll Files in Directory : "+directory+" are:\n");
		System.out.printf("|%-3s| |%-40s| |%-40s| |%-40s| ","No.","File Name (Ascending)","File Type","File Size");
		System.out.println();
		for(int i=0;i<140;i++)
		System.out.print("-");
		System.out.println();
		for(String s:list_of_files)
		{
			fileloc="";
			fileloc=fileloc.concat(directory+"\\"+s);
			temp = new File(fileloc);
			String[] type=s.split("[.]");
			if(type.length>1)
			{
			System.out.printf("|%-3s| |%-40s| |%-40s| |%-40s| ",x+++".",s,type[type.length-1],temp.length()+" bytes");
			System.out.println();
			}
			else
			{
			if(temp.isDirectory())
			{
				System.out.printf("|%-3s| |%-40s| |%-40s| |%-40s| ",x+++".",s,"Directory / Folder",temp.length()+" bytes");
				System.out.println();
			}
			else
			{
				System.out.printf("|%-3s| |%-40s| |%-40s| |%-40s| ",x+++".",s,"No Type",temp.length()+" bytes");
				System.out.println();
			}
			
			}
				
		}
		
	
	}
	static void operations(File input_file,String directory)
	{
		
	}
	

}
