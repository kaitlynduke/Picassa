package Parsers;

import java.util.ArrayList;

import Expressions.Expression;

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
		
		ParserData data = new ParserData(input);
		data.setCurrentPosition(0);
		Expression result = parseParser(data);
		data.skipWhiteSpace();
		if (data.notAtEndOfString()) {
			throw new ParserException(
					"Unexpected characters at end of the string: "
							+ data.getMyInput().substring(data.getCurrentPosition()),
					ParserException.Type.EXTRA_CHARACTERS);
		}
		return result;
	}
	
	
	
}
