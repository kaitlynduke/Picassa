package Expressions;

import Parsers.VariableData;
import Parsers.ParserException.Type;
import model.RGBColor;


/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical functions and the
 * leaves represent constant values.
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, some code)
 */
public abstract class Expression // arraylist of expressions ? design? not too closed
{
	private RGBColor myValue;
	private String myCommand;
	private Expression myOperand1;
	private Expression myOperand2;
	private Expression myOperand3;
	private Boolean isxcor;
	private Boolean isycor;

	/**
	 * Create expression representing the given constant value
	 */
	public Expression(){
		
	}
	
	/**
	 * @return string representation of expression
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		if (myCommand == null) {
			result.append(myValue);
		} else {
			result.append("(");
			result.append(" " + myCommand + " ");
			result.append(myOperand1.toString());
			result.append(myOperand2.toString());
			result.append(")");
		}
		return result.toString();
	}
	
	public abstract RGBColor evaluate(VariableData parameterObject);
}