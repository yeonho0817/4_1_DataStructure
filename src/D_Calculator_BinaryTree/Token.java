package D_Calculator_BinaryTree;

public class Token {
	private int operand;
	private String operator;
	
	Token(String str)
	{
		if (48 <= str.charAt(0) && str.charAt(0) <= 57)		// 첫번째가 숫자이면 숫자니깐
			operand = Integer.valueOf(str);
		else
			operator = str;
	}
	
	public void setOperand(int operand)
	{
		this.operand = operand;
	}
	
	public void setOperator(String operator)
	{
		this.operator = operator;
	}
	
	public int getOperand()
	{
		return operand;
	}
	
	public String getOperator()
	{
		return operator;
	}
	
	public String getToken()
	{
		if (operator != null)
			return operator;
		else
			return String.valueOf(operand);
	}
	
	
}
