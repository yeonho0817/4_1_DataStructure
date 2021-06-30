package A_Fibonacci;

import java.util.Scanner;

public class FibonacciTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		int first_num = 0;
		int second_num = 1;
		int sum = 0;
		
		for (int i=2; i<num; i++)
		{
			sum = first_num + second_num;
			first_num = second_num;
			second_num = sum;	
		}
		
		System.out.println("반복문 : " + num + "번째 피보나치 수 : " + sum);
		
		
		Fibonacci fibo = new Fibonacci();
		
		System.out.println("재귀 : " + num + "번째 피보나치 수 : " +  fibo.Fibo(num-1));
		
		
		scanner.close();
	}

}
