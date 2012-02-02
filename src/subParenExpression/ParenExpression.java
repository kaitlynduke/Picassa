package subParenExpression;
import java.util.ArrayList;
import model.Expression;
import model.ExpressionFactory;
import model.RGBColor;


public abstract class ParenExpression extends Expression{
	
	protected ArrayList<Expression> myOperands;
	protected String myCommand;
	
	public ParenExpression(String command, ArrayList<Expression> operands){ //Need an empty constructor in Superclass as default
		myCommand = command;
		myOperands = operands;
	}
	
	protected ParenExpression(){
		//danger of a protected empty constructor?
	}
	
	public abstract RGBColor evaluate(double x, double y);
	
	public abstract ParenExpression create(ArrayList<Expression> operands);
	
//	public abstract ExpressionFactory getFactory();
	
	public String getCmd(){
		return myCommand;
	}
}
