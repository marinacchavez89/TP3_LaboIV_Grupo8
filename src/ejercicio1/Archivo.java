package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Archivo {
	
	private String ruta;
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public boolean existe() {
		File archivo = new File(ruta);
		if(archivo.exists())
			return true;
		return false;
	}
	
	public boolean creaArchivo() {
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void escribe_letra_x_letra(String frase) {
		try {
			FileWriter fw = new FileWriter(ruta, true);
			
			for(int i = 0; i < frase.length(); i++) {
				fw.write(frase.charAt(i));
			}
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lee_letra_x_letra() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			int c = entrada.read();
			while(c!= -1) {
				char letra = (char) c;
				System.out.println(letra);
				c = entrada.read();
			}
			entrada.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void escribe_lineas(String frase) {
		try {
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(frase);
			miBuffer.close();
			entrada.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lee_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = "";
				while(linea != null) {
					System.out.println(linea);
					linea = miBuffer.readLine();
				}
				miBuffer.close();
				entrada.close();
		}catch(IOException e) {
			System.out.println("No se encontro el archivo");
		}
	}
	
	public Set<Persona> leerPersonasSinDuplicadosYOrdenadas() {
		Set<Persona> personasSet = new TreeSet<>(); // Utilizo TreeSet que ordena automáticamente.

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("-");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String apellido = partes[1].trim();
                    String dniStr = partes[2].trim();

                    try {
                        Verificar.verificarDniInvalido(dniStr);
                        int dni = Integer.parseInt(dniStr);
                        personasSet.add(new Persona(nombre, apellido, dni)); // Acá el HashSet usa equals() y hashCode() de la clase Persona para ver si la persona ya está en el set.
                    } catch (DniInvalido e) {
                        System.out.println("DNI inválido: " + dniStr);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return personasSet;
    }
	
	public void escribir_en_Resultado(Set<Persona> personas)
	{
		try(BufferedWriter wr = new BufferedWriter(new FileWriter("Resultado.txt"))) {
			
			for(Persona persona : personas)
			{
				wr.write(persona.toString());
				wr.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Set<String> obtenerDnisInvalidos() {
	    Set<String> dnisInvalidos = new TreeSet<>();

	    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            String[] partes = linea.split("-");
	            if (partes.length == 3) {
	                String dniStr = partes[2].trim();

	                try {
	                    Verificar.verificarDniInvalido(dniStr);
	                } catch (DniInvalido e) {
	                    dnisInvalidos.add(dniStr);
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return dnisInvalidos;
	}
	
}
