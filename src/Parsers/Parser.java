package Parsers;

import Expressions.Expression;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser is
 * used http://en.wikipedia.org/wiki/Recursive_descent_parser
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public abstract class Parser {
		
	public abstract Boolean isThisKind(ParserData data);
	public abstract Expression parseExpression(ParserData data);
	
}