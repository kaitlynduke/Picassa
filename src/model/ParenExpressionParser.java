package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import subParenExpression.AbsParenExpression;
import subParenExpression.AtanParenExpression;
import subParenExpression.CeilingParenExpression;
import subParenExpression.ClampParenExpression;
import subParenExpression.ColorParenExpression;
import subParenExpression.CosParenExpression;
import subParenExpression.DividParenExpression;
import subParenExpression.ExpParenExpression;
import subParenExpression.FloorParenExpression;
import subParenExpression.LogParenExpression;
import subParenExpression.MinusParenExpression;
import subParenExpression.ModParenExpression;
import subParenExpression.MulParenExpression;
import subParenExpression.NegParenExpression;
import subParenExpression.PlusParenExpression;
import subParenExpression.RandomParenExpression;
import subParenExpression.SinParenExpression;
import subParenExpression.TanParenExpression;
import subParenExpression.WrapParenExpression;

public class ParenExpressionParser extends Parser{
	public ParenExpressionParser(){
		super(); // superclass Parser's constructor has protected ParserData myData;	
	}
	
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
	.compile("\\(([a-z]+)");
	
	public Boolean isThisKind(ParserData data){
		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(data.myInput
				.substring(data.myCurrentPosition));
		System.out.println(expMatcher.lookingAt());
		return expMatcher.lookingAt();
	}
	
	
	public Expression parseExpression(ParserData data){
		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(data.myInput);
		expMatcher.find(data.myCurrentPosition);
		String commandName = expMatcher.group(1);
		data.myCurrentPosition = expMatcher.end();
		
		
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
		
		ArrayList<Expression> allExp = new ArrayList<Expression>();
		skipWhiteSpace(data);
		
		while(currentCharacter(data) != ')'){
			Expression left = ParserMediator.parseParser(data); //TODO 
			skipWhiteSpace(data);
			allExp.add(left);
		}
		data.myCurrentPosition++;
		
		for( ExpressionFactory current: PE )
		{
			if(current.isThisKind(commandName))
			{
				return current.creatExpression(allExp);
			}
		}
		return null;
	}
		
	
	public static void skipWhiteSpace(ParserData data) {
		while (notAtEndOfString(data) && Character.isWhitespace(currentCharacter(data))) {
			data.myCurrentPosition++;
		}
	}

	public static char currentCharacter(ParserData data) {
		return data.myInput.charAt(data.myCurrentPosition);
	}

	public static boolean notAtEndOfString(ParserData data) {
		return data.myCurrentPosition < data.myInput.length();
	}
}
