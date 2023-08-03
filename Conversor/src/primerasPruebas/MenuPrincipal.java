package primerasPruebas;

import javax.accessibility.Accessible;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class MenuPrincipal extends Mensaje implements Accessible {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6833315276290332134L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private String opt;
	
	public void setOpt(String str) {
		this.opt = str;
	}
	public String getOpt() {
		return opt;
	}
	

	/**
	 * Launch the application.
	 */
	
	public void launchMenuPrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	
	@Override
	public void dispose() {
		setTipoDeCambio(opt);
		super.dispose();
	}
	
	public MenuPrincipal() {
		setTitle("Conversor - Menu principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuTittle = new JLabel("Conversor");
		lblMenuTittle.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMenuTittle.setBounds(10, 11, 414, 30);
		contentPane.add(lblMenuTittle);
		
		JLabel lblMenuTxt1 = new JLabel("Bienvenido a la aplicación de conversión realizada con Java");
		lblMenuTxt1.setBounds(10, 52, 414, 20);
		contentPane.add(lblMenuTxt1);
		
		JLabel lblMenuTxt2 = new JLabel("¿Qué tipo de conversión desea realizar?");
		lblMenuTxt2.setBounds(10, 68, 414, 20);
		contentPane.add(lblMenuTxt2);
		
		JComboBox<String> cbList = new JComboBox<String>();
		cbList.setMaximumRowCount(4);
		cbList.setToolTipText("Moneda");
		cbList.setBounds(97, 138, 236, 22);
		contentPane.add(cbList);
		
		JButton btnMenu = new JButton("Siguiente >");
		btnMenu.setBounds(274, 209, 118, 30);
		contentPane.add(btnMenu);
		
		String itemDefault = "Seleccione una conversión";
		String itemHora = "Hora";
		cbList.addItem(itemDefault);
		cbList.setSelectedItem(itemDefault);
		cbList.addItem("Moneda");
		cbList.addItem("Temperatura");
		cbList.addItem(itemHora);
		
		
		btnMenu.setEnabled(false);
		cbList.addItemListener(event -> {
			if(event.getStateChange() == ItemEvent.SELECTED) {
				if(event.getItem() != itemDefault && event.getItem() != itemHora) {
					btnMenu.setEnabled(true);
				} else {
					btnMenu.setEnabled(false);
				}
			}
		});
		btnMenu.addActionListener(event -> {
			opt = (String)cbList.getSelectedItem();
			setTipoDeCambio(getOpt());
			if (getOpt() == "Moneda") {
				menuConversionMoneda.launchMenuConversion();
			} else if (getOpt() == "Temperatura") {
				menuConversionTemperatura.launchConversionTemperatura();
			} else if (getOpt() == itemHora) {
				
			}
			this.dispose();
		});

	}

	
}
