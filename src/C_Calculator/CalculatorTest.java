package C_Calculator;

import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {
		// 중위, 후위 -> queue
		// 계산 -> stack
		
		Scanner scanner = new Scanner(System.in);
				
		while (true)
		{
			System.out.print("식을 입력하세요.(종료는 quit) : ");
			String input = scanner.nextLine();
			
			if (input.equals("quit")) break;
			
			ListQueue<Token> queue = new ListQueue<>();
			queue.push(input);
//			System.out.println(queue.toString());
			
			
			System.out.print("--- postfix notation : ");
			queue = queue.postfix();
			
			
			System.out.print("\n--- 결과 : ");
			ListStack<Token> resultStack = new ListStack<>();
			String result = resultStack.calculatePostfix(queue);
			System.out.println(result + "\n");
			
		}
	}
	
	

}
