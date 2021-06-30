package E_SortAlgorithm;

public class ComparsionTest 
{
	public static void main(String[] args)
	{
		final int SIZE = 50000;
		int[] randomInt = new int[SIZE];
		
		// 입력 값 생성
		CreateInput input = new CreateInput(SIZE);
		randomInt = input.createRandom(randomInt);
		
//		--------------------------------------
		
		System.out.println("--- Modular 16진수 ---");
//		System.out.print("정렬 전 : ");
//		input.printArray(randomInt);
		
		RadixSort radixSort = new RadixSort();
		
		int[] modularHex = radixSort.radixModularHex(randomInt);
		
//		System.out.print("정렬 후 : ");
//		input.printArray(modularHex);
		System.out.println("수행시간 : " + radixSort.getTime());
		
//		-------------------------------------
		
		System.out.println("\n--- Masking 16진수 ---");
//		System.out.print("정렬 전 : ");
//		input.printArray(randomInt);
		
		int[] maskingHex = radixSort.radixMaskingHex(randomInt);
		
//		System.out.print("정렬 후 : ");
//		input.printArray(maskingHex);
		System.out.println("수행시간 : " + radixSort.getTime());
		
//		------------------------------------
		
		System.out.println("\n--- Modular 10진수 ---");
//		System.out.print("정렬 전 : ");
//		input.printArray(randomInt);
		
		int[] modularDec = radixSort.radixModularDec(randomInt);
		
//		System.out.print("정렬 후 : ");
//		input.printArray(modularDec);
		System.out.println("수행시간 : " + radixSort.getTime());
		
	}
	
}
