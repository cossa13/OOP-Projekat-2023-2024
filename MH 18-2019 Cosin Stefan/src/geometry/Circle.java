package geometry;

import java.awt.Graphics;

public class Circle extends Shape {
	
	protected int radius;
	protected Point center;
	
	//Konstruktori
	
	public Circle()
	{
		
	}
	public Circle(Point center, int radius)
	{
		this.radius = radius;
		this.center = center;
	}
	public Circle(Point center, int radius, boolean selected)
	{
		this(center, radius);
		this.selected = selected;
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
	}
	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);	
	}
	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX()-radius, center.getY()-radius, radius * 2, radius * 2);	
		if(this.isSelected() == true)
		{
			g.drawRect(this.getCenter().getX() - 3,this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - (int)(this.getRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + (int)(this.getRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 - (int)(this.getRadius()), this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 + (int)(this.getRadius()), this.getCenter().getY() - 3, 6, 6);
		}
	}
	@Override
	public String toString()
	{
		return "(" + this.getCenter().getX() + ", " + this.getCenter().getY() + ")"
				+ " , radius = " + this.getRadius();
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle)
		{
			Circle temp = (Circle) o;
			return (int) (area() - temp.area());
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Circle)
		{
			Circle temp = (Circle) o;
			if(this.radius == temp.radius && center.equals(temp.getCenter()))
			{
				return true;
			}
		}
		return false;
	}
	public boolean contains(int x, int y)
	{
		if(center.distance(new Point(x, y)) <= radius)
		{
			return true;
		}
		return false;
	}
	public boolean contains(Point p)
	{
		return contains(p.getX(), p.getY());
	}
	public double area()
	{
		return Math.PI*radius*radius;
	}
	public double circumference()
	{
		return 2*radius*Math.PI;
	}
	
	//Get i set metode
	public int getRadius()
	{
		return radius;
	}
	public void setRadius(int radius) throws Exception
	{
		if(radius < 0) {
			throw new Exception("Radius cannot be less than 0");
		}
		else
		{
			this.radius = radius;
		}
	}
	public Point getCenter()
	{
		return center;
	}
	public void setCenter(Point center)
	{
		this.center = center;
	}
}
