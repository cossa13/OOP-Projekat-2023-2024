package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape{
	
	private Point upperLeft;
	private int width;
	private int height;
	
	//Konstruktori
	
	public Rectangle()
	{
		
	}
	public Rectangle(Point upperLeft, int width, int height)
	{
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	public Rectangle(Point upperLeft, int width, int height, boolean selected)
	{
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);
	}
	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if(this.isSelected() == true)
		{
			g.drawRect(upperLeft.getX() - 3, upperLeft.getY() - 3, 6, 6);
			g.drawRect(upperLeft.getX() - 3 + this.getWidth(), upperLeft.getY() - 3, 6, 6);
			g.drawRect(upperLeft.getX() - 3, upperLeft.getY() + this.getHeight() - 3, 6, 6);
			g.drawRect(upperLeft.getX() + this.getWidth() - 3, upperLeft.getY() + this.getHeight() - 3, 6, 6);
		}
	}
	
	@Override
	public String toString()
	{
		return "(" + this.getUpperLeft().getX() + ", " + this.getUpperLeft().getY() + ")"
				+ ", width = " + this.getWidth() + ", height = " + this.getHeight();
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle)
		{
			Rectangle temp = (Rectangle) o;
			return area() - temp.area();
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Rectangle)
		{
			Rectangle temp = (Rectangle) o;
			if((this.width == temp.width) && (this.height == temp.height))
			{
				return true;
			}
		}
		return false;
	}
	public boolean contains(int x, int y)
	{
		if ((x >= upperLeft.getX() && x <= upperLeft.getX() + width)
				&& (y >= upperLeft.getY() && y <= upperLeft.getY()+height))
		{
			return true;
		}
		return false;
	}
	//Get i set metode
	public int area() //povrisna
	{
		return width * height;
	}
	public int circumference() //obim
	{
		return height*2 + width*2;
	}
	public Point getUpperLeft()
	{
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft)
	{
		this.upperLeft = upperLeft;
	}
	public int getWidth()
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}

}
