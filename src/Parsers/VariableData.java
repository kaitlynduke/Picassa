package Parsers;

import java.util.HashMap;

import model.RGBColor;

public class VariableData {
	private double x;
	private double y;
	private double t;
	private HashMap<String, RGBColor> myMap;

	public VariableData(double x, double y, double t) {
		this.setX(x);
		this.setY(y);
		this.setT(t);
		setMyMap(new HashMap<String, RGBColor>());
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public void setT(double t) {
		this.t = t;
	}

	public double getT() {
		return t;
	}

	public void setMyMap(HashMap<String, RGBColor> myMap) {
		this.myMap = myMap;
	}

	public HashMap<String, RGBColor> getMyMap() {
		return myMap;
	}
}