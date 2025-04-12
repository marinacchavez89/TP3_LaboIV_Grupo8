package ejercicio1;

public class Persona {

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
		return nombre + " " + apellido + " - DNI: " + dni ;
	}
	
	
	
}
