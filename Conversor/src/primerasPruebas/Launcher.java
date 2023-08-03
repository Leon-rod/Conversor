package primerasPruebas;


import javax.swing.JFrame;

public class Launcher extends JFrame{
	/**
	 * 
	 */
	private String tipoDeCambio;

	private static final long serialVersionUID = 1L;
	
	
	static MenuConversion menuConversionMoneda = new MenuConversion();
	static ConversionTemperatura menuConversionTemperatura = new ConversionTemperatura();
	static MenuPrincipal menu = new MenuPrincipal();
	static Mensaje msg = new Mensaje();

	public static void main(String[] args) {

		menu.launchMenuPrincipal();
		
		
		

	}


	public void setTipoDeCambio(String tipoDeCambio) {
		this.tipoDeCambio = tipoDeCambio;
	}

	public String getTipoDeCambio() {
		return tipoDeCambio;
	}

}
