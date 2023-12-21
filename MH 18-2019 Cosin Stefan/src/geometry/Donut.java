package geometry;

import java.awt.Graphics;

public class Donut extends Circle{
	private int innerRadius;
	
	//Kontruktori
	public Donut()
	{
		
	}
	public Donut(Point center, int radius,  int innerRadius)
	{
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	public Donut(Point center, int radius, int innerRadius, boolean selected)
	{
		this(center, radius, innerRadius);
		super.setSelected(selected);
	}
	
	@Override
	public void draw(Graphics g)
	{
		super.draw(g);
		g.drawOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, innerRadius * 2, innerRadius * 2);
		if(this.isSelected() == true)
		{
			//Spoljasnji krug
			g.drawRect(this.getCenter().getX() - 3,this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - (int)(this.getRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + (int)(this.getRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 - (int)(this.getRadius()), this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 + (int)(this.getRadius()), this.getCenter().getY() - 3, 6, 6);
			
			//g.drawRect(this.getCenter().getX() - 3,this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - (int)(this.getInnerRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + (int)(this.getInnerRadius()) - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 - (int)(this.getInnerRadius()), this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3 + (int)(this.getInnerRadius()), this.getCenter().getY() - 3, 6, 6);
		}
	
	}
	@Override
	public boolean contains(int x, int y)
	{
		return super.contains(x, y) && 
				(getCenter().distance(new Point(x, y)) >= innerRadius);
	}
	@Override
	public boolean contains(Point p)
	{
		return contains(p.getX(), p.getY());
	}
	@Override
	public double area()
	{
		return super.area() - (Math.PI*innerRadius*innerRadius);
	}
	@Override
	public String toString()
	{
		return super.toString() + ", inner radius: " + innerRadius;
	}
	@Override
	public int compareTo(Object o)
	{
		if(o instanceof Donut)
		{
			Donut temp = (Donut) o;
			return (int) (area() - temp.area());
		}
		return 0;
	}
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Donut)
		{
			Donut temp = (Donut) o;
			if(getCenter().equals(temp.getCenter()) &&
					getRadius() == temp.getRadius() &&
					innerRadius == temp.getInnerRadius())
			{
				return true;
			}
		}
		return false;
	}
	//Get i set metode
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	
}
