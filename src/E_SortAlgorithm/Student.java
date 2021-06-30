package E_SortAlgorithm;

public class Student implements Comparable<Student> {
	int[] score;
	
	public Student() 
	{	
		final int SIZE = 5;
		
		score = new int[SIZE];
		
		for (int i=0; i<SIZE; i++)
		{
			score[i] = (int) ((Math.random()*1000)/10);
		}
	}
	
	public double getAvg()
	{
		double result = 0;
		
		for (int i=0; i<score.length; i++)
		{
			result += score[i];
		}
		
		return result/score.length;
	}

	@Override
	public int compareTo(Student student) {
		if ( getAvg() > student.getAvg() ) return 1;
		else if (getAvg() < student.getAvg()) return -1;
		else return 0;
	}
	
	public String toString()
	{
		return String.valueOf(getAvg());
	}
}
