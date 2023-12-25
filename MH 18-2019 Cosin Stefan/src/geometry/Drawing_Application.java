package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;

public class Drawing_Application extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group = new ButtonGroup();
	public static String Draw_shape;
	public static String Operation;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing_Application frame = new Drawing_Application();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Drawing_Application() {
		setTitle("Drawing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		PnlDrawing panelCenter = new PnlDrawing();
		panelCenter.setBackground(Color.WHITE);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Cosin Stefan MH18-2019");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelNorth.add(lblTitle);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.BLUE);
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_panelSouth = new GridBagLayout();
		gbl_panelSouth.columnWidths = new int[]{22, 87, 71, 0, 0, 0, 0};
		gbl_panelSouth.rowHeights = new int[]{0, 0};
		gbl_panelSouth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelSouth.setLayout(gbl_panelSouth);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Drawing_Application.setDraw_shape("Point");
			}
		});
		group.add(tglbtnPoint);
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPoint.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnPoint.gridx = 1;
		gbc_tglbtnPoint.gridy = 0;
		panelSouth.add(tglbtnPoint, gbc_tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Drawing_Application.setDraw_shape("Line");
			}
		});
		group.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnLine.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnLine.gridx = 2;
		gbc_tglbtnLine.gridy = 0;
		panelSouth.add(tglbtnLine, gbc_tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Drawing_Application.setDraw_shape("Rectangle");
			}
		});
		group.add(tglbtnRectangle);
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnRectangle.gridx = 3;
		gbc_tglbtnRectangle.gridy = 0;
		panelSouth.add(tglbtnRectangle, gbc_tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Drawing_Application.setDraw_shape("Circle");
			}
		});
		group.add(tglbtnCircle);
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnCircle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnCircle.gridx = 4;
		gbc_tglbtnCircle.gridy = 0;
		panelSouth.add(tglbtnCircle, gbc_tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Drawing_Application.setDraw_shape("Donut");
			}
		});
		group.add(tglbtnDonut);
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnDonut.gridx = 5;
		gbc_tglbtnDonut.gridy = 0;
		panelSouth.add(tglbtnDonut, gbc_tglbtnDonut);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.BLUE);
		contentPane.add(panelWest, BorderLayout.WEST);
		GridBagLayout gbl_panelWest = new GridBagLayout();
		gbl_panelWest.columnWidths = new int[]{0, 0};
		gbl_panelWest.rowHeights = new int[]{48, 0, 0, 0, 0, 0};
		gbl_panelWest.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelWest.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelWest.setLayout(gbl_panelWest);
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Operation = "Draw";
			}
		});
		btnDraw.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnDraw = new GridBagConstraints();
		gbc_btnDraw.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDraw.insets = new Insets(0, 0, 5, 0);
		gbc_btnDraw.gridx = 0;
		gbc_btnDraw.gridy = 1;
		panelWest.add(btnDraw, gbc_btnDraw);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Operation = "Selection";
			}
		});
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelect.gridx = 0;
		gbc_btnSelect.gridy = 2;
		panelWest.add(btnSelect, gbc_btnSelect);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Shape selected_shape = PnlDrawing.getSelected_shape();
				if(selected_shape != null)
				{
					boolean flag_instance_donut = false;
					if(selected_shape instanceof Point)
					{
						Point temp = (Point) selected_shape;
						DlgDrawingPoint drwp = new DlgDrawingPoint();
						drwp.getTextFieldX().setText(Integer.toString(temp.getX()));
						drwp.getTextFieldY().setText(Integer.toString(temp.getY()));
						drwp.setVisible(true);
						if(drwp.isFlag_ok())
						{
							temp.setX(Integer.parseInt(drwp.getTextFieldX().getText()));
							temp.setY(Integer.parseInt(drwp.getTextFieldY().getText()));
							temp.setPointColor(DlgDrawingPoint.getPoint_color());
							((Point) selected_shape).moveTo(temp.getX(), temp.getY());
							((Point) selected_shape).setPointColor(temp.getPointColor());
							drwp.setFlag_ok(false);
							panelCenter.repaint();
						}
						
					}
					if(selected_shape instanceof Line)
					{
						Line temp = (Line) selected_shape;
						DlgDrawingLine drwl = new DlgDrawingLine();
						drwl.getTextFieldXstart().setText(Integer.toString(temp.getStartPoint().getX()));
						drwl.getTextFieldYstart().setText(Integer.toString(temp.getStartPoint().getY()));
						drwl.getTextFieldXend().setText(Integer.toString(temp.getEndPoint().getX()));
						drwl.getTextFieldYend().setText(Integer.toString(temp.getEndPoint().getY()));
						drwl.setVisible(true);
						if(drwl.isFlag_ok())
						{
							temp.setStartPoint(new Point(drwl.getCheckSX(), drwl.getCheckSY()));
							temp.setEndPoint(new Point(drwl.getCheckEX(), drwl.getCheckEY()));
							temp.setLineColor(DlgDrawingLine.getLine_color());
							((Line) selected_shape).setStartPoint(temp.getStartPoint());
							((Line) selected_shape).setEndPoint(temp.getEndPoint());
							((Line) selected_shape).setLineColor(temp.getLineColor());
							drwl.setFlag_ok(false);
							panelCenter.repaint();
						}
						
					}
					if(selected_shape instanceof Rectangle)
					{
						Rectangle temp = (Rectangle) selected_shape;
						DlgDrawingRectangle drwr = new DlgDrawingRectangle();
						drwr.getTextFieldX().setText(Integer.toString(temp.getUpperLeft().getX()));
						drwr.getTextFieldY().setText(Integer.toString(temp.getUpperLeft().getY()));
						drwr.getTextFieldWidth().setText(Integer.toString(temp.getWidth()));
						drwr.getTextFieldHeight().setText(Integer.toString(temp.getHeight()));
						drwr.setVisible(true);
						if(drwr.isFlag_ok())
						{
							temp.getUpperLeft().setX(drwr.getCheck_x());
							temp.getUpperLeft().setY(drwr.getCheck_y());
							temp.setWidth(drwr.getCheck_width());
							temp.setHeight(drwr.getCheck_height());
							temp.setRectangle_color(DlgDrawingRectangle.getRectangle_color());
							temp.setFill_color(DlgDrawingRectangle.getRectangle_fill_color());
							((Rectangle) selected_shape).getUpperLeft().moveTo(temp.getUpperLeft().getX(), temp.getUpperLeft().getY());
							((Rectangle) selected_shape).setWidth(temp.getWidth());
							((Rectangle) selected_shape).setHeight(temp.getHeight());
							((Rectangle) selected_shape).setRectangle_color(temp.getRectangle_color());
							((Rectangle) selected_shape).setFill_color(temp.getFill_color());
							drwr.setFlag_ok(false);
							repaint();
						}
					}
					if(selected_shape instanceof Donut)
					{
						Donut temp = (Donut) selected_shape;
						DlgDrawingDonut drdr = new DlgDrawingDonut();
						drdr.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
						drdr.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
						drdr.getTextFieldOradius().setText(Integer.toString(temp.getRadius()));
						drdr.getTextFieldIradius().setText(Integer.toString(temp.getInnerRadius()));
						drdr.setVisible(true);
						if(drdr.isFlag_ok())
						{
							temp.getCenter().moveTo(drdr.getCheck_x(), drdr.getCheck_y());
							try
							{
								temp.setRadius(drdr.getCheck_oradius());
							}
							catch(Exception ex)
							{
								System.out.println(ex.getMessage());
							}
							temp.setInnerRadius(drdr.getCheck_iradius());
							temp.setDonut_color(DlgDrawingDonut.getDonut_color());
							temp.setDonut_fill_color(DlgDrawingDonut.getDonut_fill_color());
							((Donut) selected_shape).setCenter(temp.getCenter());
							try
							{
								((Donut) selected_shape).setRadius(temp.getRadius());
							}
							catch(Exception ex)
							{
								System.out.println(ex.getMessage());
							}
							((Donut) selected_shape).setInnerRadius(temp.getInnerRadius());
							((Donut) selected_shape).setDonut_color(temp.getDonut_color());
							((Donut) selected_shape).setDonut_fill_color(temp.getDonut_fill_color());
							drdr.setFlag_ok(false);
							repaint();
						}
						flag_instance_donut = true;
					}
					if(selected_shape instanceof Circle && flag_instance_donut == false)
					{
						Circle temp = (Circle) selected_shape;
						DlgDrawingCircle drcr = new DlgDrawingCircle();
						drcr.getTextFieldX().setText(Integer.toString(temp.getCenter().getX()));
						drcr.getTextFieldY().setText(Integer.toString(temp.getCenter().getY()));
						drcr.getTextFieldRadius().setText(Integer.toString(temp.getRadius()));
						drcr.setVisible(true);
						if(drcr.isFlag_ok())
						{
							temp.getCenter().moveTo(drcr.getCheck_x(), drcr.getCheck_y());
							try
							{
								temp.setRadius(drcr.getCheck_radius());
							}
							catch(Exception ex)
							{
								System.out.println(ex.getMessage());
							}
							temp.setCircle_color(DlgDrawingCircle.getCircle_color());
							temp.setCircle_fill_color(DlgDrawingCircle.getCircle_fill_color());
							((Circle) selected_shape).setCenter(temp.getCenter());
							try
							{
								((Circle) selected_shape).setRadius(temp.getRadius());
							}
							catch(Exception ex)
							{
								System.out.println(ex.getMessage());
							}
							((Circle) selected_shape).setCircle_color(temp.getCircle_color());
							((Circle) selected_shape).setCircle_fill_color(temp.getCircle_fill_color());
							drcr.setFlag_ok(false);
							repaint();
						}
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You must select shape!", "WARNING!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModify.insets = new Insets(0, 0, 5, 0);
		gbc_btnModify.gridx = 0;
		gbc_btnModify.gridy = 3;
		panelWest.add(btnModify, gbc_btnModify);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(PnlDrawing.getSelected_shape() != null)
				{
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove selected shape?", "Remove", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION)
					{
						PnlDrawing.getShape_list().remove(PnlDrawing.getSelected_shape());
						PnlDrawing.setSelected_shape(null);
						panelCenter.repaint();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You must select shape!", "WARNING!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 4;
		panelWest.add(btnRemove, gbc_btnRemove);
		
	}

	public static String getOperation() {
		return Operation;
	}

	public static void setOperation(String operation) {
		Operation = operation;
	}

	public static String getDraw_shape() {
		return Draw_shape;
	}
	public static void setDraw_shape(String draw_shape) {
		Draw_shape = draw_shape;
	}
}
