package ejercicio1;

public class Persona implements Comparable<Persona> {

	private String nombre;
	private String apellido;
	private int dni;
	
		
	//contructor
	
	public Persona(String nombre, String apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	// getters and setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-15s DNI: %08d", nombre, apellido, dni);
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Persona persona = (Persona) obj;
	    return dni == persona.dni;
	}

	@Override
	public int hashCode() {
	    return Integer.hashCode(dni);
	}
	
	@Override
	public int compareTo(Persona otra) {
        return this.apellido.compareToIgnoreCase(otra.apellido);
    }
	
}
