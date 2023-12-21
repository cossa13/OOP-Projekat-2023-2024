package geometry;

import java.awt.Graphics;

public class Line extends Shape{
	
	private Point startPoint;
	private Point endPoint;
	
	//Konsturktori
	
	public Line()
	{
		
	}
	public Line(Point startPoint, Point endPoint)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	public Line(Point startPoint, Point endPoint, boolean selected)
	{
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	@Override
	public void moveTo(int x, int y) {
		//Nije moguce uraditi		
	}
	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(this.isSelected() == true)
		{
			g.drawRect(this.getStartPoint().getX() - 3,this.getStartPoint().getY() - 3, 6, 6);
			g.drawRect(this.getEndPoint().getX() - 3,this.getEndPoint().getY() - 3, 6, 6);
		}
	}
	public double length()
	{
		return startPoint.distance(endPoint);
	}
	
	@Override
	public String toString()
	{
		return "(" + this.getStartPoint().getX() + ", " + this.getStartPoint().getY() + ")"
				+ " -- > " + "(" + this.getEndPoint().getX() + ", " + this.getEndPoint().getY() + ")";
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line)
		{
			Line temp = (Line) o;
			return (int) (length() - temp.length());
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Line)
		{
			Line temp = (Line) o;
			if((this.startPoint.equals(temp.startPoint) && (this.endPoint.equals(temp.endPoint))))
			{
				return true;
			}
		}
		return false;
	}
	public boolean contains(int x, int y)
	{
		return (length() - startPoint.distance(new Point(x, y)) -
				endPoint.distance(new Point(x, y))) <= 3;
	}
	
	//Get i set metode
	public Point getStartPoint()
	{
		return startPoint;
	}
	public void setStartPoint(Point startPoint)
	{
		this.startPoint = startPoint;
	}
	public Point getEndPoint()
	{
		return endPoint;
	}
	public void setEndPoint(Point endPoint)
	{
		this.endPoint = endPoint;
	}
}
