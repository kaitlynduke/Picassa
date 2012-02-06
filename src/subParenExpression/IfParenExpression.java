package subParenExpression;

import java.util.ArrayList;

import model.*;
import Expressions.*;
import Parsers.*;

public class IfParenExpression extends ParenExpression {
	
	public IfParenExpression(ArrayList<Expression> operands){
		super(operands, "if");
	}

	@Override
	public RGBColor evaluate(VariableData parameterObject) {
		// TODO Auto-generated method stub
		if(myOperands.get(0).evaluate(parameterObject).getAverage() > 0)
		{
			return myOperands.get(1).evaluate(parameterObject);
		}
		return myOperands.get(2).evaluate(parameterObject);
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new IfParenExpression(operands);
	}
	
	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new IfParenExpression(null));
	}
	
	
	
}
