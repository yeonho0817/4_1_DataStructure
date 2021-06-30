package D_CompleteBinaryTree;

import java.util.NoSuchElementException;

public class CircularQueue {
	private final int SIZE = 4;
	private int[] circularQueue;
	private int front, rear;
	private int size;
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public CircularQueue()
	{
		circularQueue = new int[SIZE];
		front = rear = size = 0;
	}
	
	public void add(int[] levelorder)
	{
		for (int i=1; i<levelorder.length; i++)
		{
			push(levelorder[i]);
		}
	}
	
	private void push(int num)
	{
		if ( ((rear+1)%circularQueue.length) == front)
			resize(2*circularQueue.length);
		
		rear = (rear+1) % circularQueue.length;
		
		circularQueue[rear] = num;
		
		size++;
	}
	
	public String remove()
	{	
		String str = "";
		
		for (int i=0; i<circularQueue.length; i++)
		{
			if (circularQueue[i] != 0)
				str += pop() + " ";
		}
		
		return str;
		
	}
	
	public int pop()
	{
		if (isEmpty()) throw new NoSuchElementException();
		
		front = (front+1) % circularQueue.length;
		int num = circularQueue[front];
		circularQueue[front] = 0;
		
		size--;
		
		return num;
	}
	
	private void resize(int newSize)
	{
		int[] tempQueue = new int[newSize];
		
		for (int i=1, j=front+1; i<size+1; i++, j++)
		{
			tempQueue[i] = circularQueue[j%circularQueue.length];
		}
		
		front = 0;
		rear = size;
		circularQueue = tempQueue;
	}
	
}
