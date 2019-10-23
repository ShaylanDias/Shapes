package shaylan.shapes;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import processing.core.PApplet;


/**
 * 
 * This class models a Processing-drawable Rectangle.
 * 
 * @author sdias695
 *
 */
public class Rectangle extends Shape{

	private double height, width;

	/**
	 * Creates a default instance of a Rectangle object with all dimensions
	 * set to zero
	 */
	public Rectangle() {
		this(0, 0, 0, 0);
	}
	
	
	/**
	 * 
	 *  Creates a new instance of a Rectangle object with the 
	 *  upper left corner of the Rectangle at x,y and with width
	 *  and height
	 * 
	 * @param x The upper left x-coordinate of the Shape
	 * @param y The upper-left y-coordinate of the Shape
	 * @param width The pixel width of the Rectangle
	 * @param height The pixel height of the Rectangle
	 * @param strokeWeight The Processing strokeWeight when drawing this Shape
	 * @param strokeColor The Processing strokeColor when drawing this Shape
	 * @param fillColor The Processing fillColor when drawing this Shape
	 */
	public Rectangle(double x, double y, double width, double height, double strokeWeight, Color strokeColor, Color fillColor) {
		super(x, y, strokeWeight, strokeColor, fillColor);
		this.width = width;
		this.height = height;
	}

	/**
	 * 
	 *  Creates a new instance of a Rectangle object with the 
	 *  left and right edges of the rectangle at x and x + width. 
	 *  The top and bottom edges are at y and y + height.
	 * 
	 * @param x The upper left x-coordinate of the Rectangle
	 * @param y The upper-left y-coordinate of the Rectangle
	 * @param height The pixel height of the Rectangle
	 * @param width The pixel height of the Rectangle
	 */
	public Rectangle(double x, double y, double height, double width) {
		super(x, y);
		this.height = height;
		this.width = width;
	}

	/**
	 * 
	 * Changes the size of the Rectangle by multiplying its
	 * height and width by the scale factor
	 * 
	 * @param scaleFactor The scale factor
	 */
	public void scale(double scaleFactor) {
		width *= scaleFactor;
		height *= scaleFactor;

	}

	/** 
	 * 
	 * Returns a String representing the Rectangle
	 * 
	 * @return A String representing the Rectangle
	 */
	public String toString() {
		return "(" + x + ", " + y + ")" + " width: " + width + ", height: " + height; 
	}

	/**
	 * Tells if this Rectangle touches the parameter Rectangle other.
	 * @pre The Rectangle parameter must not be null
	 * @param other The Rectangle to compare to
	 * @return True iff this Rectangle intersects the parameter
	 */
	public boolean intersects(Rectangle other) {
		double otherMaxX = Math.max(other.getX(), other.getX() + other.getWidth());
		double otherMinX = Math.min(other.getX(), other.getX() + other.getWidth());
		double otherMaxY = Math.max(other.getY(), other.getY() + other.getHeight());
		double otherMinY = Math.min(other.getY(), other.getY() + other.getHeight());
		double maxX = Math.max(x, x + width);
		double minX = Math.min(x, x + width);
		double maxY = Math.max(y, y + height);
		double minY = Math.min(y, y + height);	
	
		if(otherMaxX > minX && otherMaxX < maxX) {
			if(otherMaxY > minY && otherMinY < maxY) {
				return true;
			}
		}
		else if(otherMinX > minX && otherMinX < maxX) {
			if(otherMaxY > minY && otherMinY < maxY) {
				return true;
			}
		}
		if(minX >= otherMinX && maxX <= otherMaxX && minY >= otherMinY && maxY <= otherMaxY) {
			return true;
		}
		if(((maxX >= otherMinX && maxX <= otherMaxX) || (minX >= otherMinX && minX <= otherMaxX))) {
			if((minY >= otherMinY && minY <= otherMaxY) || (maxY >= otherMinY && maxY <= otherMaxY)) {
				return true;
			}
		}
	
		return false;
	
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.abs(width) + 2 * Math.abs(height);
	}

	@Override
	public double getArea() {
		return Math.abs(width * height);
	}
	
	@Override
	public boolean isPointInside(double x, double y) {
		double smallX = Math.min(this.x, this.x + width);
		double bigX = Math.max(this.x, this.x + width);
		double smallY = Math.min(this.y, this.y + height);
		double bigY = Math.max(this.y, this.y + height);

		if(x >= smallX && x <= bigX) {
			if(y >= smallY && y <= bigY) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Draws a new instance of a Rectangle object with the left and right 
	 * edges of the rectangle at getX() and getX() + getWidth() and 
	 * top and bottom edges are at getY() and getY() + getHeight() to the PApplet.
	 * 
	 * @pre The drawer must not be null. All modifications to marker besides rectMode will apply to the Rectangle
	 * @post the drawer will have its rectangle mode modified to PApplet.CORNER 
	 * @param marker The PApplet to draw to
	 */
	public void draw(PApplet marker) {
		marker.pushStyle();
		super.draw(marker);
		marker.rectMode(PApplet.CORNER);
		marker.rect((float)x, (float)y, (float)width, (float)height);
		marker.popStyle();
	}
	
	/**
	 * Draws a new clear instance of a Rectangle object with the left and right
	 * edges of the rectangle at getX() and getX() + getWidth() and 
	 * top and bottom edges are at getY() and getY() + getHeight() to the PApplet.
	 * 
	 * @pre The drawer must not be null. All modifications to marker besides rectMode will apply to the Rectangle
	 * @post the drawer will have its rectangle mode modified to PApplet.CORNER 
	 * @param marker The PApplet to draw to
	 */
	public void drawNoFill(PApplet marker) {
		marker.pushStyle();
		super.drawNoFill(marker);
		marker.rectMode(PApplet.CORNER);
		marker.rect((float)x, (float)y, (float)width, (float)height);
		marker.popStyle();
	}
	
	
	/**
	 * Gets the Rectangle's width
	 * 
	 * @return The Rectangle's width height as a double
	 */
	public double getWidth() { 
		return width; 
	}	
	
	/**
	 * 
	 * Gets the Rectangle's height
	 * 
	 * @return The Rectangle's height as a double
	 */
	public double getHeight() { 
		return height; 
	}

	/**
	 * 
	 * Adds to the Rectangle's width
	 * 
	 * @param addition Change to the width
	 */
	public void addWidth(double addition) {
		width += addition;
	}

	/**
	 * 
	 * Adds the the Rectangle's height
	 * 
	 * @param addition Change to the height
	 */
	public void addHeight(double addition) {
		width += addition;
	}

	/**
	 * 
	 * Sets the Rectangle's height
	 * 
	 * @param height The new height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * 
	 * Sets the Rectangle's width
	 * 
	 * @param width The new width
	 */
	public void setWidth(double width) {
		this.width = width;
	}


	/**
	 * 
	 * Sets the bottom right corner of the Rectangle to the input value
	 * 
	 * @param mouseX X-coordinate of new bottom right corner
	 * @param mouseY Y-coordinate of new bottom right corner
	 */
	public void setBottomRight(int mouseX, int mouseY) {
		width = mouseX-this.x;
		height = mouseY-this.y;
	}

	/**
	 * 
	 * Returns a Point that is the center point of the Rectangle
	 * 
	 * @return The Center point of the Rectangle as the new Rectangle
	 */
	public Double getCenter() {
		return new Point2D.Double(x+width/2,y+height/2);
	}


}
