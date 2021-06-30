package D_Calculator_BinaryTree;

public class Calculator {
	ListQueue<Token> infix;
	ListQueue<Token> postfix;
	ListStack<Token> calculate;
	BinaryTree<Token> binaryTree;
	
	public Calculator() 
	{
		infix = postfix = null;
		calculate = null;
		binaryTree = null;
	}
	
	public void init()
	{
		infix = new ListQueue<>();
		postfix = new ListQueue<>();
		calculate = new ListStack<>();
		binaryTree = new BinaryTree<>();
	}
	
	public void inorder(String str)
	{
		Node<Token> prevNode = infix.getFront();
//		Node<Token> newNode = null;
		
		for (int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			
			if (c == ' ') continue;	// 공백이면 넘기기
			
			if (isOperator(c))	// 연산자
			{
				String prevOperator = "";
				
				if (!infix.isEmpty() && prevNode.getElement().getOperator() != null)
					prevOperator = prevNode.getElement().getOperator();
				
				if (prevOperator.equals(">") || prevOperator.equals("<"))	// 뒤에 한개 더 있는 거
				{
					prevNode.getElement().setOperator( prevOperator + prevOperator );
				} else 
				{
					String operator = "";
					
					// c=- && 이전이 ) 가 아니거나 && 이전이 ( 이거나,  이전이 연산자가 비어있는게 아니거나, 지금이 비었거나  ->  "m" 입력
					if ( c == '-' && !prevOperator.equals(")") && (prevOperator.equals("(") || ! prevOperator.equals("") || infix.isEmpty()) )
						operator = "m";
					else
						operator = String.valueOf(c);
					
					infix.push(new Token(operator));
					prevNode = infix.getRear();
				}
			} else		// 숫자
			{
				if ( !infix.isEmpty() && prevNode.getElement().getOperator() == null ) // 이 전에도 숫자여서 더해야함 (원래*10)+새거
				{
					prevNode.getElement().setOperand(prevNode.getElement().getOperand()*10 + Integer.parseInt(String.valueOf(c)) );
					
				} else 
				{
					infix.push(new Token(String.valueOf(c)));
					prevNode = infix.getRear();
				}
			}
			
		}
	}
	
	public void postorder()
	{
		ListStack<Token> stack = new ListStack<>();			// 연산자
		
		Node<Token> cur = infix.getFront();
		
		for (int i=0; i < infix.getSize(); i++, cur = cur.getNext())
		{
			String operator = cur.getElement().getOperator();
			
			if (operator != null) 		// 연산자 -> stack 넣음
			{
				if (stack.peek() != null && ! operator.equals("m"))
				{
					if (operator.equals("(") || stack.peek().getToken().equals("("))  //  현재가 괄호이거나 이전이 괄호이면 -> push
					{
						stack.push(new Token(operator));
					} else if (operator.equals(")"))		// -> 닫는 괄호면 ( 나올때까지 pop
					{	
						for (; !stack.isEmpty() && !stack.getTop().getElement().getOperator().equals("(");)
						{
							System.out.print(stack.peek().getToken() + " ");
							postfix.push(stack.pop());
						}
						stack.pop(); // "(" pop
					} else
					{	
						String[] OPERATOR = {"( )",		"~ m",	"* / %",	"+ -",		"<< >>",	"&",	"^",	"|"};					
						
						int topPriority = 0;
						int newPriority = 0;
						
						for (int j=0; j<OPERATOR.length; j++)
						{
							if (OPERATOR[j].contains(operator))
							{
								newPriority = j;
							} else if (OPERATOR[j].contains(stack.peek().getOperator()))
							{
								topPriority = j;
							}
						}
						
						while ( !stack.isEmpty() && topPriority <= newPriority  & !stack.peek().getToken().equals("("))
						{
							System.out.print(stack.peek().getToken() + " ");
							postfix.push(stack.pop());
							
							if (stack.peek() == null) break;
							for (int j=0; j<OPERATOR.length; j++)
							{
								if (OPERATOR[j].contains(stack.peek().getOperator()))
								{
									topPriority = j;
								}
							}
						}
						
						stack.push(new Token(operator));
					}
				} else
					stack.push(new Token(operator));
				
			} else		// 숫자면 걍 출력
			{
				System.out.print(cur.getElement().getToken() + " ");
				postfix.push(cur.getElement());
			}
		}
		
		// 모두 출력
		for (; stack.getTop() != null;)
		{
			System.out.print(stack.peek().getToken() + " ");
			postfix.push(stack.pop());
		}	
	}
	
	private boolean isOperator(char c)
	{
		if (48 <= c && c <= 57)		// 숫자
			return false;
		else
			return true;
	}
	
	public void createTree()
	{
		//postfix 피연산자 node에 저장 후 stack에 push
		//연산자 나타나면 이항/단항에 따라 피연산자 pop해서 subtree 구성해서 root를 push
		// 연산자의 leftChilden에 자식과의 연산 결과 저장
		
		ListStack<TreeNode<Token>> tempStack = new ListStack<>();
		
		for (; !postfix.isEmpty();)
		{
			TreeNode<Token> newNode = null;
			
			if (postfix.getFront().getElement().getOperator() == null)	// 피연산자
			{
				newNode = new TreeNode<>(new Token(postfix.pop().getToken()), null, null);
				tempStack.push(newNode);
			} else		// 연산
			{
				if (tempStack.isEmpty())
				{
					System.out.println("[오류] 이해할 수 없는 수식!!");
					break;
				}
				
				TreeNode<Token> firstNode = tempStack.pop();
				
				int result = 0;
				String operator = postfix.pop().getToken();
				
				
				if (operator.equals("m"))
				{
					result = firstNode.getItem().getOperand() * -1;
					newNode = new TreeNode<>(new Token(operator), firstNode, null);
					newNode.getItem().setOperand(result);
				} else if (operator.equals("~"))
				{
					result = ~ firstNode.getItem().getOperand();
					
					newNode = new TreeNode<>(new Token(operator), firstNode, null);
					newNode.getItem().setOperand(result);
				} else 
				{
					if (tempStack.isEmpty())
					{
						System.out.println("[오류] 이해할 수 없는 수식!!");
						break;
					}
					
					TreeNode<Token> secondNode = tempStack.pop();
					
					if (operator.equals("*"))
						result = secondNode.getItem().getOperand() * firstNode.getItem().getOperand() ;
					else if (operator.equals("/"))
						result = secondNode.getItem().getOperand() / firstNode.getItem().getOperand() ;
					else if (operator.equals("%"))
						result = secondNode.getItem().getOperand() % firstNode.getItem().getOperand() ;
					else if (operator.equals("+"))
						result = secondNode.getItem().getOperand() + firstNode.getItem().getOperand() ;
					else if (operator.equals("-"))
						result = secondNode.getItem().getOperand() - firstNode.getItem().getOperand() ;
					else if (operator.equals("<<"))
						result = secondNode.getItem().getOperand() << firstNode.getItem().getOperand() ;
					else if (operator.equals(">>"))
						result = secondNode.getItem().getOperand() >> firstNode.getItem().getOperand() ;
					else if (operator.equals("&"))
						result = secondNode.getItem().getOperand() & firstNode.getItem().getOperand() ;
					else if (operator.equals("^"))
						result = secondNode.getItem().getOperand() ^ firstNode.getItem().getOperand() ;
					else if (operator.equals("|"))
						result = secondNode.getItem().getOperand() | firstNode.getItem().getOperand() ;
					
					
					newNode = new TreeNode<>(new Token(operator), secondNode, firstNode);
					newNode.getItem().setOperand(result);	
				}
				tempStack.push(newNode);
			}
		}
		
		// 마지막엔 root로 연결
		binaryTree.setRoot(tempStack.pop());
//		preOrder(binaryTree.getRoot());
	}
	
	public void preorder() 
	{
		preorder(binaryTree.getRoot());
	}
	
	public void preorder(TreeNode<Token> node)
	{
		// inorder이면 단항 연산자 먼저 출력해야함
		if (node!= null)
		{
			System.out.print(node.getItem().getToken() + " ");
			preorder(node.getLeftChild());
			preorder(node.getRightChild());
		}
	}
	
	public void printTree()
	{
//		System.out.println(binaryTree.height(binaryTree.getRoot()));
		// root부터 left, right자식을 queue에 넣어서 출력
		int level = binaryTree.height(binaryTree.getRoot());
		int blankCount = ((int) Math.pow(2, level-1)) - 1;  // 최대 노드 개수의 총 공뱅
		
		ListQueue<TreeNode<Token>> tempQueue = new ListQueue<>();
		
		if (binaryTree.getRoot() != null)
			tempQueue.push(binaryTree.getRoot());
		
		
		for (int i=0; i < level; i++)
		{
			
			// 빈공간 출력
			for (int j=0; j<blankCount-1; j++)
				System.out.print("     ");
			
			// 숫자에 넣은 배열 출력
			int queueSize = tempQueue.getSize();
			for (int j=0; j < queueSize; j++)
			{	
				TreeNode<Token> frontNode = tempQueue.pop();
				if (frontNode == null)
				{
					System.out.print("    X");
					tempQueue.push(new TreeNode<>(new Token("X"), null, null));
					tempQueue.push(new TreeNode<>(new Token("X"), null, null));
				}else
				{
					if (i == level-1)		// 마지막줄이면
					{
						if (j==0)				// 첫번째는 그냥 출력
							System.out.print(frontNode.getItem().getToken());
						else if (j==1)			// 두번째는 맨 앞에 한글자가 출력되어서 한칸 줄여서 출력
							System.out.printf("%4s", frontNode.getItem().getToken());
						else
							System.out.printf("%5s", frontNode.getItem().getToken());
					}
					else
						System.out.printf("[%s] %s", frontNode.getItem().getOperand(), frontNode.getItem().getToken());
					
					tempQueue.push(frontNode.getLeftChild());
					tempQueue.push(frontNode.getRightChild());
				}

				if (j != queueSize-1)
				{
					for (int k=0; k<blankCount; k++)
						System.out.print("     ");
				}
			}
			
			System.out.println();
			
			if (i == level-1) break; 	// 마지막줄은 문자 X
			
			// 문자 출력
			
			blankCount -= (blankCount+1)/2;
			
			for (int j=0; j<blankCount; j++)
				System.out.print("     ");
			
			for (int j=0; j<queueSize; j++)
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
			System.out.println();
			
		}
		
	}
	
	public void printResult()
	{
		System.out.println(binaryTree.getRoot().getItem().getOperand());
	}
}
