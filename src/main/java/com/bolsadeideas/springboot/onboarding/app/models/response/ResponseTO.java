package com.bolsadeideas.springboot.onboarding.app.models.response;

import java.util.ArrayList;
import java.util.List;

import com.bolsadeideas.springboot.onboarding.app.models.Notification;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonInclude(Include.NON_NULL)
public class ResponseTO {

	private Object data;
	@Setter(value = AccessLevel.NONE)
	@Getter(value = AccessLevel.NONE)
	@JsonProperty("notifications")
	
	private List<Notification> notification = new ArrayList<Notification>();
	
	public void addNotification(Notification n) {
		notification.add(n);
	}
	
}
