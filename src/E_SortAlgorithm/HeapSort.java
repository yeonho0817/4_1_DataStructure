package E_SortAlgorithm;

public class HeapSort extends Sort
{
	@Override	
	public double getTime()
	{
		return runningTime;
	}
	
	@Override
	public void sort(Comparable[] array) 
	{
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
	    int n = array.length;
	 
	    // init, max heap
	    for (int i = n / 2 - 1; i >= 0; i--) 
	    {
	        heap(array, n, i);
	    }
	 
	    // for extract max element from heap
	    for (int i = n - 1; i > 0; i--) 
	    {
	        swap(array, 0, i);
	        heap(array, i, 0);
	    }
	    
	    double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	}
	
	public void heap(Comparable array[], int n, int i) 
	{
	    int p = i;
	    int l = i * 2 + 1;
	    int r = i * 2 + 2;
	 
	    if (l < n && array[p].compareTo(array[l]) < 0) 
	        p = l;
	    
	 
	    if (r < n && array[p].compareTo(array[r]) < 0) 
	        p = r;
	    
	 
	    if (i != p) 
	    {
	        swap(array, p, i);
	        heap(array, n, p);
	    }
	}
	 
	public void swap(Comparable[] array, int a, int b) 
	{
		Comparable temp = array[a];
	    array[a] = array[b];
	    array[b] = temp;
	}
	
	@Override
	public String toString() {
		return "Heap Sort";
	}


}
