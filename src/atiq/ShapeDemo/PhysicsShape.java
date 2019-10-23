package atiq.ShapeDemo;

import java.awt.Color;

import processing.core.PApplet;
import shaylan.shapes.Line;
import shaylan.shapes.Shape;

public class PhysicsShape {

	private Shape boundingShape;
	private double vx, vy, x,  y;
	
	public PhysicsShape(Shape boundingShape) 
	{
		this.boundingShape = boundingShape;
		x = this.boundingShape.getX();
		y = this.boundingShape.getY();
		vx = 0;
		vy = 0;
		
	}
	
	public void draw(PApplet drawer)
	{
		boundingShape.draw(drawer);
	}
	
	public Shape getBoundingShape()
	{
		return boundingShape;
		
	}
	public void setVelocity(double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}
	
	
	public void act2() 
	{
	
		if(boundingShape.getX()<150)
		{
				vx=-vx;		
				vy=-vy;
			
						
		}
					
			
		if(boundingShape.getX()>650)
		{

			vx = -vx;
			vy = -vy;
		}
		
		if(boundingShape.getX()==400)
		{				
			this.slowDown();
			vy=-vy;

		}
		if(boundingShape.getY()<100)
		{
			vy=-vy;
		}
		boundingShape.translate(vx,vy);
	}
	
	public void slowDown()
	{
		if(vx!=0)
		{
			if(vx>0)
			{
				vx= vx-1;
			}
			if(vx<0)
			{
				vx=vx+1;
			}
			
		}
		if(vy!=0)
		{
			if(vy>0)
			{
				vy=vy-0.1;
			}
			
			if(vy<0)
			{
				vy=vy+0.1;
			}
		}
	}
	
	public void act()
	{
		boundingShape.translate(vx, vy);
	}
	

	public void stop()
	{
		vx = 0;
		vy = 0;
	}
	
	
	public double getX() {
		return x;
	}
	
	
	public double getY() {
		return y;
	}
	
	public boolean intersects(Line l2) {
		Line ln = (Line)boundingShape;
		return ln.intersects(l2);
		
	}
	public void fillColor(Color color) 
	{
		boundingShape.setFill(color);
	}
	
	
}
