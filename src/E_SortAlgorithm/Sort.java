package E_SortAlgorithm;

public abstract class Sort {
	protected double runningTime;
	
	public abstract double getTime();
	
	public abstract void sort(Comparable[] arr);
	public abstract String toString();
	
}
