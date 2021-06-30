package E_SortAlgorithm;

public class InsertionSort_Array extends Sort {
	
    public void swap(Comparable[] arr, int i,int j) 
    {
        Comparable p = arr[i];
        arr[i] = arr[j];
        arr[j] = p;
    }
    
	@Override
	public void sort(Comparable[] arr) 
	{
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        
    	//실험할 코드 추가
        for(int i=1; i<arr.length; i++) 
        {
            for(int j=i; j>0; j--) 
            {
//                if(isless(arr[j],arr[j-1]))
            	if (arr[j].compareTo(arr[j-1]) < 0)
                    swap(arr,j,j-1);
                 else 
                    break;   
            }
        }
        
        double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	}

	@Override
	public double getTime() 
	{
		return runningTime;
	}
	
	@Override
	public String toString() {
		return "Insertion Array";
	}
    
    
    
}
