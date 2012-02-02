package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberParser extends Parser {

	public NumberParser(){
		super(); // superclass Parser's constructor has protected ParserData myData;	
	}
	
	private static final Pattern DOUBLE_REGEX = Pattern
	.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
	
	public Boolean isThisKind(ParserData data){
		Matcher doubleMatcher = DOUBLE_REGEX.matcher(data.myInput
				.substring(data.myCurrentPosition));
		System.out.println("number" + doubleMatcher.lookingAt()+ data.myCurrentPosition + data.myInput);
		return doubleMatcher.lookingAt();
	}
	
	
	public Expression parseExpression(ParserData data){
		Matcher doubleMatcher = DOUBLE_REGEX.matcher(data.myInput);
		doubleMatcher.find(data.myCurrentPosition);
		String numberMatch = data.myInput.substring(doubleMatcher.start(),
				doubleMatcher.end());
		data.myCurrentPosition = doubleMatcher.end();
		// this represents the color gray of the given intensity
		double value = Double.parseDouble(numberMatch);
		RGBColor gray = new RGBColor(value);
		return new NumberExpression(gray);
		
	}

	
//	
//	public Parser create(){
//		return new NumberParser();
//	}
	
//	public static ParserFactory getFactory(){
//	return new ParserFactory(new NumberParser());
//}
	
}
