package com.bolsadeideas.springboot.onboarding.app.dao;

import com.bolsadeideas.springboot.onboarding.app.models.Cliente;
import com.bolsadeideas.springboot.onboarding.app.models.request.UpdateClientTO;

public interface UsersDao {

	
	/**
	 * Registra un nuevo usuario en la BD
	 * @param c
	 */
	public void registerClient(Cliente c);

	/**
	 * Comprueba si el usuario ya existe
	 * 
	 * @param u Usuario
	 */
	public boolean existUsername(String u);

	
	/**
	 * Actualiza los datos del cliente
	 * @param c
	 */
	public void update(UpdateClientTO c);
	
}
