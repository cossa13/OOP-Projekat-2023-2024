package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgDrawingLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldXstart;
	private JTextField textFieldYstart;
	private JTextField textFieldXend;
	private JTextField textFieldYend;
	private int checkSX, checkSY, checkEX, checkEY;
	public static Color line_color = null;
	public static Color line_color_previous = null;
	private boolean flag_ok;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawingLine dialog = new DlgDrawingLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setResizable(false);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawingLine() {
		setTitle("Line");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{61, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{55, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPoint = new JLabel("StartingPoint");
			GridBagConstraints gbc_lblStartPoint = new GridBagConstraints();
			gbc_lblStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPoint.gridx = 5;
			gbc_lblStartPoint.gridy = 1;
			contentPanel.add(lblStartPoint, gbc_lblStartPoint);
		}
		{
			JLabel lblXcoordinate = new JLabel("X coordinate:");
			GridBagConstraints gbc_lblXcoordinate = new GridBagConstraints();
			gbc_lblXcoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblXcoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcoordinate.gridx = 6;
			gbc_lblXcoordinate.gridy = 1;
			contentPanel.add(lblXcoordinate, gbc_lblXcoordinate);
		}
		{
			textFieldXstart = new JTextField();
			textFieldXstart.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldXstart = new GridBagConstraints();
			gbc_textFieldXstart.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldXstart.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldXstart.gridx = 7;
			gbc_textFieldXstart.gridy = 1;
			contentPanel.add(textFieldXstart, gbc_textFieldXstart);
			textFieldXstart.setColumns(10);
		}
		{
			JLabel lblYcoordinate = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblYcoordinate = new GridBagConstraints();
			gbc_lblYcoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblYcoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcoordinate.gridx = 6;
			gbc_lblYcoordinate.gridy = 2;
			contentPanel.add(lblYcoordinate, gbc_lblYcoordinate);
		}
		{
			textFieldYstart = new JTextField();
			textFieldYstart.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldYstart = new GridBagConstraints();
			gbc_textFieldYstart.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldYstart.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldYstart.gridx = 7;
			gbc_textFieldYstart.gridy = 2;
			contentPanel.add(textFieldYstart, gbc_textFieldYstart);
			textFieldYstart.setColumns(10);
		}
		{
			JLabel lblEndPoint = new JLabel("End Point:");
			GridBagConstraints gbc_lblEndPoint = new GridBagConstraints();
			gbc_lblEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPoint.gridx = 5;
			gbc_lblEndPoint.gridy = 3;
			contentPanel.add(lblEndPoint, gbc_lblEndPoint);
		}
		{
			JLabel lblXcoodinate_end = new JLabel("X coordinate:");
			GridBagConstraints gbc_lblXcoodinate_end = new GridBagConstraints();
			gbc_lblXcoodinate_end.anchor = GridBagConstraints.EAST;
			gbc_lblXcoodinate_end.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcoodinate_end.gridx = 6;
			gbc_lblXcoodinate_end.gridy = 3;
			contentPanel.add(lblXcoodinate_end, gbc_lblXcoodinate_end);
		}
		{
			textFieldXend = new JTextField();
			textFieldXend.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldXend = new GridBagConstraints();
			gbc_textFieldXend.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldXend.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldXend.gridx = 7;
			gbc_textFieldXend.gridy = 3;
			contentPanel.add(textFieldXend, gbc_textFieldXend);
			textFieldXend.setColumns(10);
		}
		{
			JLabel lblYcoordinate_end = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblYcoordinate_end = new GridBagConstraints();
			gbc_lblYcoordinate_end.anchor = GridBagConstraints.EAST;
			gbc_lblYcoordinate_end.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcoordinate_end.gridx = 6;
			gbc_lblYcoordinate_end.gridy = 4;
			contentPanel.add(lblYcoordinate_end, gbc_lblYcoordinate_end);
		}
		{
			textFieldYend = new JTextField();
			textFieldYend.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldYend = new GridBagConstraints();
			gbc_textFieldYend.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldYend.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldYend.gridx = 7;
			gbc_textFieldYend.gridy = 4;
			contentPanel.add(textFieldYend, gbc_textFieldYend);
			textFieldYend.setColumns(10);
		}
		{
			JLabel lblLineColor = new JLabel("Line Color:");
			GridBagConstraints gbc_lblLineColor = new GridBagConstraints();
			gbc_lblLineColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblLineColor.gridx = 6;
			gbc_lblLineColor.gridy = 5;
			contentPanel.add(lblLineColor, gbc_lblLineColor);
		}
		{
			JButton btnLineColor = new JButton("Color");
			btnLineColor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					line_color_previous = line_color;
					line_color = JColorChooser.showDialog(null, "Choose point color", Color.WHITE);
					if(line_color == null)
					{
						if(line_color_previous == null)
						{
							line_color_previous = line_color;
						}
						line_color = line_color_previous;
					}
				}
			});
			GridBagConstraints gbc_btnLineColor = new GridBagConstraints();
			gbc_btnLineColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnLineColor.gridx = 7;
			gbc_btnLineColor.gridy = 5;
			contentPanel.add(btnLineColor, gbc_btnLineColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						boolean flag_message = false;
						try
						{
							checkSX = Integer.parseInt(getTextFieldXstart().getText());
							checkSY = Integer.parseInt(getTextFieldYstart().getText());
							checkEX = Integer.parseInt(getTextFieldXend().getText());
							checkEY = Integer.parseInt(getTextFieldYend().getText());
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Wrong input try again!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							flag_message = true;
						}
						if(checkSX > 342 || checkSY > 196 || checkEX > 342 || checkEY > 196)
						{
							if(!flag_message)
							{
								JOptionPane.showMessageDialog(null, "Input can't be bigger for X(0 - 342) and for Y(0 - 196)!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							flag_ok = true;
							dispose();					
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public JTextField getTextFieldXstart() {
		return textFieldXstart;
	}

	public JTextField getTextFieldYstart() {
		return textFieldYstart;
	}

	public JTextField getTextFieldXend() {
		return textFieldXend;
	}

	public JTextField getTextFieldYend() {
		return textFieldYend;
	}

	public int getCheckSX() {
		return checkSX;
	}

	public int getCheckSY() {
		return checkSY;
	}

	public int getCheckEX() {
		return checkEX;
	}

	public int getCheckEY() {
		return checkEY;
	}
	public boolean isFlag_ok() {
		return flag_ok;
	}

	public void setFlag_ok(boolean flag_ok) {
		this.flag_ok = flag_ok;
	}
	public static Color getLine_color() {
		return line_color;
	}

	public static void setLine_color(Color line_colorr) {
		line_color = line_colorr;
	}

	public static Color getLine_color_previous() {
		return line_color_previous;
	}

	public static void setLine_color_previous(Color line_color_previous) {
		DlgDrawingLine.line_color_previous = line_color_previous;
	}
	


}
