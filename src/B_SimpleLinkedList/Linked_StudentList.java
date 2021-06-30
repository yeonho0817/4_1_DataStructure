package B_SimpleLinkedList;



public class Linked_StudentList<E>  {
	private static class Node<E>
	{
		private Linked_Student element;
		private Node<E> next;
		
		public Node(Linked_Student element, Node<E> next)
		{
			this.element = element;
			this.next = next;
		}
		
		public Linked_Student getElement()
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
		
	}
	
	private Node<E> head = null;
	private int size = 0;
	
	public boolean isEmpty()
	{
		
		return size==0;
	}
	
	public void addFirst(Linked_Student element)
	{
		Node<E> newNode = new Node<E>(element, head);
		head = newNode;

		size++;
	}
	
	public void addNode(Linked_Student newElement)
	{
		
		if (head == null)
			addFirst(newElement);
		else 
		{
			Node<E> target = head;
			Node<E> prevNode = target;
			
			for (int i=0; i<size && target!=null; target=target.getNext(), i++)
			{	
				if (Integer.parseInt(target.getElement().getStudentID()) > Integer.parseInt(newElement.getStudentID()))
				{
					if (i == 0)
					{
						addFirst(newElement);
						
					} else
					{
						Node<E> nextNode = prevNode.getNext();
						Node<E> newNode = new Node<>(newElement, nextNode);
						
						prevNode.setNext(newNode);
					}
					
					break;
				} else if (target.getNext() == null)	// 마지막인 경우
				{
					Node<E> newNode = new Node<>(newElement, null);
					target.setNext(newNode);
					break;
				}
					
				prevNode = target;
			}	
			size++;
		}
				
	}
	
	public void deleteNode(String studentID)
	{
		Node<E> cur = head;
		Node<E> prevNode = cur;
		
		for (int i=0; i<size && cur!=null; cur=cur.getNext(), i++)
		{	
			if (Integer.parseInt(cur.getElement().getStudentID()) == Integer.parseInt(studentID))	// 노드 찾음
			{
				if (i==0)	// head인 경우
				{
					head = cur.next;
					size--;
					break;
				} else 
				{
					prevNode.setNext(cur.getNext());
					size--;
					break;
				}
			}
			
			prevNode = cur;
		}
		
		if (cur == null)
			System.out.println("검색한 학번이 존재하지 않습니다.");
	}
	
	public String toString()
	{
		String str = "";
		Node<E> cur = head;
		
		
		for (int i=0; i<size && cur!=null; i++, cur=cur.getNext())
		{
			str += cur.getElement().getStudentID() + " " + cur.getElement().getStudentName() + " " + cur.getElement().getStudentClub() + "\n";
		}
		
		return str;
	}
	
	
}
