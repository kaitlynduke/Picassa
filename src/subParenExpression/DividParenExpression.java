package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;


public class DividParenExpression extends ParenExpression {

	public DividParenExpression(ArrayList<Expression> operands) {
		super(operands, "divid", "/");
		// TODO Auto-generated constructor stub

	}

	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		RGBColor left = myOperands.get(0).evaluate(parameterObject);
		RGBColor right = myOperands.get(1).evaluate(
				parameterObject);
		return new RGBColor(left.getRed() / right.getRed(), left.getGreen()
		/ right.getGreen(), left.getBlue() / right.getBlue());
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new DividParenExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new DividParenExpression(null));
	}

}
