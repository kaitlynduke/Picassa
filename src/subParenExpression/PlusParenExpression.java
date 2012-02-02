package subParenExpression;

import java.util.ArrayList;

import model.Expression;
import model.ExpressionFactory;
import model.RGBColor;
import model.util.ColorCombinations;

public class PlusParenExpression extends ParenExpression{

	public PlusParenExpression(ArrayList<Expression> operands) {
		super("plus", operands);
		// TODO Auto-generated constructor stub

	}

	
	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		RGBColor left = myOperands.get(0).evaluate(x, y);
		RGBColor right = myOperands.get(1).evaluate(x, y);
		return new RGBColor(left.getRed() + right.getRed(), left.getGreen()
		+ right.getGreen(), left.getBlue() + right.getBlue()); 
	}


	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new PlusParenExpression(operands);
	}
	

	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new PlusParenExpression(null));
	}
	
}
