package subParenExpression;

import java.util.ArrayList;

import model.Expression;
import model.ExpressionFactory;
import model.RGBColor;
import model.util.ColorCombinations;

public class ColorParenExpression extends ParenExpression{

	public ColorParenExpression(ArrayList<Expression> operands) {
		super("color", operands);
		// TODO Auto-generated constructor stub
	}
	
	

	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		return new RGBColor(myOperands.get(0).evaluate(x, y).getRed(), myOperands.get(1).evaluate(x, y).getGreen(), myOperands.get(2).evaluate(x, y).getBlue()); 
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new ColorParenExpression(operands);
	}
	
	
	private ColorParenExpression(){
		
	}

	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new ColorParenExpression(null));
	}
	
	
}
