package de.hackerslite.api;

import java.util.List;
import java.util.Random;

import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHBridgeSearchManager;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class Hue {
	private PHHueSDK phHueSDK;
	private final String apIPAddress="10.10.1.152";
	private final String apAppname="FlowSpot";
	private final String apDevicename="HackersLite";
	private final String apUsername="pQHSnoZ7IxOvYucDgeIO8A7fTgzazxAS7esQzjG6";
	private boolean connected=false;
	
	public Hue() {
		phHueSDK = PHHueSDK.getInstance();
		phHueSDK.setAppName(apAppname);     
		phHueSDK.setDeviceName(apDevicename);
//		PHBridgeSearchManager sm = (PHBridgeSearchManager) phHueSDK.getSDKService(PHHueSDK.SEARCH_BRIDGE);
//	    sm.search(true, true);
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public void setConnected(boolean connected) {
		this.connected=connected;
	}
	
	public void setSelectedBridge(PHBridge b) {
        phHueSDK.enableHeartbeat(b, PHHueSDK.HB_INTERVAL);
        phHueSDK.getLastHeartbeat().put(b.getResourceCache().getBridgeConfiguration() .getIpAddress(), System.currentTimeMillis());	
	}
	
	public void authenticate(PHAccessPoint accessPoint) {
		phHueSDK.startPushlinkAuthentication(accessPoint);
	}
	
	public void setNotificationListener(PHSDKListener listener) {
		phHueSDK.getNotificationManager().registerSDKListener(listener);
	}
	
	public void connect() {
		PHAccessPoint accessPoint = new PHAccessPoint();
		accessPoint.setIpAddress(apIPAddress);
		accessPoint.setUsername(apUsername);
		phHueSDK.connect(accessPoint);
	}
	
	public List<PHLight> getAllLights() {
		PHBridge bridge=phHueSDK.getSelectedBridge();
	    PHBridgeResourcesCache cache = bridge.getResourceCache();
	    // And now you can get any resource you want, for example:
	    List<PHLight> myLights = cache.getAllLights();
	    return myLights;
	}
	
	public PHLight getLight(String lightID) {
		for(PHLight light: phHueSDK.getSelectedBridge().getResourceCache().getAllLights()) {
			if(light.getIdentifier().equals(lightID)) {
				return light;
			}
		}
		return null;
	}
	
	public void setHue(PHLight light, int hue) {
		PHBridge bridge=phHueSDK.getSelectedBridge();
		PHLightState state=new PHLightState();
		state.setHue(hue);
		bridge.updateLightState(light, state);		
	}
	
	public void setBrightness(PHLight light, int brightness) {
		PHBridge bridge=phHueSDK.getSelectedBridge();
		PHLightState state=new PHLightState();
		state.setBrightness(brightness);
		bridge.updateLightState(light, state);		
	}

	public void setOn(PHLight light, boolean on) {
		PHBridge bridge=phHueSDK.getSelectedBridge();
		PHLightState state=new PHLightState();
		state.setOn(on);
		bridge.updateLightState(light, state);		
	}

	public void party() {
		PHBridge bridge=phHueSDK.getSelectedBridge();
		for(int i=0;i<20;i++) {
			for(PHLight light: this.getAllLights()) {
				PHLightState state=new PHLightState();
				Random random=new Random();
				state.setHue(random.nextInt() % 65535);
				bridge.updateLightState(light, state);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	}
