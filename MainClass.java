import java.io.File;
import java.util.*;


public class MainClass {

	public static Winner [] listOfWinners;
	public static void loadFromFile()
	{
		try{
			//Create instance of Scanner and provide instance of File pointing to the text file
			Scanner input = new Scanner(new File("WorldSeriesWinners.txt"));
			
			//Get the number of teams
			int years = input.nextInt();
			input.nextLine();//move to the next line
			
			//Create the array
			listOfWinners = new Winner[years];
			
			//for every year in the text file
			for(int index = 0; index<years; index++)
			{
				//Get the year
				int year = input.nextInt();
				input.skip("	");
				//Get the team
				String team = input.nextLine();
				
				//Create an instance of Winner and add it to the next spot in the array
				listOfWinners[index] = new Winner(team,year);
			}
		}catch(Exception e)
		{
			System.out.println("Hey Meatbag, I'm Bender, and something wrong in the loadFromFile method happened!");
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	public static void sortByTeamName()
	{
		//Fill In Code
		boolean sorting = true;
		Winner temp;
		while(sorting)
		{
			sorting = false;
			 for ( int j = 0;  j < listOfWinners.length - 1;  j++ )
             {
				 if ( listOfWinners[j].getTeam().compareTo(listOfWinners[j+1].getTeam()) > 0 )
                 {                                             // ascending sort
					 temp = listOfWinners[j];
					 listOfWinners[j] = listOfWinners[j+1];     // swapping
					 listOfWinners[j+1] = temp; 
					 sorting = true;
                  } 
              }
		}
	}
	
	public static void sortByYear()
	{
		//Fill In Code
		
		//Fill In Code
		boolean sorting = true;
		Winner temp;
		while(sorting)
		{
			sorting = false;
			for ( int j = 0;  j < listOfWinners.length - 1;  j++ )
		    {
				if ( listOfWinners[j].getYear() > listOfWinners[j+1].getYear())
				{                                             // ascending sort
					temp = listOfWinners[j];
					listOfWinners[j] = listOfWinners[j+1];     // swapping
					listOfWinners[j+1] = temp; 
					sorting = true;
				} 
		    }
		}			
	}
	
	public static void printArray()
	{
		//Print the array
		for(int index=0; index<listOfWinners.length; index++)
		{
			System.out.println(listOfWinners[index].getYear()+" Winners " + listOfWinners[index].getTeam());
		}
	}
	
	public static void searchForWinnerByYear(int year)
	{			
		//Fill In Code
		boolean exists = false;
		//run through entire array
		for(int i=0; i < listOfWinners.length; i++)
		{
				//if the year is in the array print it
			if(listOfWinners[i].getYear() == year)
			{
				System.out.println(listOfWinners[i].getYear() + " " + listOfWinners[i].getTeam());
				exists = true;
				i = listOfWinners.length;
			}
				
		}
		//if the year isn't in the array its invalid
		if(!exists)
			System.out.println("Invalid year");		
	}
	
	public static void searchForYearsATeamWon(String team)
	{
		//Fill In Code
		boolean exists = false;
		
		for(int i=0; i < listOfWinners.length; i++)
		{
			if(team.equals(listOfWinners[i].getTeam()))
			{
				System.out.println(listOfWinners[i].getYear() + " " + listOfWinners[i].getTeam());
				exists = true;
			}
		}
		
		if(!exists)
			System.out.println("The " + team + " never won the World Series :(");		
		
	}
	
	public static void main(String[] args) {
		
		int choice;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("World Series Program");
		
		//Load textfile 
		loadFromFile();
		do{
			System.out.println("1.........Print out the Winner List sorted by team name");
			System.out.println("2.........Print out the Winner List sorted by years");
			System.out.println("3.........Print out the Winner of a particular year");
			System.out.println("4.........Print out the years a particular team won");
			System.out.println("5.........Exit the Program");
			System.out.println("Which Choice Would You Like?");
			choice = keyboard.nextInt();
			
			switch(choice)
			{
			case 1:
				//Option 1, sort array by name and print out.
				sortByTeamName();
				printArray();
				break;
			case 2:
				//Option 2, sort array by year and print out.
				sortByYear();
				printArray();
				break;
			case 3:
				//Option 3 Search for winner by year
				System.out.println("What year would you like to find the winner?");
				int year = keyboard.nextInt();
				searchForWinnerByYear(year);
				break;
			case 4:
				//Option 4 Search for years a team won
				System.out.println("What team would you like to check for years won?");
				keyboard.nextLine();
				String team = keyboard.nextLine();
				searchForYearsATeamWon(team);
				break;
			case 5://Exit
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}while(choice != 5);
		
		System.out.println("Goodbye!");
	}

}
