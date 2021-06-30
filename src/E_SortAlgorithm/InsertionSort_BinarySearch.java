package E_SortAlgorithm;

public class InsertionSort_BinarySearch extends Sort {
	
	@Override
	public double getTime()
	{
		return runningTime;
	}
	
	@Override
    public void sort(Comparable[] arr)
    {    
    	double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
    	
        Comparable temp;
    	int find_Index,j;     //임시변수, 탐색결과가 들어갈 변수 선언
 
        for (int i = 1; i < arr.length; i++) 
        {
            temp = arr[i]; // 임시 변수에 대상 배열 값을 저장한다.
            find_Index= serach(arr, 0, i, temp); 
            //임시변수 값이 들어갈 인덱스를 이진탐색한다. serach() 메소드 참조
                                    
            for (j = i - 1; j >= find_Index; j--) 
            {
                arr[j+1]=arr[j]; 
            } //선택된 배열부터 임시변수 값이 들어갈 자리까지 오른쪽으로 한칸씩 밀어낸다.
            
            arr[find_Index]=temp; //임시변수에 저장한 값을 이진탐색을 통해 찾은 인덱스에  삽입한다.
        }
        
        double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
    }
	
	public int serach(Comparable[] arr, int left, int right, Comparable x)
	{        
        if (right >= left) 
        {
            int mid = left + ((right-left)/ 2);
            
            //찾는 값(x)과 배열의 요소가 일치하면 배열의 인덱스를 반환한다.
            if (arr[mid].compareTo(x) == 0)
                return mid;
            //찾는 값(x)보다 배열의 요소가 크다면 배열의 오른쪽 절반을 무시한다.
            if (arr[mid].compareTo(x) == 1)
                return serach(arr, left, mid-1, x);
            //찾는 값(x)보다 배열의 요소가 작다면 배열의 왼쪽 절반을 무시한다.
            return serach(arr, mid+1, right, x);
        }
	        //일치하는 값이 없다면 배열의 맨 왼쪽 인덱스 반환
	        return left;
    }
	 
	@Override
	public String toString() {
		return "Insertion Binary";
	}

}
