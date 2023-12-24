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
import java.awt.TextField;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgDrawingRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
	private int check_width, check_height;
	private int check_x, check_y;
	public static Color rectangle_color = null;
	public static Color rectangle_fill_color = null;
	public static Color rectangle_border_color_previous = null;
	public static Color rectangle_fill_color_previous = null;
	private boolean flag_ok;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawingRectangle dialog = new DlgDrawingRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawingRectangle() {
		setTitle("Rectangle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 72, 0, 49, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{48, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUpperX = new JLabel("Upper left point X coordinate:");
			GridBagConstraints gbc_lblUpperX = new GridBagConstraints();
			gbc_lblUpperX.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblUpperX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperX.gridx = 4;
			gbc_lblUpperX.gridy = 0;
			contentPanel.add(lblUpperX, gbc_lblUpperX);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.anchor = GridBagConstraints.SOUTH;
			gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 5;
			gbc_textFieldX.gridy = 0;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblUpperY = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblUpperY = new GridBagConstraints();
			gbc_lblUpperY.anchor = GridBagConstraints.EAST;
			gbc_lblUpperY.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperY.gridx = 4;
			gbc_lblUpperY.gridy = 1;
			contentPanel.add(lblUpperY, gbc_lblUpperY);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 5;
			gbc_textFieldY.gridy = 1;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			{
				JLabel lblWidth = new JLabel("Width:");
				GridBagConstraints gbc_lblWidth = new GridBagConstraints();
				gbc_lblWidth.anchor = GridBagConstraints.EAST;
				gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
				gbc_lblWidth.gridx = 4;
				gbc_lblWidth.gridy = 2;
				contentPanel.add(lblWidth, gbc_lblWidth);
			}
		}
		textFieldWidth = new JTextField();
		textFieldWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {			
				char c = e.getKeyChar();
				if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
				{
					e.consume();
				}				
			}
		});
		GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
		gbc_textFieldWidth.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldWidth.gridx = 5;
		gbc_textFieldWidth.gridy = 2;
		contentPanel.add(textFieldWidth, gbc_textFieldWidth);
		textFieldWidth.setColumns(10);
		{
			{
				JLabel lblHeight = new JLabel("Height");
				GridBagConstraints gbc_lblHeight = new GridBagConstraints();
				gbc_lblHeight.anchor = GridBagConstraints.EAST;
				gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
				gbc_lblHeight.gridx = 4;
				gbc_lblHeight.gridy = 3;
				contentPanel.add(lblHeight, gbc_lblHeight);
			}
		}
		textFieldHeight = new JTextField();
		textFieldHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
				{
					e.consume();
				}	
			}
		});
		GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
		gbc_textFieldHeight.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHeight.gridx = 5;
		gbc_textFieldHeight.gridy = 3;
		contentPanel.add(textFieldHeight, gbc_textFieldHeight);
		textFieldHeight.setColumns(10);
		{
			{
				JLabel lblRectangleBorderColor = new JLabel("Rectangle Border Color:");
				GridBagConstraints gbc_lblRectangleBorderColor = new GridBagConstraints();
				gbc_lblRectangleBorderColor.anchor = GridBagConstraints.EAST;
				gbc_lblRectangleBorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblRectangleBorderColor.gridx = 4;
				gbc_lblRectangleBorderColor.gridy = 4;
				contentPanel.add(lblRectangleBorderColor, gbc_lblRectangleBorderColor);
			}
		}
		JButton btnRectColor = new JButton("Color");
		btnRectColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rectangle_border_color_previous = rectangle_color;
				rectangle_color = JColorChooser.showDialog(null, "Choose rectangle border color", Color.WHITE); 
				if(rectangle_color == null)
				{
					if(rectangle_border_color_previous == null)
					{
						rectangle_border_color_previous = Color.BLACK;
					}
					rectangle_color = rectangle_border_color_previous;
				}	
			}
		});
		GridBagConstraints gbc_btnRectColor = new GridBagConstraints();
		gbc_btnRectColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRectColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnRectColor.gridx = 5;
		gbc_btnRectColor.gridy = 4;
		contentPanel.add(btnRectColor, gbc_btnRectColor);
		{
			JLabel lblRectangleFillColor = new JLabel("Rectangle Fill Color:");
			GridBagConstraints gbc_lblRectangleFillColor = new GridBagConstraints();
			gbc_lblRectangleFillColor.anchor = GridBagConstraints.EAST;
			gbc_lblRectangleFillColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblRectangleFillColor.gridx = 4;
			gbc_lblRectangleFillColor.gridy = 5;
			contentPanel.add(lblRectangleFillColor, gbc_lblRectangleFillColor);
		}
		{
			JButton btnRectFillColor = new JButton("Color");
			btnRectFillColor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					rectangle_fill_color_previous = rectangle_fill_color;
					rectangle_fill_color = JColorChooser.showDialog(null, "Choose rectangle fill color", Color.WHITE);
					if(rectangle_fill_color == null)
					{
						if(rectangle_fill_color_previous == null)
						{
							rectangle_fill_color_previous = Color.WHITE;
						}
						rectangle_fill_color = rectangle_fill_color_previous;
					}
				}
			});
			GridBagConstraints gbc_btnRectFillColor = new GridBagConstraints();
			gbc_btnRectFillColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnRectFillColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnRectFillColor.gridx = 5;
			gbc_btnRectFillColor.gridy = 5;
			contentPanel.add(btnRectFillColor, gbc_btnRectFillColor);
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
							check_x = Integer.parseInt(getTextFieldX().getText());
							check_y = Integer.parseInt(getTextFieldY().getText());
							check_width = Integer.parseInt(getTextFieldWidth().getText());
							check_height = Integer.parseInt(getTextFieldHeight().getText());
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Wrong input try again!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							flag_message = true;
						}
						if(check_width > 100 || check_height > 100 || check_x > 342 || check_y > 196)
						{
							if(!flag_message)
							{
								JOptionPane.showMessageDialog(null, "Input can't be bigger than 100 and input can't be bigger for X(0 - 342) and for Y(0 - 196)!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							flag_ok = true;
							PnlDrawing.setWidthHeight(check_width, check_height);
							if(!flag_message)
							{
								dispose();
							}
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
	
	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public int getCheck_x() {
		return check_x;
	}

	public int getCheck_y() {
		return check_y;
	}

	public int getCheck_width() {
		return check_width;
	}

	public int getCheck_height() {
		return check_height;
	}
	
	public boolean isFlag_ok() {
		return flag_ok;
	}

	public void setFlag_ok(boolean flag_ok) {
		this.flag_ok = flag_ok;
	}
	public static Color getRectangle_color() {
		return rectangle_color;
	}

	public static void setRectangle_color(Color rectangle_colorr) {
		rectangle_color = rectangle_colorr;
	}
	public  static Color getRectangle_fill_color() {
		return rectangle_fill_color;
	}

	public static void setRectangle_fill_color(Color rectangle_fill_colorr) {
		rectangle_fill_color = rectangle_fill_colorr;
	}

	public static Color getRectangle_border_color_previous() {
		return rectangle_border_color_previous;
	}

	public static void setRectangle_border_color_previous(Color rectangle_border_color_previous) {
		DlgDrawingRectangle.rectangle_border_color_previous = rectangle_border_color_previous;
	}

	public static Color getRectangle_fill_color_previous() {
		return rectangle_fill_color_previous;
	}

	public static void setRectangle_fill_color_previous(Color rectangle_fill_color_previous) {
		DlgDrawingRectangle.rectangle_fill_color_previous = rectangle_fill_color_previous;
	}
	

}
