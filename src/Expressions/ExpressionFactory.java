package Expressions;

import java.util.ArrayList;


public class ExpressionFactory {
	  private ParenExpression myParenExpression;
	  
	  public ExpressionFactory(ParenExpression expression){
		  myParenExpression = expression;
	  }
	  
	  public Boolean isThisKind(String readInput){
		  String[] cmds = myParenExpression.getCmd();
		  for(String cmd : cmds)
		  {
			  if(readInput.equals(cmd))
				  return true;
		  }
		  return false;
	  }
	  
	  public ParenExpression creatExpression(ArrayList<Expression> operands){
		  return myParenExpression.create(operands);
	  }
}
