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
import com.cloudrail.userInterface.Hackathon;
import com.cloudrail.userInterface.Hackathon.AddTracksToAPlaylistResponseListener;
import com.cloudrail.userInterface.Hackathon.CreatePlaylistResponseListener;
import com.cloudrail.userInterface.Hackathon.FollowAPlaylistResponseListener;
import com.cloudrail.userInterface.Hackathon.GetAPlaylistResponseListener;
import com.cloudrail.userInterface.Hackathon.GetATrackResponseListener;
import com.cloudrail.userInterface.Hackathon.GetListOfPlaylistsOfAUserResponseListener;
import com.cloudrail.userInterface.Hackathon.GetPlaylistByIdResponseListener;
import com.cloudrail.userInterface.Hackathon.GetUserDataResponseListener;
import com.cloudrail.userInterface.Hackathon.RemoveTracksFromAPlaylistResponseListener;
import com.cloudrail.userInterface.Hackathon.SearchForAPlaylistResponseListener;
import com.cloudrail.userInterface.Hackathon.SearchforartistsResponseListener;
import com.cloudrail.userInterface.Hackathon.SearchfortrackResponseListener;
import com.cloudrail.userInterface.Hackathon.ReadMeResponseListener;
import com.cloudrail.userInterface.Hackathon.ReadAppMetadataResponseListener;
import com.cloudrail.userInterface.Hackathon.GetVideosListResponseListener;
import com.cloudrail.userInterface.Hackathon.AddACommentResponseListener;
import com.cloudrail.userInterface.Hackathon.GetCommentsResponseListener;
import com.cloudrail.userInterface.Hackathon.GetPlaylistsResponseListener;
import com.cloudrail.userInterface.Hackathon.SubscribeAChannelResponseListener;
import com.cloudrail.userInterface.Hackathon.GetDevicelistResponseListener;
import com.cloudrail.userInterface.Hackathon.GetMeasureResponseListener;
import com.cloudrail.userInterface.Hackathon.CreateUserResponseListener;
import com.cloudrail.userInterface.Hackathon.GetAllLightsResponseListener;
import com.cloudrail.userInterface.Hackathon.GetLightAttributesAndStateResponseListener;
import com.cloudrail.userInterface.Hackathon.SwitchLightResponseListener;
import com.cloudrail.userInterface.Hackathon.SetBrightnessResponseListener;
import com.cloudrail.userInterface.Hackathon.SetColorResponseListener;
import com.cloudrail.userInterface.Hackathon.ContinuewithFolderContentResponseListener;
import com.cloudrail.userInterface.Hackathon.CopyFileOrFolderResponseListener;
import com.cloudrail.userInterface.Hackathon.CreateFolderResponseListener;
import com.cloudrail.userInterface.Hackathon.DeleteFileOrFolderResponseListener;
import com.cloudrail.userInterface.Hackathon.GetAccountInfoResponseListener;
import com.cloudrail.userInterface.Hackathon.GetFolderContentResponseListener;
import com.cloudrail.userInterface.Hackathon.GetMetadataResponseListener;
import com.cloudrail.userInterface.Hackathon.GetSpaceUsageResponseListener;
import com.cloudrail.userInterface.Hackathon.MoveFileOrFolderResponseListener;
import com.cloudrail.userInterface.Hackathon.CreateANewTaskListResponseListener;
import com.cloudrail.userInterface.Hackathon.CreateNewTaskOnTaskListResponseListener;
import com.cloudrail.userInterface.Hackathon.DeleteATaskListResponseListener;
import com.cloudrail.userInterface.Hackathon.DeleteTaskFromTaskListResponseListener;
import com.cloudrail.userInterface.Hackathon.GetAllTaskListsResponseListener;
import com.cloudrail.userInterface.Hackathon.GetinformationabouttheuserResponseListener;
import com.cloudrail.userInterface.Hackathon.GetUserFeedResponseListener;
import com.cloudrail.userInterface.Hackathon.GetusersfriendsResponseListener;

public class HackathonTest {

private static Hackathon ep;
private static final String philipshueapi_ipaddress = "Put Value Here!";
private static final String spotifywebapi_clientidentifier = "Put Value Here!";
private static final String spotifywebapi_redirecturi = "Put Value Here!";
private static final String spotifywebapi_state = "Put Value Here!";
private static final String spotifywebapi_scope = "Put Value Here!";
private static final String spotifywebapi_clientsecret = "Put Value Here!";
private static final String youtubeapi_clientidentifier = "Put Value Here!";
private static final String youtubeapi_clientsecret = "Put Value Here!";
private static final String youtubeapi_redirecturi = "Put Value Here!";
private static final String youtubeapi_csrftoken = "Put Value Here!";
private static final String dropboxapiv2_csrftoken = "Put Value Here!";
private static final String dropboxapiv2_clientsecret = "Put Value Here!";
private static final String dropboxapiv2_redirecturi = "Put Value Here!";
private static final String dropboxapiv2_clientidentifier = "Put Value Here!";
private static final String googletasks_clientidentifier = "Put Value Here!";
private static final String googletasks_redirecturi = "Put Value Here!";
private static final String googletasks_clientsecret = "Put Value Here!";
private static final String facebookgraphapi_clientidentifier = "Put Value Here!";
private static final String facebookgraphapi_uri = "Put Value Here!";
private static final String facebookgraphapi_scope = "Put Value Here!";
private static final String facebookgraphapi_clientsecret = "Put Value Here!";
private static final String facebookgraphapi_csrftoken = "Put Value Here!";
private static final String soundcloudapi_clientidentifier = "Put Value Here!";
private static final String soundcloudapi_redirecturi = "Put Value Here!";
private static final String soundcloudapi_csrftoken = "Put Value Here!";
private static final String soundcloudapi_clientsecret = "Put Value Here!";
private static final String netatmoweatherstationapi_clientidentifier = "Put Value Here!";
private static final String netatmoweatherstationapi_uri = "Put Value Here!";
private static final String netatmoweatherstationapi_csrftoken = "Put Value Here!";
private static final String netatmoweatherstationapi_clientsecret = "Put Value Here!";
private static String spotifyWebAPIToken;
private static String youtubeAPIToken;
private static String dropboxAPIv2Token;
private static String googleTasksToken;
private static String facebookGraphAPIToken;
private static String soundcloudAPIToken;
private static String netatmoWeatherstationAPIToken;
private final Results results = new Results();

@BeforeClass
public static void setUpBeforeClass() {
ep = new Hackathon(philipshueapi_ipaddress,spotifywebapi_clientidentifier,spotifywebapi_redirecturi,spotifywebapi_state,spotifywebapi_scope,spotifywebapi_clientsecret,youtubeapi_clientidentifier,youtubeapi_clientsecret,youtubeapi_redirecturi,youtubeapi_csrftoken,dropboxapiv2_csrftoken,dropboxapiv2_clientsecret,dropboxapiv2_redirecturi,dropboxapiv2_clientidentifier,googletasks_clientidentifier,googletasks_redirecturi,googletasks_clientsecret,facebookgraphapi_clientidentifier,facebookgraphapi_uri,facebookgraphapi_scope,facebookgraphapi_clientsecret,facebookgraphapi_csrftoken,soundcloudapi_clientidentifier,soundcloudapi_redirecturi,soundcloudapi_csrftoken,soundcloudapi_clientsecret,netatmoweatherstationapi_clientidentifier,netatmoweatherstationapi_uri,netatmoweatherstationapi_csrftoken,netatmoweatherstationapi_clientsecret);

final AtomicInteger ctr = new AtomicInteger();

ep.init_SpotifyWebAPI_Auth(new LocalUriCaller(), new HttpsServerRedirectListener(Helper.getDummyContext(), 3433), new AccessTokenCallback() {

@Override
public void onToken(String arg0){
spotifyWebAPIToken = arg0;
ctr.incrementAndGet();
}
public void onError(CloudRailException err) {}
});

ep.init_YoutubeAPI_Auth(new LocalUriCaller(), new HttpsServerRedirectListener(Helper.getDummyContext(), 3433), new AccessTokenCallback() {

@Override
public void onToken(String arg0){
youtubeAPIToken = arg0;
ctr.incrementAndGet();
}
public void onError(CloudRailException err) {}
});

ep.init_DropboxAPIv2_Auth(new LocalUriCaller(), new HttpsServerRedirectListener(Helper.getDummyContext(), 3433), new AccessTokenCallback() {

@Override
public void onToken(String arg0){
dropboxAPIv2Token = arg0;
ctr.incrementAndGet();
}
public void onError(CloudRailException err) {}
});

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

ep.init_SoundcloudAPI_Auth(new LocalUriCaller(), new HttpsServerRedirectListener(Helper.getDummyContext(), 3433), new AccessTokenCallback() {

@Override
public void onToken(String arg0){
soundcloudAPIToken = arg0;
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

ep.start_SpotifyWebAPI_Auth();

while(ctr.get() == 0) ;

ctr.decrementAndGet();
ep.start_YoutubeAPI_Auth();

while(ctr.get() == 0) ;

ctr.decrementAndGet();
ep.start_DropboxAPIv2_Auth();

while(ctr.get() == 0) ;

ctr.decrementAndGet();
ep.start_GoogleTasks_Auth();

while(ctr.get() == 0) ;

ctr.decrementAndGet();
ep.start_FacebookGraphAPI_Auth();

while(ctr.get() == 0) ;

ctr.decrementAndGet();
ep.start_SoundcloudAPI_Auth();

while(ctr.get() == 0) ;

ctr.decrementAndGet();
ep.start_NetatmoWeatherstationAPI_Auth();

while(ctr.get() == 0) ;

}

private void addTracksToAPlaylist(List<Object> uri_list, String useridentifier, String playlistidentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.addTracksToAPlaylist(uri_list, useridentifier, playlistidentifier, accesstoken, new AddTracksToAPlaylistResponseListener(){

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
fail("Error in addTracksToAPlaylist()!");
}

}

private void createPlaylist(String playlistname, Boolean publicstatus, String useridentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.createPlaylist(playlistname, publicstatus, useridentifier, accesstoken, new CreatePlaylistResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String playlistid, String spotifyurlplaylist) {
results.playlistid = playlistid;
results.spotifyurlplaylist = spotifyurlplaylist;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in createPlaylist()!");
}

}

private void followAPlaylist(Boolean visibility, String playlistidentifier, String owneridentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.followAPlaylist(visibility, playlistidentifier, owneridentifier, accesstoken, new FollowAPlaylistResponseListener(){

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
fail("Error in followAPlaylist()!");
}

}

private void getAPlaylist(String playlistidentifier, String owneridentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getAPlaylist(playlistidentifier, owneridentifier, accesstoken, new GetAPlaylistResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String playlistid, Long numberoffollowers, String spotifyurlplaylist, Boolean collaborative, String description, String playlistname, String ownerid, String spotifyurlowner, String usertype, Long numberoftracks, Long limit, List<Object> track_list, Boolean publicstatus) {
results.playlistid = playlistid;
results.numberoffollowers = numberoffollowers;
results.spotifyurlplaylist = spotifyurlplaylist;
results.collaborative = collaborative;
results.description = description;
results.playlistname = playlistname;
results.ownerid = ownerid;
results.spotifyurlowner = spotifyurlowner;
results.usertype = usertype;
results.numberoftracks = numberoftracks;
results.limit = limit;
results.track_list = track_list;
results.publicstatus = publicstatus;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getAPlaylist()!");
}

}

private void getATrack(String trackidentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getATrack(trackidentifier, accesstoken, new GetATrackResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String trackid, List<Object> artist_list, String spotifyurltrack, Long discnumber, List<Object> list_availablemarket, Boolean explicit, String previewurl, String trackname, String albumid, String spotifyurlalbum, String albumname, String albumtype, Long durationms, Long popularity, String trackuri) {
results.trackid = trackid;
results.artist_list = artist_list;
results.spotifyurltrack = spotifyurltrack;
results.discnumber = discnumber;
results.list_availablemarket = list_availablemarket;
results.explicit = explicit;
results.previewurl = previewurl;
results.trackname = trackname;
results.albumid = albumid;
results.spotifyurlalbum = spotifyurlalbum;
results.albumname = albumname;
results.albumtype = albumtype;
results.durationms = durationms;
results.popularity = popularity;
results.trackuri = trackuri;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getATrack()!");
}

}

private void getListOfPlaylistsOfAUser(String useridentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getListOfPlaylistsOfAUser(useridentifier, accesstoken, new GetListOfPlaylistsOfAUserResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(Long totalnumberofplaylists, Long limit, List<Object> playlist_list) {
results.totalnumberofplaylists = totalnumberofplaylists;
results.limit = limit;
results.playlist_list = playlist_list;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getListOfPlaylistsOfAUser()!");
}

}

private void getPlaylistById(String useridentifier, String playlistidentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getPlaylistById(useridentifier, playlistidentifier, accesstoken, new GetPlaylistByIdResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String url, String description, String name) {
results.url = url;
results.description = description;
results.name = name;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getPlaylistById()!");
}

}

private void getUserData(String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getUserData(accesstoken, new GetUserDataResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String date_birthdate, String country, String name, String email, String identifier, String product) {
results.date_birthdate = date_birthdate;
results.country = country;
results.name = name;
results.email = email;
results.identifier = identifier;
results.product = product;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getUserData()!");
}

}

private void removeTracksFromAPlaylist(List<Object> track_list, String owneridentifier, String playlistidentifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.removeTracksFromAPlaylist(track_list, owneridentifier, playlistidentifier, accesstoken, new RemoveTracksFromAPlaylistResponseListener(){

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
fail("Error in removeTracksFromAPlaylist()!");
}

}

private void searchForAPlaylist(String accesstoken, String searchquery){
final AtomicInteger ctr = new AtomicInteger();

ep.searchForAPlaylist(accesstoken, searchquery, new SearchForAPlaylistResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(Long playlistsnumber, Long limit, List<Object> playlist_list) {
results.playlistsnumber = playlistsnumber;
results.limit = limit;
results.playlist_list = playlist_list;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in searchForAPlaylist()!");
}

}

private void searchforartists(String searchquery, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.searchforartists(searchquery, accesstoken, new SearchforartistsResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> items_list) {
results.items_list = items_list;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in searchforartists()!");
}

}

private void searchfortrack(String searchquery, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.searchfortrack(searchquery, accesstoken, new SearchfortrackResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> list_items) {
results.list_items = list_items;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in searchfortrack()!");
}

}

private void readMe(String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.readMe(accesstoken, new ReadMeResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String description, String country_location, String city_location, String fullname_name, String username_name) {
results.description = description;
results.country_location = country_location;
results.city_location = city_location;
results.fullname_name = fullname_name;
results.username_name = username_name;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in readMe()!");
}

}

private void readAppMetadata(String identifier_appidentifier){
final AtomicInteger ctr = new AtomicInteger();

ep.readAppMetadata(identifier_appidentifier, new ReadAppMetadataResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String appname_name, String creator) {
results.appname_name = appname_name;
results.creator = creator;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in readAppMetadata()!");
}

}

private void getVideosList(String videoids, String accesstoken, String part){
final AtomicInteger ctr = new AtomicInteger();

ep.getVideosList(videoids, accesstoken, part, new GetVideosListResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> videoList) {
results.videoList = videoList;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getVideosList()!");
}

}

private void addAComment(String textoriginal, String parentid, String accesstoken, String part){
final AtomicInteger ctr = new AtomicInteger();

ep.addAComment(textoriginal, parentid, accesstoken, part, new AddACommentResponseListener(){

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
fail("Error in addAComment()!");
}

}

private void getComments(String accesstoken, String part){
final AtomicInteger ctr = new AtomicInteger();

ep.getComments(accesstoken, part, new GetCommentsResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> comments) {
results.comments = comments;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getComments()!");
}

}

private void getPlaylists(String accesstoken, String part){
final AtomicInteger ctr = new AtomicInteger();

ep.getPlaylists(accesstoken, part, new GetPlaylistsResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> playlists) {
results.playlists = playlists;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getPlaylists()!");
}

}

private void subscribeAChannel(String kind, String channelid, String part, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.subscribeAChannel(kind, channelid, part, accesstoken, new SubscribeAChannelResponseListener(){

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
fail("Error in subscribeAChannel()!");
}

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

private void continuewithFolderContent(String cursorposition, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.continuewithFolderContent(cursorposition, accesstoken, new ContinuewithFolderContentResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> content, String cursorposition, Boolean hasmoreentries) {
results.content = content;
results.cursorposition = cursorposition;
results.hasmoreentries = hasmoreentries;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in continuewithFolderContent()!");
}

}

private void copyFileOrFolder(String path_source, String path_destination, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.copyFileOrFolder(path_source, path_destination, accesstoken, new CopyFileOrFolderResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String name, String path, String timestamp_modificationdate, String revision, Long size, String identifier) {
results.name = name;
results.path = path;
results.timestamp_modificationdate = timestamp_modificationdate;
results.revision = revision;
results.size = size;
results.identifier = identifier;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in copyFileOrFolder()!");
}

}

private void createFolder(String path_identifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.createFolder(path_identifier, accesstoken, new CreateFolderResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String name, String path, String timestamp_modificationdate, String revision, Long size, String identifier) {
results.name = name;
results.path = path;
results.timestamp_modificationdate = timestamp_modificationdate;
results.revision = revision;
results.size = size;
results.identifier = identifier;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in createFolder()!");
}

}

private void deleteFileOrFolder(String path_identifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.deleteFileOrFolder(path_identifier, accesstoken, new DeleteFileOrFolderResponseListener(){

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
fail("Error in deleteFileOrFolder()!");
}

}

private void getAccountInfo(String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getAccountInfo(accesstoken, new GetAccountInfoResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String accountidentifier, String firstname, String lastname, String username, String countryidentifier) {
results.accountidentifier = accountidentifier;
results.firstname = firstname;
results.lastname = lastname;
results.username = username;
results.countryidentifier = countryidentifier;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getAccountInfo()!");
}

}

private void getFolderContent(String path_identifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getFolderContent(path_identifier, accesstoken, new GetFolderContentResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(List<Object> content, String cursorposition, Boolean hasmoreentries) {
results.content = content;
results.cursorposition = cursorposition;
results.hasmoreentries = hasmoreentries;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getFolderContent()!");
}

}

private void getMetadata(String path_identifier, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getMetadata(path_identifier, accesstoken, new GetMetadataResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String name, String path, String timestamp_modificationdate, String revision, Long size, String identifier) {
results.name = name;
results.path = path;
results.timestamp_modificationdate = timestamp_modificationdate;
results.revision = revision;
results.size = size;
results.identifier = identifier;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getMetadata()!");
}

}

private void getSpaceUsage(String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.getSpaceUsage(accesstoken, new GetSpaceUsageResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(Long usedquota, Long totalquota) {
results.usedquota = usedquota;
results.totalquota = totalquota;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in getSpaceUsage()!");
}

}

private void moveFileOrFolder(String path_source, String path_destination, String accesstoken){
final AtomicInteger ctr = new AtomicInteger();

ep.moveFileOrFolder(path_source, path_destination, accesstoken, new MoveFileOrFolderResponseListener(){

@Override
public void onError(CloudRailException err) {
ctr.decrementAndGet();
err.printStackTrace();
}

@Override
public void onProgress(double percentFinished) {}

@Override
public void onSuccess(String name, String path, String timestamp_modificationdate, String revision, Long size, String identifier) {
results.name = name;
results.path = path;
results.timestamp_modificationdate = timestamp_modificationdate;
results.revision = revision;
results.size = size;
results.identifier = identifier;
ctr.incrementAndGet();
}

});

while(ctr.get() == 0) ;
if(ctr.get() < 0) {
fail("Error in moveFileOrFolder()!");
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

@Test
public void testAddTracksToAPlaylist() {
List<Object> uri_list = new ArrayList<Object>();
String useridentifier = "Hello World";
String playlistidentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Add Tracks To A Playlist:");

addTracksToAPlaylist(uri_list, useridentifier, playlistidentifier, accesstoken);

assertTrue(true);
}

@Test
public void testCreatePlaylist() {
String playlistname = "Hello World";
Boolean publicstatus = true;
String useridentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Create Playlist:");

createPlaylist(playlistname, publicstatus, useridentifier, accesstoken);

System.out.println("Playlistid: " + results.playlistid);
System.out.println("Spotifyurlplaylist: " + results.spotifyurlplaylist);
System.out.println();

assertTrue(true);
}

@Test
public void testFollowAPlaylist() {
Boolean visibility = true;
String playlistidentifier = "Hello World";
String owneridentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Follow A Playlist:");

followAPlaylist(visibility, playlistidentifier, owneridentifier, accesstoken);

assertTrue(true);
}

@Test
public void testGetAPlaylist() {
String playlistidentifier = "Hello World";
String owneridentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Get A Playlist:");

getAPlaylist(playlistidentifier, owneridentifier, accesstoken);

System.out.println("Playlistid: " + results.playlistid);
System.out.println("Numberoffollowers: " + results.numberoffollowers);
System.out.println("Spotifyurlplaylist: " + results.spotifyurlplaylist);
System.out.println("Collaborative: " + results.collaborative);
System.out.println("Description: " + results.description);
System.out.println("Playlistname: " + results.playlistname);
System.out.println("Ownerid: " + results.ownerid);
System.out.println("Spotifyurlowner: " + results.spotifyurlowner);
System.out.println("Usertype: " + results.usertype);
System.out.println("Numberoftracks: " + results.numberoftracks);
System.out.println("Limit: " + results.limit);
System.out.println("Track_list: " + results.track_list);
System.out.println("Publicstatus: " + results.publicstatus);
System.out.println();

assertTrue(true);
}

@Test
public void testGetATrack() {
String trackidentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Get A Track:");

getATrack(trackidentifier, accesstoken);

System.out.println("Trackid: " + results.trackid);
System.out.println("Artist_list: " + results.artist_list);
System.out.println("Spotifyurltrack: " + results.spotifyurltrack);
System.out.println("Discnumber: " + results.discnumber);
System.out.println("List_availablemarket: " + results.list_availablemarket);
System.out.println("Explicit: " + results.explicit);
System.out.println("Previewurl: " + results.previewurl);
System.out.println("Trackname: " + results.trackname);
System.out.println("Albumid: " + results.albumid);
System.out.println("Spotifyurlalbum: " + results.spotifyurlalbum);
System.out.println("Albumname: " + results.albumname);
System.out.println("Albumtype: " + results.albumtype);
System.out.println("Durationms: " + results.durationms);
System.out.println("Popularity: " + results.popularity);
System.out.println("Trackuri: " + results.trackuri);
System.out.println();

assertTrue(true);
}

@Test
public void testGetListOfPlaylistsOfAUser() {
String useridentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Get List Of Playlists Of A User:");

getListOfPlaylistsOfAUser(useridentifier, accesstoken);

System.out.println("Totalnumberofplaylists: " + results.totalnumberofplaylists);
System.out.println("Limit: " + results.limit);
System.out.println("Playlist_list: " + results.playlist_list);
System.out.println();

assertTrue(true);
}

@Test
public void testGetPlaylistById() {
String useridentifier = "Hello World";
String playlistidentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Get Playlist By Id:");

getPlaylistById(useridentifier, playlistidentifier, accesstoken);

System.out.println("Url: " + results.url);
System.out.println("Description: " + results.description);
System.out.println("Name: " + results.name);
System.out.println();

assertTrue(true);
}

@Test
public void testGetUserData() {
String accesstoken = "Hello World";

System.out.println("Test Get User Data:");

getUserData(accesstoken);

System.out.println("Date_birthdate: " + results.date_birthdate);
System.out.println("Country: " + results.country);
System.out.println("Name: " + results.name);
System.out.println("Email: " + results.email);
System.out.println("Identifier: " + results.identifier);
System.out.println("Product: " + results.product);
System.out.println();

assertTrue(true);
}

@Test
public void testRemoveTracksFromAPlaylist() {
List<Object> track_list = new ArrayList<Object>();
String owneridentifier = "Hello World";
String playlistidentifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Remove Tracks From A Playlist:");

removeTracksFromAPlaylist(track_list, owneridentifier, playlistidentifier, accesstoken);

assertTrue(true);
}

@Test
public void testSearchForAPlaylist() {
String accesstoken = "Hello World";
String searchquery = "Hello World";

System.out.println("Test Search For A Playlist:");

searchForAPlaylist(accesstoken, searchquery);

System.out.println("Playlistsnumber: " + results.playlistsnumber);
System.out.println("Limit: " + results.limit);
System.out.println("Playlist_list: " + results.playlist_list);
System.out.println();

assertTrue(true);
}

@Test
public void testSearchforartists() {
String searchquery = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Search for artists:");

searchforartists(searchquery, accesstoken);

System.out.println("Items_list: " + results.items_list);
System.out.println();

assertTrue(true);
}

@Test
public void testSearchfortrack() {
String searchquery = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Search for track:");

searchfortrack(searchquery, accesstoken);

System.out.println("List_items: " + results.list_items);
System.out.println();

assertTrue(true);
}

@Test
public void testReadMe() {
String accesstoken = "Hello World";

System.out.println("Test Read Me:");

readMe(accesstoken);

System.out.println("Description: " + results.description);
System.out.println("Country_location: " + results.country_location);
System.out.println("City_location: " + results.city_location);
System.out.println("Full name_name: " + results.fullname_name);
System.out.println("Username_name: " + results.username_name);
System.out.println();

assertTrue(true);
}

@Test
public void testReadAppMetadata() {
String identifier_appidentifier = "Hello World";

System.out.println("Test Read App Metadata:");

readAppMetadata(identifier_appidentifier);

System.out.println("App name_name: " + results.appname_name);
System.out.println("Creator: " + results.creator);
System.out.println();

assertTrue(true);
}

@Test
public void testGetVideosList() {
String videoids = "Hello World";
String accesstoken = "Hello World";
String part = "Hello World";

System.out.println("Test Get Videos List:");

getVideosList(videoids, accesstoken, part);

System.out.println("VideoList: " + results.videoList);
System.out.println();

assertTrue(true);
}

@Test
public void testAddAComment() {
String textoriginal = "Hello World";
String parentid = "Hello World";
String accesstoken = "Hello World";
String part = "Hello World";

System.out.println("Test Add A Comment:");

addAComment(textoriginal, parentid, accesstoken, part);

assertTrue(true);
}

@Test
public void testGetComments() {
String accesstoken = "Hello World";
String part = "Hello World";

System.out.println("Test Get Comments:");

getComments(accesstoken, part);

System.out.println("Comments: " + results.comments);
System.out.println();

assertTrue(true);
}

@Test
public void testGetPlaylists() {
String accesstoken = "Hello World";
String part = "Hello World";

System.out.println("Test Get Playlists:");

getPlaylists(accesstoken, part);

System.out.println("Playlists: " + results.playlists);
System.out.println();

assertTrue(true);
}

@Test
public void testSubscribeAChannel() {
String kind = "Hello World";
String channelid = "Hello World";
String part = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Subscribe A Channel:");

subscribeAChannel(kind, channelid, part, accesstoken);

assertTrue(true);
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
public void testContinuewithFolderContent() {
String cursorposition = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Continue with Folder Content:");

continuewithFolderContent(cursorposition, accesstoken);

System.out.println("Content: " + results.content);
System.out.println("Cursorposition: " + results.cursorposition);
System.out.println("Hasmoreentries: " + results.hasmoreentries);
System.out.println();

assertTrue(true);
}

@Test
public void testCopyFileOrFolder() {
String path_source = "Hello World";
String path_destination = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Copy File Or Folder:");

copyFileOrFolder(path_source, path_destination, accesstoken);

System.out.println("Name: " + results.name);
System.out.println("Path: " + results.path);
System.out.println("Timestamp_modificationdate: " + results.timestamp_modificationdate);
System.out.println("Revision: " + results.revision);
System.out.println("Size: " + results.size);
System.out.println("Identifier: " + results.identifier);
System.out.println();

assertTrue(true);
}

@Test
public void testCreateFolder() {
String path_identifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Create Folder:");

createFolder(path_identifier, accesstoken);

System.out.println("Name: " + results.name);
System.out.println("Path: " + results.path);
System.out.println("Timestamp_modificationdate: " + results.timestamp_modificationdate);
System.out.println("Revision: " + results.revision);
System.out.println("Size: " + results.size);
System.out.println("Identifier: " + results.identifier);
System.out.println();

assertTrue(true);
}

@Test
public void testDeleteFileOrFolder() {
String path_identifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Delete File Or Folder:");

deleteFileOrFolder(path_identifier, accesstoken);

assertTrue(true);
}

@Test
public void testGetAccountInfo() {
String accesstoken = "Hello World";

System.out.println("Test Get Account Info:");

getAccountInfo(accesstoken);

System.out.println("Accountidentifier: " + results.accountidentifier);
System.out.println("Firstname: " + results.firstname);
System.out.println("Lastname: " + results.lastname);
System.out.println("Username: " + results.username);
System.out.println("Countryidentifier: " + results.countryidentifier);
System.out.println();

assertTrue(true);
}

@Test
public void testGetFolderContent() {
String path_identifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Get Folder Content:");

getFolderContent(path_identifier, accesstoken);

System.out.println("Content: " + results.content);
System.out.println("Cursorposition: " + results.cursorposition);
System.out.println("Hasmoreentries: " + results.hasmoreentries);
System.out.println();

assertTrue(true);
}

@Test
public void testGetMetadata() {
String path_identifier = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Get Metadata:");

getMetadata(path_identifier, accesstoken);

System.out.println("Name: " + results.name);
System.out.println("Path: " + results.path);
System.out.println("Timestamp_modificationdate: " + results.timestamp_modificationdate);
System.out.println("Revision: " + results.revision);
System.out.println("Size: " + results.size);
System.out.println("Identifier: " + results.identifier);
System.out.println();

assertTrue(true);
}

@Test
public void testGetSpaceUsage() {
String accesstoken = "Hello World";

System.out.println("Test Get Space Usage:");

getSpaceUsage(accesstoken);

System.out.println("Usedquota: " + results.usedquota);
System.out.println("Totalquota: " + results.totalquota);
System.out.println();

assertTrue(true);
}

@Test
public void testMoveFileOrFolder() {
String path_source = "Hello World";
String path_destination = "Hello World";
String accesstoken = "Hello World";

System.out.println("Test Move File Or Folder:");

moveFileOrFolder(path_source, path_destination, accesstoken);

System.out.println("Name: " + results.name);
System.out.println("Path: " + results.path);
System.out.println("Timestamp_modificationdate: " + results.timestamp_modificationdate);
System.out.println("Revision: " + results.revision);
System.out.println("Size: " + results.size);
System.out.println("Identifier: " + results.identifier);
System.out.println();

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

private class Results {

public String playlistid;
public String spotifyurlplaylist;
public Long numberoffollowers;
public Boolean collaborative;
public String description;
public String playlistname;
public String ownerid;
public String spotifyurlowner;
public String usertype;
public Long numberoftracks;
public Long limit;
public List<Object> track_list;
public Boolean publicstatus;
public String trackid;
public List<Object> artist_list;
public String spotifyurltrack;
public Long discnumber;
public List<Object> list_availablemarket;
public Boolean explicit;
public String previewurl;
public String trackname;
public String albumid;
public String spotifyurlalbum;
public String albumname;
public String albumtype;
public Long durationms;
public Long popularity;
public String trackuri;
public Long totalnumberofplaylists;
public List<Object> playlist_list;
public String url;
public String name;
public String date_birthdate;
public String country;
public String email;
public String identifier;
public String product;
public Long playlistsnumber;
public List<Object> items_list;
public List<Object> list_items;
public String country_location;
public String city_location;
public String fullname_name;
public String username_name;
public String appname_name;
public String creator;
public List<Object> videoList;
public List<Object> comments;
public List<Object> playlists;
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
public List<Object> content;
public String cursorposition;
public Boolean hasmoreentries;
public String path;
public String timestamp_modificationdate;
public String revision;
public Long size;
public String accountidentifier;
public String firstname;
public String lastname;
public String username;
public String countryidentifier;
public Long usedquota;
public Long totalquota;
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
public String bio;
public List<Object> list_data_pages;
public List<Object> list_friends;
public String gender;
public List<Object> feed;
public Long totalcount;

}
}
