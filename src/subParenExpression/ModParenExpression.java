package subParenExpression;

import java.util.ArrayList;

import model.Expression;
import model.ExpressionFactory;
import model.RGBColor;
import model.util.ColorCombinations;

public class ModParenExpression extends ParenExpression{

	public ModParenExpression(ArrayList<Expression> operands) {
		super("mod", operands);
		// TODO Auto-generated constructor stub
	}
	
	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		return ColorCombinations.modulus(myOperands.get(0).evaluate(x, y), myOperands.get(1).evaluate(x, y)); 
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new ModParenExpression(operands);
	}
	
	private ModParenExpression(){
		
	}

	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new ModParenExpression(null));
	}
}
