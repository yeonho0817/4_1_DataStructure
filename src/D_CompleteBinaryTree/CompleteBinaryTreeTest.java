package D_CompleteBinaryTree;

import java.util.Scanner;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("노드 개수를 입력하세요 : ");
		int nodeNumber = scanner.nextInt();
		
		CompleteBinaryTree binaryTree = new CompleteBinaryTree(nodeNumber);
	
		// tree 출력 직접 구현했습니다.
		binaryTree.toString();
		
		System.out.printf("\n%-10s : ", "preorder");
		binaryTree.preorder(1);
		
		System.out.printf("\n%-10s : ", "inorder");
		binaryTree.inorder(1);
		
		System.out.printf("\n%-10s : ", "postorder");
		binaryTree.postorder(1);
		
		System.out.printf("\n%-10s : ", "levelorder");
		binaryTree.levelorder();
		
		System.out.printf("");
	}

}
