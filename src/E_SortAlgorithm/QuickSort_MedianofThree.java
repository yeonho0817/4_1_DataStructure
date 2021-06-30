package E_SortAlgorithm;

public class QuickSort_MedianofThree extends Sort {
	@Override
	public double getTime()
	{
		return runningTime;
	}
	
	@Override
	public void sort(Comparable[] arr)
	{
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		quickSort(arr, 0, arr.length-1);
		
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	}
	
	private void quickSort(Comparable []arr, int front, int rear)
	{
		
		
		int i, j, mid = front+(rear-front)/2;
		Comparable pivot;
		threeSort(arr, front, mid, rear);		
	
		if(rear-front+1>3)
		{
			pivot = arr[mid];
			swap(arr, mid, rear-1);
			
			i = front;
			j = rear-1;			
		
			while(true)
			{
				while(arr[++i].compareTo(pivot) < 0 && i<rear);
				while(arr[--j].compareTo(pivot) > 0 && front<j);
			
				if(i>=j) break;
				
				swap(arr, i, j);
			}
			swap(arr, i, rear-1);
			
			quickSort(arr, front, i-1);
			quickSort(arr, i+1, rear);
		}
		
		
	}
	
	private void threeSort(Comparable []arr, int front, int mid, int rear)
	{
		if(arr[front].compareTo(arr[mid]) > 0) swap(arr, front, mid);
		if(arr[mid].compareTo(arr[rear]) > 0) swap(arr, mid, rear);
		if(arr[front].compareTo(arr[mid]) > 0) swap(arr, front, mid);
	}
	
	private void swap(Comparable []arr, int a, int b)
	{
		Comparable tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	@Override
	public String toString() {
		return "Quick Sort (Medain-of-Three is Pivot)";
	}
}
