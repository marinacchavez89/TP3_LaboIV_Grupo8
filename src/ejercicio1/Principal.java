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
        
        archivo.escribir_en_Resultado(personas);
        
        System.out.println("\n Lista de Personas escritas en Resultado.txt\n");
        for(Persona p : personas)
        {
        	System.out.println(p);
        }
        System.out.println("\nCantidad total de personas válidas: " + personas.size());

     // NUEVO: Obtener y mostrar los DNIs inválidos
        Set<String> dnisInvalidos = archivo.obtenerDnisInvalidos();

        System.out.println("\nDNIs inválidos encontrados en Personas.txt:\n");
        for (String dni : dnisInvalidos) {
            System.out.println("DNI inválido: " + dni);
        }
        System.out.println("\nCantidad total de DNIs inválidos: " + dnisInvalidos.size());
	}

}
