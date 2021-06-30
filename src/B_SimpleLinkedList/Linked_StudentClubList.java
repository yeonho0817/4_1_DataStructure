package B_SimpleLinkedList;



public class Linked_StudentClubList <E>{
	private static class Node<E>
	{
		private Linked_StudentClub element;
		private Node<E> next;
		
		public Node(Linked_StudentClub element, Node<E> next)
		{
			this.element = element;
			this.next = next;
		}
		
		public Linked_StudentClub getElement()
		{
			return element;
		}
		public Node<E> getNext()
		{
			return next;
		}
	}
	
	private Node<E> head = null;
	private int size = 0;
	
	public int getSize()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public Linked_StudentClub first()
	{
		if (isEmpty()) return null;
		
		return head.getElement();
	}
	
	public void add(Linked_StudentClub element)
	{
		Node<E> newNode = new Node<E>(element, head);
		head = newNode;
		
		size++;
	}
	
	public String toString()
	{
		String str = "";
		Node<E> cur = head;
		
		for (int i=0; i<size && cur!=null; i++, cur=cur.getNext())
		{
			str += cur.getElement().getName();
			
			if (cur.getNext()!=null)
				str += "/";
		}
		
		return str;
	}
	
	
}
