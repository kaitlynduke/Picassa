package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;


public class ColorParenExpression extends ParenExpression {

	public ColorParenExpression(ArrayList<Expression> operands) {
		super(operands,"color");
		// TODO Auto-generated constructor stub
	}

	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		return new RGBColor(myOperands.get(0).evaluate(parameterObject)
				.getRed(), myOperands
				.get(1)
				.evaluate(
						parameterObject)
				.getGreen(), myOperands
				.get(2)
				.evaluate(
						parameterObject)
				.getBlue());
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new ColorParenExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new ColorParenExpression(null));
	}

}
