package atiq.ShapeDemo;



import java.awt.Color;

import processing.core.PApplet;
import shaylan.shapes.Circle;
import shaylan.shapes.Line;
import shaylan.shapes.Rectangle;




public class DrawingSurface extends PApplet {

	private PhysicsShape c1, l2;
	private PhysicsShape r1;
	private Line l1,l3, post;
	private boolean hit;
	
	
	public DrawingSurface() {
	
		c1 = new PhysicsShape(new Circle(400,300,20));
		
		r1 = new PhysicsShape (new Rectangle(20.0, 200.0, 200.0, 10.0));
		
		l1 = new Line(r1.getX()+10, r1.getY(),r1.getX()+10 , r1.getY()+200);
		
		l2 = new PhysicsShape(new Line(c1.getX(), c1.getY(),400d , 100d));
		
		l3 = new Line(c1.getX()-10, c1.getY()-10, c1.getX()-10, c1.getY()+10);
		post = new Line(400d, 100d,400d , 600d);


	}
	
	
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
	
		
		
		post.draw(this);
		post.setStrokeWeight(4);
		post.setStroke(Color.lightGray);
		
		l2.draw(this);
		c1.draw(this);
		c1.fillColor(Color.orange);

		
		l1.draw(this);
		l1.setStrokeWeight(5);
		l1.setStroke(Color.BLUE);
		
		
		if(hit)
		{
			r1.setVelocity(10, 0);
			l1.translate(10, 10, 0, 0);
			r1.act();
			if(l1.intersects(l3))
			{
				c1.setVelocity(5, 0.5);
				l2.setVelocity(5,0.5);

			}
			
		}
		else
		{
			r1.stop();
			r1.act();
		}
			
			c1.act2();
			l2.act2();


		
		
	}
		
			
	



	public void mousePressed()
	{
		if(r1.getX()<200)
		{
			hit = true;
		}
		
	
	}
	public void mouseReleased()
	{
		hit = false;
		
		for(int x = -100 ; x<0 ;x++)
		{
			if(r1.getX() > 10)
			{
				r1.setVelocity(x, 0);
				r1.act();

			}
		}
		for(int c = -100 ; c<0;c++)
		{
			if(l1.getX()>10)
			{
				l1.translate(c,c,0, 0);
			}
		}
		
	}
	
	
	

}










