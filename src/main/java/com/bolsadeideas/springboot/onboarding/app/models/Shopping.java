package com.bolsadeideas.springboot.onboarding.app.models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "shopping")
public class Shopping {

}
