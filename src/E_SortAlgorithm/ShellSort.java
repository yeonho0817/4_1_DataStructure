package E_SortAlgorithm;

public class ShellSort extends Sort {
	@Override
	public double getTime()
	{
		return runningTime;
	}
	@Override
    public void sort(Comparable[] arr) 
    {
    	double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
    	
        int arrSize = arr.length;
        int interval = 4;	// 간격
 
        while (interval >= 1) 
        {
            for (int i = 0; i < interval; i++) 
            {
                intervalSort(arr, i, arrSize - 1, interval);
            }
            interval /= 2;
            
        }
        
        double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
    }
 
    private void intervalSort(Comparable[] arr, int start, int end, int interval) 
    {
        for (int i = start + interval; i <= end; i += interval) 
        {
            Comparable item = arr[i];
            int j = 0;
            for (j = i - interval; j >= start && item.compareTo(arr[j]) == -1; j -= interval) 
            {
                // arr[j]의 값이 크니까 삽입
                arr[j + interval] = arr[j];
            }
            //삽입 끝낫으니 기억해둔 값 삽입
            arr[j + interval] = item;
        }
    }
    
    @Override
	public String toString() {
		return "Shell Sort";
	}

}
