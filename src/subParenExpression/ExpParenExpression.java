package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;


public class ExpParenExpression extends ParenExpression {

	public ExpParenExpression(ArrayList<Expression> operands) {
		super(operands, "exp", "^");
		// TODO Auto-generated constructor stub

	}

	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		return new RGBColor(Math.pow(myOperands.get(0).evaluate(
		parameterObject).getRed(), myOperands.get(1).evaluate(
		parameterObject).getRed()));
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new ExpParenExpression(operands);
	}

	private ExpParenExpression() {

	}

	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new ExpParenExpression(null));
	}

}
