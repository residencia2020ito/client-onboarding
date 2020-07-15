package com.bolsadeideas.springboot.onboarding.app.models.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class UpdateClientTO {
	
	
	private String name;// nombre
	private String lastName;// primer apellido
	private String secondLastName;// segundo apellido
	private String descriptionHouse;//Descripcion de casa
	private String state;//estado
	private String city;//ciudad
	private String suburb;//colonia
	private String street;//Calle
	private String houseNumberI;//numero de casa interno
	private String houseNumberE;//numero de casa externo
	private String cp;//codigo postal
	private String numberPhone;//numero de telefono
	private String firstParStreet;//Primera calle paralela
	private String secondParStreet;//Segunda calle paralela

}
