package E_SortAlgorithm;

public class QuickSort_FirstPivot extends Sort
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
		
		quick(arr, 0, arr.length-1);
		
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	}
	public void quick(Comparable[] a, int left, int right) {
		int pl = left;	// 왼쪽 커서
		int pr = right;	// 오른쪽 커서
		Comparable x  = a[(pl + pr) / 2];	// 피벗
		
		// 배열 a를 피벗 x를 기준으로 나눕니다.
		do {
			while(a[pl].compareTo(x) < 0) pl++;
			while(a[pr].compareTo(x) > 0) pr--;
			if(pl <= pr)
				swap(a, pl++, pr--);
		}while(pl <= pr);
		
		if(left < pr)
			quick(a, left, pr);
		if(pl < right)
			quick(a, pl, right);
	}
	
	
//	public void quick(Comparable[] array, int start, int end) {
//		if(start >= end) { //원소가 한개일 떄
//			return;
//		}
//		int pivot = start; // 피벗값, 첫번째 원소
//		int i = start + 1; //큰 키값을 찾을 인덱스
//		int j = end; //작은 키값을 찾을 인덱스
//		Comparable temp; //값을 바꿀 임시변수
//		
//		while(i <= j) { // 엇갈릴 때 즉 큰 키값을 찾을 인덱스하고 작은 키값을 찾을 인덱스가 서로 엇갈렸을 때
//			while(array[i].compareTo(array[pivot]) <= 0 && i <= end) {//키값보다 큰 값을 찾을 때 까지 반복
//				i++;
//			}
//			while(array[j].compareTo(array[pivot]) >= 0 && j > start) {//키값보다 작은 값을 찾을 때 까지 반복
//				j--;
//			}
//			if(i > j) { //현재 엇갈린 상태라면 키 값과 교체
//				temp = array[j];
//				array[j] = array[pivot];
//				array[pivot] = temp;
//			}
//			else {
//				temp = array[j];
//				array[j] = array[i];
//				array[i] = temp;
//			}
//		}
//		quick(array,start, j-1);
//		quick(array,j+1, end); // 이 두개는 정렬된 값을 제외하고 나머지의 퀵정렬이다.
//	}


	public int partition(Comparable[] array, int left, int right) 
	{ 
		Comparable pivot = array[left]; 
		int i = left, j = right; 
		
		while (i < j) 
		{ 
			while (pivot.compareTo(array[j]) < 0) 
			{ 
				j--; 
			} 
			while (i < j && pivot.compareTo(array[i]) >= 0) 
			{ 
				i++; 
			} 
			swap(array, i, j); 
		} 
		array[left] = array[i]; 
		array[i] = pivot; 
		return i; 
	}
	
	public static void swap(Comparable[] array, int a, int b) 
	{
	    Comparable temp = array[b];
	    array[b] = array[a];
	    array[a] = temp;
	}


	
//	public void quick(Comparable[] data, int l, int r)
//	{
//	    int left = l;
//        int right = r;
//        int pivot = l;
//      
//        do
//        {
//            while(data[left].compareTo(data[pivot]) < 0) left++;
//            while(data[right].compareTo(data[pivot]) > 0) right--;
//            
//            if(left <= right)
//            {    
//                Comparable temp = data[left];
//                data[left] = data[right];
//                data[right] = temp;
//                left++;
//                right--;
//            }
//        } while (left <= right);
//        
//        if(l < right) quick(data, l, right);
//        if(r > left) quick(data, left, r);
//    }
	
	@Override
	public String toString() {
		return "Quick Sort (First is pivot)";
	}

}
