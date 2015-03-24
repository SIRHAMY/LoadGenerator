import java.util.Random;


public class CreateLoad {
	
	protected Random rand;
	
	//Respective chance of each laundry load being selected (use as fractions where 1.0 = 100%)
	//Make sure all fractions end up equaling 1
	double whites = 0.2;
	double colors = 0.5;
	double brights = 0.1;
	double permPress = 0.05;
	double woolens = 0.05;
	double delicate = 0.1;
	
	//Water Level chances - Make sure all double end up equaling 1
	double low = 0.1;
	double medium = 0.4;
	double high = 0.5;
	
	//Clothing size chances
	double smallLoad = 0.1;
	double mediumLoad = 0.4;
	double largeLoad = 0.5;
	
	public CreateLoad()
	{
		rand = new Random();
	}
	
	//creates load and returns in string format
	public String printLoad()
	{
		StringBuffer result = new StringBuffer();
		
		//Decide number of loads participant is making
		int loadNum = rand.nextInt(3);
		
		result.append(getAge() + "\t" + getRace() + "\t" + getGender() + "\t");
		
		for(int i = 0; i<=loadNum; i++)
		{
			//Add formatting for multiple loads
			if(i > 0) result.append("\t \t \t ");
			
			String clothingSize = getClothingSize();
			result.append(clothingSize + "\t" + getLevelSelected(clothingSize) + "\t" + getType() + "\n");
			
		}
		
		return result.toString();
	}
	
	private String getType()
	{
		double type = rand.nextDouble();
		
		String cType;
		
		if(type < whites) cType = "Whites";
		else if(type< whites+ brights) cType = "Brights";
		else if(type< whites+brights+permPress) cType = "Perm Press";
		else if(type<whites+brights+permPress + woolens) cType = "Woolens";
		else if(type<whites+brights+permPress+woolens+delicate) cType = "Delicate";
		else cType = "Colors";
		
		return cType;
	}
	
	private String getLevelSelected(String size)
	{
		String result;
		
		double level = rand.nextDouble();
		
		if(size.equals("Large")) result = "High";
		else if(size.equals("Medium"))
		{
			if(level < medium) result = "Medium";
			else result = "High";
		}
		else
		{
			if(level < low) result = "Low";
			else if(level < low+medium) result = "Medium";
			else result = "High";
		}
		
		return result;
	}
	
	private String getClothingSize()
	{
		String loadSize;
		
		double sizeChance = rand.nextDouble();
		if(sizeChance< smallLoad) loadSize = "Small";
		else if(sizeChance < smallLoad + mediumLoad) loadSize = "Medium";
		else loadSize = "Large";
		
		return loadSize;
	}
	
	//Generate race of participant
	protected String getRace()
	{
		String race;
		
		switch(rand.nextInt(4))
		{
			case 0: race = "White";
				break;
			case 1: race = "Asian";
				break;
			case 2: race = "Black";
				break;
			case 3: race = "Hispanic";
				break;
			default: race = "N/A";
				break;
		}
		
		return race;
	}
	
	//Generate age of participant
	private String getAge()
	{
		String age;
		
		//Leaving open for future development
		switch(0)
		{
			case 0:	age = "18-25";
				break;
			default: age = "N/A";
				break;
		}
		
		return age;
	}
	
	private String getGender()
	{
		String gender;
		
		switch(rand.nextInt(2))
		{
			case 0: gender = "Male";
				break;
			case 1: gender = "Female";
				break;
			default: gender = "N/A";
				break;
		}
		
		return gender;
	}
	
}
