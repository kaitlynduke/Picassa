package Expressions;

import model.RGBColor;
import Parsers.ParserException;
import Parsers.VariableData;

public class VarExpression extends Expression {
	private boolean isX;
	private boolean isY;
	private boolean isT;
	private String varName;
	
	
	public VarExpression(String variable) {
		isX = variable.equals("x");
		isY = variable.equals("y");
		isT = variable.equals("t");
		varName = variable;
	}
	
	public String getString(){
		return varName;
	}
	
	public RGBColor evaluate(VariableData parameterObject){
		if (isX)
			return new RGBColor(parameterObject.getX());
		if (isY)
			return new RGBColor(parameterObject.getY());
		if (isT)
			return new RGBColor(parameterObject.getT());
		if (parameterObject.getMyMap().size()> 0)
		{
			for(String s : parameterObject.getMyMap().keySet())
			{
				if(s.equals(varName))
					return parameterObject.getMyMap().get(s);
			}
		}
		throw new ParserException ("No value assigned to this variable" + varName);
	}
	
	
	
}
