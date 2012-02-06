package Parsers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Expressions.Expression;
import Expressions.ExpressionFactory;

import subParenExpression.*;

public class ParenExpressionParser extends Parser{
	public ParenExpressionParser(){
		super(); // superclass Parser's constructor has protected ParserData myData;	
	}
	
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
	.compile("\\(([a-zA-Z+-x/!%^]+)");
	
	public Boolean isThisKind(ParserData data){
		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(data.getMyInput()
				.substring(data.getCurrentPosition()));
		return expMatcher.lookingAt();
	}
	
	
	public Expression parseExpression(ParserData data){
		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(data.getMyInput());
		expMatcher.find(data.getCurrentPosition());
		String commandName = expMatcher.group(1);
		data.setCurrentPosition(expMatcher.end());
		
		
		// NOTE From notes of Roulette_Revised - substitute with loops
		ArrayList<ExpressionFactory> PE = new ArrayList<ExpressionFactory>();
		PE.add(ColorParenExpression.getFactory());
		PE.add(DividParenExpression.getFactory());
		PE.add(ExpParenExpression.getFactory());
		PE.add(MinusParenExpression.getFactory());
		PE.add(ModParenExpression.getFactory());
		PE.add(MulParenExpression.getFactory());
		PE.add(NegParenExpression.getFactory());
		PE.add(PlusParenExpression.getFactory());
		PE.add(RandomParenExpression.getFactory());
		PE.add(FloorParenExpression.getFactory());
		PE.add(CeilingParenExpression.getFactory());
		PE.add(AbsParenExpression.getFactory());
		PE.add(ClampParenExpression.getFactory());
		PE.add(WrapParenExpression.getFactory());
		PE.add(SinParenExpression.getFactory());
		PE.add(CosParenExpression.getFactory());
		PE.add(TanParenExpression.getFactory());
		PE.add(AtanParenExpression.getFactory());
		PE.add(LogParenExpression.getFactory());
		PE.add(toLuminanceParenExpression.getFactory());
		PE.add(fromLuminanceParenExpression.getFactory());
		PE.add(perlinColorParenExpression.getFactory());
		PE.add(perlinBWParenExpression.getFactory());
		PE.add(LetParenExpression.getFactory());
		PE.add(IfParenExpression.getFactory());
		PE.add(AveParenExpression.getFactory());
		PE.add(MinParenExpression.getFactory());
		PE.add(MaxParenExpression.getFactory());
		PE.add(SumParenExpression.getFactory());
		PE.add(ProductParenExpression.getFactory());
		
		ArrayList<Expression> allExp = new ArrayList<Expression>();
		data.skipWhiteSpace();
		
		while(data.currentCharacter() != ')'){
			Expression left = ParserMediator.parseParser(data); //TODO 
			data.skipWhiteSpace();
			allExp.add(left);
		}
		
		data.setCurrentPosition(data.getCurrentPosition() + 1);
		
		for( ExpressionFactory current: PE )
		{
			if(current.isThisKind(commandName))
			{
				return current.creatExpression(allExp);
			}
		}
		throw new ParserException("no such expression! -- parenExpressionParser");
	}
}
