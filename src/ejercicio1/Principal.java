package ejercicio1;

import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("¡Proyecto corriendo!\n");
		

		/*try {
			String dni = JOptionPane.showInputDialog("Ingrese un numero");
			Verificar.verificarDniInvalido(dni);
		} catch (DniInvalido e) {
			System.out.println("Error. El dni deberia ser numerico");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		Archivo archivo = new Archivo();
		archivo.setRuta("Personas.txt");
		
		if(archivo.existe()) {
			System.out.println("Existe archivo.");
		}
		else {
			System.out.println("No existe el archivo, entonces se crea.\n");
			archivo.creaArchivo();
		}
		
		System.out.println("\nSe lee el archivo Personas.txt linea por linea:\n");
		archivo.lee_lineas();
		
		Set<Persona> personas = archivo.leerPersonasSinDuplicadosYOrdenadas();

        System.out.println("\nLista de personas ordenadas por apellido:\n");
        for (Persona p : personas) {
            System.out.println(p);
        }		
		
	}

}
