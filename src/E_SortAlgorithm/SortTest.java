package E_SortAlgorithm;

public class SortTest {

	public static void main(String[] args) 
	{
		/*
		 * 	1 : insertion - array
		 *  2 : insertion - binary
		 *  3 : shell sort
		 *  4 : recursive quick - 처음이 pivot
		 *  5 : recursive quick - medain-of three
		 *  6 : recursive Merge
		 *  7 : iterative Merge
		 *  8 : natural Merge
		 *  9 : heap
		 *  10 : bubble
		 *  11 : selection
		 *  12 : arrays.sort
		 *  13 : collections.sort
		 */
		
		Operation operation = new Operation();
	
//		operation.sort(new InsertionSort_Array());
//		operation.sort(new InsertionSort_BinarySeasrch());
//		operation.sort(new ShellSort());
//		operation.sort(new QuickSort_FirstPivot());
//		operation.sort(new QuickSort_MedianofThree());
//		operation.sort(new MergeSort_Recursive());
		operation.sort(new MergeSort_Iterative());
//		operation.sort(new MergeSort_Natural());
//		operation.sort(new HeapSort());
//		operation.sort(new BubbleSort());
//		operation.sort(new SelectionSort());
//		operation.sort(new ArraysSort());
//		operation.sort(new CollectionsSort());
	}

}
