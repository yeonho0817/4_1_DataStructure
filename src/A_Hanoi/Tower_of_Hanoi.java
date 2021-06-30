package A_Hanoi;

import java.util.Scanner;

public class Tower_of_Hanoi {
	
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		moveDisk("1", "2", "3", num);
		
		System.out.println("\nResult : " + cnt);
	}
	
	public static void moveDisk(String first, String center, String last, int num)
	{
		if (num == 1)
		{
			++cnt;
			System.out.println(num + " : " + first + " -> " + last);
		} else 
		{
			moveDisk(first, last, center, num-1);
			++cnt;
			System.out.println(num + " : " + first + " -> " + last);
			
			moveDisk(center, first, last, num-1);
		}
	}

}
