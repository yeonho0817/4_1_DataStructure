package E_SortAlgorithm;

public class SelectionSort extends Sort 
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
		
		for(int i = 0; i < arr.length - 1; i++) 
		{
			int min_index = i;	
			
			// 최솟값을 갖고있는 인덱스 찾기 
			for(int j = i + 1; j < arr.length; j++) 
			{
				if(arr[j].compareTo(arr[min_index]) < 0)
					min_index = j;
			}
			// i번째 값과 찾은 최솟값을 서로 교환 
//			swap(a, min_index, i);?
			Comparable temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
		
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	}
	
	@Override
	public String toString() {
		return "Selection Sort";
	}
	
}
