package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	private int innerRadius;
	private Color donut_color = Color.BLACK;
	private Color donut_fill_color = Color.WHITE;
	
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
		super.setCircle_fill_color(donut_fill_color);
		super.draw(g);
		super.setCircle_color(donut_color);
		super.draw(g);
		g.setColor(Color.WHITE);
		g.fillOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, innerRadius * 2, innerRadius * 2);
		g.setColor(donut_color);
		g.drawOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, innerRadius * 2, innerRadius * 2);
		
		g.setColor(Color.BLACK);
		if(this.isSelected() == true)
		{
			g.setColor(Color.BLUE);
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
			g.setColor(Color.BLACK);
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
	public Color getDonut_color() {
		return donut_color;
	}
	public void setDonut_color(Color donut_color) {
		this.donut_color = donut_color;
	}
	public Color getDonut_fill_color() {
		return donut_fill_color;
	}
	public void setDonut_fill_color(Color donut_fill_color) {
		this.donut_fill_color = donut_fill_color;
	}
	
	
}
