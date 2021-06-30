package A_Fibonacci;


public class Fibonacci {

	public  int Fibo(int num)
	{
		if (num == 0)
			return 0;
		else if (num == 1)
			return 1;
		else
			return Fibo(num-2) + Fibo(num-1);
	}

}
