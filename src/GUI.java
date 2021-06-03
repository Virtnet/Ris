import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {
	public Menu menu;
	JFrame frmLaBellaVita;
	private JPanel mainMenuPanel;
	private JPanel chefPanel;
	private JPanel camerierePanel;
	private JPanel cuocoPanel;
	private JPanel responsabilePanel;
	private JTextField nomeField;
	private JTextField prezzoField;
	JTable table;
	DefaultTableModel model;
	ActionListener listnerEvent;
	// DefaultListModel is a implementation of the ListModel that extends from
	// AbstractListModel.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmLaBellaVita.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		InputFile file = new InputFile();
		menu = file.readFile();
		frmLaBellaVita = new JFrame();
		frmLaBellaVita.setResizable(false);
		frmLaBellaVita.setTitle("La Bella Vita");
		frmLaBellaVita.setBounds(100, 100, 790, 601);
		frmLaBellaVita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLaBellaVita.getContentPane().setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(15, 37, 761, 518);
		frmLaBellaVita.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		mainMenuPanel = new JPanel();
		layeredPane.add(mainMenuPanel, "name_920655863222900");
		mainMenuPanel.setLayout(null);

		JButton btnNewButton = new JButton("Chef");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(chefPanel);
				layeredPane.repaint();
				layeredPane.revalidate();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(102, 220, 85, 21);
		mainMenuPanel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("- BENVENUTO AL RISTORANTE LA BELLA VITA - ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(1, 118, 759, 13);
		mainMenuPanel.add(lblNewLabel);

		JButton btnCameriere = new JButton("Cameriere");
		btnCameriere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(camerierePanel);
				layeredPane.repaint();
				layeredPane.revalidate();

			}
		});
		btnCameriere.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCameriere.setBounds(225, 220, 116, 21);
		mainMenuPanel.add(btnCameriere);

		JButton btnNewButton_1_1 = new JButton("Cuoco");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(cuocoPanel);
				layeredPane.repaint();
				layeredPane.revalidate();

			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(371, 220, 85, 21);
		mainMenuPanel.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Responsabile di cassa");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(responsabilePanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(476, 220, 220, 21);
		mainMenuPanel.add(btnNewButton_1_2);

		JLabel lblNewLabel_1 = new JLabel("Scelga il suo ruolo al ristorante");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(1, 168, 759, 13);
		mainMenuPanel.add(lblNewLabel_1);

		chefPanel = new JPanel();
		layeredPane.add(chefPanel, "name_920655872620400");
		chefPanel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Ruolo:");
		lblNewLabel_2.setBounds(10, 10, 50, 19);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.BLACK);
		chefPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(" Chef");
		lblNewLabel_3.setBounds(60, 10, 39, 19);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.RED);
		chefPanel.add(lblNewLabel_3);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 761, 2);
		chefPanel.add(separator);

		JButton btnNewButton_1 = new JButton("Torna al Menu Principale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(mainMenuPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(512, 11, 239, 21);
		chefPanel.add(btnNewButton_1);

		JLabel lblNewLabel_4 = new JLabel("Menu");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setBounds(20, 63, 69, 13);
		chefPanel.add(lblNewLabel_4);
		

		nomeField = new JTextField();
		nomeField.setBounds(512, 128, 182, 19);
		chefPanel.add(nomeField);
		nomeField.setColumns(10);

		prezzoField = new JTextField();
		prezzoField.setBounds(512, 175, 109, 19);
		chefPanel.add(prezzoField);
		prezzoField.setColumns(10);
		
		
		JButton aggiungeButton = new JButton("Aggiunge un piatto");
		//ActionListener listen;
		aggiungeButton.addActionListener(new SomeActionListener(nomeField,prezzoField,1,this,menu));
		
		/*
		 * aggiungeButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { String name = nomeField.getText(); double
		 * prezzo = Double.parseDouble(prezzoField.getText()); Object[] row =
		 * {name,prezzo}; model.addRow(row); menu.addPiatto(new
		 * Menu.Piatto(name,prezzo)); nomeField.setText(""); prezzoField.setText("");
		 * System.out.println(menu.numeroDiPiatti); } });
		 */
		aggiungeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		aggiungeButton.setBounds(512, 255, 182, 49);
		chefPanel.add(aggiungeButton);




		
		Object[] col = {"Piatto","Prezzo"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(col);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 86, 461, 398);
		chefPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//aggiornaButton.setEnabled(true);
				//rimuoveButton.setEnabled(true);
				int i = table.getSelectedRow();
				nomeField.setText(model.getValueAt(i, 0).toString());
				prezzoField.setText(model.getValueAt(i, 1).toString());
			}
		});
		
		JButton rimuoveButton = new JButton("Rimuove un piatto");
		rimuoveButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rimuoveButton.setBounds(512, 329, 182, 49);
		chefPanel.add(rimuoveButton);
		rimuoveButton.addActionListener(new SomeActionListener(nomeField,prezzoField,3,this,menu));
		JButton aggiornaButton = new JButton("Aggiorna un piatto");
		aggiornaButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		aggiornaButton.setBounds(512, 405, 182, 49);
		//aggiornaButton.setEnabled(false);
		chefPanel.add(aggiornaButton);
		aggiornaButton.addActionListener(new SomeActionListener(nomeField,prezzoField,2,this,menu));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(model);
		table.setForeground(Color.BLACK);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		System.out.println(menu.numeroDiPiatti);
		
		for(int i =0;i<menu.numeroDiPiatti;i++) { 
			String name = menu.getPiatto(i).getPiattoNome(); 
			double prezzo = menu.getPiatto(i).getPrezzo(); 
			Object[] data = {name,prezzo};
			System.out.println(name + prezzo);
			model.addRow(new Object[] {name,prezzo});;
		}
		


		JLabel lblNewLabel_5 = new JLabel("Nome del piatto:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(512, 110, 155, 13);
		chefPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("Prezzo del piatto:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5_1.setBounds(512, 157, 155, 13);
		chefPanel.add(lblNewLabel_5_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(512, 226, 182, 2);
		chefPanel.add(separator_2);

		camerierePanel = new JPanel();
		camerierePanel.setLayout(null);
		layeredPane.add(camerierePanel, "name_921335801766300");

		JLabel lblNewLabel_2_1 = new JLabel("Ruolo:");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 10, 50, 19);
		camerierePanel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("Cameriere");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(60, 10, 89, 19);
		camerierePanel.add(lblNewLabel_3_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 39, 761, 2);
		camerierePanel.add(separator_1);

		JButton btnNewButton_1_4 = new JButton("Torna al Menu Principale");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(mainMenuPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_4.setBounds(512, 11, 239, 21);
		camerierePanel.add(btnNewButton_1_4);

		cuocoPanel = new JPanel();
		cuocoPanel.setLayout(null);
		layeredPane.add(cuocoPanel, "name_921348150507400");

		JLabel lblNewLabel_2_1_1 = new JLabel("Ruolo:");
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(10, 10, 50, 19);
		cuocoPanel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Cuoco");
		lblNewLabel_3_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(60, 10, 78, 19);
		cuocoPanel.add(lblNewLabel_3_1_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 39, 761, 2);
		cuocoPanel.add(separator_1_1);

		JButton btnNewButton_1_3 = new JButton("Torna al Menu Principale");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(mainMenuPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_3.setBounds(512, 11, 239, 21);
		cuocoPanel.add(btnNewButton_1_3);

		responsabilePanel = new JPanel();
		responsabilePanel.setLayout(null);
		layeredPane.add(responsabilePanel, "name_921362284259100");

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Ruolo:");
		lblNewLabel_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(10, 10, 50, 19);
		responsabilePanel.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Responsabile di cassa");
		lblNewLabel_3_1_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(60, 10, 175, 19);
		responsabilePanel.add(lblNewLabel_3_1_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(0, 39, 761, 2);
		responsabilePanel.add(separator_1_1_1);

		JButton btnNewButton_1_3_1 = new JButton("Torna al Menu Principale");
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(mainMenuPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_3_1.setBounds(512, 11, 239, 21);
		responsabilePanel.add(btnNewButton_1_3_1);
		
	}
}
