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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgDrawingCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	public static Color circle_color = null;
	public static Color circle_fill_color = null;
	public static Color circle_border_color_previous = null;
	public static Color circle_fill_color_previous = null;
	private int check_radius;
	private boolean flag_ok;
	private int check_x, check_y;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawingCircle dialog = new DlgDrawingCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawingCircle() {
		setTitle("Circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{86, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{77, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("Center X coordinate:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.SOUTHEAST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 6;
			gbc_lblX.gridy = 0;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.anchor = GridBagConstraints.SOUTH;
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 7;
			gbc_textFieldX.gridy = 0;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 6;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 7;
			gbc_textFieldY.gridy = 1;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			{
				JLabel lblRadius = new JLabel("Radius:");
				GridBagConstraints gbc_lblRadius = new GridBagConstraints();
				gbc_lblRadius.anchor = GridBagConstraints.EAST;
				gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblRadius.gridx = 6;
				gbc_lblRadius.gridy = 2;
				contentPanel.add(lblRadius, gbc_lblRadius);
			}
		}
		textFieldRadius = new JTextField();
		textFieldRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
				{
					e.consume();
				}
			}
		});
		GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
		gbc_textFieldRadius.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRadius.gridx = 7;
		gbc_textFieldRadius.gridy = 2;
		contentPanel.add(textFieldRadius, gbc_textFieldRadius);
		textFieldRadius.setColumns(10);
		{
			{
				JLabel lblCircleBorderColor = new JLabel("Circle Border Color:");
				GridBagConstraints gbc_lblCircleBorderColor = new GridBagConstraints();
				gbc_lblCircleBorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblCircleBorderColor.gridx = 6;
				gbc_lblCircleBorderColor.gridy = 3;
				contentPanel.add(lblCircleBorderColor, gbc_lblCircleBorderColor);
			}
		}
		JButton btnCircleColor = new JButton("Color");
		btnCircleColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				circle_border_color_previous = circle_color;
				circle_color = JColorChooser.showDialog(null, "Choose circle boorder color", Color.WHITE); 
				if(circle_color == null)
				{
					if(circle_border_color_previous == null)
					{
						circle_border_color_previous = Color.BLACK;
					}
					circle_color = circle_border_color_previous;
				}
			}
		});
		GridBagConstraints gbc_btnCircleColor = new GridBagConstraints();
		gbc_btnCircleColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnCircleColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCircleColor.gridx = 7;
		gbc_btnCircleColor.gridy = 3;
		contentPanel.add(btnCircleColor, gbc_btnCircleColor);
		{
			JLabel lblNewLabel = new JLabel("Circle Fill Color:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 6;
			gbc_lblNewLabel.gridy = 4;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JButton btnCircleFillColor = new JButton("Color");
			btnCircleFillColor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					circle_fill_color_previous = circle_fill_color;
					circle_fill_color = JColorChooser.showDialog(null, "Choose circle fill color", Color.WHITE);
					if(circle_fill_color == null)
					{
						if(circle_fill_color_previous == null)
						{
							circle_fill_color_previous = Color.WHITE;
						}
						circle_fill_color = circle_fill_color_previous;
					}
				}
			});
			GridBagConstraints gbc_btnCircleFillColor = new GridBagConstraints();
			gbc_btnCircleFillColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnCircleFillColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnCircleFillColor.gridx = 7;
			gbc_btnCircleFillColor.gridy = 4;
			contentPanel.add(btnCircleFillColor, gbc_btnCircleFillColor);
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
							check_radius = Integer.parseInt(getTextFieldRadius().getText());
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Wrong input try again!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							flag_message = true;
						}
						if(check_radius > 100 || check_x > 342 || check_y > 196)
						{
							if(!flag_message)
							{
								JOptionPane.showMessageDialog(null, "Input can't be bigger than 100 and input can't be bigger for X(0 - 342) and for Y(0 - 196)!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							flag_ok = true;
							PnlDrawing.setRadius(check_radius);
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

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public int getCheck_radius() {
		return check_radius;
	}
	public boolean isFlag_ok() {
		return flag_ok;
	}

	public void setFlag_ok(boolean flag_ok) {
		this.flag_ok = flag_ok;
	}
	public int getCheck_x() {
		return check_x;
	}

	public int getCheck_y() {
		return check_y;
	}
	public static Color getCircle_color() {
		return circle_color;
	}

	public static void setCircle_color(Color circle_colorr) {
		circle_color = circle_colorr;
	}

	public static Color getCircle_fill_color() {
		return circle_fill_color;
	}

	public static void setCircle_fill_color(Color circle_fill_colorr) {
		circle_fill_color = circle_fill_colorr;
	}

	public static Color getCircle_border_color_previous() {
		return circle_border_color_previous;
	}

	public static void setCircle_border_color_previous(Color circle_border_color_previouss) {
		circle_border_color_previous = circle_border_color_previouss;
	}

	public static Color getCircle_fill_color_previous() {
		return circle_fill_color_previous;
	}

	public static void setCircle_fill_color_previous(Color circle_fill_color_previouss) {
		circle_fill_color_previous = circle_fill_color_previouss;
	}
	
}
