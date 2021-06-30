package B_CircularLinkedList;

public class Circular_StudentList<E>  {
	private static class Node<E>
	{
		private Circular_Student element;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(Circular_Student element, Node<E> prev, Node<E> next)
		{
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		
		public Circular_Student getElement()
		{
			return element;
		}
		public Node<E> getNext()
		{
			return next;
		}
		public void setNext(Node<E> next)
		{
			this.next = next;
		}
		
		public Node<E> getPrev()
		{
			return prev;
		}
		public void setPrev(Node<E> prev)
		{
			this.prev = prev;
		}
		
	}
	
	private Node<E> head = null;
	private int size = 0;
	
	Circular_StudentList()
	{
		head = new Node<>(null, null, null);
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public void addNode(Circular_Student newElement)
	{
		if (head.getNext() == null)	// 첫번째 추가인 경우
		{		
			Node<E> newNode = new Node<E>(newElement, head, head.next);
			head.setPrev(newNode);
			head.setNext(newNode);
			newNode.setPrev(head);
			newNode.setNext(head);
			
		} else
		{
			Node<E> cur = head.getNext();
			int i;
			
			for (i=0; i<size && cur.getElement()!=null; i++, cur=cur.getNext())
			{
				if (Integer.parseInt(newElement.getStudentID()) < Integer.parseInt(cur.getElement().getStudentID()))
				{
					Node<E> newNode = new Node<>(newElement, cur.getPrev(), cur);
					cur.getPrev().setNext(newNode);
					cur.setPrev(newNode);
					break;
				} else if (cur.getNext().getElement() == null)		// 젤 커서 head 전(마지막)의 추가인 경우
				{
					Node<E> newNode = new Node<>(newElement, cur, cur.getNext());
					cur.setNext(newNode);
					newNode.getNext().setPrev(newNode);
				}
			}
		}
		size++;
				
	}
	
	public void deleteNode(String studentID)
	{
		Node<E> cur = head.getNext();
		
		for (int i=0; i<size && cur.getElement()!=null; cur=cur.getNext(), i++)
		{	
			if (Integer.parseInt(cur.getElement().getStudentID()) == Integer.parseInt(studentID))	// 노드 찾음
			{
				cur.getPrev().setNext(cur.getNext());
				cur.getNext().setPrev(cur.getPrev());
				size--;
				break;
			}
		}
		
		if (cur == null)
			System.out.println("검색한 학번이 존재하지 않습니다.");
	}
	
	public String printReverse()
	{
		String str = "";
		Node<E> cur = head.getPrev();
		
		for (int i=0; i<size && cur.getElement() != null; i++, cur = cur.getPrev())
		{
			str += cur.getElement().getStudentID() + " " + cur.getElement().getStudentName() + "\n";
		}
		
		return str;
	}
	
	public String printSpecific(String studentID)
	{
		String str = "";
		Node<E> cur = head.getNext();
		
		for (int i=0; i<size && cur.getElement() != null; i++, cur=cur.getNext())
		{
			if (cur.getElement().getStudentID().equals(studentID))
				break;
		}
		
		for (int i=0; i<size+1; i++, cur=cur.getNext())
		{                     
			if (cur.getElement() == null) continue;
				
			str += cur.getElement().getStudentID() + " " + cur.getElement().getStudentName() + "\n";
		}
		
		return str;
	}
	
	public String toString()
	{
		String str = "";
		Node<E> cur = head.getNext();
		
		
		for (int i=0; i<size && cur.getElement()!=null; i++, cur=cur.getNext())
		{
			str += cur.getElement().getStudentID() + " " + cur.getElement().getStudentName() + "\n";
		}
		
		return str;
	}

	
	
}
