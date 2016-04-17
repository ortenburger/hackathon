package de.hackerslite.flowspot.webservice;

import java.util.List;

public interface WebserviceNotificationListener {

	List<String> getAllLights();

	boolean setHue(String lightID, int hue);

	boolean setBrightness(String lightID, int brightness);

	boolean setOn(String lightID, boolean on);

	boolean party();

}
