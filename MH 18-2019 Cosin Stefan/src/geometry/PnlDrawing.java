package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel{
	
	private ArrayList<Shape> selected_shapes = new ArrayList<Shape>();
	public static ArrayList<Shape> shape_list = new ArrayList<Shape>();
	public static Shape selected_shape;
	public static int width, height;
	public static int radius;
	public static int oradius, iradius;
	private Point point;
	private Rectangle r1;
	private Circle c1;
	private Line l1;
	private Donut d1;
	private Point p1;
	private Point p2;
	private int brojac_line = 0;
	
	public PnlDrawing()
	{
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Drawing_Application.getOperation() == "Draw")
				{
					if(Drawing_Application.getDraw_shape() == "Point")
					{
						point = new Point(e.getX(), e.getY());
						DlgDrawingPoint.setPoint_color(Color.BLACK);
						shape_list.add(point);
						repaint();	
					}
					if(Drawing_Application.getDraw_shape() == "Line")
					{
						if(brojac_line == 0)
						{
							p1 = new Point(e.getX(), e.getY());
						}
						if(brojac_line == 1)
						{
							p2 = new Point(e.getX(), e.getY());
							l1 = new Line(p1, p2);
							DlgDrawingLine.setLine_color(Color.BLACK);
							shape_list.add(l1);
						}
						brojac_line++;
						if(brojac_line == 2)
						{
							brojac_line = 0;
							repaint();
						}
					}
					if(Drawing_Application.getDraw_shape() == "Rectangle")
					{
						DlgDrawingRectangle drwr = new DlgDrawingRectangle();
						drwr.getTextFieldX().setText(Integer.toString(e.getX()));
						drwr.getTextFieldY().setText(Integer.toString(e.getY()));
						drwr.getTextFieldX().setEditable(false);
						drwr.getTextFieldY().setEditable(false);
						DlgDrawingRectangle.setRectangle_color(Color.BLACK);
						DlgDrawingRectangle.setRectangle_fill_color(Color.WHITE);
						drwr.setVisible(true);
						if(drwr.isFlag_ok())
						{
							r1 = new Rectangle(new Point(e.getX(), e.getY()), width, height);
							r1.setRectangle_color(DlgDrawingRectangle.getRectangle_color());
							r1.setFill_color(DlgDrawingRectangle.getRectangle_fill_color());
							shape_list.add(r1);
							drwr.setFlag_ok(false);
							repaint();
						}
					}
					if(Drawing_Application.getDraw_shape() == "Circle")
					{
						DlgDrawingCircle drcr = new DlgDrawingCircle();
						drcr.getTextFieldX().setText(Integer.toString(e.getX()));
						drcr.getTextFieldY().setText(Integer.toString(e.getY()));
						drcr.getTextFieldX().setEditable(false);
						drcr.getTextFieldY().setEditable(false);
						DlgDrawingCircle.setCircle_color(Color.BLACK);
						DlgDrawingCircle.setCircle_fill_color(Color.WHITE);
						drcr.setVisible(true);
						if(drcr.isFlag_ok())
						{
							c1 = new Circle(new Point(e.getX(), e.getY()), radius);
							c1.setCircle_color(DlgDrawingCircle.getCircle_color());
							c1.setCircle_fill_color(DlgDrawingCircle.getCircle_fill_color());
							shape_list.add(c1);
							drcr.setFlag_ok(false);
							repaint();
						}
					}
					if(Drawing_Application.getDraw_shape() == "Donut")
					{
						DlgDrawingDonut drdr = new DlgDrawingDonut();
						drdr.getTextFieldX().setText(Integer.toString(e.getX()));
						drdr.getTextFieldY().setText(Integer.toString(e.getY()));
						drdr.getTextFieldX().setEditable(false);
						drdr.getTextFieldY().setEditable(false);
						DlgDrawingDonut.setDonut_color(Color.BLACK);
						DlgDrawingDonut.setDonut_fill_color(Color.WHITE);
						drdr.setVisible(true);
						if(drdr.isFlag_ok())
						{
							d1 = new Donut(new Point(e.getX(), e.getY()), oradius, iradius);
							d1.setDonut_color(DlgDrawingDonut.getDonut_color());
							d1.setDonut_fill_color(DlgDrawingDonut.getDonut_fill_color());
							shape_list.add(d1);
							drdr.setFlag_ok(false);
							repaint();
						}
					}
				}
				if(Drawing_Application.getOperation() == "Selection")
				{
					selection(e.getX(), e.getY());
					repaint();
				}
			}
		});
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		for(Shape shapes : shape_list)
		{
			shapes.draw(g);
		}
	}

	public void selection(int x, int y)
	{

		selected_shapes.clear();
		selected_shape = null;
		
		for(Shape s : shape_list)
		{
			s.setSelected(false);
			if(s.contains(x, y) == true)
			{
				selected_shapes.add(s);
			}
		}
		if(selected_shapes.size() == 1)
		{
			selected_shapes.get(0).setSelected(true);
			selected_shape = selected_shapes.get(0);
		}
		if(selected_shapes.size() > 1)
		{
			selected_shapes.get(selected_shapes.size()-1).setSelected(true);
			selected_shape = selected_shapes.get(selected_shapes.size()-1);		
		}
		
	}
	
	public static Shape getSelected_shape() {
		return selected_shape;
	}
	public static void setSelected_shape(Shape selected_shape) {
		PnlDrawing.selected_shape = selected_shape;
	}
	public static void setWidthHeight(int widthh, int heightt)
	{
		width = widthh;
		height = heightt;
	}
	public static void setRadius(int radiuss)
	{
		radius = radiuss;
	}
	public static void setORadiusIRadius(int oradiuss, int iradiuss)
	{
		oradius = oradiuss;
		iradius = iradiuss;
	}
	public static ArrayList<Shape> getShape_list() {
		return shape_list;
	}
}
