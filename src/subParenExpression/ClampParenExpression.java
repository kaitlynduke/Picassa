package subParenExpression;

import java.util.ArrayList;

import model.Expression;
import model.ExpressionFactory;

public class ClampParenExpression extends SingleParenExpression {
	public ClampParenExpression(ArrayList<Expression> operands){
		super("clamp", operands);
	}
	
	@Override
	public double calculate(double operatedValue) {
		// TODO Auto-generated method stub
		if(operatedValue > 1) return 1;
		if(operatedValue < -1) return -1;
		return operatedValue;
	}

	@Override
	public ParenExpression create(
			ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new ClampParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new ClampParenExpression(null));
	}

}
