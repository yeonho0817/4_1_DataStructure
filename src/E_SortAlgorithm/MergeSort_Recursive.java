package E_SortAlgorithm;

import java.util.Arrays;

public class MergeSort_Recursive extends Sort
{
	@Override
	public double getTime()
	{
		return runningTime;
	}
	
	@Override
	public void sort(Comparable[] arr)
	{
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		mergeSort(arr, 0, arr.length-1);
		
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	}
	
	private void mergeSort(Comparable[] arr, int p, int r){
        if(p < r){
            int q = (p+r)/2;
            mergeSort(arr, p, q);
            mergeSort(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }

    private void merge(Comparable[] data, int p, int q, int r) {
        int i = p, j = q + 1, k = p;
        
        Comparable[] tmp = new Comparable[data.length];
        
        while (i <= q && j <= r) 
        {
//        	System.out.print(data[i].compareTo(data[j]));
            if (data[i].compareTo(data[j]) < 1 )
                tmp[k++] = data[i++];
            else
                tmp[k++] = data[j++];
        }
        while (i <= q)
            tmp[k++] = data[i++];
        
        while (j <= r)
            tmp[k++] = data[j++];
        
        for (int m = p; m <= r; m++)
            data[m] = tmp[m];
    }
    
    @Override
	public String toString() {
		return "Merge Recursive";
	}
}
