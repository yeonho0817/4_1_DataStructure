package D_Calculator_BinaryTree;

public class ListQueue<E> {
	
	private Node<E> front, rear;
	private int size;
	
	public ListQueue() {
		front = rear = null;
		size = 0;
	}

	public Node<E> getFront() {
		return front;
	}

	public void setFront(Node<E> front) {
		this.front = front;
	}

	public Node<E> getRear() {
		return rear;
	}

	public Node<E> setRear(Node<E> rear) {
		this.rear = rear;
		return rear;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void push(E newElement)
	{
		Node<E> newNode = new Node<>(newElement, null);
		
		if (isEmpty())
			setFront(newNode);
		else
			getRear().setNext(newNode);
		
		setRear(newNode);
		size++;
	}
	
	public E pop()
	{
		if (! isEmpty())
		{
			E frontItem = getFront().getElement();
			front = getFront().getNext();
			
			if (front == null) rear = null;
			
			size--;
			return frontItem;
		}
		return null;
	}
	
	public E peek()
	{
		if (! isEmpty())
			return front.getElement();
		
		return null;
	}
	
	
	
}
