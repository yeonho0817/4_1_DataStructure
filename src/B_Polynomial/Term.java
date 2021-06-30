package B_Polynomial;

public class Term {
	private int coef;
	private int exp;
	
	Term(int coef, int exp)
	{
		this.coef = coef;
		this.exp = exp;
	}
	
	public void setCoef(int coef)
	{
		this.coef = coef;
	}
	public void setExp(int exp)
	{
		this.exp = exp;
	}
	public int getCoef()
	{
		return coef;
	}
	public int getExp()
	{
		return exp;
	}
}
