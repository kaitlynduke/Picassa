package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;


public class SinParenExpression extends SingleParenExpression {

	public SinParenExpression(ArrayList<Expression> operands){
		super("sin", operands);
	}
	
	@Override
	public double calculate(double operatedValue) {
		// TODO Auto-generated method stub
		return Math.sin(operatedValue);
	}

	@Override
	public ParenExpression create(
			ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new SinParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new SinParenExpression(null));
	}


}
