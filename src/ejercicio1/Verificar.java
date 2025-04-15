package ejercicio1;

public class Verificar {
	
	public static void verificarDniInvalido(String dni) throws DniInvalido {
		// Validar que tenga exactamente 8 caracteres
        if (dni.length() != 8) {
            throw new DniInvalido("DNI inválido: debe tener exactamente 8 dígitos.");
        }
	    try {
	        Integer.parseInt(dni);  
	    } catch (NumberFormatException e) {
	        throw new DniInvalido("DNI inválido: debe ser solo numérico.");  
	    }
	}

}
