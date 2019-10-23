package shaylan.illusiondrawings.illusion1;

import shaylan.shapes.Circle;
import shaylan.shapes.Rectangle;

import java.awt.Color;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	public DrawingSurface() {

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
		Circle circle = new Circle(300, 185, 260);
		Rectangle rect = new Rectangle(100, 20, 400, 350, 5, new Color(0), new Color(0));
		boolean black = true;
		background(255);   // Clear the screen with a white background
//		scale((float)(width/400.0), (float)(height/300.0));
		stroke(0);
		fill(0);
		noStroke();
		while(circle.getRadius() > 40) {
			circle.draw(this);
			if(black) {
				circle = new Circle(circle.getX(), circle.getY(), circle.getRadius() - 8, 1, new Color(0), Color.BLACK);
				black = false;
			}
			else {
				circle = new Circle(circle.getX(), circle.getY(), circle.getRadius() - 8, 1, Color.WHITE, Color.WHITE);
				black = true;
			}
		}
		circle.setRadius(260);
		strokeWeight(5);
		stroke(110);
		rect.drawNoFill(this);
		strokeWeight(1);

	}


}










