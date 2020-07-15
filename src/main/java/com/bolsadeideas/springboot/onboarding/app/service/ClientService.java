package com.bolsadeideas.springboot.onboarding.app.service;

import com.bolsadeideas.springboot.onboarding.app.models.Cliente;
import com.bolsadeideas.springboot.onboarding.app.models.request.RegisterClientTO;

public interface ClientService {

	
	public void registerClient(RegisterClientTO r);
	
}
