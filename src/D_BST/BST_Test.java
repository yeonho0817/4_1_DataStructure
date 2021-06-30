package D_BST;

import java.util.Scanner;

public class BST_Test {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			System.out.print("문자열들을 입력하세요. (마지막은 quit) : ");
			String input = scanner.nextLine();
			
			if (input.equals("quit")) break;
			
			BST_Operation operation = new BST_Operation();
			
			operation.init();
			
			operation.createTree(input);
			operation.printTree();
			
		}
	}
}
