package primerasPruebas;

import java.awt.EventQueue;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConversionTemperatura extends MenuPrincipal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfInput;

	/**
	 * Launch the application.
	 */
	
	public void launchConversionTemperatura () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversionTemperatura frame = new ConversionTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Función para la conversión
	public double convertirTemperatura (double input, String tempInicial, String tempSaliente) {
		switch (tempInicial) {
		case "°Celsius":
			switch (tempSaliente) {
			case "°Fahrenheit":
				return (input * 1.8) + 32.0;
			}
			break;
		case "°Fahrenheit":
			switch (tempSaliente) {
			case "°Celsius":
				return (input - 32.0) * (5/9);
			}
			break;
		}
		return input;
	}

	/**
	 * Create the frame.
	 */
	public ConversionTemperatura() {
		setTitle("Conversor - Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTittle = new JLabel("Conversor de Temperatura");
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblTittle.setBounds(10, 11, 414, 30);
		contentPane.add(lblTittle);
		
		JLabel lblSubtittle = new JLabel("Ingrese la unidad de medida y el valor de temperatura que desea convertir");
		lblSubtittle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSubtittle.setBounds(10, 52, 414, 24);
		contentPane.add(lblSubtittle);
		
		tfInput = new JTextField();
		tfInput.setBounds(10, 107, 255, 20);
		contentPane.add(tfInput);
		tfInput.setColumns(10);
		
		JComboBox<String> cbInputUnidad = new JComboBox<String>();
		cbInputUnidad.setBounds(275, 106, 172, 22);
		contentPane.add(cbInputUnidad);
		String itemDefault = "Seleccione una unidad";
		cbInputUnidad.addItem(itemDefault);
		cbInputUnidad.setSelectedItem(itemDefault);
		cbInputUnidad.addItem("°Celsius");
		cbInputUnidad.addItem("°Fahrenheit");
		
		
		JLabel lblMedida = new JLabel("A qué unidad de medida desea convertir?");
		lblMedida.setBounds(20, 139, 255, 24);
		contentPane.add(lblMedida);
		
		JComboBox<String> cbOutputMedida = new JComboBox<String>();
		cbOutputMedida.setBounds(275, 139, 172, 24);
		contentPane.add(cbOutputMedida);
		cbOutputMedida.addItem(itemDefault);
		cbOutputMedida.setSelectedItem(itemDefault);
		cbOutputMedida.addItem("°Celsius");
		cbOutputMedida.addItem("°Fahrenheit");
		
		JLabel lblResultado = new JLabel("Esperando proceso...");
		lblResultado.setBounds(10, 215, 414, 24);
		contentPane.add(lblResultado);
		
		JButton btnConversion = new JButton("Convertir");
		btnConversion.setBounds(309, 174, 107, 23);
		contentPane.add(btnConversion);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(335, 250, 89, 23);
		contentPane.add(btnCerrar);
		
		JButton btnAtras = new JButton("< Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtras.setBounds(237, 250, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(10, 76, 414, 20);
		contentPane.add(lblError);
		
		//Verificando caracteres para la conversion
		btnConversion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfInput.getText().isEmpty() != true) {
					lblError.setText("");
					Pattern patternValorInicial = Pattern.compile("[^0-9.]");
					Matcher matcherValorInicial = patternValorInicial.matcher(tfInput.getText());
					if (matcherValorInicial.find()) {
						lblResultado.setText("Esperando proceso...");
						lblError.setText("Caracteres inválidos detectados, ingrese carácteres respetando el formato (0.00)");
					} else if (cbInputUnidad.getSelectedItem() == cbOutputMedida.getSelectedItem()) {
						lblError.setText("Las unidades para la conversion deben tener un tipo de unidad");
						lblResultado.setText("Esperando proceso...");
					} else if (cbInputUnidad.getSelectedItem().toString() == itemDefault || cbOutputMedida.getSelectedItem().toString() == itemDefault) {
						lblError.setText("Las unidades para la conversion deben ser diferentes");
						lblResultado.setText("Esperando proceso...");
					}	else {
					
						lblError.setText("");
						double valorConvertir = Double.parseDouble(tfInput.getText());
						double res = convertirTemperatura(valorConvertir, (String) cbInputUnidad.getSelectedItem(), (String) cbOutputMedida.getSelectedItem());
						lblResultado.setText("Resultado de la conversion: " + res + cbOutputMedida.getSelectedItem().toString());
					}
					
				} else {
					lblResultado.setText("Esperando proceso");
				}
			}
		});
		
		//Volver un frame atras
		btnAtras.addActionListener(event -> {
			menu.launchMenuPrincipal();
			dispose();
		});
		
		//Cerrar frame y abrir mensaje
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchMensaje();
				dispose();
			}
		});
	}
}
