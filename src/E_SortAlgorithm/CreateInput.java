package E_SortAlgorithm;

public class CreateInput {
	Comparable[] intInput;
	Comparable[] doubleInput;
	Comparable[] stringInput;
	Comparable[] studentInput;	
	
	public CreateInput(int size) 
	{
		// 만개
		intInput = new Integer[size];
		doubleInput = new Double[size];
		stringInput = new String[size];
		studentInput = new Student[size];	
	}
	
	// n = 10000, 20000, 30000, 40000, 50000
	public int[] createRandom(int[] randomInt)
	{
		for (int i=0; i<intInput.length; i++)
		{
			randomInt[i] = (int) ((Math.random() * intInput.length)%10);
		}
		
		return randomInt;
	}
	public void createRandom()
	{
		for (int i=0; i<intInput.length; i++)
		{
			intInput[i] = (int) ((Math.random() * intInput.length)%10);
		}
		
		for (int i=0; i<doubleInput.length; i++)
		{
			doubleInput[i] =  Math.round(  (Math.random() * doubleInput.length) * 1000  )/1000.0;
		}
		// A~Z : 65~90 (0~25)
		// a~z : 97~122 (27~52)
		for (int i=0; i<stringInput.length; i++)
		{
			String randomStr = "";
			for (int j=0; j<12; j++)	// 문자 길이 12개
			{
				int randomInt = (int) (Math.random() * 52) + 1;
				
				char c;
				if (randomInt > 26)// 소문자
					c = (char) (randomInt + 70);
				else 
					c = (char) (randomInt + 64);
				
				randomStr += c;
			}
			stringInput[i] = randomStr;
		}
		for (int i=0; i<studentInput.length; i++)
		{
			studentInput[i] = new Student();
		}
		
	}
	
	public void createDecrease()
	{
		Comparable[] temp = new Integer[intInput.length];
		
		for (int i=intInput.length-1; i>=0; i--)
		{
			temp[(intInput.length-1)-i] = intInput[i];
		}
		intInput = temp;
		
		
		temp = new Double[doubleInput.length];
		for (int i=0; i<doubleInput.length; i++)
		{
			temp[(doubleInput.length-1)-i] = doubleInput[i];
		}
		doubleInput = temp;
		
		
		temp = new String[stringInput.length];
		for (int i=0; i<stringInput.length; i++)
		{
			temp[(stringInput.length-1)-i] = stringInput[i];
		}
		stringInput = temp;
		
		
		temp = new Student[studentInput.length];
		for (int i=0; i<studentInput.length; i++)
		{
			temp[(studentInput.length-1)-i] = studentInput[i];
		}
		studentInput = temp;
		
	}
	
	public String toString(Object[] arr)
	{
		String str = "";
		
		for (int i=0; i<arr.length; i++)
		{
			str += "[" + arr[i].toString() + "] ";
		}
		
		return str;
	}
	
	
}
