package shaylan.shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * 
 * Represents a Processing-drawable Regular Polygon of 3 or more sides
 * 
 * @author shaylandias
 *
 */
public class RegularPolygon extends Shape{

	private Line[] sides;
	private final double angle;
	private double sideLength;
	private int numSides;
	private Circle outCircle;
	private Circle inCircle;

	/**
	 * 
	 * Creates a new RegularPolygon object as a triangle at the point 300,100 
	 * 
	 */
	public RegularPolygon() {
		this(300, 100, 5, 100);
	}

	/**
	 * 
	 * Creates a new RegularPolygon object at the point x,y with
	 * the input number of sides and side length
	 * 
	 * @param x The x-coordinate of the polygon
	 * @param y The y-coordinate of the polygon
	 * @param sides The number of sides, must be 3 or greater
	 * @param sideLength The length of the sides
	 */
	public RegularPolygon(double x, double y, int sides, double sideLength) {
		this(x, y, sides, sideLength, 1, new Color(Color.RED.getRGB()));
	}

	/**
	 * 
	 * Creates a new RegularPolygon object at point x,y with
	 * the input number of sides and side length, stroke weight
	 * and stroke color
	 * 
	 * @param x The x-coordinate of the polygon
	 * @param y The y-coordinate of the polygon
	 * @param sides The number of sides, must be 3 or greater
	 * @param sideLength The length of the sides
	 * @param strokeWeight The thickness of the lines of the polygon
	 * @param strokeColor The color of the polygon
	 */
	public RegularPolygon(double x, double y, int sides, double sideLength, double strokeWeight, Color strokeColor) {
		super(x, y, strokeWeight, strokeColor, new Color(0));
		this.sideLength = sideLength;
		numSides = sides;

		if(sides >=3) {
			angle = ((sides - 2.0)/sides * 180);
			this.sides = new Line[sides];
		}
		else {
			angle = 180;
			this.sides = new Line[0];
		}
		
		outCircle = new Circle(x,y,2 * calcR());
		inCircle = new Circle(x,y,2 * calcr());
		
		double lCenter = calcR();
		x += Math.cos(Math.PI/2 - Math.toRadians(angle)) * lCenter;
		y +=  Math.sin(Math.PI/2 + Math.toRadians(angle)) * lCenter;
		setX(x);
		setY(y);

		double value = (2 * Math.PI) / numSides;

		for(int i = 0; i < this.sides.length; i++) {
			if(i != 0) {
				this.sides[i] = new Line(this.sides[i-1].getX2(), this.sides[i-1].getY2(), this.sides[i-1].getX2() + Math.cos(Math.toRadians(angle) + value * i) * sideLength, this.sides[i-1].getY2() + Math.sin(Math.toRadians(angle) + value * i) * sideLength);
			}
			else {
				this.sides[0] = new Line(x, y, (int)sideLength, angle);
			}
		}
		
	}

	/**
	 * 
	 * Draws the RegularPolygon to the PApplet surface
	 * 
	 * @pre The input PApplet must not be null
	 * @param surface the PApplet to draw to, must not be null
	 */
	public void draw(PApplet surface) {
		surface.pushStyle();
		super.draw(surface);
		if(sides.length > 1) {
			for(int i = 0; i < sides.length; i++) {
				sides[i].draw(surface);
			}
		}
		else {
			sides[0].draw(surface);
		}
		surface.popStyle();
	}

	/**
	 * 
	 * Gets the angle of the RegularPolygon's vertex angle
	 * 
	 * @return The vertex angle
	 */
	public double getVertexAngle() {
		return angle;
	}

	/**
	 * 
	 * Returns true if the input point is inside the circle this polygon
	 * is inscribed inside
	 * 
	 * @param x The x-coordinate of the point
	 * @param y The y-coordinate of the point
	 */
	public boolean isPointInside(double x, double y) {
		if(outCircle.isPointInside(x, y)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public double getArea() {
		return 0.5 * numSides * calcR() * calcR() * Math.sin((2 * Math.PI)/numSides);
	}

	@Override
	public double getPerimeter() {
		return sideLength * numSides;
	}

	/**
	 * 
	 * Gets the number of sides of the RegularPolygon
	 * 
	 * @return The number of sides
	 */
	public int getNumSides(){
		return numSides;
	}

	/**
	 * 
	 * Gets the side length of the RegularPloygon
	 * 
	 * @return The side length
	 */
	public double getSideLength(){
		return sideLength;
	}

	/**
	 * 
	 * Gets the radius of the circle that the RegularPolygon is inscribed in
	 * 
	 * @return The radius of the circle
	 */
	public double getR(){
		return calcR();
	}

	/**
	 * 
	 * Gets the radius of the circle inscribed in the RegularPolygon
	 * 
	 * @return The radius of the circle
	 */
	public double getr(){
		return calcr();
	}

	/**
	 * 
	 * Draws the bounding circles of the RegularPolygon
	 * 
	 * @param marker The PApplet to draw to
	 */
	public void drawBoundingCircles(PApplet marker){
		inCircle.drawNoFill(marker);
		outCircle.drawNoFill(marker);
	}

	// private methods
	private double calcr(){
		double r = 0.5 * (sideLength)/Math.tan(Math.PI/numSides);
		return r;
	}

	private double calcR() {
		double r = 0.5 * (sideLength)/Math.sin(Math.PI/numSides);
		return r;
	}


}
