package C_Calculator;

public class ListQueue<E> {
	
	private Node<E> front, rear;			// front == head,   rear == tail
	private int size;
	public ListQueue()
	{
		front = rear = new Node<E>(null, null);
		size=0;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public Node<E> getFront()
	{
		return front;
	}
	
	public Node<E> getRear()
	{
		return rear;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public String peek()		// front return
	{
		if (! isEmpty())
			return getFront().getElement().getToken();
		
		return null;
	}
	
	public String pop()
	{
		if (! isEmpty())
		{
			String topItem = getFront().getElement().getToken();
			front = getFront().getNext();
			
			size--;
			return topItem;
		}
		return null;
	}
	
	public void push(int operand)		// postfix 할 때 두자리 수 이상을 저장할 때
	{
		Node<E> newNode = new Node<E>(new Token(String.valueOf(operand)), null);
		if (isEmpty())
			front = newNode;
		else
			rear.setNext(newNode);
		
		rear = newNode;
		size++;
	}
	
	public void push(String str)
	{
		Node<E> prevNode = front;
		Node<E> newNode = null;
		
		for (int i=0; i<str.length(); i++, prevNode = newNode)
		{
			char c = str.charAt(i);
			
			if (c == ' ') continue;	// 공백이면 넘기기
			
			if (isOperator(c))	// 연산자
			{
				String prevOperator = "";
				
				if (!isEmpty() && prevNode.getElement().getOperator() != null)
					prevOperator = prevNode.getElement().getOperator();
				
				
				if (prevOperator.equals(">") || prevOperator.equals("<"))	// 뒤에 한개 더 있는 거
				{
					prevNode.getElement().setOperator( prevOperator + prevOperator );
				} else 
				{
					String operator = "";
					
					// c=- && 이전이 ) 가 아니거나 && 이전이 ( 이거나,  이전이 연산자가 비어있는게 아니거나, 지금이 비었거나  ->  "m" 입력
					if ( c == '-' && !prevOperator.equals(")") && (prevOperator.equals("(") || ! prevOperator.equals("") || isEmpty()) )
						operator = "m";
					else
						operator = String.valueOf(c);
					
					newNode = new Node<E>(new Token(operator), null);
					
					if (isEmpty())
						front = newNode;
					else
						rear.setNext(newNode);
					
					rear = newNode;
					size++;
				}
			} else		// 숫자
			{
				if ( ! isEmpty() && prevNode.getElement().getOperator() == null ) // 이 전에도 숫자여서 더해야함 (원래*10)+새거
				{
					prevNode.getElement().setOperand(prevNode.getElement().getOperand()*10 + Integer.parseInt(String.valueOf(c)) );;
					
				} else 
				{
					newNode = new Node<E>( new Token(String.valueOf(c)), null);
					
					if (isEmpty())
						front = newNode;
					else
						rear.setNext(newNode);
					
					rear = newNode;
					size++;
				}
			}
			
		}
	}
	
	public ListQueue<E> postfix()
	{
		ListQueue<E> resultPostfix = new ListQueue<>();  // 결과 queue
		ListStack<E> stack = new ListStack<>();			// 연산자
		
		Node<E> cur = getFront();
		
		for (int i=0; i < getSize(); i++, cur = cur.getNext())
		{
			String operator = cur.getElement().getOperator();
			
			if (operator != null) 		// 연산자 -> stack 넣음
			{
				if (stack.peek() != null && ! operator.equals("m"))
				{
					if (operator.equals("(") || stack.peek().equals("("))  //  현재가 괄호이거나 이전이 괄호이면 -> push
					{
						stack.push(operator);
					} else if (operator.equals(")"))		// -> 닫는 괄호면 ( 나올때까지 pop
					{	
						for (; ! stack.getTop().getElement().getOperator().equals("(");)
						{
							System.out.print(stack.peek() + " ");
							resultPostfix.push(stack.pop());
						}
						stack.pop(); // "(" pop
					} else
					{	
						int topPriority = getPriority(stack.peek());
						int newPriority = getPriority(operator);
							
						while (true)
						{
							if (topPriority <= newPriority && topPriority != 0)
							{
								System.out.print(stack.peek() + " ");
								resultPostfix.push(stack.pop());
							}
							else 
								break;
							
							if (stack.peek() == null) break;
							topPriority = getPriority(stack.peek());
						}
						
						stack.push(operator);
					}
				} else
					stack.push(operator);
				
			} else		// 숫자면 걍 출력
			{
				System.out.print(cur.getElement().getOperand() + " ");
				resultPostfix.push(cur.getElement().getOperand());
			}
		}
		
		// 모두 출력
		for (; stack.getTop() != null;)
		{
			System.out.print(stack.peek() + " ");
			resultPostfix.push(stack.pop());
		}
		
		return resultPostfix;
	}
	
	private int getPriority(String operator)
	{
		/* 연산자 우선순위
		0. (), []
		1. ~, m
		2. *, /, %
		3. +, -
		4. <<, >>
		5. &
		6. ^
		7. |
	*/
		final String[] OPERATOR = {"( )",		"~ m",	"* / %",	"+ -",		"<< >>",	"&",	"^",	"|"};					
		
		for (int j=0; j<OPERATOR.length; j++)
		{
			if (OPERATOR[j].contains(operator))
				return j;
		}
		
		return -1;
	}
	
	private boolean isOperator(char c)
	{
		if (48 <= c && c <= 57)		// 숫자
			return false;
		else
			return true;
	}
	
	public String toString()
	{
		String str = "";
		Node<E> cur = front;
		for (int i=0; i < size; i++, cur=cur.getNext())
		{
			str += cur.getElement().getToken() + " ";
		}
		
		return str;
	}
}
