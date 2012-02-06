package Parsers;

public class ParserData {
	private int myCurrentPosition;
	private String myInput;

	public ParserData(String input) {
		myInput = input;
		myCurrentPosition = 0;
	}

	public void skipWhiteSpace() {
		while (notAtEndOfString() && Character.isWhitespace(currentCharacter())) {
			setCurrentPosition(getCurrentPosition() + 1);
		}
	}

	public char currentCharacter() {
		return getMyInput().charAt(getCurrentPosition());
	}

	public boolean notAtEndOfString() {
		return getCurrentPosition() < getMyInput().length();
	}

	public void setCurrentPosition(int myCurrentPosition) {
		this.myCurrentPosition = myCurrentPosition;
	}

	public int getCurrentPosition() {
		return myCurrentPosition;
	}

	public String getMyInput() {
		return myInput;
	}
}