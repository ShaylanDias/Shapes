package shaylan.shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * 
 * Represents a Processing-drawable ambiguous Shape as a super class for more specific shapes
 * 
 * @author shaylandias
 *
 */
public abstract class Shape {

	/**
	 * The x-coordinate value of this Shape
	 */
	protected double x;
	
	/**
	 * The y-coordinate value of this Shape
	 */
	protected double y;
	
	private Color strokeColor, fillColor;
	private double strokeWeight;

	/**
	 * Creates a default instance of a Shape object with all dimensions
	 * set to zero, fillWeight 1, and stroke and fill colors black
	 * 
	 * @param x the x-value for this Shape's coordinate
	 * @param y the y-value for this Shape's coordinate
	 */
	public Shape(double x, double y) {
		this(x, y, 1.0, new Color(0), new Color(0));
	}

	/**
	 * 
	 *  Creates a new instance of a Shape object with the 
	 *  upper left corner of the Shape at x,y and with width
	 *  and height
	 * 
	 * @param x The upper left x-coordinate of the Shape
	 * @param y The upper-left y-coordinate of the Shape
	 * @param strokeWeight The Processing strokeWeight when drawing this Shape
	 * @param strokeColor The Processing strokeColor when drawing this Shape
	 * @param fillColor The Processing fillColor when drawing this Shape
	 */
	public Shape(double x, double y, double strokeWeight, Color strokeColor, Color fillColor) {
		this.x = x;
		this.y = y;
		this.strokeColor = new Color(strokeColor.getRGB());
		this.strokeWeight = strokeWeight;
		this.fillColor = new Color(fillColor.getRGB());
	}

	/**
	 * Sets the stroke, fill, and strokeWeight of the drawer to the Shape's values
	 * 
	 * @pre The drawer must not be null. All modifications to marker besides rectMode will apply to the Shape
	 * @param drawer The PApplet to draw to
	 */
	public void draw(PApplet drawer) {
		drawer.stroke(strokeColor.getRGB());
		drawer.fill(fillColor.getRGB());
		drawer.strokeWeight((float) strokeWeight);
	}
	
	/**
	 * Sets the stroke and strokeWeight of the drawer to the Shape's values and sets the drawer to noFill()
	 * 
	 * @pre The drawer must not be null. All modifications to marker besides rectMode will apply to the Shape
	 * @param drawer The PApplet to draw to
	 */
	public void drawNoFill(PApplet drawer) {
		drawer.stroke(strokeColor.getRGB());
		drawer.noFill();
		drawer.strokeWeight((float) strokeWeight);
	}
	

	/**
	 * 
	 * Returns true if the input point is contained by the Shape
	 * 
	 * @param x The x-value of the point
	 * @param y The y-value of the point
	 * @return True if the Point x,y is inside the Shape
	 */
	public abstract boolean isPointInside(double x, double y);

	/**
	 * Calculates and returns the area of the Shape
	 * 
	 * @return The area of the Shape as a double
	 */
	public abstract double getArea();

	/**
	 * Calculates and returns the perimeter of the Shape
	 * 
	 * @return The perimeter of the Shape as a double
	 */
	public abstract double getPerimeter();

	/**
	 * 
	 * Changes the x and y values of the Shape by 
	 * moving the upper-left hand corner
	 * 
	 * @param xChange The change in the x-value
	 * @param yChange The change in the y-value
	 */
	public void translate(double xChange, double yChange) {
		this.x += xChange;
		this.y += yChange;
	}

	/**
	 * 
	 * Moves the Shape to the input x,y
	 * 
	 * @param x The x to move to
	 * @param y The y to move to
	 */
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets the Shape's strokeWeight
	 * 
	 * @return The Shape's strokeWeight
	 */
	public double getStrokeWeight() {
		return strokeWeight;
	}

	/**
	 * Sets the Shape's strokeWeight
	 * 
	 * @param weight The Shape's new strokeWeight
	 */
	public void setStrokeWeight(double weight) {
		strokeWeight = weight;
	}
	
	/**
	 * Gets the Shape's fillColor
	 * 
	 * @return The Shape's fillColor
	 */
	public Color getFill() {
		return fillColor;
	}

	/**
	 * Sets the Shape's fillColor
	 * 
	 * @param fill The Shape's new fillColor
	 */
	public void setFill(Color fill) {
		fillColor = new Color(fill.getRGB());
	}
	
	/**
	 * Gets the Shape's fillColor
	 * 
	 * @pre fill must not be null
	 * @return The Shape's fillColor
	 */
	public Color getStroke() {
		return strokeColor;
	}

	/**
	 * Sets the Shape's strokeColor
	 * 
	 * @pre stroke must not be null
	 * @param stroke The Shape's new fillColor
	 */
	public void setStroke(Color stroke) {
		strokeColor = new Color(stroke.getRGB());
	}

	/**
	 * Gets the Shape's upper-left x-coordinate
	 * 
	 * @return The Shape's upper-left x-coordinate height as a double
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the Shape's upper-left y-coordinate
	 * 
	 * @return The Shape's upper-left y-coordinate height as a double
	 */
	public double getY() {
		return y;
	}

	/**
	 * 
	 * Sets the Rectangle's x-coordinate
	 * 
	 * @param x The new x-coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * 
	 * Sets the Rectangle's y-coordinate
	 * 
	 * @param y The new y-coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}
}
