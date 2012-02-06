package Parsers;

import java.util.HashMap;

import model.RGBColor;

public class VariableData {
	public double x;
	public double y;
	public double t;
	public HashMap<String, RGBColor> myMap;

	public VariableData(double x, double y, double t) {
		this.x = x;
		this.y = y;
		this.t = t;
		myMap = new HashMap<String, RGBColor>();
	}
}