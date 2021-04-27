package file_exp;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class File_Explorer {
	

	public static void main(String[] args) {
		
		 System.out.println("--------------------------------------Welcome to the File Explorer Application by Company Lockers Pvt. Ltd.-----------------------------------------");
		 System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> This Project is developed by : Saurabh Kawatra <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
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
				 System.out.println("\n**************************************************************** Thank you for using the Application ***************************************************************");
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
			System.out.println("Invalid Input!");
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
			System.out.println("\n-------------------------------------------------------------Main Menu---------------------------------------------------------------\n");
			System.out.println("You are in Directory--> "+"[ "+input_file+" ]\n");
			System.out.println("Choose an option among the following to perform in this Directory");
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
				System.out.println("\n************************************************************* Thank you for using the Application *************************************************************");
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
		File[] list_of_files = input_file.listFiles();
		Arrays.sort(list_of_files);
		int x=1;
		if(list_of_files.length==0)
			System.out.println("\n\t["+directory+"]---> This Directory is an Empty Directory!\n");
		else
		{
			System.out.println("\nAll Files in Directory : "+directory+" are:\n");
			System.out.printf("|%-4s| |%-70s| |%-20s| |%-40s ","No.","File Name (Ascending)","File Type","File Size");
			System.out.println();
			for(int i=0;i<140;i++)
			System.out.print("-");
			System.out.println();
			for(File s:list_of_files)
			{
				
				long size=0;
				size=s.length();
				String name=s.getName();
				String[] type=name.split("[.]");
				if(s.isDirectory())
				{
				System.out.printf("|%-4s| |%-70s| |%-20s| |%-40s ",x+++".",name,"Directory / Folder","----");
				System.out.println();
				}
				else
				{
					if(type.length>1)
					{
					System.out.printf("|%-4s| |%-70s| |%-20s| |%-40s ",x+++".",name,type[type.length-1],size/1024+" KB");
					System.out.println();
					}
					else
					{
					System.out.printf("|%-4s| |%-70s| |%-20s| |%-40s ",x+++".",name,"No Type",size/1024+" KB");
					System.out.println();
					}
				
				}
					
			}
		}
					
	}
	static void operations(File input_file,String directory)
	{
		while(true)
		{
			int choice;
			System.out.println("\n------------------------------------------------------------------Directory Operations-------------------------------------------------------------\n");
			System.out.println("You are in Directory :- [ "+directory+" ]\n");
			System.out.println("Choose the option to perform in this Directory");
			System.out.println("1. Add a File");
			System.out.println("2. Delete a File");
			System.out.println("3. Search a File");
			System.out.println("4. Go back to the Main Menu");
			System.out.println("5. Exit the Application");
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
				addfile(input_file,directory);
			}
			else if(choice==2)
			{
				deletefile(input_file,directory);
			}
			else if(choice==3)
			{
				String[] listoffiles = input_file.list();
				if(listoffiles.length==0)
				{
					System.out.println("\nSorry! ["+directory+"] is an Empty Directory!");
					System.out.println("\tNo Files to Search in this directory!");
				}
				else
				{
					List<File> searchresults = new ArrayList<File>();
					String keyname="",input;
					System.out.println("------------------------------------------------------------------Search Console-------------------------------------------------------------");
					System.out.println("\nYou are in Directory :- [ "+directory+" ]\n");
					System.out.println("Enter the File name that you want search in this directroy");
					System.out.print("Enter Here---->");
					input=stringreader();
					keyname=Pattern.quote(input);
					searchresults=searchfile(input_file,keyname);
					if(searchresults.isEmpty())
					{
						System.out.println("\nSorry! No Files or Folders Found with the name \""+input+"\" inside the directory!");
						System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
					}
					else
					{
						System.out.println("\nDeep Search Operation Performed over all files and sub-folders of Directory [ "+directory+" ]");
						System.out.println("\n"+" ( "+searchresults.size()+" ) "+" Search Results Found :-\n");
						System.out.printf("\n|%-3s| |%-40s| |%-30s| |%-70s| ","No.","File Name","File Type","File Location");
						System.out.println();
						String resultname,path,name;
						int x=1;
						for(File e:searchresults)
						{
							 resultname=e.getName();
							 path=e.getAbsolutePath();
							 name=e.getName();
							 String[] type=name.split("[.]");
								if(type.length>1)
								{
								System.out.printf("|%-3s| |%-40s| |%-30s| |%-70s| ",x+++".",e.getName(),type[type.length-1],e.getAbsolutePath());
								System.out.println();
								}
								else
								{
									
									if(e.isDirectory())
								      	
									{
										System.out.printf("|%-3s| |%-40s| |%-30s| |%-70s| ",x+++".",e.getName(),"Directory / Folder",e.getAbsolutePath());
									   	System.out.println();
								      	}
									else
								     	{
										System.out.printf("|%-3s| |%-40s| |%-30s| |%-70s| ",x+++".",e.getName(),"No Type",e.getAbsolutePath());
										System.out.println();
								     	}
						        } 	
					      }
				}
			}	
		}
			else if(choice==4)
			{
				break;
			}
			else if(choice==5)
			{
				System.out.println("\n********************************************************** Thank you for using the Application **************************************************************");
				System.exit(0);
			}
			else
			{
				System.out.println("Option doesn't Exist! Please Try Again!");
			}
		}
		
	}
	static void addfile(File input_file,String directory)
	{
		System.out.println("\nOption chosen to Add a file in the directory ["+directory+"]");
		System.out.println("Please type 'Yes' if you wish to Proceed");
		System.out.print("Type Confirmation here -->");
		String confirm=stringreader();
		if(confirm.matches("[Y|y][e|E][s|S]"))
		{
			while(true)
			{
				String name;
				System.out.println("\n"+"Enter the Name that you'd like to keep for the New File");
				System.out.print("Type the Name here -->");
				name=stringreader();
				System.out.println("Name Entered -> "+name);
				if(name.matches("([^(\\\\|/|:|?|*|<|>|||\")*])*")) //pattern to accept any character other than \ / ? < > \ " | * 
				{
					String g=directory.concat("\\"+name);
					File F=new File(g);
					if(F.exists())
					{
						System.out.println("\nA File already exists with a same name in the directory.");
						System.out.println("Please Try Again with a different name.");
						continue;
					}
					else
					{
						try {
							F.createNewFile();
						}catch(IOException e)
						{
							System.out.println("\nException occured."+e);
							System.out.println("Please try again!");
						}
						if(F.exists())
						{
							System.out.println("\n\t\tFile has been successfully created.");
							System.out.println("File name :- \""+name+"\"\tFile Location :- "+g);
							break;
						}
						else
						{
							System.out.println("File not created due to an unknown issue. Please Try again!");
						}
					}
				}
				else
				{
					System.out.println("\nFile name cannot contain characters \\ / ? < > \" | * : ");
					System.out.println("Please enter a different name which do not contain these characters");
					continue;
				
				}
			}

			}
			else
			{
				System.out.println("\n\t\t\tSorry! Unable to confirm your Response!");
				System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
			}
		
		}
	static void deletefile(File input_file,String directory)
	{
		String[] listoffiles=input_file.list();
		if(listoffiles.length==0)
		{
			System.out.println("\nSorry! ["+directory+"] is an Empty Directory!");
			System.out.println("\tNo Files to Delete in this directory!");
			System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
		}
		else
		{
			System.out.println("\nOption chosen to Delete a file in the directory ["+directory+"]");
			System.out.println("\nPlease type the Name of the File that you wish to Delete.");
			System.out.print("Type the Name here -->");
			String input=stringreader();
			String keyname=Pattern.quote(input);
			System.out.println("\nFile Name Entered :- "+input);
			List<File> Search=searchforkeyname(input_file,keyname);
			if(Search.isEmpty())
			{
				System.out.println("\nSorry! There is no file with Name :- \""+input+"\" in Directory :- "+directory);
				System.out.println("\nPlease try with Again with a vaild Filename!");
				System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
			}
			else if(Search.size()==1)
			{
				System.out.println("The File :- \""+Search.get(0).getName()+"\" would be permanantly deleted from Directory :- "+directory);
				System.out.println("Please type 'Yes' if you wish to Proceed");
				System.out.print("Type Confirmation here -->");
				String confirm=stringreader();
				if(confirm.matches("[Y|y][e|E][s|S]"))
				{
					Search.get(0).delete();
					if(Search.get(0).exists()==false)
					{
						System.out.println("\n\tFile has been successfully Deleted.");
						System.out.println("File name :- \""+Search.get(0).getName()+"\" has been deleted from Directory :- "+Search.get(0));
					}
					else
					{
						System.out.println("Unable to Delete the File!");
						System.out.println("Please make sure that File isn't open or in use.");
						System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
					}
				}
				else
				{
					System.out.println("\n\t\t\tSorry! Unable to confirm your Response!");
					System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
				}
			}
			else if(Search.size()>1)
			{
				System.out.println("\nThere are multiple files found with name:- \""+input+"\" in Directory:- "+directory);
				System.out.println("\nChoose the numeric option to Delete the specific file.");
				System.out.printf("\n|%-3s| |%-40s| |%-40s| ","No.","File Name","File Location");
				for(File e:Search)
				{
					System.out.printf("\n|%-3s| |%-40s| |%-40s| ",(Search.indexOf(e)+1),e.getName(),e);
				}
				System.out.println("\n|"+(Search.size()+1)+"  | Delete all the above mentioned files.");
				System.out.print("Enter the Choice Here--->");
				int choice=0;String s="";Scanner sc=new Scanner(System.in);
				try {s=sc.nextLine();if(s.matches("[0-9]+"))
				{choice=Integer.valueOf(s);}}catch(Exception e) {System.out.println("Invalid Input");}
				
				
				if(0<choice&&choice<=Search.size())
				{
					System.out.println("The File :- "+Search.get(choice-1).getName()+" would be permanantly deleted from Directory :- "+directory);
					System.out.println("Please type 'Yes' if you wish to Proceed");
					System.out.print("Type Confirmation here -->");
					String confirm=stringreader();
					if(confirm.matches("[Y|y][e|E][s|S]"))
					{
						Search.get(choice-1).delete();
						if(Search.get(choice-1).exists()==false)
						{
							System.out.println("\n\tFile has been successfully Deleted.");
							System.out.println("File name :- "+Search.get(choice-1).getName()+" deleted from Directory :- "+Search.get(choice-1));
						}
						else
						{
							System.out.println("Unable to Delete the File!");
							System.out.println("Please make sure that File isn't open or in use.");
							System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
						}
					}
					else
					{
						System.out.println("\n\t\t\tSorry! Unable to confirm your Response!");
						System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
					}
				}
				else if(choice==(Search.size()+1))
				{
					System.out.println("\nOption chosen to Delete all the above mentioned files in the directory ["+directory+"]");
					System.out.println("Please type 'Yes' if you wish to Proceed");
					System.out.print("Type Confirmation here -->");
					String confirm=stringreader();
					if(confirm.matches("[Y|y][e|E][s|S]"))
					{
						for(File e:Search)
						{
							e.delete();
							if(e.exists()==false)
							{
								System.out.println("File name :- "+e.getName()+" deleted from Directory :- "+e);
							}
							else
							{
								System.out.println("Unable to Delete "+e.getName()+" from Directory :- "+e);
								System.out.println("Please make sure that File isn't open or in use.");
							}
						}
					}
					else
					{
						System.out.println("\n\t\t\tSorry! Unable to confirm your Response!");
						System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
					}
				}
				else
				{
					System.out.println("\nInvalid Input!");
					System.out.println("\n<<<<<< Proceeding Back to Directory Operations <<<<<<<<\n");
				}
					
			}
				
		}
		
	}
	static List<File> searchfile(File input_file,String keyname)
	{
		List<File> searchresults=new ArrayList<File>();
		File[] filesindirectory;
		filesindirectory=input_file.listFiles();           //saving all the files of the input_file directory in filesindirectory 
		int numofsubdirectories=0,c=0;
		
		if(filesindirectory!=null)
		{
		
		for(File e:filesindirectory)                    //finding number of sub-folders in the directory
			if(e.isDirectory())
			numofsubdirectories++;
		
		File[] subdirectoryfiles = new File[numofsubdirectories];
		for(File e:filesindirectory)                    //Saving the sub-folders in subdirectoryfiles file array
			if(e.isDirectory())
				subdirectoryfiles[c++]=e;
		
		if(numofsubdirectories==0)
		{
			searchresults=searchforkeyname(input_file,keyname);
			return(searchresults);
		}
		else
		{
			searchresults=searchforkeyname(input_file,keyname);
			for(int i=0;i<numofsubdirectories;i++)
			{
					List<File> temp=null;
					temp=searchfile(subdirectoryfiles[i],keyname);
					if(temp==null)
					{
					   continue;
					}
					else
					{
						for(File e:temp)	
							searchresults.add(e);
					}
				   
			}
			return(searchresults);
		}
		
	  }
		else
		{
			return(null);
		}
	}
	static List<File> searchforkeyname(File file,String keyname)
	{
		List<File> searchresults=new ArrayList<File>();
		String[] filesindirectory;
		filesindirectory=file.list();
		for(String s:filesindirectory)
		{
			if(s.matches(keyname+"[.][0-9|a-z|A-Z]*")||s.matches(keyname))
			{
				File f=new File(file.getAbsolutePath()+"\\"+s);
				searchresults.add(f);
			}
		}
		return(searchresults);
	}

}
