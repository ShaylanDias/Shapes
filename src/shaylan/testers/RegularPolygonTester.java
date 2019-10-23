package shaylan.testers;


import processing.core.PApplet;
import shaylan.shapes.RegularPolygon;

public class RegularPolygonTester extends PApplet{
		
	private RegularPolygon polygon;
	
	public RegularPolygonTester() {
		polygon = new RegularPolygon();
	}

	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {

	}

	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		polygon = new RegularPolygon();
		polygon.draw(this);
		polygon = new RegularPolygon(300, 100, 4, 10);
		polygon.draw(this);
		polygon = new RegularPolygon(100, 100, 19, 2);
		polygon.draw(this);
		polygon = new RegularPolygon(200, 100, 8, 5.75);
		polygon.draw(this);
		polygon = new RegularPolygon(150, 100, 91, 0.5);
		polygon.draw(this);
	}

}
