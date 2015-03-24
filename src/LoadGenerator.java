import java.util.Scanner;

/*
 * LoadGenerator creates dummy data for laundry load observations
 * Author: Hamilton Greene
 */
public class LoadGenerator {
	public static void main(String[] args)
	{
		//Initialize Scanner, CreateLoad
		Scanner myScanner = new Scanner(System.in);
		CreateLoad myLoad = new CreateLoad();
		
		//Ask for number of people to observe
		System.out.println("How many people would you like to observe? (int)");
		int personNum = myScanner.nextInt();
		
		//Sets up table format
		
		
		//Create observations for given number of persons
		for(int i = 0; i<personNum; i++)
		{
			System.out.println(myLoad.printLoad());
		}
		
		myScanner.close();
	}
}
