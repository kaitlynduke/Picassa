package subParenExpression;

import java.util.ArrayList;

import Expressions.*;
import Parsers.VariableData;

import model.RGBColor;


public class MinParenExpression extends ParenExpression{

	public MinParenExpression(ArrayList<Expression> operands) {
		super(operands,"min");
		// TODO Auto-generated constructor stub
	}

	
	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		ArrayList<RGBColor> colors = new ArrayList<RGBColor>();
		ArrayList<Double> numbers = new ArrayList<Double>();
		Double min = 1.0;
		for(Expression op : myOperands)
		{
			colors.add(op.evaluate(parameterObject));
		}
		for(RGBColor c : colors)
		{
			numbers.add(c.getAverage());
		}
		for(Double n : numbers)
		{
			if(n < min)
				min = n;
		}
		return new RGBColor(); 
	}


	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new MinParenExpression(operands);
	}
	
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new MinParenExpression(null));
	}
	
}
