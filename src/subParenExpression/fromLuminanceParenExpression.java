package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;

public class fromLuminanceParenExpression extends ParenExpression {

	public fromLuminanceParenExpression(ArrayList<Expression> operands){
		super(operands, "yCrCbToRGB");
	}
	
	@Override
	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		RGBColor first = myOperands.get(0).evaluate(parameterObject);
		double y = first.getRed();
		double u = first.getGreen();
		double v = first.getBlue();
		double red = y + 1.140*v;
		double green = y - 0.395*u - 0.581*v;
		double blue = y + 2.032*u;
		return new RGBColor(red, green, blue);
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new fromLuminanceParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new fromLuminanceParenExpression(null));
	}
}
