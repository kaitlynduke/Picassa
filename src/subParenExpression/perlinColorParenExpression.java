package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;
import model.util.PerlinNoise;

public class perlinColorParenExpression extends ParenExpression{
	public perlinColorParenExpression(ArrayList<Expression> operands){
		super(operands, "perlinColor");
	}
	@Override
	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		RGBColor left = myOperands.get(0).evaluate(parameterObject);
		RGBColor right = myOperands.get(1).evaluate(parameterObject);
		return PerlinNoise.colorNoise(left, right);
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new perlinColorParenExpression(operands);
	}

	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new perlinColorParenExpression(null));
	}

}
