package Expressions;

import Parsers.VariableData;
import model.RGBColor;

public class NumberExpression extends Expression{ //when do we want a class/constructor to be public/private?
	private RGBColor myValue;
	
	public NumberExpression(RGBColor value){
		myValue = value;
	}
	
	public RGBColor evaluate(VariableData parameterObject){
		return myValue;
	}


}
