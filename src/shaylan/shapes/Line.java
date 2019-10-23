package shaylan.shapes;
import java.awt.Color;
import java.awt.Point;

import processing.core.PApplet;

/**
 * 
 * This class models a Processing-drawable Line
 * 
 * @author shaylandias
 *
 */
public class Line extends Shape{

	private double x2, y2;

	/**
	 * 
	 * Creates and instance of Line with one point at x1,y1
	 * and the other point at x2,y2
	 * 
	 * @param x The first point's x-coordinate
	 * @param y The first point's y-coordinate
	 * @param x2 The seconds point's x-coordinate
	 * @param y2 The second point's y-coordinate
	 */
	public Line(double x, double y, double x2, double y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * 
	 * Creates an instance of the Line with starting point x,y
	 * and length length extending from angle degrees from the horizontal
	 * 
	 * @param x The starting point x-coordinate
	 * @param y The starting point y-coordinate
	 * @param length The length of the Line
	 * @param angle The angle of the Line
	 */

	public Line(double x, double y, int length, double angle) {
		super(x, y);
		x2 = x + Math.cos(Math.toRadians(angle)) * length;
		y2 = y + Math.sin(Math.toRadians(angle)) * length;
	}

	/**
	 * 
	 *  Creates an instance of the Line with starting point x,y
	 * and length length extending from angle degrees from the horizontal
	 * 
	 * @param x The starting point x-coordinate
	 * @param y The starting point y-coordinate
	 * @param length The length of the Line
	 * @param angle The angle of the Line
	 * @param strokeWeight The thickness of the Line
	 * @param strokeColor The Color of the Line
	 */
	public Line(double x, double y, int length, double angle, double strokeWeight, Color strokeColor) {
		super(x, y, strokeWeight, strokeColor, new Color(0));
		x2 = x + Math.cos(Math.toRadians(angle)) * length;
		y2 = y + Math.sin(Math.toRadians(angle)) * length;
	}


	/**
	 * 
	 *  Creates a new instance of a Line object with one point at x,y
	 *  and the other point at x2,y2
	 * 
	 * @param x The first point's x-coordinate
	 * @param y The first point's y-coordinate
	 * @param x2 The second point's x-coordinate
	 * @param y2 The second point's y-coordinate
	 * @param strokeWeight The Processing strokeWeight when drawing this Shape
	 * @param strokeColor The Processing strokeColor when drawing this Shape
	 */
	public Line(double x, double y, double x2, double y2, double strokeWeight, Color strokeColor) {
		super(x, y, strokeWeight, strokeColor, new Color(0));
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * 
	 * Draws the Line from points getX1(),getY1() to
	 * getX2(),getY2() to the drawer.
	 * 
	 * @pre The drawer must not be null
	 * @param surface The PApplet to draw to.
	 */
	public void draw(PApplet surface) {
		surface.pushStyle();
		super.draw(surface);
		surface.line((float)x, (float)y, (float)x2, (float)y2);
		surface.popStyle();
	}

	/**
	 * 
	 * Sets the second point of the line to the arguments
	 * 
	 * @param x2 The new x-coordinate for the second point
	 * @param y2 The new y-coordinate for the second point
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * 
	 * Translates the line by the input values
	 * 
	 * @param xChange Change to x-coordinate
	 * @param x2Change Change to second x-coordinate
	 * @param yChange Change to y-coordinate
	 * @param y2Change Change to second y-coordinate
	 */
	public void translate(double xChange, double x2Change, double yChange, double y2Change) {
		super.translate(xChange, yChange);
		x2 += x2Change;
		y2 += y2Change;
	}

	/**
	 * 
	 * Sets the first point of the line to the arguments
	 * 
	 * @param x1 The new x-coordinate for the first point
	 * @param y1 The new y-coordinate for the first point
	 */
	public void setPoint1(double x1, double y1) {
		this.x = x1;
		this.y = y1;
	}

	/**
	 * 
	 * Returns the x-coordinate of the first point
	 * 
	 * @return The x-coordinate of the first point
	 */
	public double getX() {
		return x;
	}

	/**
	 * 
	 * Returns the x-coordinate of the second point
	 * 
	 * @return The x-coordinate of the second point
	 */
	public double getX2() {
		return x2;
	}

	/**
	 * 
	 * Returns the y-coordinate of the first point
	 * 
	 * @return The y-coordinate of the first point
	 */
	public double getY() {
		return y;
	}

	/**
	 * 
	 * Returns the y-coordinate of the second point
	 * 
	 * @return The y-coordinate of the second point
	 */
	public double getY2() {
		return y2;
	}

	/**
	 * 
	 * Returns a java.awt.Point representing the intersection between the Line
	 * and another Line. There may be a bug with parallel Lines where the Point is not correct.
	 * 
	 * @pre The input Line must not be null
	 * @param other The Line to compare to
	 * @return A java.awt.Point representing the intersection.
	 * 
	 */
	public Point getIntersection(Line other) {
		double x3 = other.getX();
		double y3 = other.getY();
		double x4 = other.getX2();
		double y4 = other.getY2();

		if(Double.compare((x - x2) * (y3 - y4) - (y - y2) * (x3 - x4), 0) == 0){
			if(x == x2) {
				return new Point((int)x, (int)y3);
			}
			else {
				return new Point((int)x3, (int)y);
			}
		}

		//Equation for the intersect points
		double intersectX = ((x * y2 - y * x2) * (x3 - x4) - (x - x2) * (x3 * y4 - y3 * x4))/((x - x2) * (y3 - y4) - (y - y2) * (x3 - x4));
		double intersectY = ((x * y2 - y * x2) * (y3 - y4) - (y - y2) * (x3 * y4 - y3 * x4))/((x - x2) * (y3 - y4) - (y - y2) * (x3 - x4));

		return new Point((int)intersectX, (int)intersectY);
	}

	/**
	 * 
	 * Compares two Lines to see if they intersect
	 * 
	 * @param other The Line to compare to
	 * @return True if the Lines intersect
	 */
	public boolean intersects(Line other) {
		double intersectX = this.getIntersection(other).getX();
		double intersectY = this.getIntersection(other).getY();

		boolean in1 = false, in2 = false;
		in1 = isOnLine(x, y, x2, y2, intersectX, intersectY);
		in2 = isOnLine(other.getX(), other.getY(), other.getX2(), other.getY2(), intersectX, intersectY);

		if(in1 == true && in2 == true) { //If the intersect point is on both lines
			return true;
		}
		return false;
	}

	private boolean isOnLine(double x1, double y1, double x2, double y2, double intersectX, double intersectY) {
		double greaterX, lesserX, greaterY, lesserY;
		//Finds which x is greater
		greaterX = Math.max(x1, x2);
		lesserX = Math.min(x1, x2);
		greaterY = Math.max(y1, y2);
		lesserY = Math.min(y1, y2);

		if(intersectX >= lesserX && intersectX <= greaterX) { //If the x intersect is on the line
			if(intersectY >= lesserY && intersectY <= greaterY) { //If the y intersect is on the line
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	/**
	 * 
	 * Gets the angle formed by the Line and the horizontal
	 * 
	 * @return The angle of the Line
	 */
	public double getAngle() {
		return Math.toDegrees(Math.atan((x2 - x)/(y2 - y)));
	}


	@Override
	public boolean isPointInside(double x, double y) {
		return isOnLine(this.x, this.y, x2, y2, x, y);
	}

	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public double getPerimeter() {
		return Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
	}

}
