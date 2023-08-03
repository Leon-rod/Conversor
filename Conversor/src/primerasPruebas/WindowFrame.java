package primerasPruebas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfLastName;

	/**
	 * Create the frame.
	 */
	public static void Launcher() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowFrame frame = new WindowFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public WindowFrame() {
		setTitle("Java_App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbName = new JLabel("Name");
		lbName.setBounds(10, 11, 414, 20);
		contentPane.add(lbName);
		
		tfName = new JTextField();
		tfName.setBounds(10, 42, 414, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lbLastName = new JLabel("Last Name");
		lbLastName.setBounds(10, 88, 414, 20);
		contentPane.add(lbLastName);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(10, 121, 414, 20);
		contentPane.add(tfLastName);
		tfLastName.setColumns(10);
		
		JLabel lbOk = new JLabel("");
		lbOk.setBounds(10, 189, 414, 20);
		contentPane.add(lbOk);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String LastName = tfLastName.getText();
				lbOk.setText("Welcome " + name + " " + LastName);
			}
		});
		btnOk.setBounds(10, 227, 176, 23);
		contentPane.add(btnOk);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(248, 227, 176, 23);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				tfLastName.setText("");
				lbOk.setText("");
			}
		});
	}

}
