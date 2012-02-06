package subParenExpression;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;

import Expressions.Expression;
import Expressions.ExpressionFactory;
import Expressions.ParenExpression;
import Expressions.VarExpression;
import Parsers.VariableData;

import model.RGBColor;

public class LetParenExpression extends ParenExpression {
	HashMap<String, Expression> myMap;
	
	public LetParenExpression(ArrayList<Expression> operands) {
		super(operands,"let");
	}
	
	@Override
	public RGBColor evaluate(VariableData parameterObject) { //TODO
		// TODO Auto-generated method stub
		String first = ((VarExpression)myOperands.get(0)).getString();
		RGBColor second = myOperands.get(1).evaluate(parameterObject); 
		parameterObject.myMap.put(first, second);
		RGBColor third = myOperands.get(2).evaluate(parameterObject);
		parameterObject.myMap.remove(first);
		return third;
	}

	@Override
	public ParenExpression create(ArrayList<Expression> operands) {
		// TODO Auto-generated method stub
		return new LetParenExpression(operands);
		
	}
	
	public static ExpressionFactory getFactory() {
		// TODO Auto-generated method stub
		return new ExpressionFactory(new LetParenExpression(null));
	}

}
