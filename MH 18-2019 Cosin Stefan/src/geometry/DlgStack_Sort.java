package geometry;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgStack_Sort extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldRadius;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private int check_one, check_two, check_three;
	private boolean flag_ok = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStack_Sort dialog = new DlgStack_Sort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack_Sort() {
		setTitle("Circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{120, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{63, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXcoordinate = new JLabel("X coordinate:");
			lblXcoordinate.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblXcoordinate = new GridBagConstraints();
			gbc_lblXcoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblXcoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcoordinate.gridx = 1;
			gbc_lblXcoordinate.gridy = 1;
			contentPanel.add(lblXcoordinate, gbc_lblXcoordinate);
		}
		{
			textFieldX = new JTextField();
			textFieldX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
					{
						if(c != KeyEvent.VK_MINUS)
						{
							e.consume();
						}
					}
				}
			});
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 2;
			gbc_textFieldX.gridy = 1;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblYcoordinate = new JLabel("Y coordinate:");
			lblYcoordinate.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblYcoordinate = new GridBagConstraints();
			gbc_lblYcoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblYcoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcoordinate.gridx = 1;
			gbc_lblYcoordinate.gridy = 2;
			contentPanel.add(lblYcoordinate, gbc_lblYcoordinate);
		}
		{
			textFieldY = new JTextField();
			textFieldY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
					{
						if(c != KeyEvent.VK_MINUS)
						{
							e.consume();
						}
					}
				}
			});
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 2;
			gbc_textFieldY.gridy = 2;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			lblRadius.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			textFieldRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE)
					{
						if(c != KeyEvent.VK_MINUS)
						{
							e.consume();
						}
					}
				}
			});
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 2;
			gbc_textFieldRadius.gridy = 3;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
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
							check_one = Integer.parseInt(textFieldX.getText());
							check_two = Integer.parseInt(textFieldY.getText());
							check_three = Integer.parseInt(textFieldRadius.getText());
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, "Wrong input try again!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
							flag_message = true;
						}
						if(check_one <= 0 || check_two <= 0 || check_three <= 0)
						{
							if(!flag_message)
							{
							JOptionPane.showMessageDialog(null, "Input can't be equal or lower than 0!", "Incorrect input", JOptionPane.ERROR_MESSAGE);
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
	
	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public boolean isFlag_ok() {
		return flag_ok;
	}

	public void setFlag_ok(boolean flag_ok) {
		this.flag_ok = flag_ok;
	}
	public int getCheck_one() {
		return check_one;
	}

	public int getCheck_two() {
		return check_two;
	}

	public int getCheck_three() {
		return check_three;
	}


}
