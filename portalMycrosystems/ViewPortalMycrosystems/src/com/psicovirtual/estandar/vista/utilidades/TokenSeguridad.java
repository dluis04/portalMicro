package com.psicovirtual.estandar.vista.utilidades;

import java.security.SecureRandom;

public class TokenSeguridad {

	protected SecureRandom random;

	public TokenSeguridad() {
		random = new SecureRandom();
	}

	public String generarToken() {
		
		long longToken = Math.abs(random.nextLong());
		String random = Long.toString(longToken, 17).substring(0, 8);
		return random;
	}

}
