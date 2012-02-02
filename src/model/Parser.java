package model;
import subParenExpression.*;
import model.ExpressionFactory;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import subParenExpression.ColorParenExpression;
import subParenExpression.ParenExpression;

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
	
//	protected ParserData myData;	
	public abstract Boolean isThisKind(ParserData data);
	public abstract Expression parseExpression(ParserData data);
	
}

//	public abstract Expression parse(String input, int currentPosition);	
		

//	
//	// double is made up of an optional negative sign, followed by a sequence
//	// of one or more digits, optionally followed by a period, then possibly
//	// another sequence of digits
//	private static final Pattern DOUBLE_REGEX = Pattern
//			.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
//	// expression begins with a left paren followed by the command name,
//	// which is a sequence of alphabetic characters
//	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern
//			.compile("\\(([a-z]+)");
//	private static final Pattern VARIABLE_REGEX = Pattern.compile("[xy]");
//
//	// different possible kinds of expressions     
//	private static enum ExpressionType {
//		NUMBER, PAREN_EXPRESSION, VARIABLE
//	}
	
	
//	private ParserData data = new ParserData();

	/**
	 * Converts given string into expression tree.
	 * 
	 * @param input
	 *            expression given in the language to be parsed
	 * @return expression tree representing the given formula
	 */
//	public Expression makeExpression(String input) {
//		data.myInput = input;
//		data.myCurrentPosition = 0;
//		Expression result = parseExpression();
//		skipWhiteSpace();
//		if (notAtEndOfString()) {
//			throw new ParserException(
//					"Unexpected characters at end of the string: "
//							+ data.myInput.substring(data.myCurrentPosition),
//					ParserException.Type.EXTRA_CHARACTERS);
//		}
//		return result;
//	}
	
//	private boolean isNumber() {
//		Matcher doubleMatcher = DOUBLE_REGEX.matcher(data.myInput
//				.substring(data.myCurrentPosition));
//		return doubleMatcher.lookingAt();
//	}
//
//	private boolean isParenExpression() {
//		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(data.myInput
//				.substring(data.myCurrentPosition));
//		return expMatcher.lookingAt();
//	}
//
//	private boolean isVariable() {
//		Matcher variableMatcher = VARIABLE_REGEX.matcher(data.myInput
//				.substring(data.myCurrentPosition));
//		return variableMatcher.lookingAt();
//	}
//	
//	private ExpressionType getExpressionType() { // TODO Can we get ride of the if-statements here?
//		skipWhiteSpace();
//		if (isNumber())
//			return ExpressionType.NUMBER;
//		if (isParenExpression())
//			return ExpressionType.PAREN_EXPRESSION;
//		if (isVariable())
//			return ExpressionType.VARIABLE;
//		else
//			throw new ParserException("Unexpected Character "
//					+ currentCharacter());
//	}
//
//	private abstract Expression parseExpression() { //TODO as well as the if-statements here..?
//		switch (getExpressionType()) { 
//		case NUMBER:
//			return parseNumber();
//		case PAREN_EXPRESSION:
//			return parseParenExpression();
//		case VARIABLE:
//			return parseVariable();
//		default:
//			throw new ParserException("Unexpected expression type "
//					+ getExpressionType().toString());
//		}
//	}
//
//
//
//	private Expression parseNumber() {
//		Matcher doubleMatcher = DOUBLE_REGEX.matcher(data.myInput);
//		doubleMatcher.find(data.myCurrentPosition);
//		String numberMatch = data.myInput.substring(doubleMatcher.start(),
//				doubleMatcher.end());
//		data.myCurrentPosition = doubleMatcher.end();
//		// this represents the color gray of the given intensity
//		double value = Double.parseDouble(numberMatch);
//		RGBColor gray = new RGBColor(value);
//		return new NumberExpression(gray); //MODIFIED
//	}

//	private Expression parseVariable() {
//		Matcher xyMatcher = VARIABLE_REGEX.matcher(data.myInput);
//		xyMatcher.find(data.myCurrentPosition);
//		String varMatch = data.myInput.substring(xyMatcher.start(), xyMatcher.end());
//		data.myCurrentPosition = xyMatcher.end();
//		if (xyMatch.equals("x"))
//			return new VarExpression(true, false);
//		if (xyMatch.equals("y"))
//			return new VarExpression(false, true);
//		return new XYExpression(false, false);
//		return new VarExpression(varMatch);
//	}
//
//	private Expression parseParenExpression() {
//		Matcher expMatcher = EXPRESSION_BEGIN_REGEX.matcher(data.myInput);
//		expMatcher.find(data.myCurrentPosition);
//		String commandName = expMatcher.group(1);
//		data.myCurrentPosition = expMatcher.end();
//		
//		
//		// NOTE From notes of Roulette_Revised - substitute with loops
//		ArrayList<ExpressionFactory> PE = new ArrayList<ExpressionFactory>();
//		PE.add(ColorParenExpression.getFactory());
//		PE.add(DividParenExpression.getFactory());
//		PE.add(ExpParenExpression.getFactory());
//		PE.add(MinusParenExpression.getFactory());
//		PE.add(ModParenExpression.getFactory());
//		PE.add(MulParenExpression.getFactory());
//		PE.add(NegParenExpression.getFactory());
//		PE.add(PlusParenExpression.getFactory());
//		PE.add(RandomParenExpression.getFactory());
//		PE.add(FloorParenExpression.getFactory());
//		PE.add(CeilingParenExpression.getFactory());
//		PE.add(AbsParenExpression.getFactory());
//		PE.add(ClampParenExpression.getFactory());
//		PE.add(WrapParenExpression.getFactory());
//		PE.add(SinParenExpression.getFactory());
//		PE.add(CosParenExpression.getFactory());
//		PE.add(TanParenExpression.getFactory());
//		PE.add(AtanParenExpression.getFactory());
//		PE.add(LogParenExpression.getFactory());
//		
//		ArrayList<Expression> allExp = new ArrayList<Expression>();
//		
//		while(currentCharacter() != ')'){
//			Expression left = parseExpression();
//			skipWhiteSpace();
//			allExp.add(left);
//		}
//		data.myCurrentPosition++;
//		
//		for( ExpressionFactory current: PE )
//		{
//			if(current.isThisKind(commandName))
//			{
//				return current.creatExpression(allExp);
//			}
//		}
//		return null;
//	}

//		if (currentCharacter() == ')') // accomodate 'negate' case
//		{
//			myCurrentPosition++;
//			if (!commandName.equals("neg"))
//				throw new ParserException("Unexpected close paren");
//			return new Expression(commandName, left);
//		}
//		Expression right = parseExpression();
//		skipWhiteSpace();
//		if (currentCharacter() == ')') {
//			myCurrentPosition++;
//			return new Expression(commandName, left, right);
//		}
//
//		else {
//			Expression third = parseExpression();
//			if (currentCharacter() == ')') {
//				myCurrentPosition++;
//				return new Expression(commandName, left, right, third); //now for color
//			}
//			throw new ParserException("Expected close paren, instead found "
//					+ myInput.substring(myCurrentPosition));
//		}
	

//	private void skipWhiteSpace() {
//		while (notAtEndOfString() && Character.isWhitespace(currentCharacter(data))) {
//			data.myCurrentPosition++;
//		}
//	}
//
//	private char currentCharacter(ParserData data) {
//		return data.myInput.charAt(data.myCurrentPosition);
//	}
//
//	private boolean notAtEndOfString() {
//		return data.myCurrentPosition < data.myInput.length();
//	}

