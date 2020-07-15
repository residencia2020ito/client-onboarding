package com.bolsadeideas.springboot.onboarding.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.onboarding.app.dao.UsersDao;
import com.bolsadeideas.springboot.onboarding.app.models.Cliente;
import com.bolsadeideas.springboot.onboarding.app.models.Notification;
import com.bolsadeideas.springboot.onboarding.app.models.Shopping;
import com.bolsadeideas.springboot.onboarding.app.models.request.RegisterClientTO;
import com.bolsadeideas.springboot.onboarding.app.models.request.UpdateClientTO;
import com.bolsadeideas.springboot.onboarding.app.models.response.ResponseTO;
import com.bolsadeideas.springboot.onboarding.app.service.ClientServiceImplement;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/controller")
public class ClientController {

	private static final Logger log = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private UsersDao userDao;

	@Autowired
	ClientServiceImplement clientServiceImplement;

	@RequestMapping(path = "/newClient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO> registerNewClient(HttpServletRequest httpServletRequest,
			@Valid @RequestBody RegisterClientTO request,
			@RequestHeader(name = "x-header", required = false, defaultValue = "0000") String header) {

		clientServiceImplement.registerClient(request);
		Notification notification = new Notification();
		ResponseTO response = new ResponseTO();
		notification.setCodigo("000000040");
		notification.setDescripcion("Cliente registrado");
		response.addNotification(notification);
		httpServletRequest.getSession();
		HttpHeaders hr = new HttpHeaders();
		hr.set("x-hr", "12345");
		ResponseEntity<ResponseTO> responseEntity = new ResponseEntity<ResponseTO>(response, hr, HttpStatus.CREATED);
		return responseEntity;

	}

	@RequestMapping(path = "/updateCliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO> updateClient(HttpServletRequest httpServletRequest,
			@Valid @RequestBody UpdateClientTO request,
			@RequestHeader(name = "x-header", required = false, defaultValue = "0000") String header) {

		String id = (String) httpServletRequest.getSession().getAttribute("idClient");
		log.debug("Cookie update: " + id);
		userDao.update(request);
		Notification notification = new Notification();
		ResponseTO response = new ResponseTO();
		notification.setCodigo("000000000");
		notification.setDescripcion("Datos actualizados correctamente");
		response.addNotification(notification);
		HttpHeaders hr = new HttpHeaders();
		hr.set("x-hr", "12345");
		ResponseEntity<ResponseTO> responseEntity = new ResponseEntity<ResponseTO>(response, hr, HttpStatus.OK);
		return responseEntity;

	}

	@RequestMapping(path = "/shoppingCliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseTO> ShoppingsClient(HttpServletRequest httpServletRequest,
			@Valid @RequestBody Shopping request,
			@RequestHeader(name = "x-header", required = false, defaultValue = "0000") String header) {

		
		Notification notification = new Notification();
		ResponseTO response = new ResponseTO();
		notification.setCodigo("000000000");
		notification.setDescripcion("Datos actualizados correctamente");
		response.addNotification(notification);
		
		HttpHeaders hr = new HttpHeaders();
		hr.set("x-hr", "12345");
		ResponseEntity<ResponseTO> responseEntity = new ResponseEntity<ResponseTO>(response, hr, HttpStatus.OK);
		return responseEntity;
	}

}
