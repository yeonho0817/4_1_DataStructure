package D_BST;

public class BST_Operation {
	BST bst;
	
	public BST_Operation() {
		bst = null;
	}
	
	public void init()
	{
		bst = new BST();
	}
	
	public void createTree(String input)
	{
		String[] str = input.split(" ");
		
		for (int i=0; i<str.length; i++)
		{
			bst.insertNode(str[i], str[i]);
		}
	}
	
	public void printTree()
	{
//		printTree(bst.getRoot());
//		final int SIZE = 1;
		int level = bst.height(bst.getRoot());
		int blankCount = ((int) Math.pow(2, level-1))-1;  // 최대 노드 개수의 총 공뱅
		
		// 배열에 root부터 해서 그의 자식들을 넣어서 출력
		
		Node cur = bst.getRoot();
		
		Node[] parentNode = new Node[] {cur};
		Node[] childNode ;
		
		for (int i=0; i<level; i++)
		{
			
			// 빈공간 출력
			for (int j=0; j<blankCount-1; j++)
				System.out.print("     ");
			
			
			int childIndex = 0;
			childNode = new Node[parentNode.length*2];
			
			for (int j=0; j<parentNode.length; j++, childIndex++)
			{
				String str = null;
				
				if (parentNode[j] == null)
				{
					str = "X";
					childNode[childIndex] = new Node("X", "X");
					childNode[++childIndex] = new Node("X", "X");
				} else
				{
					str = parentNode[j].getValue().toString();
					
					childNode[childIndex] = parentNode[j].getLeftChild();
					childNode[++childIndex] = parentNode[j].getRightChild();
				}
				
				System.out.printf("%5s", str);
				
				if (j != parentNode.length-1)
				{
					for (int k=0; k<blankCount-1; k++)
						System.out.print("    ");
				}
			}
			
			System.out.println();
			
			if (i == level-1) break; 	// 마지막줄은 문자 X
			
			// 문자 출력z
			
			blankCount -= (blankCount)/2;
			
			for (int j=0; j<blankCount; j++)
				System.out.print("     ");
			
			for (int j=0; j<parentNode.length; j++)
			{
				String str = "+";
				
				for (int k=0; k<blankCount; k++)
				{
					str += "-----";
				}
				str = str.substring(0, str.length()-2) + "+";
				
				System.out.print(str);
				
				for (int k=0; k<blankCount; k++)
				{
					System.out.print("     ");
				}		
			}
			System.out.println();
			
			
			// child를 parent로
			parentNode = new Node[childNode.length];
			parentNode = childNode;
			
			
			
		}
	}
	
	private Node[] resize(Node[] array)
	{
		Node[] newArray = new Node[array.length*2];
		
		for (int i=0; i<array.length; i++)
		{
			newArray[i] = array[i];
		}
		
		return newArray;
	}
		
}
