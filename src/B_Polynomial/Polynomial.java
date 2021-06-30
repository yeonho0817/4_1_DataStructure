package B_Polynomial;

public class Polynomial {
	private Term[] termArr;
	private int terms;
	
	final private int SIZE = 5;
	
	Polynomial()
	{
		terms = 0;
		termArr = new Term[SIZE];
	}
	
	public int getLength()
	{
		return this.termArr.length;
	}
	
	public int getTerms()
	{
		return this.terms;
	}
	
	public void setTermarr(int coef, int exp)
	{
		termArr[terms] = new Term(coef, exp);
		terms++;
	}
	
	public Polynomial mulTerm(Polynomial secondPolynomial)
	{
		Polynomial resultPolynomial = new Polynomial();
		
		int firstCnt = 0, secondCnt = 0;
		
		for (int i=0; i<this.terms*secondPolynomial.terms; i++, secondCnt++)
		{
			
			if (resultPolynomial.getTerms() == resultPolynomial.getLength())
				resultPolynomial = resizeArray(resultPolynomial);
			
			if (secondCnt == secondPolynomial.getTerms())
			{
				secondCnt=0;
				firstCnt++;
			}
			
			int coef=0, exp=0;
			
			coef = this.termArr[firstCnt].getCoef() * secondPolynomial.termArr[secondCnt].getCoef();
			exp = this.termArr[firstCnt].getExp() + secondPolynomial.termArr[secondCnt].getExp();
			
			resultPolynomial = checkArrange(resultPolynomial, coef, exp);
		}
		
		return resultPolynomial;
	}
	
	private Polynomial checkArrange(Polynomial polynomial, int coef, int exp)
	{
		Polynomial resultPolynomial = new Polynomial();
				
		
		
		for (int i=0; i<polynomial.terms; i++)
		{
			if (resultPolynomial.getTerms() == resultPolynomial.getLength())
				resultPolynomial = resizeArray(resultPolynomial);
			
			if (exp > polynomial.termArr[i].getExp() && coef !=0)		// 새로운게 더 큰 경우
			{
				resultPolynomial.setTermarr(coef, exp);
				coef = 0;
				i--;
			} else if (exp == polynomial.termArr[i].getExp())	// 같은게 있는 경우
			{
				if (polynomial.termArr[i].getCoef() + coef != 0) 
					resultPolynomial.setTermarr(polynomial.termArr[i].getCoef()+coef, polynomial.termArr[i].getExp());
				
				coef = 0;
			}  else //if (exp < polynomial.termArr[i].getExp())	// 기존게 더 큰 경우
			{
				resultPolynomial.setTermarr(polynomial.termArr[i].getCoef(), polynomial.termArr[i].getExp());
			}
		}
		
		if (resultPolynomial.getTerms() == resultPolynomial.getLength())
			resultPolynomial = resizeArray(resultPolynomial);
		
		if (coef != 0)
			resultPolynomial.setTermarr(coef, exp);
		
		
		return resultPolynomial; 
	}
	
	public Polynomial resizeArray(Polynomial polynomial)
	{
		Polynomial tempPolynomial = new Polynomial();
		
		tempPolynomial.termArr = new Term[polynomial.getLength() + SIZE];
		
		for (int i=0; i<polynomial.terms; i++)
		{
			tempPolynomial.setTermarr(polynomial.termArr[i].getCoef(), polynomial.termArr[i].getExp());
		}
		
		return tempPolynomial;
	}
	

	public String toString()
	{
		String str = "";
		for (int i=0; i<terms; i++)
		{
			int coef=termArr[i].getCoef(), exp=termArr[i].getExp();
			
			if (coef == 0) continue;
			
			
			if (i != 0 && coef > 0)
				str += " + ";
			else if (coef < 0)
				str += " - ";
			
			if ((! (-1<=coef && coef <=1)) || exp==0)
			{
				if (coef < 0)
					str += coef * -1;
				else
					str += coef;
			}
			
			
			if (exp == 1)
				str += "X";
			else if (exp != 0)
				str += "X^" + exp;
			
		}
		
		return str;
	}
	
	
}
