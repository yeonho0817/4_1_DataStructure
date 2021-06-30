package C_Calculator;

public class ListStack<E> {
	
	
	private Node<E> top;
	private int size;
	
	public ListStack()
	{
		top = null;
		size = 0;
	}
	
	public Node<E> getTop()
	{
		return top;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public String peek()		// top return
	{
		if (! isEmpty())
			return top.getElement().getToken();
		
		return null;
	}
	
	public String pop()
	{
		if (! isEmpty())
		{
			String topItem = top.getElement().getToken();
			top = top.getNext();
			
			size--;
			return topItem;
		}
		return null;
	}
	
	public void push(String str)
	{
		Node<E> newNode = new Node<E>(new Token(str), top);
		top = newNode;
		size++;
	}
		
	public String calculatePostfix(ListQueue<E> postfix)
	{

		for (; postfix.getFront() != null;)
		{	
			if (isOperator(postfix.peek().charAt(postfix.peek().length()-1)))		// 숫자 -> push
			{
				String operator = postfix.pop();
				
				if (top == null) return "[오류] 이해할 수 없는 수식";
				
				if (operator.equals("m"))
					push( String.valueOf( Integer.valueOf(pop()) * -1 ));
				else if (operator.equals("~"))
					push( String.valueOf( ~ Integer.valueOf(pop()) ));
				else 
				{
					if (top == null) return "[오류] 이해할 수 없는 수식";
					int secondOperand = Integer.valueOf(pop());
					
					if (top == null) return "[오류] 이해할 수 없는 수식";
					int firstOperand = Integer.valueOf(pop());
	
					
					if (operator.equals("*"))
						push( String.valueOf( firstOperand * secondOperand ));
					else if (operator.equals("/"))
						push( String.valueOf( firstOperand / secondOperand ));
					else if (operator.equals("%"))
						push( String.valueOf( firstOperand % secondOperand ));
					else if (operator.equals("+"))
						push( String.valueOf( firstOperand + secondOperand ));
					else if (operator.equals("-"))
						push( String.valueOf( firstOperand - secondOperand ));
					else if (operator.equals("<<"))
						push( String.valueOf( firstOperand << secondOperand ));
					else if (operator.equals(">>"))
						push( String.valueOf( firstOperand >> secondOperand ));
					else if (operator.equals("&"))
						push( String.valueOf( firstOperand & secondOperand ));
					else if (operator.equals("^"))
						push( String.valueOf( firstOperand ^ secondOperand ));
					else if (operator.equals("|"))
						push( String.valueOf( firstOperand | secondOperand ));
				}
					
			}
			else			// 연산자 -> pop 해서 연산.
				push(String.valueOf(postfix.pop()));
			
		}
		return pop();
		
	}
	
	private boolean isOperator(char c)
	{
		if (48 <= c && c <= 57)		// 숫자
			return false;
		else
			return true;
	}
	
}
