package de.hackerslite.flowspot.controllers;

import java.util.ArrayList;
import java.util.List;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.hue.sdk.notification.impl.PHHandlerListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHLight;

import de.hackerslite.api.Hue;
import de.hackerslite.flowspot.webservice.WebserviceNotificationListener;

public class MainController {
	private final MainController instance;
	private Hue hue;
	public MainController() {
		instance=this;
		hue=new Hue();
		hue.setNotificationListener(listener);
		hue.connect();
	}

	private void startWebservice() {
		WebserviceController webservice=new WebserviceController(webserviceListener);
		webservice.start();
	}
	
	private WebserviceNotificationListener webserviceListener=new WebserviceNotificationListener() {
		public List<String> getAllLights() {
			List<String> lights=new ArrayList<String>();
			for(PHLight light: hue.getAllLights()) {
				lights.add(light.getIdentifier());
			}
			return lights;
		}
		
		public boolean setHue(String lightID, int hue) {
			PHLight light=instance.hue.getLight(lightID);
			if(light instanceof PHLight) {
				instance.hue.setHue(light, hue);
				return true;
			}
			return false;
		}

		public boolean setBrightness(String lightID, int brightness) {
			PHLight light=instance.hue.getLight(lightID);
			if(light instanceof PHLight) {
				instance.hue.setBrightness(light, brightness);
				return true;
			}
			return false;
		}

		public boolean setOn(String lightID, boolean on) {
			PHLight light=instance.hue.getLight(lightID);
			if(light instanceof PHLight) {
				instance.hue.setOn(light, on);
				return true;
			}
			return false;
		}

		@Override
		public boolean party() {
			instance.hue.party();
			return true;
		}
};

	private PHSDKListener listener = new PHSDKListener() {

		@Override
		public void onAccessPointsFound(List<PHAccessPoint> accessPoint) {
			System.out.format("%d Access Points Found. ",accessPoint.size());
		}

		@Override
		public void onCacheUpdated(List<Integer> arg0, PHBridge bridge) {
			//System.out.println("On CacheUpdated");
		}

		@Override
		public void onBridgeConnected(PHBridge bridge, String username) {
			hue.setSelectedBridge(bridge);
			String lastIpAddress =  bridge.getResourceCache().getBridgeConfiguration().getIpAddress();
			System.out.format("%s - %s",lastIpAddress,username);
			hue.setConnected(true);
			instance.startWebservice();
		}

		@Override
		public void onAuthenticationRequired(PHAccessPoint accessPoint) {
			System.out.println("Authentication Required.");
			hue.authenticate(accessPoint);
		}

		@Override
		public void onConnectionResumed(PHBridge bridge) {

		}

		@Override
		public void onConnectionLost(PHAccessPoint accessPoint) {
			System.out.format("onConnectionLost : %s" + accessPoint.getIpAddress());
			//	            if (!phHueSDK.getDisconnectedAccessPoint().contains(accessPoint)) {
			//	                phHueSDK.getDisconnectedAccessPoint().add(accessPoint);
			//	            }
		}

		@Override
		public void onError(int code, final String message) {
			System.out.format("on Error Called : %d : %s",code,message);
		}

		@Override
		public void onParsingErrors(List parsingErrorsList) {
			System.out.format("ParsingErrors : %s" + parsingErrorsList);
		}
	};
}
