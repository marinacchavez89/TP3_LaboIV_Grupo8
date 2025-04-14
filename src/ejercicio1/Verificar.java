package ejercicio1;

public class Verificar {
	
	public static void verificarDniInvalido(String dni) throws DniInvalido {
	    try {
	        Integer.parseInt(dni);  
	    } catch (NumberFormatException e) {
	        throw new DniInvalido("DNI inválido: debe ser solo numérico.");  
	    }
	}

}
