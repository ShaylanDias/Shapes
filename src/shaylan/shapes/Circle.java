package shaylan.shapes;
import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * 
 * This class models a Processing-drawable Circle
 * 
 * @author shaylandias
 *
 */
public class Circle extends Shape{

	private double radius;

	/**
	 * Creates a default instance of the Circle object with all
	 * values set to zero
	 */
	public Circle() {
		this(0, 0, 0);
	}

	/**
	 * 
	 * Creates a new instance of the Circle object with center at x,y 
	 * and the input radius
	 * 
	 * @param x X-coordinate of the center
	 * @param y Y-coordinate of the center
	 * @param radius Radius of the Circle
	 */
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}

	/**
	 * 
	 *  Creates a new instance of a Circle object with the 
	 *  center of the Circle at x,y and with radius radius
	 * 
	 * @param x The upper left x-coordinate of the Shape
	 * @param y The upper-left y-coordinate of the Shape
	 * @param radius The radius of the Circle
	 * @param strokeWeight The Processing strokeWeight when drawing this Shape
	 * @param strokeColor The Processing strokeColor when drawing this Shape
	 * @param fillColor The Processing fillColor when drawing this Shape
	 */
	public Circle(double x, double y, double radius, double strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, strokeWeight, strokeColor, fillColor);
		this.radius = radius;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * Math.abs(radius);
	}

	@Override
	public double getArea() {
		return Math.abs(radius * radius) * Math.PI;
	}

	/**
	 * Tells if two Circles intersects
	 * 
	 * @pre The Circle parameter must not be null
	 * @param other The Circle to compare to
	 * @return True if the Circles intersect
	 */
	public boolean intersects(Circle other) {
		double otherX = other.getX();
		double otherY = other.getY();
		double otherR = other.getRadius();
		if(getDistance(otherX, otherY) <= Math.abs(radius) + Math.abs(otherR)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isPointInside(double x, double y) {
		double distance = getDistance(x, y);
		if(distance <= Math.abs(radius)) {
			return true;
		}
		else {
			return false;
		}

	}

	/**
	 * 
	 * Multiplies the radius of the circle by the parameter
	 * 
	 * @param factor How much to multiply the size of the circle by
	 */
	public void scale(double factor)	{
		radius *= factor;
	}


	/**
	 * 
	 * Returns a String representing the Circle
	 * 
	 * @return This Circle represented as a String
	 */
	public String toString() {
		return "(" + x +", " + y + ")" + " radius= " + radius;
	}
	
	/**
	 * 
	 * Draws a clear Circle using the Processing draw methods
	 * with the center at getX(),getY() with a radius of 
	 * getRadius()
	 * 
	 * @post The drawer will have its ellipse mode modified to PApplet.CENTER
	 * @pre The drawer must not be null. All changes to marker besides ellipseMode will affect the Circle
	 * @param marker The PApplet to draw to
	 */
	public void drawNoFill(PApplet marker) {
		marker.pushStyle();
		super.drawNoFill(marker);
		marker.ellipseMode(PConstants.CENTER);
		marker.ellipse((float)x, (float)y, (float)radius, (float)radius);
		marker.popStyle();
	}
	
	
	/**
	 * 
	 * Draws the Circle using the Processing draw methods
	 * with the center at getX(),getY() with a radius of 
	 * getRadius()
	 * 
	 * @post The drawer will have its ellipse mode modified to PApplet.CENTER
	 * @pre The drawer must not be null. All changes to marker besides ellipseMode will affect the Circle
	 * @param marker The PApplet to draw to
	 */
	public void draw(PApplet marker) {
		marker.pushStyle();
		super.draw(marker);
		marker.ellipseMode(PConstants.CENTER);
		marker.ellipse((float)x, (float)y, (float)radius*2, (float)radius*2);
		marker.popStyle();
	}

	/**
	 * 
	 * Returns the radius of the Circle
	 * 
	 * @return The radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * 
	 * Changes the radius of the Circle
	 * 
	 * @param radius The new radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	private double getDistance(double otherX, double otherY) {
		return Math.sqrt((otherX - x) * (otherX - x) + (otherY - y) * (otherY - y));
	}

}
