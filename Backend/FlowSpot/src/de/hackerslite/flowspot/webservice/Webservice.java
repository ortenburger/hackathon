package de.hackerslite.flowspot.webservice;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.ws.WebServiceContext;

@WebService (endpointInterface="de.hackerslite.flowspot.webservice.Webservice")
public class Webservice {
	@Resource WebServiceContext context;
	private WebserviceNotificationListener listener;
	public Webservice(WebserviceNotificationListener listener) {
		this.listener=listener;
	}

	@WebMethod(action="getAllLights")
	@XmlElementWrapper(name="lights")
	@XmlElement(name="light")
	public List<String> getAllLights() {
	    return listener.getAllLights();
	}

	@WebMethod(action="setHue")
	public boolean setHue(@XmlElement(required=true) @WebParam(name="lightID") String lightID, @XmlElement(required=true) @WebParam(name="hue") int hue) {
		return this.listener.setHue(lightID,hue);
	}

	@WebMethod(action="setBrightness")
	public boolean setBrightness(@XmlElement(required=true) @WebParam(name="lightID") String lightID, @XmlElement(required=true) @WebParam(name="brightness") int brightness) {
		return this.listener.setBrightness(lightID, brightness);
	}

	@WebMethod(action="setOn")
	public boolean setOn(@XmlElement(required=true) @WebParam(name="lightID") String lightID, @XmlElement(required=true) @WebParam(name="on") boolean on) {
		return this.listener.setOn(lightID, on);
	}

	@WebMethod(action="party")
	public boolean party() {
		return this.listener.party();
	}
}
