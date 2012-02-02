package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableParser extends Parser {
	public VariableParser(){
		super(); // superclass Parser's constructor has protected ParserData data;	
	}
	
	private static final Pattern VARIABLE_REGEX = Pattern.compile("[xy]");
	
	public Boolean isThisKind(ParserData data){
		Matcher variableMatcher = VARIABLE_REGEX.matcher(data.myInput
				.substring(data.myCurrentPosition));
		return variableMatcher.lookingAt();
	}
	
	
	public Expression parseExpression(ParserData data){
		Matcher xyMatcher = VARIABLE_REGEX.matcher(data.myInput);
		xyMatcher.find(data.myCurrentPosition);
		String varMatch = data.myInput.substring(xyMatcher.start(), xyMatcher.end());
		data.myCurrentPosition = xyMatcher.end();
		return new VarExpression(varMatch);
		
	}
}
