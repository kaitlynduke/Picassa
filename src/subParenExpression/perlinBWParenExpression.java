package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;
import model.util.PerlinNoise;

public class perlinBWParenExpression extends ParenExpression{

	public perlinBWParenExpression(ArrayList<Expression> operands){
		super(operands, "perlinBW");
	}
	@Override
	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		RGBColor left = myOperands.get(0).evaluate(parameterObject);
		RGBColor right = myOperands.get(1).evaluate(parameterObject);
		return PerlinNoise.greyNoise(left, right);
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new perlinBWParenExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new perlinBWParenExpression(null));
	}
}
