package primerasPruebas;

import java.util.regex.*;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthInternalFrameUI;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class MenuConversion extends MenuPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfValorIngresado;
	private JTextField tfValorInicial;
	private JTextField tfValorFinal;

	/**
	 * Launch the application.
	 */
	public void launchMenuConversion() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuConversion frame = new MenuConversion();
					frame.setTitle("Menu de conversion");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Conversor de monedas
	public double convertirMoneda(double valor, String monedaInicial, String monedaSaliente) {
		switch (monedaInicial) {
		case "ARS":
			switch (monedaSaliente) {
			case "USD":
				return valor * 0.0038;
			case "EURO":
				return valor * 0.0035;
			case "LIBRA":
				return valor * 0.0030;
			case "YEN":
				return valor * 0.54;
			case "WON":
				return valor * 4.93;
			}
		case "USD":
			switch (monedaSaliente) {
			case "ARS":
				return valor * 262.55;
			case "EURO":
				return valor * 0.91;
			case "LIBRA":
				return valor * 0.78;
			case "YEN":
				return valor * 140.80;
			case "WON":
				return valor * 1293.68;
			}
		case "EURO":
			switch (monedaSaliente) {
			case "ARS":
				return valor * 289.20;
			case "USD":
				return valor * 1.10;
			case "LIBRA":
				return valor * 0.86;
			case "YEN":
				return valor * 155.11;
			case "WON":
				return valor * 1424.32;
			}
		case "LIBRA":
			switch (monedaSaliente) {
			case "ARS":
				return valor * 337.97;
			case "USD":
				return valor * 1.29;
			case "EURO":
				return valor * 1.17;
			case "YEN":
				return valor * 181.28;
			case "WON":
				return valor * 1664.68;
			}
		case "YEN":
			switch (monedaSaliente) {
			case "ARS":
				return valor * 1.86;
			case "USD":
				return valor * 0.0071;
			case "EURO":
				return valor * 0.0064;
			case "LIBRA":
				return valor * 0.0055;
			case "WON":
				return valor * 9.18;
			}
		case "WON":
			switch (monedaSaliente) {
			case "ARS":
				return valor * 0.20;
			case "USD":
				return valor * 0.00077;
			case "EURO":
				return valor * 0.00070;
			case "LIBRA":
				return valor * 0.00060;
			case "YEN":
				return valor * 0.11;
			}
		}
		return valor;
	}

	

	/**
	 * Create the frame.
	 */
	public MenuConversion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuConvTittle = new JLabel("Conversor");
		lblMenuConvTittle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMenuConvTittle.setBounds(23, 11, 474, 40);
		contentPane.add(lblMenuConvTittle);

		JLabel lblMCTxt = new JLabel(
				"Los tipos de cambio son con referencias estáticas; estamos trabajando en añadir un cambio real.");
		lblMCTxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMCTxt.setBounds(23, 62, 558, 21);
		contentPane.add(lblMCTxt);

		JLabel lblIngresoMoneda = new JLabel("¿Que valor desea cambiar?");
		lblIngresoMoneda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngresoMoneda.setBounds(23, 108, 474, 21);
		contentPane.add(lblIngresoMoneda);

		tfValorIngresado = new JTextField();
		tfValorIngresado.setBounds(23, 157, 324, 26);
		contentPane.add(tfValorIngresado);
		tfValorIngresado.setColumns(10);
		tfValorIngresado.addActionListener(event -> {
			System.out.println(event);
		});

		JComboBox<String> cbMonedaIngresada = new JComboBox<String>();
		cbMonedaIngresada.setBounds(357, 157, 224, 26);
		contentPane.add(cbMonedaIngresada);
		String ingresoDefault = "Seleccione una moneda";
		cbMonedaIngresada.addItem(ingresoDefault);
		cbMonedaIngresada.setSelectedItem(ingresoDefault);
		cbMonedaIngresada.addItem("ARS");
		cbMonedaIngresada.addItem("USD");
		cbMonedaIngresada.addItem("EURO");
		cbMonedaIngresada.addItem("LIBRA");
		cbMonedaIngresada.addItem("YEN");
		cbMonedaIngresada.addItem("WON");

		JLabel lblSalidaMoneda = new JLabel("¿En qué desea expresar el cambio?");
		lblSalidaMoneda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalidaMoneda.setBounds(23, 224, 280, 26);
		contentPane.add(lblSalidaMoneda);

		JComboBox<String> cbMonedaSaliente = new JComboBox<String>();
		cbMonedaSaliente.setBounds(313, 224, 224, 26);
		contentPane.add(cbMonedaSaliente);
		cbMonedaSaliente.addItem(ingresoDefault);
		cbMonedaSaliente.setSelectedItem(ingresoDefault);
		cbMonedaSaliente.addItem("ARS");
		cbMonedaSaliente.addItem("USD");
		cbMonedaSaliente.addItem("EURO");
		cbMonedaSaliente.addItem("LIBRA");
		cbMonedaSaliente.addItem("YEN");
		cbMonedaSaliente.addItem("WON");

		JLabel lblAviso = new JLabel("");
		lblAviso.setBounds(23, 140, 380, 14);
		contentPane.add(lblAviso);

		JButton btnConversion = new JButton("Convertir");
		btnConversion.setBounds(367, 286, 118, 23);
		contentPane.add(btnConversion);

		JLabel lblValorInicial = new JLabel("El valor inicial es :");
		lblValorInicial.setBounds(26, 335, 128, 21);
		contentPane.add(lblValorInicial);

		JLabel lblValorConvertido = new JLabel("El valor convertido es :");
		lblValorConvertido.setBounds(26, 367, 128, 21);
		contentPane.add(lblValorConvertido);

		tfValorInicial = new JTextField();
		tfValorInicial.setBounds(173, 335, 110, 20);
		contentPane.add(tfValorInicial);
		tfValorInicial.setColumns(10);
		tfValorInicial.setEditable(false);

		tfValorFinal = new JTextField();
		tfValorFinal.setColumns(10);
		tfValorFinal.setBounds(173, 367, 110, 20);
		contentPane.add(tfValorFinal);
		tfValorFinal.setEditable(false);

		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(492, 422, 89, 23);
		contentPane.add(btnCerrar);

		JButton btnAtras = new JButton("< Atras");
		btnAtras.setBounds(396, 422, 89, 23);
		contentPane.add(btnAtras);

		/*
		 * Etapa de verificacion de caracteres ingresados
		 */
		btnConversion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfValorIngresado.getText().isEmpty() != true) {
					lblAviso.setText("");
					Pattern patternValorInicial = Pattern.compile("[^0-9.]");
					Matcher matcherValorInicial = patternValorInicial.matcher(tfValorIngresado.getText());
					if (matcherValorInicial.find()) { // Bloque si se introducen carácteres inválidos
						lblAviso.setText("Carácter/es inválidos detectados, introduzca un número válido (0.00)");
						tfValorInicial.setText("");
						tfValorFinal.setText("");
					} else if (cbMonedaIngresada.getSelectedItem() == cbMonedaSaliente.getSelectedItem()) { // Verificar
																											// que la
																											// moneda
																											// inicial y
																											// la final
																											// no sean
																											// la misma
						lblAviso.setText("Selección de monedas inválidas, deben tener una unidad para convertir");
						tfValorInicial.setText("");
						tfValorFinal.setText("");
					} else if (cbMonedaIngresada.getSelectedItem().toString() == ingresoDefault || cbMonedaSaliente.getSelectedItem().toString() == ingresoDefault) {
						lblAviso.setText("Selección de monedas inválidas, deben tener una unidad diferente para convertir");
						tfValorInicial.setText("");
						tfValorFinal.setText("");
					} else { // Bloque de carácteres válidos
					
						lblAviso.setText("");
						double valorIngresado = Double.parseDouble(tfValorIngresado.getText());
						double resultadoConversion = convertirMoneda(valorIngresado,(String) cbMonedaIngresada.getSelectedItem(),(String) cbMonedaSaliente.getSelectedItem());
						tfValorInicial.setText(tfValorIngresado.getText());
						tfValorFinal.setText(String.valueOf(resultadoConversion));
					}
				} else {			//Bloque si no se introduce un valor para conversion
					tfValorInicial.setText("");
					tfValorFinal.setText("");
					lblAviso.setText("Ingrese un valor para realizar la conversion");
				}

			}
		});
		
		
		//Bloque para volver un frame atras
		btnAtras.addActionListener(event -> {
			menu.launchMenuPrincipal();
			this.dispose();
		});
		
		
		//Cerrar conversor
		btnCerrar.addActionListener(event -> {
			launchMensaje();
			this.dispose();
		});
	}
}
