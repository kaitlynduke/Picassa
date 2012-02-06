package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;


public class WrapParenExpression extends SingleParenExpression{

	public WrapParenExpression(ArrayList<Expression> operands) {
		super("wrap", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate(double operatedValue) {
		// TODO Auto-generated method stub
		if(operatedValue > 1) return calculate(operatedValue - 2);
		if(operatedValue < -1) return calculate(operatedValue + 2);
		return operatedValue;
	}

	@Override
	public ParenExpression create(
			ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new WrapParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new WrapParenExpression(null));
	}


}
