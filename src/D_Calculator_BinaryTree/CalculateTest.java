package D_Calculator_BinaryTree;

import java.util.Scanner;

public class CalculateTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Calculator calculator = new Calculator();
		
		while (true)
		{
			System.out.print("--------------------\n계산식을 입력하세요. (종료는 quit) : ");
			String input = scanner.nextLine();
			
			if (input.equals("quit")) break;
			
			//들어있는 값 초기화
			calculator.init();
			
			// 중위
			calculator.inorder(input);
			
			System.out.print("---- 후위 계산식은 : ");
			calculator.postorder();

			calculator.createTree();
			
			System.out.print("\n---- 전위 계산식은 : ");
			calculator.preorder();
			
			System.out.println("\n---- 트리는 : ");
			calculator.printTree();
			
			System.out.print("\n---- 결과는 : ");
			calculator.printResult();
			
			System.out.println();
		}
	}

}
