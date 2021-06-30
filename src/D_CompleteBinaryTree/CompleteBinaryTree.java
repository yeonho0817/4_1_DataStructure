package D_CompleteBinaryTree;

public class CompleteBinaryTree {
	private int[] binaryTree;
	// i의 부모노드는 i/2
	// i의 왼쪽 자식은 2i
	// i의 오른쪽 자식은 2i+1
	
	public CompleteBinaryTree(int size) {
		// 배열 크기는 입력 값+1이 적절 ? or 크기 정해놓고 부족하면 resize ? 
		// 크기 정하면 0이 많음 -> 입력값 +1
		
		binaryTree = new int[size+1];
		
		for (int i=1; i<size+1; i++)
		{
			binaryTree[i] = i;
		}
	}
	
	private int getLeft(int nodeNumber)
	{
		return 2*nodeNumber;
	}
	
	private int getRight(int nodeNumber)
	{
		
		return 2*nodeNumber+1;
	}
	
	public void preorder(int nodeNumber)
	{
		if (nodeNumber <= binaryTree.length-1 )
		{
			System.out.print(binaryTree[nodeNumber] + " ");
			preorder(getLeft(nodeNumber));
			preorder(getRight(nodeNumber));
		}
	}
	
	public void inorder(int nodeNumber)
	{
		if (nodeNumber <= binaryTree.length-1 )
		{
			inorder(getLeft(nodeNumber));
			System.out.print(binaryTree[nodeNumber] + " ");
			inorder(getRight(nodeNumber));
		}
	}
	
	public void postorder(int nodeNumber)
	{
		if (nodeNumber <= binaryTree.length-1 )
		{
			postorder(getLeft(nodeNumber));
			postorder(getRight(nodeNumber));
			System.out.print(binaryTree[nodeNumber] + " ");
		}
	}
	
	public void levelorder()
	{
		CircularQueue circularQueue = new CircularQueue();
		
		// 입력
		circularQueue.add(binaryTree);
		
		// 출력
		System.out.println(circularQueue.remove());
		
	}
	
	
	public String toString()
	{
		// 레벨 -> 세로 반복 횟수 = log2(N+1)
		
		CircularQueue circularQueue = new CircularQueue();
		circularQueue.add(binaryTree);
		
		final int SIZE = 2;
		
		String[] arrayNode = new String[SIZE];
		int level = (int) (Math.log((binaryTree.length-1) * 2) / Math.log(2));
		int blankCount = ((int) Math.pow(2, level-1)) - 1;  // 최대 노드 개수의 총 공뱅
		
		
		for (int i=0; i < (level-1)*2 + 1; i++)
		{
			
			// 숫자를 미리 읽음.
			if (i==0 || i%2 == 1)
			{
				arrayNode = new String[(int) Math.pow(2, i/2)];		// 어떤 총 노드 수 = 레벨의 2^n승
				
				for (int j=0; j < Math.pow(2, (i+1)/2) ; j++)
				{
					if (j == arrayNode.length)
						arrayNode = resize(arrayNode);
					
					if (circularQueue.getSize() != 0)
						arrayNode[j] = String.valueOf( circularQueue.pop() );
					else
						arrayNode[j] = "X";		
				}
			}
			
			
			if (i%2 == 1)	// 문자 출력
			{
				for (int j=0; j<blankCount; j++)
					System.out.print("     ");
				
				for (int j=0; j<arrayNode.length/2; j++)
				{
					String str = "+";
					
					for (int k=0; k<blankCount+1; k++)
					{
						str += "-----";
					}
					str = str.substring(0, str.length()-2) + "+";
					
					System.out.print(str);
					
					for (int k=0; k<blankCount+1; k++)
					{
						System.out.print("     ");
					}
				}
			}
			else	//숫자 출력
			{	
				// 빈공간 출력
				for (int j=0; j<blankCount-1; j++)
					System.out.print("     ");
				
				// 숫자에 넣은 배열 출력
				for (int j=0; j<arrayNode.length && arrayNode[j] != null; j++)
				{	
					if (i == (level-1)*2)		// 마지막줄이면
					{
						if (j==0)				// 첫번째는 그냥 출력
							System.out.print(arrayNode[j]);
						else if (j==1)			// 두번째는 맨 앞에 한글자가 출력되어서 한칸 줄여서 출력
							System.out.printf("%4s", arrayNode[j]);
						else
							System.out.printf("%5s", arrayNode[j]);
					}
					else
						System.out.printf("%5s", arrayNode[j]);

					
					if (j != Math.pow(2, i/2) -1 )
					{
						for (int k=0; k<blankCount; k++)
							System.out.print("     ");
					}
				}
				
				blankCount -= (blankCount+1)/2;
			}
			System.out.println();
		}
		
		return null;
	}
	
	private String[] resize(String[] array)
	{
		String[] newArray = new String[array.length*2];
		
		for (int i=0; i<array.length; i++)
		{
			newArray[i] = array[i];
		}
		
		return newArray;
	}
	
}
