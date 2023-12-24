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

public class DlgDrawingDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldOradius;
	private JTextField textFieldIradius;
	private int check_oradius, check_iradius;
	private int check_x, check_y;
	public static Color donut_color = null;
	public static Color donut_fill_color = null;
	public static Color donut_border_color_previous = null;
	public static Color donut_fill_color_previous = null;
	private boolean flag_ok;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawingDonut dialog = new DlgDrawingDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawingDonut() {
		setTitle("Donut");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{77, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{63, 0, 0, 0, 0, 0, 0};
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
			textFieldOradius = new JTextField();
			textFieldOradius.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
					{
						e.consume();
					}
				}
			});
			{
				JLabel lblOuter = new JLabel("Outer radius:");
				GridBagConstraints gbc_lblOuter = new GridBagConstraints();
				gbc_lblOuter.anchor = GridBagConstraints.EAST;
				gbc_lblOuter.insets = new Insets(0, 0, 5, 5);
				gbc_lblOuter.gridx = 6;
				gbc_lblOuter.gridy = 2;
				contentPanel.add(lblOuter, gbc_lblOuter);
			}
			GridBagConstraints gbc_textFieldOradius = new GridBagConstraints();
			gbc_textFieldOradius.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldOradius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldOradius.gridx = 7;
			gbc_textFieldOradius.gridy = 2;
			contentPanel.add(textFieldOradius, gbc_textFieldOradius);
			textFieldOradius.setColumns(10);
		}
		{
			{
				JLabel lblInner = new JLabel("Inner radius:");
				GridBagConstraints gbc_lblInner = new GridBagConstraints();
				gbc_lblInner.anchor = GridBagConstraints.EAST;
				gbc_lblInner.insets = new Insets(0, 0, 5, 5);
				gbc_lblInner.gridx = 6;
				gbc_lblInner.gridy = 3;
				contentPanel.add(lblInner, gbc_lblInner);
			}
		}
		textFieldIradius = new JTextField();
		textFieldIradius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
				{
					e.consume();
				}
			}
		});
		GridBagConstraints gbc_textFieldIradius = new GridBagConstraints();
		gbc_textFieldIradius.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIradius.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIradius.gridx = 7;
		gbc_textFieldIradius.gridy = 3;
		contentPanel.add(textFieldIradius, gbc_textFieldIradius);
		textFieldIradius.setColumns(10);
		{
			{
				JLabel lblDonutBorderColor = new JLabel("Donut Border color:");
				GridBagConstraints gbc_lblDonutBorderColor = new GridBagConstraints();
				gbc_lblDonutBorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblDonutBorderColor.gridx = 6;
				gbc_lblDonutBorderColor.gridy = 4;
				contentPanel.add(lblDonutBorderColor, gbc_lblDonutBorderColor);
			}
		}
		JButton btnDonutColor = new JButton("Color");
		btnDonutColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				donut_border_color_previous = donut_color;
				donut_color = JColorChooser.showDialog(null, "Choose donut border color", Color.WHITE); 
				if(donut_color == null)
				{
					if(donut_border_color_previous == null)
					{
						donut_border_color_previous = Color.BLACK;
					}
					donut_color = donut_border_color_previous;
				}
			}
		});
		GridBagConstraints gbc_btnDonutColor = new GridBagConstraints();
		gbc_btnDonutColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnDonutColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDonutColor.gridx = 7;
		gbc_btnDonutColor.gridy = 4;
		contentPanel.add(btnDonutColor, gbc_btnDonutColor);
		{
			JLabel lblNewLabel = new JLabel("Donut Fill Color:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 6;
			gbc_lblNewLabel.gridy = 5;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JButton btnDonutFillColor = new JButton("Color");
			btnDonutFillColor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					donut_fill_color_previous = donut_fill_color;
					donut_fill_color = JColorChooser.showDialog(null, "Choose donut fill color", Color.WHITE);
					if(donut_fill_color == null)
					{
						if(donut_fill_color_previous == null)
						{
							donut_fill_color_previous = Color.WHITE;
						}
						donut_fill_color = donut_fill_color_previous;
					}
				}
			});
			GridBagConstraints gbc_btnDonutFillColor = new GridBagConstraints();
			gbc_btnDonutFillColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnDonutFillColor.gridx = 7;
			gbc_btnDonutFillColor.gridy = 5;
			contentPanel.add(btnDonutFillColor, gbc_btnDonutFillColor);
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
							check_oradius = Integer.parseInt(getTextFieldOradius().getText());
							check_iradius = Integer.parseInt(getTextFieldIradius().getText());
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Wrong input try again!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							flag_message = true;
						}
						if(check_oradius > 100 || check_iradius > 100 || check_x > 342 || check_y > 196)
						{
							if(!flag_message)
							{
								JOptionPane.showMessageDialog(null, "Input can't be bigger than 100 and input can't be bigger for X(0 - 342) and for Y(0 - 196)!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							}
						}
						else if(check_iradius >= check_oradius)
						{
							if(!flag_message)
							{
								JOptionPane.showMessageDialog(null, "Inner radius can't be bigger or equal to outer radius!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							flag_ok = true;
							PnlDrawing.setORadiusIRadius(check_oradius, check_iradius);
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

	public JTextField getTextFieldOradius() {
		return textFieldOradius;
	}

	public JTextField getTextFieldIradius() {
		return textFieldIradius;
	}

	public int getCheck_oradius() {
		return check_oradius;
	}

	public int getCheck_iradius() {
		return check_iradius;
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
	public static Color getDonut_color() {
		return donut_color;
	}

	public static void setDonut_color(Color donut_colorr) {
		donut_color = donut_colorr;
	}
	public static Color getDonut_fill_color() {
		return donut_fill_color;
	}

	public static void setDonut_fill_color(Color donut_fill_colorr) {
		donut_fill_color = donut_fill_colorr;
	}

	public static Color getDonut_border_color_previous() {
		return donut_border_color_previous;
	}

	public static void setDonut_border_color_previous(Color donut_border_color_previous) {
		DlgDrawingDonut.donut_border_color_previous = donut_border_color_previous;
	}

	public static Color getDonut_fill_color_previous() {
		return donut_fill_color_previous;
	}

	public static void setDonut_fill_color_previous(Color donut_fill_color_previous) {
		DlgDrawingDonut.donut_fill_color_previous = donut_fill_color_previous;
	}
	
}
