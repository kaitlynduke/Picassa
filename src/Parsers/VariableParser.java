package Parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import Expressions.Expression;
import Expressions.VarExpression;

public class VariableParser extends Parser {
	public VariableParser(){
		super(); // superclass Parser's constructor has protected ParserData data;	
	}
	
	private static final Pattern VARIABLE_REGEX = Pattern.compile("[a-zA-Z]+");
	
	public Boolean isThisKind(ParserData data){
		Matcher variableMatcher = VARIABLE_REGEX.matcher(data.getMyInput()
				.substring(data.getCurrentPosition()));
		return variableMatcher.lookingAt();
	}
	
	
	public Expression parseExpression(ParserData data){
		Matcher xyMatcher = VARIABLE_REGEX.matcher(data.getMyInput());
		xyMatcher.find(data.getCurrentPosition());
		String varMatch = data.getMyInput().substring(xyMatcher.start(), xyMatcher.end());
		data.setCurrentPosition(xyMatcher.end());
		return new VarExpression(varMatch);
		
	}
}
