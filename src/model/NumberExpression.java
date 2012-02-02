package model;

public class NumberExpression extends Expression{ //when do we want a class/constructor to be public/private?
	private RGBColor myValue;
	
	public NumberExpression(RGBColor value){
		myValue = value;
	}
	
	public RGBColor evaluate(double x, double y){
		return myValue;
	}


}
