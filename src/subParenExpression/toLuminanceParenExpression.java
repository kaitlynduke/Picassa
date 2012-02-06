package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;

public class toLuminanceParenExpression extends ParenExpression {
	
	public toLuminanceParenExpression(ArrayList<Expression> operands){
		super(operands, "rgbToYCrCb");
	}
	
	@Override
	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		RGBColor first = myOperands.get(0).evaluate(parameterObject);
		double red = first.getRed();
		double green = first.getGreen();
		double blue = first.getBlue();
		double y = 0.299*red + 0.587*green + 0.114*blue;
		double u = 0.492*(blue - y);
		double v = 0.877*(red - y);
		return new RGBColor(y,u,v);
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new toLuminanceParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new toLuminanceParenExpression(null));
	}

}
