package A_Matrix;

public class MatrixTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		final int SIZE = 4;
		
		Matrix matrix = new Matrix();
		
		//System.out.println("최초 행렬");
		//matrix.toString();
		
		
		Matrix trans_right = matrix.transRight(matrix);
		//System.out.println("우측으로 90도 회전");
		//trans_right.toString();
		
		
		Matrix trans_left = matrix.transLeft(matrix);
		//System.out.println("좌측으로 90도 회전");
		//trans_left.toString();
		
		Matrix transposed = matrix.transTransposed(matrix);
		//System.out.println("전치행렬(for문)");
		//transposed.toString();
		
		
		Matrix selftransposed = matrix.selfTransposed(matrix);
		//System.out.println("전치행렬(재귀)");
		//selftransposed.toString();
		
		
		System.out.printf("%-15S %-12S %-12S %-15S %-13S\n", "최초행렬", 
				"우측으로 90도 회전", "좌측으로 90도 회전", "전치행렬(for)", "전치행렬(재귀)");
		for (int i=0; i<SIZE; i++)
		{
			matrix.printRow(i);
			trans_right.printRow(i);
			trans_left.printRow(i);
			transposed.printRow(i);
			selftransposed.printRow(i);
			System.out.println();
		}
		
	}

}
