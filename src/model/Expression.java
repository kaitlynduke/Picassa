package model;

import model.ParserException.Type;
import model.util.ColorCombinations;

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
	
	public abstract RGBColor evaluate(double x, double y);
}

	
//	public Expression(RGBColor value) // for constant
//	{
//		myValue = value;
//		myCommand = null;
//		myOperand1 = null;
//		myOperand2 = null;
//		myOperand3 = null;
//		isxcor = false;
//		isycor = false;
//	}
//
//	public Expression(Boolean xc, Boolean yc) {
//		myValue = null;
//		myCommand = null;
//		myOperand1 = null;
//		myOperand2 = null;
//		myOperand3 = null;
//		isxcor = xc;
//		isycor = yc;
//	}
//
//	/**
//	 * Create expression representing the given operation between the two given
//	 * sub-expressions.
//	 */
//	public Expression(String command, Expression operand1, Expression operand2) // for
//																				// operators
//	{
//		myCommand = command;
//		myOperand1 = operand1;
//		myOperand2 = operand2;
//		myOperand3 = null;
//		myValue = null;
//		isxcor = false;
//		isycor = false;
//	}
//
//	public Expression(String command, Expression operand1) // for negate
//	{
//		myCommand = command;
//		myOperand1 = operand1;
//		myOperand2 = null;
//		myOperand3 = null;
//		myValue = null;
//		isxcor = false;
//		isycor = false;
//	}
//
//	/**
//	 * Create expression to capture the different colors
//	 */
//	public Expression(String command, Expression operand1, Expression operand2,
//			Expression operand3) {
//		myCommand = command;
//		myOperand1 = operand1;
//		myOperand2 = operand2;
//		myOperand3 = operand3;
//		myValue = null;
//		isxcor = false;
//		isycor = false;
//	}
//
//	/**
//	 * @return value of expression
//	 */

//		if (myCommand == null) // base case of recursion
//		{
//			if (isxcor)
//				return new RGBColor(x);
//			if (isycor)
//				return new RGBColor(y);
//			return myValue;
//		} else {
//			if (myCommand.equals("plus"))
//				return ColorCombinations.add(myOperand1.evaluate(x, y),
//						myOperand2.evaluate(x, y));
//			else if (myCommand.equals("minus"))
//				return ColorCombinations.subtract(myOperand1.evaluate(x, y),
//						myOperand2.evaluate(x, y));
//			else if (myCommand.equals("mul"))
//				return ColorCombinations.multiply(myOperand1.evaluate(x, y),
//						myOperand2.evaluate(x, y));
//			else if (myCommand.equals("div"))
//				return ColorCombinations.divide(myOperand1.evaluate(x, y),
//						myOperand2.evaluate(x, y));
//			else if (myCommand.equals("mod"))
//				return ColorCombinations.modulus(myOperand1.evaluate(x, y),
//						myOperand2.evaluate(x, y));
//			else if (myCommand.equals("exp"))
//				return ColorCombinations.exponent(myOperand1.evaluate(x, y),
//						myOperand2.evaluate(x, y));
//			else if (myCommand.equals("neg"))
//				return ColorCombinations.negate(myOperand1.evaluate(x, y));
//			else if (myCommand.equals("color"))
//				return ColorCombinations.color(myOperand1.evaluate(x, y),
//						myOperand2.evaluate(x, y), myOperand3.evaluate(x, y));
//			else
//				throw new ParserException("Unknown Command " + myCommand,
//						Type.UNKNOWN_COMMAND);
//		}
//	}

//	/**
//	 * @return value of expression
//	 */
//	public RGBColor evaluate() {
//		if (myCommand == null) // base case of recursion
//		{
//			return myValue;
//		} else {
//			if (myCommand.equals("plus"))
//				return ColorCombinations.add(myOperand1.evaluate(),
//						myOperand2.evaluate());
//			else if (myCommand.equals("minus"))
//				return ColorCombinations.subtract(myOperand1.evaluate(),
//						myOperand2.evaluate());
//			else if (myCommand.equals("mul"))
//				return ColorCombinations.multiply(myOperand1.evaluate(),
//						myOperand2.evaluate());
//			else if (myCommand.equals("div"))
//				return ColorCombinations.divide(myOperand1.evaluate(),
//						myOperand2.evaluate());
//			else if (myCommand.equals("mod"))
//				return ColorCombinations.modulus(myOperand1.evaluate(),
//						myOperand2.evaluate());
//			else if (myCommand.equals("exp"))
//				return ColorCombinations.exponent(myOperand1.evaluate(),
//						myOperand2.evaluate());
//			else if (myCommand.equals("neg"))
//				return ColorCombinations.negate(myOperand1.evaluate());
//			else if (myCommand.equals("color"))
//				return ColorCombinations.color(myOperand1.evaluate(),
//						myOperand2.evaluate(), myOperand3.evaluate());
//			else
//				throw new ParserException("Unknown Command " + myCommand,
//						Type.UNKNOWN_COMMAND);
//		}
//	}

	