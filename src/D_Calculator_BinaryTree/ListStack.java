package D_Calculator_BinaryTree;

public class ListStack<E> {
		
	private Node<E> top;
	private int size=0;
	
	public ListStack() {
		top = null;
		size = 0;
	}

	public Node<E> getTop() {
		return top;
	}

	public void setTop(Node<E> top) {
		this.top = top;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public E peek()		// top return
	{
		if (! isEmpty())
			return top.getElement();
		
		return null;
	}
	
	public E pop()
	{
		if (! isEmpty())
		{
			E topItem = top.getElement();
			top = top.getNext();
			
			size--;
			return topItem;
		}
		return null;
	}
	
	public void push(E newElement)
	{
		Node<E> newNode = new Node<>(newElement, top);
		top = newNode;
		size++;
	}
	
}
