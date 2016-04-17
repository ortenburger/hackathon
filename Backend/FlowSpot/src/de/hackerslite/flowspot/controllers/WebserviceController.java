package de.hackerslite.flowspot.controllers;

import javax.xml.ws.Endpoint;
import javax.xml.ws.spi.http.HttpContext;

import de.hackerslite.flowspot.webservice.Webservice;
import de.hackerslite.flowspot.webservice.WebserviceNotificationListener;

public class WebserviceController {
	private WebserviceNotificationListener listener;
	public WebserviceController(WebserviceNotificationListener listener) {
		this.listener=listener;
	}
	
	public void start() {
		Endpoint endpoint=Endpoint.create(new Webservice(listener));
		endpoint.publish("http://127.0.0.1:9999/ws/hue");
	}
}
