package E_SortAlgorithm;

public class BubbleSort extends Sort {
	
	@Override
	public double getTime() 
	{
		return runningTime;
	}

	@Override
	public void sort(Comparable[] arr) 
	{
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		for(int i = 0; i < arr.length; i++) 
		{
	        for(int j = 0 ; j < arr.length - i - 1 ; j++) 
	        {
	            if(arr[j].compareTo(arr[j+1]) > 0) 
	            {
	                Comparable temp = arr[j+1];
	                arr[j+1] = arr[j];
	                arr[j] = temp;
	            }
	        }
	    }

		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	}
	
	@Override
	public String toString() {
		return "Bubble Sort";
	}
}
