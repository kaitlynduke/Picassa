package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;


public class CeilingParenExpression extends SingleParenExpression {
	public CeilingParenExpression(ArrayList<Expression> operands){
		super("ceil", operands);
	}
	
	@Override
	public double calculate(double operatedValue) {
		// TODO Auto-generated method stub
		return Math.ceil(operatedValue);
	}

	@Override
	public ParenExpression create(
			ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new CeilingParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new CeilingParenExpression(null));
	}
}
