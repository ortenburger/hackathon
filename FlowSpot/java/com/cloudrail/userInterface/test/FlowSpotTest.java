package com.cloudrail.userInterface.test;
import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cloudrail.auth.uriRedirect.HttpsServerRedirectListener;
import com.cloudrail.auth.uriView.LocalUriCaller;
import com.cloudrail.exception.CloudRailException;
import java.io.InputStream;
import com.cloudrail.userInterface.AccessTokenCallback;
import com.cloudrail.userInterface.Helper;
import com.cloudrail.userInterface.FlowSpot;
import com.cloudrail.userInterface.FlowSpot.GetDevicelistResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetMeasureResponseListener;
import com.cloudrail.userInterface.FlowSpot.CreateUserResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetAllLightsResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetLightAttributesAndStateResponseListener;
import com.cloudrail.userInterface.FlowSpot.SwitchLightResponseListener;
import com.cloudrail.userInterface.FlowSpot.SetBrightnessResponseListener;
import com.cloudrail.userInterface.FlowSpot.SetColorResponseListener;
import com.cloudrail.userInterface.FlowSpot.CreateANewTaskListResponseListener;
import com.cloudrail.userInterface.FlowSpot.CreateNewTaskOnTaskListResponseListener;
import com.cloudrail.userInterface.FlowSpot.DeleteATaskListResponseListener;
import com.cloudrail.userInterface.FlowSpot.DeleteTaskFromTaskListResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetAllTaskListsResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetinformationabouttheuserResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetUserFeedResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetusersfriendsResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetLocationsKeyByTextResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetDailyForecastResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetCurrentConditionsResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetDataByZipCodeResponseListener;
import com.cloudrail.userInterface.FlowSpot.GetDataByCityNameResponseListener;

public class FlowSpotTest {

private static FlowSpot ep;
private static final String philipshueapi_ipaddress = "Put Value Here!";
private static final String googletasks_clientidentifier = "Put Value Here!";
private static final String googletasks_redirecturi = "Put Value Here!";
private static final String googletasks_clientsecret = "Put Value Here!";
private static final String facebookgraphapi_clientidentifier = "Put Value Here!";
private static final String facebookgraphapi_uri = "Put Value Here!";
private static final String facebookgraphapi_scope = "Put Value Here!";
private static final String facebookgraphapi_clientsecret = "Put Value Here!";
private static final String facebookgraphapi_csrftoken = "Put Value Here!";
private static final String netatmoweatherstationapi_clientidentifier = "Put Value Here!";
private static final String netatmoweatherstationapi_uri = "Put Value Here!";
private static final String netatmoweatherstationapi_csrftoken = "Put Value Here!";
private static final String netatmoweatherstationapi_clientsecret = "Put Value Here!";
private static String googleTasksToken;
private static String facebookGraphAPIToken;
private static String netatmoWeatherstationAPIToken;
private final Results results = new Results();

@BeforeClass
public static void setUpBeforeClass() {
ep = new FlowSpot(philipshueapi_ipaddress,googletasks_clientidentifier,googletasks_redirecturi,googletasks_clientsecret,facebookgraphapi_clientidentifier,facebookgraphapi_uri,facebookgraphapi_scope,facebookgraphapi_clientsecret,facebookgraphapi_csrftoken,netatmoweatherstationapi_clientidentifier,netatmoweatherstationapi_uri,netatmoweatherstationapi_csrftoken,netatmoweatherstationapi_clientsecret);

final AtomicInteger ctr = new AtomicInteger();

ep.init_GoogleTasks_Auth(new LocalUriCaller(), new HttpsServerRedirectListener(Helper.getDummyContext(), 3433), new AccessTokenCallback() {

@Override
public void onToken(String arg0){
googleTasksToken = arg0;
ctr.incrementAndGet();
}
public void onError(CloudRailException err) {}
});

ep.init_FacebookGraphAPI_Auth(new LocalUriCaller(), new HttpsServerRedirectListener(Helper.getDummyContext(), 3433), new AccessTokenCallback() {

@Override
public void onToken(String arg0){
facebookGraphAPIToken = arg0;
ctr.incrementAndGet();
}
public void onError(CloudRailException err) {}
});

ep.init_NetatmoWeatherstationAPI_Auth(new LocalUriCaller(), new HttpsServerRedirectListener(Helper.getDummyContext(), 3433), new AccessTokenCallback() {

@Override
public void onToken(String arg0){
netatmoWeatherstationAPIToken = arg0;
ctr.incrementAndGet();
}
public void onError(CloudRailException err) {}
});

ep.start_GoogleTasks_Auth();

while(ctr.get() == 0) ;

ctr.decrementAndGet();
ep.start_FacebookGraphAPI_Auth();

while(ctr.get() == 0) ;

ctr.decrementAndGet();
ep.start_NetatmoWeatherstationAPI_Auth();

while(ctr.get() == 0) ;

}

private void getDevicelist(String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getDevicelist(accesstoken, new GetDevicelistResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String status, List<Object> device_list) {
results.status = status;
results.device_list = device_list;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getDevicelist()!");
}

}

private void getMeasure(String accesstoken, String identifier){
final AtomicInteger ctr = new AtomicInteger();

ep.getMeasure(accesstoken, identifier, new GetMeasureResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> list_measure, String status) {
results.list_measure = list_measure;
results.status = status;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getMeasure()!");
}

}

private void createUser(String devicetype){
final AtomicInteger ctr = new AtomicInteger();

ep.createUser(devicetype, new CreateUserResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess() {
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in createUser()!");
}

}

private void getAllLights(String username){
final AtomicInteger ctr = new AtomicInteger();

ep.getAllLights(username, new GetAllLightsResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> list_identifier) {
results.list_identifier = list_identifier;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getAllLights()!");
}

}

private void getLightAttributesAndState(String username, String lightidentifier){
final AtomicInteger ctr = new AtomicInteger();

ep.getLightAttributesAndState(username, lightidentifier, new GetLightAttributesAndStateResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(Boolean state_onoffstate, Long brightness, Long hue, Long saturation, List<Object> ciecolor, Long colortemperature, String alerteffect, String effect, String colormode, Boolean accessibility, String lighttypeidentifier_typeidentifier, String name_lightname, String hardwaremodelidentifier, String softwareversion) {
results.state_onoffstate = state_onoffstate;
results.brightness = brightness;
results.hue = hue;
results.saturation = saturation;
results.ciecolor = ciecolor;
results.colortemperature = colortemperature;
results.alerteffect = alerteffect;
results.effect = effect;
results.colormode = colormode;
results.accessibility = accessibility;
results.lighttypeidentifier_typeidentifier = lighttypeidentifier_typeidentifier;
results.name_lightname = name_lightname;
results.hardwaremodelidentifier = hardwaremodelidentifier;
results.softwareversion = softwareversion;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getLightAttributesAndState()!");
}

}

private void switchLight(Boolean state_onoffstate, String username, String lightidentifier){
final AtomicInteger ctr = new AtomicInteger();

ep.switchLight(state_onoffstate, username, lightidentifier, new SwitchLightResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess() {
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in switchLight()!");
}

}

private void setBrightness(Long brightness, String username, String lightidentifier){
final AtomicInteger ctr = new AtomicInteger();

ep.setBrightness(brightness, username, lightidentifier, new SetBrightnessResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess() {
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in setBrightness()!");
}

}

private void setColor(List<Object> ciecolor, String username, String lightidentifier){
final AtomicInteger ctr = new AtomicInteger();

ep.setColor(ciecolor, username, lightidentifier, new SetColorResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess() {
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in setColor()!");
}

}

private void createANewTaskList(String title, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.createANewTaskList(title, accesstoken, new CreateANewTaskListResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String id, String title, String updated) {
results.id = id;
results.title = title;
results.updated = updated;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in createANewTaskList()!");
}

}

private void createNewTaskOnTaskList(String title, String tasklistidentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.createNewTaskOnTaskList(title, tasklistidentifier, accesstoken, new CreateNewTaskOnTaskListResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String updated, String title, String id) {
results.updated = updated;
results.title = title;
results.id = id;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in createNewTaskOnTaskList()!");
}

}

private void deleteATaskList(String tasklistidentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.deleteATaskList(tasklistidentifier, accesstoken, new DeleteATaskListResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess() {
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in deleteATaskList()!");
}

}

private void deleteTaskFromTaskList(String tasklistidentifier, String taskidentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.deleteTaskFromTaskList(tasklistidentifier, taskidentifier, accesstoken, new DeleteTaskFromTaskListResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess() {
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in deleteTaskFromTaskList()!");
}

}

private void getAllTaskLists(String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getAllTaskLists(accesstoken, new GetAllTaskListsResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> list_tasklist) {
results.list_tasklist = list_tasklist;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getAllTaskLists()!");
}

}

private void getinformationabouttheuser(String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getinformationabouttheuser(accesstoken, new GetinformationabouttheuserResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> list_work, String birthday, String name_hometown, String name_location, List<Object> list_education, Map<String, Object> agerange, String id_user, String firstname, String bio, String lastname, List<Object> list_data_pages, List<Object> list_friends, String gender) {
results.list_work = list_work;
results.birthday = birthday;
results.name_hometown = name_hometown;
results.name_location = name_location;
results.list_education = list_education;
results.agerange = agerange;
results.id_user = id_user;
results.firstname = firstname;
results.bio = bio;
results.lastname = lastname;
results.list_data_pages = list_data_pages;
results.list_friends = list_friends;
results.gender = gender;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getinformationabouttheuser()!");
}

}

private void getUserFeed(String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getUserFeed(accesstoken, new GetUserFeedResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> feed) {
results.feed = feed;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getUserFeed()!");
}

}

private void getusersfriends(String useridentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getusersfriends(useridentifier, accesstoken, new GetusersfriendsResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> list_friends, Long totalcount) {
results.list_friends = list_friends;
results.totalcount = totalcount;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getusersfriends()!");
}

}

private void getLocationsKeyByText(String countryidentifier, String searchquery, String apikey){
final AtomicInteger ctr = new AtomicInteger();

ep.getLocationsKeyByText(countryidentifier, searchquery, apikey, new GetLocationsKeyByTextResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> results) {
results.results = results;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getLocationsKeyByText()!");
}

}

private void getDailyForecast(String apikey, String forecasttime, Long locationidentifier){
final AtomicInteger ctr = new AtomicInteger();

ep.getDailyForecast(apikey, forecasttime, locationidentifier, new GetDailyForecastResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> default0) {
results.default0 = default0;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getDailyForecast()!");
}

}

private void getCurrentConditions(Long locationidentifier, String apikey){
final AtomicInteger ctr = new AtomicInteger();

ep.getCurrentConditions(locationidentifier, apikey, new GetCurrentConditionsResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> results) {
results.results = results;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getCurrentConditions()!");
}

}

private void getDataByZipCode(String countrycode, String apikey, String zipcode){
final AtomicInteger ctr = new AtomicInteger();

ep.getDataByZipCode(countrycode, apikey, zipcode, new GetDataByZipCodeResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(Double longitude, Double latitude, Double temperature, Double pressure, Long humidity, Double temperature_minimum, Double temperature_maximum, Double wind_speed, Double wind_direction, Long cloudiness, String cityname, Long cityidentifier) {
results.longitude = longitude;
results.latitude = latitude;
results.temperature = temperature;
results.pressure = pressure;
results.humidity = humidity;
results.temperature_minimum = temperature_minimum;
results.temperature_maximum = temperature_maximum;
results.wind_speed = wind_speed;
results.wind_direction = wind_direction;
results.cloudiness = cloudiness;
results.cityname = cityname;
results.cityidentifier = cityidentifier;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getDataByZipCode()!");
}

}

private void getDataByCityName(String cityname, String apikey){
final AtomicInteger ctr = new AtomicInteger();

ep.getDataByCityName(cityname, apikey, new GetDataByCityNameResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(Double longitude, Double latitude, Double temperature, Double pressure, Long humidity, Double temperature_minimum, Double temperature_maximum, Double wind_speed, Double wind_direction, Long cloudiness, Long cityidentifier, String cityname) {
results.longitude = longitude;
results.latitude = latitude;
results.temperature = temperature;
results.pressure = pressure;
results.humidity = humidity;
results.temperature_minimum = temperature_minimum;
results.temperature_maximum = temperature_maximum;
results.wind_speed = wind_speed;
results.wind_direction = wind_direction;
results.cloudiness = cloudiness;
results.cityidentifier = cityidentifier;
results.cityname = cityname;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getDataByCityName()!");
}

}

@Test
public void testGetDevicelist() {
String accesstoken = "Hello World";

System.out.println("Test Get Devicelist:");

getDevicelist(accesstoken);

System.out.println("Status: " + results.status);
System.out.println("Device_list: " + results.device_list);
System.out.println();

assertTrue(true);
}

@Test
public void testGetMeasure() {
String accesstoken = "Hello World";
String identifier = "Hello World";

System.out.println("Test Get Measure:");

getMeasure(accesstoken, identifier);

System.out.println("List_measure: " + results.list_measure);
System.out.println("Status: " + results.status);
System.out.println();

assertTrue(true);
}

@Test
public void testCreateUser() {
String devicetype = "Hello World";

System.out.println("Test Create User:");

createUser(devicetype);

assertTrue(true);
}

@Test
public void testGetAllLights() {
String username = "Hello World";

System.out.println("Test Get All Lights:");

getAllLights(username);

System.out.println("List_identifier: " + results.list_identifier);
System.out.println();

assertTrue(true);
}

@Test
public void testGetLightAttributesAndState() {
String username = "Hello World";
String lightidentifier = "Hello World";

System.out.println("Test Get Light Attributes And State:");

getLightAttributesAndState(username, lightidentifier);

System.out.println("State_onoffstate: " + results.state_onoffstate);
System.out.println("Brightness: " + results.brightness);
System.out.println("Hue: " + results.hue);
System.out.println("Saturation: " + results.saturation);
System.out.println("Ciecolor: " + results.ciecolor);
System.out.println("Colortemperature: " + results.colortemperature);
System.out.println("Alerteffect: " + results.alerteffect);
System.out.println("Effect: " + results.effect);
System.out.println("Colormode: " + results.colormode);
System.out.println("Accessibility: " + results.accessibility);
System.out.println("Lighttypeidentifier_typeidentifier: " + results.lighttypeidentifier_typeidentifier);
System.out.println("Name_lightname: " + results.name_lightname);
System.out.println("Hardwaremodelidentifier: " + results.hardwaremodelidentifier);
System.out.println("Softwareversion: " + results.softwareversion);
System.out.println();

assertTrue(true);
}

@Test
public void testSwitchLight() {
Boolean state_onoffstate = true;
String username = "Hello World";
String lightidentifier = "Hello World";

System.out.println("Test Switch Light:");

switchLight(state_onoffstate, username, lightidentifier);

assertTrue(true);
}

@Test
public void testSetBrightness() {
Long brightness = new Long(12345);
String username = "Hello World";
String lightidentifier = "Hello World";

System.out.println("Test Set Brightness:");

setBrightness(brightness, username, lightidentifier);

assertTrue(true);
}

@Test
public void testSetColor() {
List<Object> ciecolor = new ArrayList<Object>();
String username = "Hello World";
String lightidentifier = "Hello World";

System.out.println("Test Set Color:");

setColor(ciecolor, username, lightidentifier);

assertTrue(true);
}

@Test
public void testCreateANewTaskList() {
String title = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Create A New Task List:");

createANewTaskList(title, accesstoken);

System.out.println("Id: " + results.id);
System.out.println("Title: " + results.title);
System.out.println("Updated: " + results.updated);
System.out.println();

assertTrue(true);
}

@Test
public void testCreateNewTaskOnTaskList() {
String title = "Hello World";
String tasklistidentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Create New Task On Task List:");

createNewTaskOnTaskList(title, tasklistidentifier, accesstoken);

System.out.println("Updated: " + results.updated);
System.out.println("Title: " + results.title);
System.out.println("Id: " + results.id);
System.out.println();

assertTrue(true);
}

@Test
public void testDeleteATaskList() {
String tasklistidentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Delete A Task List:");

deleteATaskList(tasklistidentifier, accesstoken);

assertTrue(true);
}

@Test
public void testDeleteTaskFromTaskList() {
String tasklistidentifier = "Hello World";
String taskidentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Delete Task From Task List:");

deleteTaskFromTaskList(tasklistidentifier, taskidentifier, accesstoken);

assertTrue(true);
}

@Test
public void testGetAllTaskLists() {
String accesstoken = "Hello World";

System.out.println("Test Get All Task Lists:");

getAllTaskLists(accesstoken);

System.out.println("List_tasklist: " + results.list_tasklist);
System.out.println();

assertTrue(true);
}

@Test
public void testGetinformationabouttheuser() {
String accesstoken = "Hello World";

System.out.println("Test Get information about the user:");

getinformationabouttheuser(accesstoken);

System.out.println("List_work: " + results.list_work);
System.out.println("Birthday: " + results.birthday);
System.out.println("Name_hometown: " + results.name_hometown);
System.out.println("Name_location: " + results.name_location);
System.out.println("List_education: " + results.list_education);
System.out.println("Agerange: " + results.agerange);
System.out.println("Id_user: " + results.id_user);
System.out.println("Firstname: " + results.firstname);
System.out.println("Bio: " + results.bio);
System.out.println("Lastname: " + results.lastname);
System.out.println("List_data_pages: " + results.list_data_pages);
System.out.println("List_friends: " + results.list_friends);
System.out.println("Gender: " + results.gender);
System.out.println();

assertTrue(true);
}

@Test
public void testGetUserFeed() {
String accesstoken = "Hello World";

System.out.println("Test Get User Feed:");

getUserFeed(accesstoken);

System.out.println("Feed: " + results.feed);
System.out.println();

assertTrue(true);
}

@Test
public void testGetusersfriends() {
String useridentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Get users friends:");

getusersfriends(useridentifier, accesstoken);

System.out.println("List_friends: " + results.list_friends);
System.out.println("Totalcount: " + results.totalcount);
System.out.println();

assertTrue(true);
}

@Test
public void testGetLocationsKeyByText() {
String countryidentifier = "Hello World";
String searchquery = "Hello World";
String apikey = "Hello World";

System.out.println("Test GetLocationsKeyByText:");

getLocationsKeyByText(countryidentifier, searchquery, apikey);

System.out.println("Results: " + results.results);
System.out.println();

assertTrue(true);
}

@Test
public void testGetDailyForecast() {
String apikey = "Hello World";
String forecasttime = "Hello World";
Long locationidentifier = new Long(12345);

System.out.println("Test GetDailyForecast:");

getDailyForecast(apikey, forecasttime, locationidentifier);

System.out.println("Default0: " + results.default0);
System.out.println();

assertTrue(true);
}

@Test
public void testGetCurrentConditions() {
Long locationidentifier = new Long(12345);
String apikey = "Hello World";

System.out.println("Test GetCurrentConditions:");

getCurrentConditions(locationidentifier, apikey);

System.out.println("Results: " + results.results);
System.out.println();

assertTrue(true);
}

@Test
public void testGetDataByZipCode() {
String countrycode = "Hello World";
String apikey = "Hello World";
String zipcode = "Hello World";

System.out.println("Test Get Data By ZipCode:");

getDataByZipCode(countrycode, apikey, zipcode);

System.out.println("Longitude: " + results.longitude);
System.out.println("Latitude: " + results.latitude);
System.out.println("Temperature: " + results.temperature);
System.out.println("Pressure: " + results.pressure);
System.out.println("Humidity: " + results.humidity);
System.out.println("Temperature_minimum: " + results.temperature_minimum);
System.out.println("Temperature_maximum: " + results.temperature_maximum);
System.out.println("Wind_speed: " + results.wind_speed);
System.out.println("Wind_direction: " + results.wind_direction);
System.out.println("Cloudiness: " + results.cloudiness);
System.out.println("Cityname: " + results.cityname);
System.out.println("Cityidentifier: " + results.cityidentifier);
System.out.println();

assertTrue(true);
}

@Test
public void testGetDataByCityName() {
String cityname = "Hello World";
String apikey = "Hello World";

System.out.println("Test Get DataBy City Name:");

getDataByCityName(cityname, apikey);

System.out.println("Longitude: " + results.longitude);
System.out.println("Latitude: " + results.latitude);
System.out.println("Temperature: " + results.temperature);
System.out.println("Pressure: " + results.pressure);
System.out.println("Humidity: " + results.humidity);
System.out.println("Temperature_minimum: " + results.temperature_minimum);
System.out.println("Temperature_maximum: " + results.temperature_maximum);
System.out.println("Wind_speed: " + results.wind_speed);
System.out.println("Wind_direction: " + results.wind_direction);
System.out.println("Cloudiness: " + results.cloudiness);
System.out.println("Cityidentifier: " + results.cityidentifier);
System.out.println("Cityname: " + results.cityname);
System.out.println();

assertTrue(true);
}

private class Results {

public String status;
public List<Object> device_list;
public List<Object> list_measure;
public List<Object> list_identifier;
public Boolean state_onoffstate;
public Long brightness;
public Long hue;
public Long saturation;
public List<Object> ciecolor;
public Long colortemperature;
public String alerteffect;
public String effect;
public String colormode;
public Boolean accessibility;
public String lighttypeidentifier_typeidentifier;
public String name_lightname;
public String hardwaremodelidentifier;
public String softwareversion;
public String id;
public String title;
public String updated;
public List<Object> list_tasklist;
public List<Object> list_work;
public String birthday;
public String name_hometown;
public String name_location;
public List<Object> list_education;
public Map<String, Object> agerange;
public String id_user;
public String firstname;
public String bio;
public String lastname;
public List<Object> list_data_pages;
public List<Object> list_friends;
public String gender;
public List<Object> feed;
public Long totalcount;
public List<Object> results;
public List<Object> default0;
public Double longitude;
public Double latitude;
public Double temperature;
public Double pressure;
public Long humidity;
public Double temperature_minimum;
public Double temperature_maximum;
public Double wind_speed;
public Double wind_direction;
public Long cloudiness;
public String cityname;
public Long cityidentifier;

}
}
