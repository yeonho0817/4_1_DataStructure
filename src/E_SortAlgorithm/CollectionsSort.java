package E_SortAlgorithm;

import java.util.*;

public class CollectionsSort extends Sort 
{
	@Override
	public double getTime()
	{
		return runningTime;
	}
	
	@Override
	public void sort(Comparable[] arr)
	{
		List<Comparable> list = Arrays.asList(arr);
		
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		Collections.sort(list);

		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
	}
	
	@Override
	public String toString() {
		return "Collections Sort";
	}
}
