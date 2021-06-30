package E_SortAlgorithm;

import java.util.Arrays;

public class MergeSort_Iterative extends Sort {
	@Override
	public double getTime()
	{
		return runningTime;
	}
	
	@Override
	public void sort(Comparable[] arr)
	{
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		mergeSort(arr);
		
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	}
	
	public static void merge(Comparable[] A, Comparable[] temp, int from, int mid, int to)
    {
        int k = from, i = from, j = mid + 1;
 
        while (i <= mid && j <= to)
        {
            if (A[i].compareTo(A[j]) < 0) 
            {
                temp[k++] = A[i++];
            }
            else {
                temp[k++] = A[j++];
            }
        }
 
        while (i <= mid) 
        {
            temp[k++] = A[i++];
        }
 
        for (i = from; i <= to; i++) 
        {
            A[i] = temp[i];
        }
    }
 
    public static void mergeSort(Comparable[] A)
    {
        int low = 0;
        int high = A.length - 1;
 
        Comparable[] temp = Arrays.copyOf(A, A.length);
 
        for (int m = 1; m <= high - low; m = 2*m)
        {
            for (int i = low; i < high; i += 2*m)
            {
                int from = i;
                int mid = Integer.min(i + m-1, high);;
                int to = Integer.min(i + 2*m - 1, high);
 
                merge(A, temp, from, mid, to);
            }
        }
    }
    
    @Override
	public String toString() {
		return "Merge Iterative";
	}
}
