package primerasPruebas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Mensaje extends Launcher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	public static void launchMensaje() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mensaje frame = new Mensaje();
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
	public Mensaje() {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gracias por utilizar el conversor!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 23, 414, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Actualmente estamos trabajando en próximas actualizaciones");
		lblNewLabel_1.setBounds(10, 69, 414, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnClose = new JButton("Cerrar");
		btnClose.setBounds(219, 117, 89, 23);
		contentPane.add(btnClose);
		
		btnClose.addActionListener(event -> {
			this.dispose();
		});
	}
}
