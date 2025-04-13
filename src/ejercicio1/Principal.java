package ejercicio1;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("¡Proyecto corriendo!");
		

			try {
				String dni = JOptionPane.showInputDialog("Ingrese un numero");
				Verificar.verificarDniInvalido(dni);
			} catch (DniInvalido e) {
				System.out.println("Error. El dni deberia ser numerico");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

	}

}
