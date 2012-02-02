package subParenExpression;

import java.util.ArrayList;

import model.Expression;
import model.RGBColor;

public abstract class SingleParenExpression extends ParenExpression {
	public SingleParenExpression(String str, ArrayList<Expression> operands){
		super(str,operands);
	}
	@Override
	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		RGBColor one = myOperands.get(0).evaluate(x, y);
		return new RGBColor(calculate(one.getRed()), calculate(one.getGreen()), calculate(one.getBlue()));
	}
	
	public abstract double calculate(double operatedValue);

//	@Override
//	public ParenExpression create(ArrayList<Expression> operands) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
