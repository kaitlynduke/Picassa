package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;


public class LogParenExpression extends SingleParenExpression {

	public LogParenExpression(ArrayList<Expression> operands) {
		super("log", operands);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate(double operatedValue) {
		// TODO Auto-generated method stub
		return Math.log(operatedValue);
	}

	@Override
	public ParenExpression create(
			ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new LogParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new LogParenExpression(null));
	}


}
