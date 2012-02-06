package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;


public class AtanParenExpression extends SingleParenExpression {

	public AtanParenExpression(ArrayList<Expression> operands) {
		super("atan", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate(double operatedValue) {
		// TODO Auto-generated method stub
		return Math.atan(operatedValue);
	}

	@Override
	public ParenExpression create(
			ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new AtanParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new AtanParenExpression(null));
	}


}
