package model;

import java.util.ArrayList;

import subParenExpression.ParenExpression;

public class ExpressionFactory {
	  private ParenExpression myParenExpression;
	  
	  public ExpressionFactory(ParenExpression expression){
		  myParenExpression = expression;
	  }
	  
	  public Boolean isThisKind(String readInput){
		  return readInput.equals(myParenExpression.getCmd());
	  }
	  
	  public ParenExpression creatExpression(ArrayList<Expression> operands){
		  return myParenExpression.create(operands);
	  }
}
