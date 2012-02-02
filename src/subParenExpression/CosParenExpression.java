package subParenExpression;

import java.util.ArrayList;

import model.Expression;
import model.ExpressionFactory;

public class CosParenExpression extends SingleParenExpression {

	public CosParenExpression(ArrayList<Expression> operands){
		super("cos", operands);
	}
	
	@Override
	public double calculate(double operatedValue) {
		// TODO Auto-generated method stub
		return Math.cos(operatedValue);
	}

	@Override
	public ParenExpression create(
			ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new CosParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new CosParenExpression(null));
	}

}
