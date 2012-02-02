package subParenExpression;

import java.util.ArrayList;

import model.Expression;
import model.ExpressionFactory;
import model.RGBColor;
import model.util.ColorCombinations;

public class NegParenExpression extends ParenExpression{

	public NegParenExpression(ArrayList<Expression> operands) {
		super("neg", operands);
		// TODO Auto-generated constructor stub
	}

	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		RGBColor one = myOperands.get(0).evaluate(x, y);
		return new RGBColor(-one.getRed(), -one.getGreen(), -one.getBlue()); 
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new NegParenExpression(operands);
	}
	

	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new NegParenExpression(null));
	}
	
	
}
