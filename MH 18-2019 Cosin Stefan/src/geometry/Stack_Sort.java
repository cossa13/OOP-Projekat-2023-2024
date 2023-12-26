package geometry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;

public class Stack_Sort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack_Sort frame = new Stack_Sort();
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
	public Stack_Sort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorth = new GridBagLayout();
		gbl_panelNorth.columnWidths = new int[]{101, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelNorth.rowHeights = new int[]{0, 0};
		gbl_panelNorth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNorth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelNorth.setLayout(gbl_panelNorth);
		
		JLabel lblTitle = new JLabel("Cosin Stefan MH18-2019");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridx = 6;
		gbc_lblTitle.gridy = 0;
		panelNorth.add(lblTitle, gbc_lblTitle);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_panelSouth = new GridBagLayout();
		gbl_panelSouth.columnWidths = new int[]{168, 51, 0};
		gbl_panelSouth.rowHeights = new int[]{21, 0};
		gbl_panelSouth.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSouth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelSouth.setLayout(gbl_panelSouth);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(dlm.size() > 1)
				{
					//bubble sort
					for(int i = 0;i < dlm.size()-1;i++)
					{
						for(int j = i + 1;j < dlm.size();j++)
						{
							if(dlm.get(i).area() < dlm.get(j).area())
							{
								Circle temp = dlm.get(i);
								dlm.set(i, dlm.get(j));
								dlm.set(j, temp);
							}
						}
					}
				}
				
			}
		});
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.anchor = GridBagConstraints.WEST;
		gbc_btnSort.gridx = 1;
		gbc_btnSort.gridy = 0;
		panelSouth.add(btnSort, gbc_btnSort);
		
		JPanel panelWest = new JPanel();
		contentPane.add(panelWest, BorderLayout.WEST);
		GridBagLayout gbl_panelWest = new GridBagLayout();
		gbl_panelWest.columnWidths = new int[]{0, 0};
		gbl_panelWest.rowHeights = new int[]{97, 0, 0, 0, 0};
		gbl_panelWest.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelWest.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelWest.setLayout(gbl_panelWest);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgStack_Sort dlgss = new DlgStack_Sort();
				dlgss.setVisible(true);
				if(dlgss.isFlag_ok())
				{
					Circle c = new Circle(new Point(dlgss.getCheck_one(), dlgss.getCheck_two()), dlgss.getCheck_three());
					dlm.add(0, c);
					dlgss.setFlag_ok(false);
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 3;
		panelWest.add(btnAdd, gbc_btnAdd);
		
		JPanel panelEast = new JPanel();
		contentPane.add(panelEast, BorderLayout.EAST);
		GridBagLayout gbl_panelEast = new GridBagLayout();
		gbl_panelEast.columnWidths = new int[]{0, 0};
		gbl_panelEast.rowHeights = new int[]{94, 0, 0, 0, 0};
		gbl_panelEast.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelEast.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEast.setLayout(gbl_panelEast);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(dlm.size() != 0)
				{
					DlgStack_Sort dlgss = new DlgStack_Sort();
					dlgss.getTextFieldX().setEditable(false);
					dlgss.getTextFieldY().setEditable(false);
					dlgss.getTextFieldRadius().setEditable(false);
					dlgss.getTextFieldX().setText(Integer.toString(dlm.get(0).getCenter().getX()));
					dlgss.getTextFieldY().setText(Integer.toString(dlm.get(0).getCenter().getY()));
					dlgss.getTextFieldRadius().setText(Integer.toString(dlm.get(0).getRadius()));
					dlgss.setVisible(true);
					if(dlgss.isFlag_ok())
					{
						dlm.remove(0);
						dlgss.setFlag_ok(false);
					}
				}
			}
		});
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 3;
		panelEast.add(btnRemove, gbc_btnRemove);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCenter.add(scrollPane, BorderLayout.CENTER);
		
		JList<Circle> list = new JList<Circle>();
		list.setModel(dlm);
		scrollPane.setViewportView(list);
	}

}
