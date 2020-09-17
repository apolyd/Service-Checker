package serviceChecker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class GUIchecker {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblStatus;
	private JButton btnExit;
	private JLabel label;
	private JTextField textField_1;
	private JLabel label_1;
	private JTextField textField_2;
	private JLabel label_2;
	private JTextField textField_3;
	private JLabel label_3;
	private JTextPane textPane_1;
	private JLabel label_4;
	private JTextPane textPane_2;
	private JLabel label_5;
	private JTextPane textPane_3;
	private JLabel lblGal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIchecker window = new GUIchecker();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIchecker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 52, 157, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblServiceName = new JLabel("Service name");
		lblServiceName.setForeground(Color.BLACK);
		lblServiceName.setBounds(10, 27, 100, 14);
		frame.getContentPane().add(lblServiceName);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(177, 52, 100, 20);
		frame.getContentPane().add(textPane);
		textPane.setText("Ready!");
		
		JButton btnSearch = new JButton("Monitor");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkerThread T1 = new checkerThread( "Thread-1",textField.getText(),textPane);
			    T1.start();
			    checkerThread T2 = new checkerThread( "Thread-2",textField_1.getText(),textPane_1);
			    T2.start();
			    checkerThread T3 = new checkerThread( "Thread-3",textField_2.getText(),textPane_2);
			    T3.start();
			    checkerThread T4 = new checkerThread( "Thread-4",textField_3.getText(),textPane_3);
			    T4.start();
				
				}
			
			}
			
		
		);
		btnSearch.setBounds(335, 191, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setBounds(177, 27, 46, 14);
		frame.getContentPane().add(lblStatus);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 219, 89, 23);
		frame.getContentPane().add(btnExit);
		
		label = new JLabel("Service name");
		label.setForeground(Color.BLACK);
		label.setBounds(10, 83, 100, 14);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 108, 157, 20);
		frame.getContentPane().add(textField_1);
		
		label_1 = new JLabel("Service name");
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(10, 139, 100, 14);
		frame.getContentPane().add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 164, 157, 20);
		frame.getContentPane().add(textField_2);
		
		label_2 = new JLabel("Service name");
		label_2.setForeground(Color.BLACK);
		label_2.setBounds(10, 195, 100, 14);
		frame.getContentPane().add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 220, 157, 20);
		frame.getContentPane().add(textField_3);
		
		label_3 = new JLabel("Status");
		label_3.setForeground(Color.BLACK);
		label_3.setBounds(177, 83, 46, 14);
		frame.getContentPane().add(label_3);
		
		textPane_1 = new JTextPane();
		textPane_1.setText("Ready!");
		textPane_1.setBounds(177, 108, 100, 20);
		frame.getContentPane().add(textPane_1);
		
		label_4 = new JLabel("Status");
		label_4.setForeground(Color.BLACK);
		label_4.setBounds(177, 139, 46, 14);
		frame.getContentPane().add(label_4);
		
		textPane_2 = new JTextPane();
		textPane_2.setText("Ready!");
		textPane_2.setBounds(177, 164, 100, 20);
		frame.getContentPane().add(textPane_2);
		
		label_5 = new JLabel("Status");
		label_5.setForeground(Color.BLACK);
		label_5.setBounds(177, 195, 46, 14);
		frame.getContentPane().add(label_5);
		
		textPane_3 = new JTextPane();
		textPane_3.setText("Ready!");
		textPane_3.setBounds(177, 220, 100, 20);
		frame.getContentPane().add(textPane_3);
		
		lblGal = new JLabel("");
		lblGal.setIcon(new ImageIcon("gal.jpg"));
		lblGal.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(lblGal);
		
		
		
		
	}
}
