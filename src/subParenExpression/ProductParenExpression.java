package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;


public class ProductParenExpression extends ParenExpression{

	public ProductParenExpression(ArrayList<Expression> operands) {
		super(operands, "product");
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
		return new ProductParenExpression(operands);
	}
	

	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new ProductParenExpression(null));
	}
	
	
}
