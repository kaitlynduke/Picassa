package Parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.RGBColor;

import Expressions.Expression;
import Expressions.NumberExpression;

public class NumberParser extends Parser {

	public NumberParser(){
		super(); // superclass Parser's constructor has protected ParserData myData;	
	}
	
	private static final Pattern DOUBLE_REGEX = Pattern
	.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
	
	public Boolean isThisKind(ParserData data){
		Matcher doubleMatcher = DOUBLE_REGEX.matcher(data.getMyInput()
				.substring(data.getCurrentPosition()));
		return doubleMatcher.lookingAt();
	}
	
	
	public Expression parseExpression(ParserData data){
		Matcher doubleMatcher = DOUBLE_REGEX.matcher(data.getMyInput());
		doubleMatcher.find(data.getCurrentPosition());
		String numberMatch = data.getMyInput().substring(doubleMatcher.start(),
				doubleMatcher.end());
		data.setCurrentPosition(doubleMatcher.end());
		// this represents the color gray of the given intensity
		double value = Double.parseDouble(numberMatch);
		RGBColor gray = new RGBColor(value);
		return new NumberExpression(gray);
		
	}
}