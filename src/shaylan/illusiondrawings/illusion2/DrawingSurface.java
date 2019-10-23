package shaylan.illusiondrawings.illusion2;

import shaylan.shapes.Circle;
import shaylan.shapes.Line;
import shaylan.shapes.Rectangle;
import java.awt.Color;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private boolean is1;

	public DrawingSurface(boolean is1) {
		this.is1 = is1;
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
		if(is1) {
			drawIllusion1();
		}
		else {
			drawIllusion2();
		}

	}

	public void drawIllusion1() {
		Circle circle = new Circle(200, 135, 260);
		Rectangle rect = new Rectangle(100, 35, 195, 195, 5, new Color(0), new Color(0));
		boolean black = true;
		background(255);   // Clear the screen with a white background
		scale((float)(width/400.0), (float)(height/300.0));
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

	private void drawIllusion2() {
		Line[] lines = new Line[40];
		int angle = 0;
		int count = 0;
		background(255);
		
		do{
			lines[count] = new Line(width/2, height/2, 150, angle, 5, new Color(0));
			lines[count].draw(this);
			angle += 9;
			count ++;
		}while(count < 40);
		
		lines = new Line[6];
		int startX = width/2 - 120;
		for(int i = 0; i < 6; i ++) {
			lines[i] = new Line(startX + i * 48.0, height/2 - 143.0, startX + i * 48.0, height/2 + 143.0, 7, new Color(Color.RED.getRGB()));
			lines[i].draw(this);
		}
		
	}


}










