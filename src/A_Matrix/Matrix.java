package A_Matrix;

public class Matrix {
	private final int SIZE = 4;
	
	private int[][] matrix = new int[SIZE][SIZE];
	Matrix()
	{
		for (int i = 0; i<SIZE; i++)
		{
			for (int j = 0; j<SIZE; j++)
			{
				matrix[i][j] = (int) (Math.random()*999)+1;
			}
		}
	}
	
	Matrix transRight(Matrix m)
	{
		Matrix result = new Matrix();
		
		for (int i=0; i<SIZE; i++)
		{
			for (int j=0; j<SIZE; j++)
			{
				result.matrix[i][j] = m.matrix[SIZE-j-1][i];
			}
		}
		
		return result;
	}
	
	Matrix transLeft(Matrix m)
	{
		Matrix result = new Matrix();
		
		for (int i=0; i<SIZE; i++)
		{
			for (int j=0; j<SIZE; j++)
			{
				result.matrix[i][j] = m.matrix[j][SIZE-1-i];
			}
		}
		
		return result;
	}
	
	Matrix transTransposed(Matrix m)	// 전치행렬 (일반)
	{
		Matrix result = new Matrix();
		
		for (int i=0; i<SIZE; i++)
		{
			for (int j=0; j<SIZE; j++)
			{
				result.matrix[i][j] = m.matrix[j][i];
			}
		}
		
		return result;
	}
	
	Matrix selfTransposed(Matrix m)	// 전치행렬 (재귀)
	{
		Matrix result = new Matrix();
		
		result = transposed(result, m, 0, 0);
		
		return result;
	}
	
	private Matrix transposed(Matrix result, Matrix m, int i, int j)
	{
		if (i>3)
		{
			i = 0;
			j++;
		} else 
			result.matrix[j][i] = m.matrix[i][j];
		
		if (j>3)
			return result;
		
		return transposed(result, m, i+1, j);
	}
	
	public String toString()	// 그냥 출력
	{
		for (int i = 0; i<SIZE; i++)
		{
			System.out.print("|");
			for (int j = 0; j<SIZE; j++)
			{
				System.out.printf("%4d", matrix[i][j]);
			}
			System.out.println(" |");
		}
		return "0";
	}
	
	public void printRow(int i)
	{
		System.out.print("|");
		for (int j=0; j<SIZE; j++)
		{
			System.out.printf("%4d", this.matrix[i][j]);
		}
		System.out.print(" | ");
	}
	
}
