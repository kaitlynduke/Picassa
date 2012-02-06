package subParenExpression;

import java.util.ArrayList;

import Expressions.Expression;
import Expressions.ParenExpression;
import Parsers.VariableData;

import model.RGBColor;

public abstract class SingleParenExpression extends ParenExpression {
	public SingleParenExpression(String str, ArrayList<Expression> operands){
		super(operands, str);
	}
	@Override
	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		RGBColor one = myOperands.get(0).evaluate(parameterObject);
		return new RGBColor(calculate(one.getRed()), calculate(one.getGreen()), calculate(one.getBlue()));
	}
	
	public abstract double calculate(double operatedValue);

}
