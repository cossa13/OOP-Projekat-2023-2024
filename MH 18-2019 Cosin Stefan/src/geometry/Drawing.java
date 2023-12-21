package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel{
	public static void main(String[] args) {
		JFrame frame = new JFrame(); //Prozor u kome se nalazi panel
		Drawing drawing = new Drawing(); //Instanca panela
		frame.setContentPane(drawing); //Postavljanje panela u prozor
		frame.setSize(900, 600); //Velicina prozora
		frame.setLocationRelativeTo(null); //Centriranje prozora na ekranu
		frame.setVisible(true); //Prikazivanje prozora - obavezno
	}
	
	public void paint(Graphics g)
	{
		Point p1 = new Point(500, 200);
		Line l1 = new Line(p1, new Point(500, 500));
		Rectangle r1 = new Rectangle(new Point(600, 200), 100, 100);
		Circle c1 = new Circle(new Point(550, 200), 50);
		Donut d1 = new Donut(new Point(400,400), 50, 30);
		
		/*
		g.setColor(Color.BLUE);
		p1.draw(g);
		l1.draw(g);
		r1.draw(g);
		c1.draw(g);
		d1.draw(g);
		*/
		//Zadatak 5
		/*
		Rectangle r2 = new Rectangle(new Point(500, 300), 50, 50);
		Donut d = new Donut(new Point(r2.getUpperLeft().getX() + (r2.getWidth() / 2),
				r2.getUpperLeft().getY() + (r2.getHeight() / 2)),
				80, 
				(int) (r2.getWidth() * Math.sqrt(2) / 2));
		
		g.setColor(Color.BLUE);
		r2.draw(g);
		d.draw(g);
		*/
		//Vezbe8
		//4
		/*
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p1);
		shapes.add(l1);
		shapes.add(c1);
		shapes.add(d1);
		shapes.add(r1);
		
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		*/
		/*
		for(Shape s : shapes)
		{
			g.setColor(Color.BLUE);
			s.draw(g);
			g.setColor(Color.RED);
			s.moveBy(10, 0);
			s.draw(g);
		}
		*/
		//5
		/*
		shapes.get(2).draw(g);
		shapes.get(shapes.size() - 1).draw(g);
		shapes.remove(1);
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, l1);
		for(Shape sh: shapes)
		{
			if(sh instanceof Circle && !(sh instanceof Donut))
			{
				sh.draw(g);
			}
		}
		for(Shape sh: shapes)
		{
			if(sh instanceof Circle || sh instanceof Rectangle)
			{
				sh.draw(g);
			}
		}
		//7
		HashMap<String, Shape> hmShapes = new HashMap<String, Shape>();
		for(Shape s: shapes)
		{
			if(s instanceof Point)
			{
				hmShapes.put("Point", s);
			}
			if(s instanceof Line)
			{
				hmShapes.put("Line", s);
			}
			if(s instanceof Rectangle)
			{
				hmShapes.put("Rectangle", s);
			}
			if(s instanceof Circle)
			{
				hmShapes.put("Circle", s);
			}
			if(s instanceof Donut)
			{
				hmShapes.put("Donut", s);
			}
			else
			{
				hmShapes.put("Nepoznati oblik", s);
			}
		}
		for(Map.Entry<String, Shape> es: hmShapes.entrySet())
		{
			System.out.println(es);
			es.getValue().draw(g);
		}
		*/
		Circle c3 = new Circle(p1, 100);
		c3.setSelected(true);
		c3.draw(g);
		Point p3 = new Point(100, 100);
		p3.setSelected(true);
		p3.draw(g);
		Line l3 = new Line(p3, p1);
		l3.setSelected(true);
		l3.draw(g);
		Rectangle r3 = new Rectangle(p3, 50, 200);
		r3.setSelected(true);
		r3.draw(g);
		Donut d3 = new Donut(p3, 100, 50);
		d3.draw(g);
		
		
	}	
}

