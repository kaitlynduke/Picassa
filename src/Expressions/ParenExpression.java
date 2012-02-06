package Expressions;
import java.util.ArrayList;

import Parsers.VariableData;
import model.RGBColor;


public abstract class ParenExpression extends Expression{
	
	protected ArrayList<Expression> myOperands;
	protected String[] myCommand;
	
	public ParenExpression(ArrayList<Expression> operands , String ... command){ //Need an empty constructor in Superclass as default
		myCommand = command;
		myOperands = operands;
	}
	
	protected ParenExpression(){
		//danger of a protected empty constructor?
	}
	
	public abstract RGBColor evaluate(VariableData parameterObject);
	
	public abstract ParenExpression create(ArrayList<Expression> operands);
	
//	public abstract ExpressionFactory getFactory();
	
	public String[] getCmd(){
		return myCommand;
	}
}
