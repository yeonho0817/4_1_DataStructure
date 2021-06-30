package C_Calculator;

public class Node<E> {
		private Token element;
		private Node<E> next;
		
		public Node(Token element, Node<E> next)
		{
			this.element = element;
			this.next = next;
		}
		
		public Token getElement()
		{
			return element;
		}
		
		public Node<E> getNext()
		{
			return next;
		}
		
		public void setElement(Token element)
		{
			this.element = element;
		}
		
		public void setNext(Node<E> next)
		{
			this.next = next;
		}
	
}
