package E_SortAlgorithm;

public class RadixSort 
{
	private double runningTime;
	private final int HEX = 16;
	private final int DEC = 10;
	
	public int[] radixModularHex(int[] arr)
	{
		int[] result = arr.clone();
		
		runningTime = 0;
		
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		// 배열 크기를 최대값으로 잡으면 되니깐
		int max = getMax(result);

		
//		최대값의 자리수만큼 countsort
		for (int exp = 1; max/exp > 0; exp *= 16) 
		{
			int[] output = new int[arr.length];	// 정렬된 배열을 담기위한 공간
			int[] count = new int[HEX];	
//			  Arrays.fill(count, 0);		// 우선 모두 0으로 채워줌

			  // count개수 증가
			for (int i = 0; i < result.length; i++) {
				count[(result[i]/exp) % HEX]++;
			}

			  // 누적합
			for (int i = 1; i < HEX; i++) {
				count[i] += count[i-1]; 
			}	

			  // 정렬
			for (int i = arr.length - 1; i >= 0; i--) {
				output[count[(result[i]/exp) % HEX]-1] = result[i];
				count[(result[i]/exp) % HEX]--;
			}

			  // 정렬된 배열을 복사
			for (int i = 0; i < result.length; i++) {
				result[i] = output[i];
			}
		}
		
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
    	
    	return result;
	}
	
	public int[] radixMaskingHex(int[] arr)
	{
		int[] result = arr.clone();
		
		runningTime = 0;
		
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		// 배열 크기를 최대값으로 잡으면 되니깐
		int max = getMax(arr);
		
//		최대값의 자리수만큼 countsort
		for (int exp = 1; max/exp > 0; exp <<= 4) 
		{
			int[] output = new int[result.length];	// 정렬된 배열을 담기위한 공간
			int[] count = new int[HEX];	
			//			  Arrays.fill(count, 0);		// 우선 모두 0으로 채워줌
			
			  // count개수 증가
			for (int i = 0; i < result.length; i++) {
			 	count[(result[i]/exp) & (HEX - 1)]++;
			}
			
			  // 누적합
			for (int i = 1; i < HEX; i++) {
			  	count[i] += count[i-1]; 
			}
			
			  // 정렬
			for (int i = result.length - 1; i >= 0; i--) {
			    output[count[(result[i]/exp) & (HEX - 1)] - 1] = result[i];
			    count[(result[i]/exp) & (HEX - 1)] --;
			}
			
			  // 정렬된 배열을 복사
			for (int i = 0; i < result.length; i++) {
				result[i] = output[i];
			}
		}
		
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
    	
    	return result;
	}
	
	
	public int[] radixModularDec(int[] arr)
	{
		int[] result = arr.clone();
		
		runningTime = 0;
		
		double beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
		// 배열 크기를 최대값으로 잡으면 되니깐
		int max = getMax(arr);
		
//		최대값의 자리수만큼 countsort
		for (int exp = 1; max/exp > 0; exp = exp << 4) 
		{
			int[] output = new int[result.length];	// 정렬된 배열을 담기위한 공간
			int[] count = new int[DEC];	
			//			  Arrays.fill(count, 0);		// 우선 모두 0으로 채워줌
			
			  // count개수 증가
			for (int i = 0; i < result.length; i++) {
			 	count[(result[i]/exp) % DEC]++;
			}
			
			  // 누적합
			for (int i = 1; i < DEC; i++) {
			  	count[i] += count[i-1]; 
			}
			
			  // 정렬
			for (int i = result.length - 1; i >= 0; i--) {
			    output[count[(result[i]/exp) % DEC] - 1] = result[i];
			    count[(result[i]/exp) % DEC] --;
			}
			
			  // 정렬된 배열을 복사
			for (int i = 0; i < result.length; i++) {
				result[i] = output[i];
			}
		}
		
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    	runningTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
    	
    	return result;
	}
	
	
	
	private int getMax(int[] arr) 
	{
		  int max = arr[0];

		  // 배열에서의 최대 원소 찾아 반환
		  for (int i = 1; i < arr.length; i++) 
		  {
		    if(max < arr[i]) 
		    	max = arr[i];
		  }
		  
		  return max;
	}
	
	public double getTime()
	{
		return runningTime;
	}
}
