package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;


public class MulParenExpression extends ParenExpression{

	public MulParenExpression(ArrayList<Expression> operands) {
		super(operands, "mul", "*");
		// TODO Auto-generated constructor stub

	}

	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		ArrayList<RGBColor> color = new ArrayList<RGBColor>();
		for (Expression op : myOperands)
		{
			color.add(op.evaluate(parameterObject));
		}
		double red = 1;
		double green = 1;
		double blue = 1;
		for (RGBColor c : color)
		{
			red = red*c.getRed();
			green = green*c.getGreen();
			blue = blue*c.getBlue();
		}
		return new RGBColor(red, green, blue);
	}


	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new MulParenExpression(operands);
	}
	

	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new MulParenExpression(null));
	}
	
	
}
