package ejercicio1;

import java.io.IOException;


public class DniInvalido extends IOException {
	public DniInvalido (String cartel) {
		super(cartel);
	}

}

