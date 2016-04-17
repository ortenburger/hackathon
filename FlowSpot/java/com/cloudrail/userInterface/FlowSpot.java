package com.cloudrail.userInterface;
import java.util.HashMap;
import com.cloudrail.userInterface.Endpoint;
import com.cloudrail.userInterface.EndpointCallResponseListener;
import com.cloudrail.userInterface.Endpoint.WebAuthorization;
import java.util.List;
import java.util.Map;
import com.cloudrail.exception.CloudRailException;
import java.io.InputStream;
import com.cloudrail.auth.UriRedirectListener;
import com.cloudrail.auth.UriView;
import com.cloudrail.userInterface.AccessTokenCallback;

public class FlowSpot {

private Endpoint endpoint;

/**
 * 
 * @param philipshueapi_ipaddress   
 * @param googletasks_clientidentifier The client ID you obtain from the Developers Console. 
 * @param googletasks_redirecturi Determines where the response is sent. 
 * @param googletasks_clientsecret Clients secret. 
 * @param facebookgraphapi_clientidentifier Register an app @ developer.facebook.com to get the credentials 
 * @param facebookgraphapi_uri OAuth 2.0 redirect address of your server 
 * @param facebookgraphapi_scope The permissions to be requested, see
https://developers.facebook.com/docs/facebook-login/permissions
for an overview 
 * @param facebookgraphapi_clientsecret See app-id 
 * @param facebookgraphapi_csrftoken The OAuth 2.0 state 
 * @param netatmoweatherstationapi_clientidentifier The client id retrieved from the Netatmo app creation page. 
 * @param netatmoweatherstationapi_uri After granting access the user is redirected to the callback URL defined in your application settings or to the redirect_uri provided in the request in order to finish the authorization flow. 
 * @param netatmoweatherstationapi_csrftoken To ensure the security of the process, you should generate and store a state parameter which is unique to this request. The state parameter is an arbitrary string you choose. Its value will be passed back to your application as a parameter of the redirect_uri when the user completes the authentication flow. 
 * @param netatmoweatherstationapi_clientsecret The client secret retrieved from the Netatmo app creation page. 
 */
public FlowSpot(String philipshueapi_ipaddress, String googletasks_clientidentifier, String googletasks_redirecturi, String googletasks_clientsecret, String facebookgraphapi_clientidentifier, String facebookgraphapi_uri, String facebookgraphapi_scope, String facebookgraphapi_clientsecret, String facebookgraphapi_csrftoken, String netatmoweatherstationapi_clientidentifier, String netatmoweatherstationapi_uri, String netatmoweatherstationapi_csrftoken, String netatmoweatherstationapi_clientsecret) {
HashMap<String, Object> globals = new HashMap<String, Object>();
globals.put("philipshueapi_ipaddress", philipshueapi_ipaddress);
globals.put("googletasks_clientidentifier", googletasks_clientidentifier);
globals.put("googletasks_redirecturi", googletasks_redirecturi);
globals.put("googletasks_clientsecret", googletasks_clientsecret);
globals.put("facebookgraphapi_clientidentifier", facebookgraphapi_clientidentifier);
globals.put("facebookgraphapi_uri", facebookgraphapi_uri);
globals.put("facebookgraphapi_scope", facebookgraphapi_scope);
globals.put("facebookgraphapi_clientsecret", facebookgraphapi_clientsecret);
globals.put("facebookgraphapi_csrftoken", facebookgraphapi_csrftoken);
globals.put("netatmoweatherstationapi_clientidentifier", netatmoweatherstationapi_clientidentifier);
globals.put("netatmoweatherstationapi_uri", netatmoweatherstationapi_uri);
globals.put("netatmoweatherstationapi_csrftoken", netatmoweatherstationapi_csrftoken);
globals.put("netatmoweatherstationapi_clientsecret", netatmoweatherstationapi_clientsecret);
try{
endpoint = new Endpoint(getClass().getResourceAsStream("FlowSpot.cloudrail"), globals);
}catch(Exception e) {
throw new CloudRailException(e);
}
}

/**
 * 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getDevicelist(String accesstoken, final GetDevicelistResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
endpoint.call("Get Devicelist", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("status"), (List<Object>) result.get("device_list"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param identifier The device / weather station you want to obtain data from. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getMeasure(String accesstoken, String identifier, final GetMeasureResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
inputs.put("identifier", identifier);
endpoint.call("Get Measure", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("list_measure"), (String) result.get("status"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param devicetype An identifier of the form [application_name]#[devicename], e.g. my_hue_app#iphone peter

 Restrictions:
 - Pattern: .{0,20}#.{0,19}
 
 * @param answer The ResponseListener for this asynchronous call
 */
public void createUser(String devicetype, final CreateUserResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("devicetype", devicetype);
endpoint.call("Create User", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess();
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param username The username that was created before 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getAllLights(String username, final GetAllLightsResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("username", username);
endpoint.call("Get All Lights", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("list_identifier"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param username The username that has been created before 
 * @param lightidentifier The light's identifier, usually counts up from "1" 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getLightAttributesAndState(String username, String lightidentifier, final GetLightAttributesAndStateResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("username", username);
inputs.put("lightidentifier", lightidentifier);
endpoint.call("Get Light Attributes And State", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((Boolean) result.get("state_onoffstate"), (Long) result.get("brightness"), (Long) result.get("hue"), (Long) result.get("saturation"), (List<Object>) result.get("ciecolor"), (Long) result.get("colortemperature"), (String) result.get("alerteffect"), (String) result.get("effect"), (String) result.get("colormode"), (Boolean) result.get("accessibility"), (String) result.get("lighttypeidentifier_typeidentifier"), (String) result.get("name_lightname"), (String) result.get("hardwaremodelidentifier"), (String) result.get("softwareversion"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param state_onoffstate On/Off state of the light. On=true, Off=false 
 * @param username The username that has been created before 
 * @param lightidentifier The light's identifier, usually counts up from "1" 
 * @param answer The ResponseListener for this asynchronous call
 */
public void switchLight(Boolean state_onoffstate, String username, String lightidentifier, final SwitchLightResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("state_onoffstate", state_onoffstate);
inputs.put("username", username);
inputs.put("lightidentifier", lightidentifier);
endpoint.call("Switch Light", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess();
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param brightness Brightness of the light. This is a scale from the minimum brightness the light is capable of, 1, to the maximum capable brightness, 254. 
 * @param username The username that has been created before 
 * @param lightidentifier The light's identifier, usually counts up from "1" 
 * @param answer The ResponseListener for this asynchronous call
 */
public void setBrightness(Long brightness, String username, String lightidentifier, final SetBrightnessResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("brightness", brightness);
inputs.put("username", username);
inputs.put("lightidentifier", lightidentifier);
endpoint.call("Set Brightness", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess();
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param ciecolor The x and y coordinates of a color in CIE color space. 
 * @param username The username that has been created before 
 * @param lightidentifier The light's identifier, usually counts up from "1" 
 * @param answer The ResponseListener for this asynchronous call
 */
public void setColor(List<Object> ciecolor, String username, String lightidentifier, final SetColorResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("ciecolor", ciecolor);
inputs.put("username", username);
inputs.put("lightidentifier", lightidentifier);
endpoint.call("Set Color", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess();
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param title New task list title 
 * @param accesstoken Access Token 
 * @param answer The ResponseListener for this asynchronous call
 */
public void createANewTaskList(String title, String accesstoken, final CreateANewTaskListResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("title", title);
inputs.put("accesstoken", accesstoken);
endpoint.call("Create A New Task List", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("id"), (String) result.get("title"), (String) result.get("updated"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param title New task title 
 * @param tasklistidentifier Task list identifier. 
 * @param accesstoken Access Token 
 * @param answer The ResponseListener for this asynchronous call
 */
public void createNewTaskOnTaskList(String title, String tasklistidentifier, String accesstoken, final CreateNewTaskOnTaskListResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("title", title);
inputs.put("tasklistidentifier", tasklistidentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Create New Task On Task List", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("updated"), (String) result.get("title"), (String) result.get("id"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param tasklistidentifier Task list identifier. 
 * @param accesstoken Access Token 
 * @param answer The ResponseListener for this asynchronous call
 */
public void deleteATaskList(String tasklistidentifier, String accesstoken, final DeleteATaskListResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("tasklistidentifier", tasklistidentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Delete A Task List", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess();
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param tasklistidentifier Task list identifier. 
 * @param taskidentifier Task identifier. 
 * @param accesstoken Access Token 
 * @param answer The ResponseListener for this asynchronous call
 */
public void deleteTaskFromTaskList(String tasklistidentifier, String taskidentifier, String accesstoken, final DeleteTaskFromTaskListResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("tasklistidentifier", tasklistidentifier);
inputs.put("taskidentifier", taskidentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Delete Task From Task List", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess();
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param accesstoken Access Token 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getAllTaskLists(String accesstoken, final GetAllTaskListsResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
endpoint.call("Get All Task Lists", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("list_tasklist"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param accesstoken Access Token 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getinformationabouttheuser(String accesstoken, final GetinformationabouttheuserResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
endpoint.call("Get information about the user", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("list_work"), (String) result.get("birthday"), (String) result.get("name_hometown"), (String) result.get("name_location"), (List<Object>) result.get("list_education"), (Map<String, Object>) result.get("agerange"), (String) result.get("id_user"), (String) result.get("firstname"), (String) result.get("bio"), (String) result.get("lastname"), (List<Object>) result.get("list_data_pages"), (List<Object>) result.get("list_friends"), (String) result.get("gender"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param accesstoken The access token retrieved after authentication 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getUserFeed(String accesstoken, final GetUserFeedResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
endpoint.call("Get User Feed", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("feed"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param user identifier The id of this person's user account. This ID is unique to each app and cannot be used across different apps. 
 * @param accesstoken A user access token with user_friends permission is required to view the current person's friends. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getusersfriends(String useridentifier, String accesstoken, final GetusersfriendsResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("user identifier", useridentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Get users friends", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("list_friends"), (Long) result.get("totalcount"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param countryidentifier See http://apidev.accuweather.com/developers/countries for a list. Example: "fr" for France 
 * @param searchquery The query text, e.g. a city name like "Paris" 
 * @param apikey The API key, contact sales@accuweather.com to receive one 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getLocationsKeyByText(String countryidentifier, String searchquery, String apikey, final GetLocationsKeyByTextResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("countryidentifier", countryidentifier);
inputs.put("searchquery", searchquery);
inputs.put("apikey", apikey);
endpoint.call("GetLocationsKeyByText", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("results"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param apikey Contact sales@accuweather.com to receive an API key 
 * @param forecasttime The interval. One of '1day', '5day', '10day','15day', '25day', '45day' 
 * @param locationidentifier Location key retrieved by GetLocationsKeyByText 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getDailyForecast(String apikey, String forecasttime, Long locationidentifier, final GetDailyForecastResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("apikey", apikey);
inputs.put("forecasttime", forecasttime);
inputs.put("locationidentifier", locationidentifier);
endpoint.call("GetDailyForecast", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("default0"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param locationidentifier The location key retrieved from GetLocationsKeyByText 
 * @param apikey Contact sales@accuweather.com to receive an API key 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getCurrentConditions(Long locationidentifier, String apikey, final GetCurrentConditionsResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("locationidentifier", locationidentifier);
inputs.put("apikey", apikey);
endpoint.call("GetCurrentConditions", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("results"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param countrycode The location's country code, e.g. "us" 
 * @param apikey The API key, available at http://openweathermap.org/appid 
 * @param zipcode The location's zip code, e.g. "94040" 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getDataByZipCode(String countrycode, String apikey, String zipcode, final GetDataByZipCodeResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("countrycode", countrycode);
inputs.put("apikey", apikey);
inputs.put("zipcode", zipcode);
endpoint.call("Get Data By ZipCode", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((Double) result.get("longitude"), (Double) result.get("latitude"), (Double) result.get("temperature"), (Double) result.get("pressure"), (Long) result.get("humidity"), (Double) result.get("temperature_minimum"), (Double) result.get("temperature_maximum"), (Double) result.get("wind_speed"), (Double) result.get("wind_direction"), (Long) result.get("cloudiness"), (String) result.get("cityname"), (Long) result.get("cityidentifier"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

/**
 * 
 * @param cityname The name of the city, e.g. "Mannheim" 
 * @param apikey The API key, available at http://openweathermap.org/appid 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getDataByCityName(String cityname, String apikey, final GetDataByCityNameResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("cityname", cityname);
inputs.put("apikey", apikey);
endpoint.call("Get DataBy City Name", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((Double) result.get("longitude"), (Double) result.get("latitude"), (Double) result.get("temperature"), (Double) result.get("pressure"), (Long) result.get("humidity"), (Double) result.get("temperature_minimum"), (Double) result.get("temperature_maximum"), (Double) result.get("wind_speed"), (Double) result.get("wind_direction"), (Long) result.get("cloudiness"), (Long) result.get("cityidentifier"), (String) result.get("cityname"));
}
public void onError(CloudRailException error) {
answer.onError(error);
}
public void onProgress(double percentFinished) {
answer.onProgress(percentFinished);
}});
}

private WebAuthorization GoogleTasks_Auth;

 /**
 * Set up authorization for Google Tasks
 * @param uriOpener An implementation of UriView that opens URIs at the appropriate place
 * @param uriRedirectListener An implementation of UriRedirectListener which receives authorization redirects
 * @param tokenCallback An implementation of AccessTokenCallback which receives the access token after successful authorization
 */
public void init_GoogleTasks_Auth(UriView uriOpener, UriRedirectListener uriRedirectListener, AccessTokenCallback tokenCallback) {
GoogleTasks_Auth = endpoint.createWebAuthorization("Google Tasks", uriOpener, uriRedirectListener, tokenCallback);
}

/**
 * Start the authorization process for Google Tasks
 */
public void start_GoogleTasks_Auth() {
GoogleTasks_Auth.openLogin();
}

private WebAuthorization FacebookGraphAPI_Auth;

 /**
 * Set up authorization for Facebook Graph API
 * @param uriOpener An implementation of UriView that opens URIs at the appropriate place
 * @param uriRedirectListener An implementation of UriRedirectListener which receives authorization redirects
 * @param tokenCallback An implementation of AccessTokenCallback which receives the access token after successful authorization
 */
public void init_FacebookGraphAPI_Auth(UriView uriOpener, UriRedirectListener uriRedirectListener, AccessTokenCallback tokenCallback) {
FacebookGraphAPI_Auth = endpoint.createWebAuthorization("Facebook Graph API", uriOpener, uriRedirectListener, tokenCallback);
}

/**
 * Start the authorization process for Facebook Graph API
 */
public void start_FacebookGraphAPI_Auth() {
FacebookGraphAPI_Auth.openLogin();
}

private WebAuthorization NetatmoWeatherstationAPI_Auth;

 /**
 * Set up authorization for Netatmo Weatherstation API
 * @param uriOpener An implementation of UriView that opens URIs at the appropriate place
 * @param uriRedirectListener An implementation of UriRedirectListener which receives authorization redirects
 * @param tokenCallback An implementation of AccessTokenCallback which receives the access token after successful authorization
 */
public void init_NetatmoWeatherstationAPI_Auth(UriView uriOpener, UriRedirectListener uriRedirectListener, AccessTokenCallback tokenCallback) {
NetatmoWeatherstationAPI_Auth = endpoint.createWebAuthorization("Netatmo Weatherstation API", uriOpener, uriRedirectListener, tokenCallback);
}

/**
 * Start the authorization process for Netatmo Weatherstation API
 */
public void start_NetatmoWeatherstationAPI_Auth() {
NetatmoWeatherstationAPI_Auth.openLogin();
}

public interface GetDevicelistResponseListener {
/**
 * 
 * @param status The request status. Should be 'ok' in a successful request. 
 * @param device_list   
 */
public void onSuccess(String status, List<Object> device_list);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetMeasureResponseListener {
/**
 * 
 * @param list_measure   
 * @param status Request status. Should be 'ok' for a successfull request. 
 */
public void onSuccess(List<Object> list_measure, String status);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface CreateUserResponseListener {
/**
 * 
 */
public void onSuccess();
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetAllLightsResponseListener {
/**
 * 
 * @param list_identifier   
 */
public void onSuccess(List<Object> list_identifier);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetLightAttributesAndStateResponseListener {
/**
 * 
 * @param state_onoffstate On/Off state of the light. On=true, Off=false 
 * @param brightness Brightness of the light. This is a scale from the minimum brightness the light is capable of, 1, to the maximum capable brightness, 254. 
 * @param hue Hue of the light. This is a wrapping value between 0 and 65535. Both 0 and 65535 are red, 25500 is green and 46920 is blue. 
 * @param saturation Saturation of the light. 254 is the most saturated (colored) and 0 is the least saturated (white). 
 * @param ciecolor The x and y coordinates of a color in CIE color space. 
 * @param colortemperature The Mired Color temperature of the light. 2012 connected lights are capable of 153 (6500K) to 500 (2000K). 
 * @param alerteffect The alert effect, which is a temporary change to the bulb’s state. This can take one of the following values:'none' – The light is not performing an alert effect.'select' – The light is performing one breathe cycle.'lselect' – The light is performing breathe cycles for 15 seconds or until an 'alert': 'none' command is received.Note that this contains the last alert sent to the light and not its current state. i.e. After the breathe cycle has finished the bridge does not reset the alert to 'none'.

Restrictions:
 - Pattern: (^none$)|(^select$)|(^lselect$)
 
 * @param effect The dynamic effect of the light, can either be 'none' or 'colorloop'.If set to colorloop, the light will cycle through all hues using the current brightness and saturation settings.

Restrictions:
 - Pattern: (^none$)|(^colorloop$)
 
 * @param colormode Indicates the color mode in which the light is working, this is the last command type it received. Values are 'hs' for Hue and Saturation, 'xy' for XY and 'ct' for Color Temperature. This parameter is only present when the light supports at least one of the values.

Restrictions:
 - Pattern: (^xy$)|(^ct$)|(^hs$)
 
 * @param accessibility Indicates if a light can be reached by the bridge. 
 * @param lighttypeidentifier_typeidentifier A fixed name describing the type of light e.g. 'Extended color light'. 
 * @param name_lightname A unique, editable name given to the light. 
 * @param hardwaremodelidentifier The hardware model of the light. 
 * @param softwareversion An identifier for the software version running on the light. 
 */
public void onSuccess(Boolean state_onoffstate, Long brightness, Long hue, Long saturation, List<Object> ciecolor, Long colortemperature, String alerteffect, String effect, String colormode, Boolean accessibility, String lighttypeidentifier_typeidentifier, String name_lightname, String hardwaremodelidentifier, String softwareversion);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface SwitchLightResponseListener {
/**
 * 
 */
public void onSuccess();
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface SetBrightnessResponseListener {
/**
 * 
 */
public void onSuccess();
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface SetColorResponseListener {
/**
 * 
 */
public void onSuccess();
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface CreateANewTaskListResponseListener {
/**
 * 
 * @param id Task list identifier 
 * @param title Task list title 
 * @param updated Last update 
 */
public void onSuccess(String id, String title, String updated);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface CreateNewTaskOnTaskListResponseListener {
/**
 * 
 * @param updated Last update 
 * @param title Task title 
 * @param id Task identifier 
 */
public void onSuccess(String updated, String title, String id);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface DeleteATaskListResponseListener {
/**
 * 
 */
public void onSuccess();
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface DeleteTaskFromTaskListResponseListener {
/**
 * 
 */
public void onSuccess();
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetAllTaskListsResponseListener {
/**
 * 
 * @param list_tasklist The list of all task lists of the current user. 
 */
public void onSuccess(List<Object> list_tasklist);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetinformationabouttheuserResponseListener {
/**
 * 
 * @param list_work Details of a person`s work experience 
 * @param birthday The birthday date in the format DD/MM/YYYY 
 * @param name_hometown The name of the hometown 
 * @param name_location The name of the location 
 * @param list_education A list of the educational biography of the user 
 * @param agerange The age segment for this person expressed as a minimum and maximum age. For example, more than 18, less than 21. 
 * @param id_user The id of this person's user account. This ID is unique to each app and cannot be used across different apps. Our upgrade guide provides more information about app-specific IDs 
 * @param firstname The person's first name 
 * @param bio The person's bio 
 * @param lastname The person's last name 
 * @param list_data_pages A list of the pages the user likes 
 * @param list_friends A list of the friends as User nodes.  
 * @param gender The gender of the user 
 */
public void onSuccess(List<Object> list_work, String birthday, String name_hometown, String name_location, List<Object> list_education, Map<String, Object> agerange, String id_user, String firstname, String bio, String lastname, List<Object> list_data_pages, List<Object> list_friends, String gender);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetUserFeedResponseListener {
/**
 * 
 * @param feed An array of posts 
 */
public void onSuccess(List<Object> feed);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetusersfriendsResponseListener {
/**
 * 
 * @param list_friends A list of the friends of the user. 
 * @param totalcount The total count of friends 
 */
public void onSuccess(List<Object> list_friends, Long totalcount);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetLocationsKeyByTextResponseListener {
/**
 * 
 * @param results An array of search results 
 */
public void onSuccess(List<Object> results);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetDailyForecastResponseListener {
/**
 * 
 * @param default0 An array of daily forecast entries 
 */
public void onSuccess(List<Object> default0);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetCurrentConditionsResponseListener {
/**
 * 
 * @param results An array of condition entries 
 */
public void onSuccess(List<Object> results);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetDataByZipCodeResponseListener {
/**
 * 
 * @param longitude City geo location, longitude 
 * @param latitude City geo location, latitude 
 * @param temperature Current temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit 
 * @param pressure Atmospheric pressure, hPa 
 * @param humidity Humidity, % 
 * @param temperature_minimum Minimum temperature at the moment, might deviate from current for large areas 
 * @param temperature_maximum Maximum temperature at the moment, might deviate from current for large areas 
 * @param wind_speed Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour 
 * @param wind_direction Wind direction, degrees (meteorological) 
 * @param cloudiness Cloudiness, % 
 * @param cityname City name 
 * @param cityidentifier City ID 
 */
public void onSuccess(Double longitude, Double latitude, Double temperature, Double pressure, Long humidity, Double temperature_minimum, Double temperature_maximum, Double wind_speed, Double wind_direction, Long cloudiness, String cityname, Long cityidentifier);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

public interface GetDataByCityNameResponseListener {
/**
 * 
 * @param longitude City geo location, longitude 
 * @param latitude City geo location, latitude 
 * @param temperature Current temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit 
 * @param pressure Atmospheric pressure, hPa 
 * @param humidity Humidity, % 
 * @param temperature_minimum Minimum temperature at the moment, might deviate from current for large areas 
 * @param temperature_maximum Maximum temperature at the moment, might deviate from current for large areas 
 * @param wind_speed Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour 
 * @param wind_direction Wind direction, degrees (meteorological) 
 * @param cloudiness Cloudiness, % 
 * @param cityidentifier City ID 
 * @param cityname City name 
 */
public void onSuccess(Double longitude, Double latitude, Double temperature, Double pressure, Long humidity, Double temperature_minimum, Double temperature_maximum, Double wind_speed, Double wind_direction, Long cloudiness, Long cityidentifier, String cityname);
/**
 *
 * @param error This parameter contains the Exception in case one is thrown
 */
public void onError(CloudRailException error);
/**
 *
 * @param percentFinished This parameter contains the progress of the current operation in percent
 */
public void onProgress(double percentFinished);
}

}