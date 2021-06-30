package B_Polynomial;

import java.util.Scanner;

public class PolynomialTest {

	public static void main(String[] args) {
		
		Polynomial firstPolynomial = new Polynomial();
		Polynomial secondPolynomial = new Polynomial();
		
		firstPolynomial = input(firstPolynomial, '첫');
		secondPolynomial = input(secondPolynomial, '두');
		
		Polynomial resultPolynomial = firstPolynomial.mulTerm(secondPolynomial);
		
		System.out.println("두 다항식의 곱은 : " + resultPolynomial.toString());
		
		
	}
	
	public static Polynomial input(Polynomial polynomial, char c)
	{
		Scanner scanner = new Scanner(System.in);
		int coef, exp;
		System.out.println(c + "번째 다항식을 계수-지수 쌍으로 입력하세요. (지수가 0이 되면 종료)");
		
		do
		{

			if (polynomial.getTerms() == polynomial.getLength())
				polynomial = polynomial.resizeArray(polynomial);
			
			coef = scanner.nextInt();
			exp = scanner.nextInt();
			
			if (coef != 0)
				polynomial.setTermarr(coef, exp);
			
			
		} while (exp != 0);
		
		return polynomial;
	}

}
