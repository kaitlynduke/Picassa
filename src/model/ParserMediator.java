package model;

import java.util.ArrayList;

public class ParserMediator {
	
	public static Expression parseParser(ParserData data){ //TODO Smelly?? Parse parser AND create the right Expression.
		ArrayList<Parser> allParser = new ArrayList<Parser>();
		allParser.add(new NumberParser());
		allParser.add(new VariableParser());
		allParser.add(new ParenExpressionParser());
		
		for(Parser parser: allParser)
		{
			if(parser.isThisKind(data))
			{
				return parser.parseExpression(data);
			}
		}
		throw new ParserException("Unknown parser! -- From ParserMediator.parserParser");
	}
	
	public static Expression makeExpression(String input) {
		
		ParserData data = new ParserData();
		data.myInput = input;
		data.myCurrentPosition = 0;
		Expression result = parseParser(data);
		ParenExpressionParser.skipWhiteSpace(data);
		if (ParenExpressionParser.notAtEndOfString(data)) {
			throw new ParserException(
					"Unexpected characters at end of the string: "
							+ data.myInput.substring(data.myCurrentPosition),
					ParserException.Type.EXTRA_CHARACTERS);
		}
		return result;
	}
	
	
	
}
