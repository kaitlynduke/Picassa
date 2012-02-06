package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;


public class TanParenExpression extends SingleParenExpression{
	public TanParenExpression(ArrayList<Expression> operands){
		super("tan", operands);
	}
	
	@Override
	public double calculate(double operatedValue) {
		// TODO Auto-generated method stub
		return Math.tan(operatedValue);
	}

	@Override
	public ParenExpression create(
			ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new TanParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new TanParenExpression(null));
	}

}
