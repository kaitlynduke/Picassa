package model;

public class VarExpression extends Expression {
	private Boolean isX;
	private Boolean isY;
	
	public VarExpression(String variable) {
		isX = variable.equals("x");
		isY = variable.equals("y");
		
	}
	
	
	
	public RGBColor evaluate(double x, double y){
		if (isX)
			return new RGBColor(x);
		if (isY)
			return new RGBColor(y);
		return null;
	}
	
	
	
}
