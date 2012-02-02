package subParenExpression;

import java.util.ArrayList;

import model.Expression;
import model.ExpressionFactory;
import model.RGBColor;
import model.util.ColorCombinations;

public class MulParenExpression extends ParenExpression{

	public MulParenExpression(ArrayList<Expression> operands) {
		super("mul", operands);
		// TODO Auto-generated constructor stub

	}

	
	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		return ColorCombinations.multiply(myOperands.get(0).evaluate(x, y), myOperands.get(1).evaluate(x, y)); 
	}


	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new MulParenExpression(operands);
	}
	
	private MulParenExpression(){
		
	}

	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new MulParenExpression(null));
	}
	
	
}
