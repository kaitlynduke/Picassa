package subParenExpression;

import java.util.ArrayList;

import Expressions.*;
import Parsers.VariableData;

import model.RGBColor;


public class AveParenExpression extends ParenExpression{

	public AveParenExpression(ArrayList<Expression> operands) {
		super(operands,"average");
		// TODO Auto-generated constructor stub
	}

	
	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		ArrayList<RGBColor> colors = new ArrayList<RGBColor>();
		for(Expression op : myOperands)
		{
			colors.add(op.evaluate(parameterObject));
		}
		double red = 0;
		double green = 0;
		double blue = 0;
		for(RGBColor c : colors)
		{
			red += c.getRed();
			green += c.getGreen();
			blue += c.getBlue();
		}
		return new RGBColor(red/myOperands.size(), green/myOperands.size(), blue/myOperands.size()); 
	}


	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new AveParenExpression(operands);
	}
	
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new AveParenExpression(null));
	}
	
}
