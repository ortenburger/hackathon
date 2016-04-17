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

public class Hackathon {

private Endpoint endpoint;

/**
 * 
 * @param philipshueapi_ipaddress   
 * @param spotifywebapi_clientidentifier The client ID provided to you by Spotify when you register your application. 
 * @param spotifywebapi_redirecturi The URI to redirect to after the user grants/denies permission. This URI needs to have been entered in the Redirect URI whitelist that you specified when you registered your application. The value of redirect_uri here must exactly match one of the values you entered when you registered your application, including upper/lowercase, terminating slashes, etc. 
 * @param spotifywebapi_state The state can be useful for correlating requests and responses. Because your redirect_uri can be guessed, using a state value can increase your assurance that an incoming connection is the result of an authentication request. If you generate a random string or encode the hash of some client state (e.g., a cookie) in this state variable, you can validate the response to additionally ensure that the request and response originated in the same browser. This provides protection against attacks such as cross-site request forgery. 
 * @param spotifywebapi_scope A space-separated list of scopes. A list of scopes can be found here: https://developer.spotify.com/web-api/using-scopes/. 
 * @param spotifywebapi_clientsecret The client secret provided to you by Spotify when you register your application. 
 * @param youtubeapi_clientidentifier Provided after registering an app @ https://console.developers.google.com/. 
 * @param youtubeapi_clientsecret Provided after registering an app @ https://console.developers.google.com/. 
 * @param youtubeapi_redirecturi The OAuth 2.0 redirect URI where your server receives authentication redirects. 
 * @param youtubeapi_csrftoken A random string preventing CSRF (cross site request forgery) attacks from happening. 
 * @param dropboxapiv2_csrftoken Up to 500 bytes of arbitrary data that will be passed back to your redirect URI. This parameter should be used to protect against cross-site request forgery (CSRF). 
 * @param dropboxapiv2_clientsecret The app's secret, found in the Dropbox App Console. 
 * @param dropboxapiv2_redirecturi Where to redirect the user after authorization has completed. This must be the exact URI registered in the Dropbox App Console; even 'localhost' must be listed if it is used for testing. All redirect URIs must be HTTPS except for localhost URIs. 
 * @param dropboxapiv2_clientidentifier The app's key, found in the Dropbox App Console. 
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
 * @param soundcloudapi_clientidentifier The client id belonging to your application. Get it after registering an app @ http://soundcloud.com/you/apps 
 * @param soundcloudapi_redirecturi The OAuth 2.0 redirect URI, where your server receives redirects 
 * @param soundcloudapi_csrftoken OAuth 2.0 state 
 * @param soundcloudapi_clientsecret See client_id 
 * @param netatmoweatherstationapi_clientidentifier The client id retrieved from the Netatmo app creation page. 
 * @param netatmoweatherstationapi_uri After granting access the user is redirected to the callback URL defined in your application settings or to the redirect_uri provided in the request in order to finish the authorization flow. 
 * @param netatmoweatherstationapi_csrftoken To ensure the security of the process, you should generate and store a state parameter which is unique to this request. The state parameter is an arbitrary string you choose. Its value will be passed back to your application as a parameter of the redirect_uri when the user completes the authentication flow. 
 * @param netatmoweatherstationapi_clientsecret The client secret retrieved from the Netatmo app creation page. 
 */
public Hackathon(String philipshueapi_ipaddress, String spotifywebapi_clientidentifier, String spotifywebapi_redirecturi, String spotifywebapi_state, String spotifywebapi_scope, String spotifywebapi_clientsecret, String youtubeapi_clientidentifier, String youtubeapi_clientsecret, String youtubeapi_redirecturi, String youtubeapi_csrftoken, String dropboxapiv2_csrftoken, String dropboxapiv2_clientsecret, String dropboxapiv2_redirecturi, String dropboxapiv2_clientidentifier, String googletasks_clientidentifier, String googletasks_redirecturi, String googletasks_clientsecret, String facebookgraphapi_clientidentifier, String facebookgraphapi_uri, String facebookgraphapi_scope, String facebookgraphapi_clientsecret, String facebookgraphapi_csrftoken, String soundcloudapi_clientidentifier, String soundcloudapi_redirecturi, String soundcloudapi_csrftoken, String soundcloudapi_clientsecret, String netatmoweatherstationapi_clientidentifier, String netatmoweatherstationapi_uri, String netatmoweatherstationapi_csrftoken, String netatmoweatherstationapi_clientsecret) {
HashMap<String, Object> globals = new HashMap<String, Object>();
globals.put("philipshueapi_ipaddress", philipshueapi_ipaddress);
globals.put("spotifywebapi_clientidentifier", spotifywebapi_clientidentifier);
globals.put("spotifywebapi_redirecturi", spotifywebapi_redirecturi);
globals.put("spotifywebapi_state", spotifywebapi_state);
globals.put("spotifywebapi_scope", spotifywebapi_scope);
globals.put("spotifywebapi_clientsecret", spotifywebapi_clientsecret);
globals.put("youtubeapi_clientidentifier", youtubeapi_clientidentifier);
globals.put("youtubeapi_clientsecret", youtubeapi_clientsecret);
globals.put("youtubeapi_redirecturi", youtubeapi_redirecturi);
globals.put("youtubeapi_csrftoken", youtubeapi_csrftoken);
globals.put("dropboxapiv2_csrftoken", dropboxapiv2_csrftoken);
globals.put("dropboxapiv2_clientsecret", dropboxapiv2_clientsecret);
globals.put("dropboxapiv2_redirecturi", dropboxapiv2_redirecturi);
globals.put("dropboxapiv2_clientidentifier", dropboxapiv2_clientidentifier);
globals.put("googletasks_clientidentifier", googletasks_clientidentifier);
globals.put("googletasks_redirecturi", googletasks_redirecturi);
globals.put("googletasks_clientsecret", googletasks_clientsecret);
globals.put("facebookgraphapi_clientidentifier", facebookgraphapi_clientidentifier);
globals.put("facebookgraphapi_uri", facebookgraphapi_uri);
globals.put("facebookgraphapi_scope", facebookgraphapi_scope);
globals.put("facebookgraphapi_clientsecret", facebookgraphapi_clientsecret);
globals.put("facebookgraphapi_csrftoken", facebookgraphapi_csrftoken);
globals.put("soundcloudapi_clientidentifier", soundcloudapi_clientidentifier);
globals.put("soundcloudapi_redirecturi", soundcloudapi_redirecturi);
globals.put("soundcloudapi_csrftoken", soundcloudapi_csrftoken);
globals.put("soundcloudapi_clientsecret", soundcloudapi_clientsecret);
globals.put("netatmoweatherstationapi_clientidentifier", netatmoweatherstationapi_clientidentifier);
globals.put("netatmoweatherstationapi_uri", netatmoweatherstationapi_uri);
globals.put("netatmoweatherstationapi_csrftoken", netatmoweatherstationapi_csrftoken);
globals.put("netatmoweatherstationapi_clientsecret", netatmoweatherstationapi_clientsecret);
try{
endpoint = new Endpoint(getClass().getResourceAsStream("Hackathon.cloudrail"), globals);
}catch(Exception e) {
throw new CloudRailException(e);
}
}

/**
 * 
 * @param uri_list List of URIs of the tracks. 
 * @param useridentifier ID of the user. 
 * @param playlistidentifier ID of the playlist. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void addTracksToAPlaylist(List<Object> uri_list, String useridentifier, String playlistidentifier, String accesstoken, final AddTracksToAPlaylistResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("uri_list", uri_list);
inputs.put("useridentifier", useridentifier);
inputs.put("playlistidentifier", playlistidentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Add Tracks To A Playlist", inputs, new EndpointCallResponseListener() {
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
 * @param playlistname Name of the new playlist. 
 * @param publicstatus true if public, false if private. 
 * @param useridentifier ID of the user. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void createPlaylist(String playlistname, Boolean publicstatus, String useridentifier, String accesstoken, final CreatePlaylistResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("playlistname", playlistname);
inputs.put("publicstatus", publicstatus);
inputs.put("useridentifier", useridentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Create Playlist", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("playlistid"), (String) result.get("spotifyurlplaylist"));
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
 * @param visibility Optional, default true. If true the playlist will be included in user's public playlists, if false it will remain private. 
 * @param playlistidentifier ID of the playlist the user wants to follow. 
 * @param owneridentifier ID of the owner of the playlist. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void followAPlaylist(Boolean visibility, String playlistidentifier, String owneridentifier, String accesstoken, final FollowAPlaylistResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("visibility", visibility);
inputs.put("playlistidentifier", playlistidentifier);
inputs.put("owneridentifier", owneridentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Follow A Playlist", inputs, new EndpointCallResponseListener() {
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
 * @param playlistidentifier ID of the playlist. 
 * @param owneridentifier ID of the user. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getAPlaylist(String playlistidentifier, String owneridentifier, String accesstoken, final GetAPlaylistResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("playlistidentifier", playlistidentifier);
inputs.put("owneridentifier", owneridentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Get A Playlist", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("playlistid"), (Long) result.get("numberoffollowers"), (String) result.get("spotifyurlplaylist"), (Boolean) result.get("collaborative"), (String) result.get("description"), (String) result.get("playlistname"), (String) result.get("ownerid"), (String) result.get("spotifyurlowner"), (String) result.get("usertype"), (Long) result.get("numberoftracks"), (Long) result.get("limit"), (List<Object>) result.get("track_list"), (Boolean) result.get("publicstatus"));
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
 * @param trackidentifier ID of the track. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getATrack(String trackidentifier, String accesstoken, final GetATrackResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("trackidentifier", trackidentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Get A Track", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("trackid"), (List<Object>) result.get("artist_list"), (String) result.get("spotifyurltrack"), (Long) result.get("discnumber"), (List<Object>) result.get("list_availablemarket"), (Boolean) result.get("explicit"), (String) result.get("previewurl"), (String) result.get("trackname"), (String) result.get("albumid"), (String) result.get("spotifyurlalbum"), (String) result.get("albumname"), (String) result.get("albumtype"), (Long) result.get("durationms"), (Long) result.get("popularity"), (String) result.get("trackuri"));
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
 * @param useridentifier ID of the user. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getListOfPlaylistsOfAUser(String useridentifier, String accesstoken, final GetListOfPlaylistsOfAUserResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("useridentifier", useridentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Get List Of Playlists Of A User", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((Long) result.get("totalnumberofplaylists"), (Long) result.get("limit"), (List<Object>) result.get("playlist_list"));
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
 * @param useridentifier The user's Spotify user ID. 
 * @param playlistidentifier The Spotify ID for the playlist. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getPlaylistById(String useridentifier, String playlistidentifier, String accesstoken, final GetPlaylistByIdResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("useridentifier", useridentifier);
inputs.put("playlistidentifier", playlistidentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Get Playlist By Id", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("url"), (String) result.get("description"), (String) result.get("name"));
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
 * @param answer The ResponseListener for this asynchronous call
 */
public void getUserData(String accesstoken, final GetUserDataResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
endpoint.call("Get User Data", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("date_birthdate"), (String) result.get("country"), (String) result.get("name"), (String) result.get("email"), (String) result.get("identifier"), (String) result.get("product"));
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
 * @param track_list List with the tracks which should be deleted. 
 * @param owneridentifier ID of the owner. 
 * @param playlistidentifier ID of the playlist. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void removeTracksFromAPlaylist(List<Object> track_list, String owneridentifier, String playlistidentifier, String accesstoken, final RemoveTracksFromAPlaylistResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("track_list", track_list);
inputs.put("owneridentifier", owneridentifier);
inputs.put("playlistidentifier", playlistidentifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Remove Tracks From A Playlist", inputs, new EndpointCallResponseListener() {
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
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param searchquery The search query's keywords (and optional field filters and operators), for example q=roadhouse%20blues. 
Encode spaces with the hex code %20 or +. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void searchForAPlaylist(String accesstoken, String searchquery, final SearchForAPlaylistResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
inputs.put("searchquery", searchquery);
endpoint.call("Search For A Playlist", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((Long) result.get("playlistsnumber"), (Long) result.get("limit"), (List<Object>) result.get("playlist_list"));
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
 * @param searchquery The search query's keywords. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void searchforartists(String searchquery, String accesstoken, final SearchforartistsResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("searchquery", searchquery);
inputs.put("accesstoken", accesstoken);
endpoint.call("Search for artists", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("items_list"));
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
 * @param searchquery The search query's keywords for example 'roadhouse%20blues'. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void searchfortrack(String searchquery, String accesstoken, final SearchfortrackResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("searchquery", searchquery);
inputs.put("accesstoken", accesstoken);
endpoint.call("Search for track", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("list_items"));
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
 * @param accesstoken The OAuth 2.0 access token, retrieved by authentication 
 * @param answer The ResponseListener for this asynchronous call
 */
public void readMe(String accesstoken, final ReadMeResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
endpoint.call("Read Me", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("description"), (String) result.get("country_location"), (String) result.get("city_location"), (String) result.get("fullname_name"), (String) result.get("username_name"));
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
 * @param identifier_appidentifier App identifier, e.g. "123" 
 * @param answer The ResponseListener for this asynchronous call
 */
public void readAppMetadata(String identifier_appidentifier, final ReadAppMetadataResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("identifier_appidentifier", identifier_appidentifier);
endpoint.call("Read App Metadata", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("appname_name"), (String) result.get("creator"));
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
 * @param videoids   
 * @param accesstoken   
 * @param part   
 * @param answer The ResponseListener for this asynchronous call
 */
public void getVideosList(String videoids, String accesstoken, String part, final GetVideosListResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("videoids", videoids);
inputs.put("accesstoken", accesstoken);
inputs.put("part", part);
endpoint.call("Get Videos List", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("videoList"));
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
 * @param textoriginal   
 * @param parentid   
 * @param accesstoken   
 * @param part   
 * @param answer The ResponseListener for this asynchronous call
 */
public void addAComment(String textoriginal, String parentid, String accesstoken, String part, final AddACommentResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("textoriginal", textoriginal);
inputs.put("parentid", parentid);
inputs.put("accesstoken", accesstoken);
inputs.put("part", part);
endpoint.call("Add A Comment", inputs, new EndpointCallResponseListener() {
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
 * @param accesstoken   
 * @param part   
 * @param answer The ResponseListener for this asynchronous call
 */
public void getComments(String accesstoken, String part, final GetCommentsResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
inputs.put("part", part);
endpoint.call("Get Comments", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("comments"));
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
 * @param accesstoken   
 * @param part   
 * @param answer The ResponseListener for this asynchronous call
 */
public void getPlaylists(String accesstoken, String part, final GetPlaylistsResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
inputs.put("part", part);
endpoint.call("Get Playlists", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("playlists"));
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
 * @param kind   
 * @param channelid   
 * @param part   
 * @param accesstoken   
 * @param answer The ResponseListener for this asynchronous call
 */
public void subscribeAChannel(String kind, String channelid, String part, String accesstoken, final SubscribeAChannelResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("kind", kind);
inputs.put("channelid", channelid);
inputs.put("part", part);
inputs.put("accesstoken", accesstoken);
endpoint.call("Subscribe A Channel", inputs, new EndpointCallResponseListener() {
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
 * @param cursorposition The cursor returned by your last call to 'Get Folder Content' or 'Continue with Folder Content'. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void continuewithFolderContent(String cursorposition, String accesstoken, final ContinuewithFolderContentResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("cursorposition", cursorposition);
inputs.put("accesstoken", accesstoken);
endpoint.call("Continue with Folder Content", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("content"), (String) result.get("cursorposition"), (Boolean) result.get("hasmoreentries"));
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
 * @param path_source Path in the user's Dropbox to be copied or moved. 
 * @param path_destination Path in the user's Dropbox that is the destination. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void copyFileOrFolder(String path_source, String path_destination, String accesstoken, final CopyFileOrFolderResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("path_source", path_source);
inputs.put("path_destination", path_destination);
inputs.put("accesstoken", accesstoken);
endpoint.call("Copy File Or Folder", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("name"), (String) result.get("path"), (String) result.get("timestamp_modificationdate"), (String) result.get("revision"), (Long) result.get("size"), (String) result.get("identifier"));
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
 * @param path_identifier The path to the new folder on Dropbox. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void createFolder(String path_identifier, String accesstoken, final CreateFolderResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("path_identifier", path_identifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Create Folder", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("name"), (String) result.get("path"), (String) result.get("timestamp_modificationdate"), (String) result.get("revision"), (Long) result.get("size"), (String) result.get("identifier"));
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
 * @param path_identifier The path of a file or folder on Dropbox. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void deleteFileOrFolder(String path_identifier, String accesstoken, final DeleteFileOrFolderResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("path_identifier", path_identifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Delete File Or Folder", inputs, new EndpointCallResponseListener() {
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
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getAccountInfo(String accesstoken, final GetAccountInfoResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
endpoint.call("Get Account Info", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("accountidentifier"), (String) result.get("firstname"), (String) result.get("lastname"), (String) result.get("username"), (String) result.get("countryidentifier"));
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
 * @param path_identifier The path of a folder on Dropbox. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getFolderContent(String path_identifier, String accesstoken, final GetFolderContentResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("path_identifier", path_identifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Get Folder Content", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((List<Object>) result.get("content"), (String) result.get("cursorposition"), (Boolean) result.get("hasmoreentries"));
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
 * @param path_identifier The path of a file or folder on Dropbox. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void getMetadata(String path_identifier, String accesstoken, final GetMetadataResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("path_identifier", path_identifier);
inputs.put("accesstoken", accesstoken);
endpoint.call("Get Metadata", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("name"), (String) result.get("path"), (String) result.get("timestamp_modificationdate"), (String) result.get("revision"), (Long) result.get("size"), (String) result.get("identifier"));
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
 * @param answer The ResponseListener for this asynchronous call
 */
public void getSpaceUsage(String accesstoken, final GetSpaceUsageResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("accesstoken", accesstoken);
endpoint.call("Get Space Usage", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((Long) result.get("usedquota"), (Long) result.get("totalquota"));
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
 * @param path_source Path in the user's Dropbox to be copied or moved. 
 * @param path_destination Path in the user's Dropbox that is the destination. 
 * @param accesstoken Access token obtained by the authorization request. Used to authenticate this request. 
 * @param answer The ResponseListener for this asynchronous call
 */
public void moveFileOrFolder(String path_source, String path_destination, String accesstoken, final MoveFileOrFolderResponseListener answer) {
HashMap<String, Object> inputs = new HashMap<String, Object>();
inputs.put("path_source", path_source);
inputs.put("path_destination", path_destination);
inputs.put("accesstoken", accesstoken);
endpoint.call("Move File Or Folder", inputs, new EndpointCallResponseListener() {
public void onSuccess(Map<String,Object> result) {
answer.onSuccess((String) result.get("name"), (String) result.get("path"), (String) result.get("timestamp_modificationdate"), (String) result.get("revision"), (Long) result.get("size"), (String) result.get("identifier"));
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

private WebAuthorization SpotifyWebAPI_Auth;

 /**
 * Set up authorization for Spotify Web API
 * @param uriOpener An implementation of UriView that opens URIs at the appropriate place
 * @param uriRedirectListener An implementation of UriRedirectListener which receives authorization redirects
 * @param tokenCallback An implementation of AccessTokenCallback which receives the access token after successful authorization
 */
public void init_SpotifyWebAPI_Auth(UriView uriOpener, UriRedirectListener uriRedirectListener, AccessTokenCallback tokenCallback) {
SpotifyWebAPI_Auth = endpoint.createWebAuthorization("Spotify Web API", uriOpener, uriRedirectListener, tokenCallback);
}

/**
 * Start the authorization process for Spotify Web API
 */
public void start_SpotifyWebAPI_Auth() {
SpotifyWebAPI_Auth.openLogin();
}

private WebAuthorization YoutubeAPI_Auth;

 /**
 * Set up authorization for Youtube API
 * @param uriOpener An implementation of UriView that opens URIs at the appropriate place
 * @param uriRedirectListener An implementation of UriRedirectListener which receives authorization redirects
 * @param tokenCallback An implementation of AccessTokenCallback which receives the access token after successful authorization
 */
public void init_YoutubeAPI_Auth(UriView uriOpener, UriRedirectListener uriRedirectListener, AccessTokenCallback tokenCallback) {
YoutubeAPI_Auth = endpoint.createWebAuthorization("Youtube API", uriOpener, uriRedirectListener, tokenCallback);
}

/**
 * Start the authorization process for Youtube API
 */
public void start_YoutubeAPI_Auth() {
YoutubeAPI_Auth.openLogin();
}

private WebAuthorization DropboxAPIv2_Auth;

 /**
 * Set up authorization for Dropbox API v2
 * @param uriOpener An implementation of UriView that opens URIs at the appropriate place
 * @param uriRedirectListener An implementation of UriRedirectListener which receives authorization redirects
 * @param tokenCallback An implementation of AccessTokenCallback which receives the access token after successful authorization
 */
public void init_DropboxAPIv2_Auth(UriView uriOpener, UriRedirectListener uriRedirectListener, AccessTokenCallback tokenCallback) {
DropboxAPIv2_Auth = endpoint.createWebAuthorization("Dropbox API v2", uriOpener, uriRedirectListener, tokenCallback);
}

/**
 * Start the authorization process for Dropbox API v2
 */
public void start_DropboxAPIv2_Auth() {
DropboxAPIv2_Auth.openLogin();
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

private WebAuthorization SoundcloudAPI_Auth;

 /**
 * Set up authorization for Soundcloud API
 * @param uriOpener An implementation of UriView that opens URIs at the appropriate place
 * @param uriRedirectListener An implementation of UriRedirectListener which receives authorization redirects
 * @param tokenCallback An implementation of AccessTokenCallback which receives the access token after successful authorization
 */
public void init_SoundcloudAPI_Auth(UriView uriOpener, UriRedirectListener uriRedirectListener, AccessTokenCallback tokenCallback) {
SoundcloudAPI_Auth = endpoint.createWebAuthorization("Soundcloud API", uriOpener, uriRedirectListener, tokenCallback);
}

/**
 * Start the authorization process for Soundcloud API
 */
public void start_SoundcloudAPI_Auth() {
SoundcloudAPI_Auth.openLogin();
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

public interface AddTracksToAPlaylistResponseListener {
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

public interface CreatePlaylistResponseListener {
/**
 * 
 * @param playlistid ID of the playlist. 
 * @param spotifyurlplaylist URL to the playlist. 
 */
public void onSuccess(String playlistid, String spotifyurlplaylist);
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

public interface FollowAPlaylistResponseListener {
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

public interface GetAPlaylistResponseListener {
/**
 * 
 * @param playlistid ID of the playlist. 
 * @param numberoffollowers Total number of followers. 
 * @param spotifyurlplaylist URL to the playlist. 
 * @param collaborative true if the owner allows other users to modify the playlist. . 
 * @param description Description of the playlist. 
 * @param playlistname Name of the playlist. 
 * @param ownerid ID of the owner. 
 * @param spotifyurlowner URL to the owner's page. 
 * @param usertype Type of the user. 
 * @param numberoftracks Total number of tracks. 
 * @param limit Limit of the number of track. 
 * @param track_list List of tracks of the playlist. 
 * @param publicstatus true if public, false if private. 
 */
public void onSuccess(String playlistid, Long numberoffollowers, String spotifyurlplaylist, Boolean collaborative, String description, String playlistname, String ownerid, String spotifyurlowner, String usertype, Long numberoftracks, Long limit, List<Object> track_list, Boolean publicstatus);
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

public interface GetATrackResponseListener {
/**
 * 
 * @param trackid ID of the track. 
 * @param artist_list List of artists. 
 * @param spotifyurltrack URL to the track. 
 * @param discnumber Number of the disc. 
 * @param list_availablemarket List of available markets. 
 * @param explicit true if track is explicit, false if not. 
 * @param previewurl URL to the preview of the track. 
 * @param trackname Name of the track. 
 * @param albumid ID of the album. 
 * @param spotifyurlalbum URL to the album. 
 * @param albumname Name of the album. 
 * @param albumtype Type of the album. 
 * @param durationms Duration of the track in ms. 
 * @param popularity Popularity of the track. 
 * @param trackuri URI of the track. 
 */
public void onSuccess(String trackid, List<Object> artist_list, String spotifyurltrack, Long discnumber, List<Object> list_availablemarket, Boolean explicit, String previewurl, String trackname, String albumid, String spotifyurlalbum, String albumname, String albumtype, Long durationms, Long popularity, String trackuri);
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

public interface GetListOfPlaylistsOfAUserResponseListener {
/**
 * 
 * @param totalnumberofplaylists Total number of playlists. 
 * @param limit Limit of number of playlists. 
 * @param playlist_list List of the playlists of the specified user. 
 */
public void onSuccess(Long totalnumberofplaylists, Long limit, List<Object> playlist_list);
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

public interface GetPlaylistByIdResponseListener {
/**
 * 
 * @param url An external, public URL to the object. 
 * @param description The playlist description. Only returned for modified, verified playlists, otherwise null. 
 * @param name The name of the playlist. 
 */
public void onSuccess(String url, String description, String name);
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

public interface GetUserDataResponseListener {
/**
 * 
 * @param date_birthdate The user's date-of-birth. This field is only available when the current user has granted access to the user-read-birthdate scope. 
 * @param country The country of the user, as set in the user's account profile. An ISO 3166-1 alpha-2 country code. This field is only available when the current user has granted access to the user-read-private scope. 
 * @param name The name displayed on the user's profile. null if not available. 
 * @param email The user's email address, as entered by the user when creating their account. This field is only available when the current user has granted access to the user-read-email scope. 
 * @param identifier The Spotify user ID for the user. 
 * @param product The user's Spotify subscription level: 'premium', 'free', etc. (The subscription level 'open' can be considered the same as 'free'.) This field is only available when the current user has granted access to the user-read-private scope. 
 */
public void onSuccess(String date_birthdate, String country, String name, String email, String identifier, String product);
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

public interface RemoveTracksFromAPlaylistResponseListener {
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

public interface SearchForAPlaylistResponseListener {
/**
 * 
 * @param playlistsnumber Total number of playlists that match. 
 * @param limit Limit of the number of playlists shown. 
 * @param playlist_list List of the playlists that match the search query. 
 */
public void onSuccess(Long playlistsnumber, Long limit, List<Object> playlist_list);
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

public interface SearchforartistsResponseListener {
/**
 * 
 * @param items_list List of search results. 
 */
public void onSuccess(List<Object> items_list);
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

public interface SearchfortrackResponseListener {
/**
 * 
 * @param list_items   
 */
public void onSuccess(List<Object> list_items);
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

public interface ReadMeResponseListener {
/**
 * 
 * @param description The user's description, e.g. 'Buskers playing in the S-Bahn station in Berlin' 
 * @param country_location Country, e.g. 'Germany' 
 * @param city_location City, e.g. 'Berlin' 
 * @param full name_name First and last name, e.g. 'Patrock Stocklaser' 
 * @param username_name The user's username, e.g. 'Doctor GIT' 
 */
public void onSuccess(String description, String country_location, String city_location, String fullname_name, String username_name);
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

public interface ReadAppMetadataResponseListener {
/**
 * 
 * @param app name_name The app's name, e.g. 'SoundCloud iOS' 
 * @param creator The username of the app creator, e.g. 'weatherman' 
 */
public void onSuccess(String appname_name, String creator);
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

public interface GetVideosListResponseListener {
/**
 * 
 * @param videoList   
 */
public void onSuccess(List<Object> videoList);
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

public interface AddACommentResponseListener {
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

public interface GetCommentsResponseListener {
/**
 * 
 * @param comments   
 */
public void onSuccess(List<Object> comments);
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

public interface GetPlaylistsResponseListener {
/**
 * 
 * @param playlists   
 */
public void onSuccess(List<Object> playlists);
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

public interface SubscribeAChannelResponseListener {
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

public interface ContinuewithFolderContentResponseListener {
/**
 * 
 * @param content The files and (direct) subfolders in the folder. 
 * @param cursorposition Pass the cursor into 'Continue with Folder Content' to see what's changed in the folder since your previous query. 
 * @param hasmoreentries If true, then there are more entries available. Pass the cursor to 'Continue with Folder Content' to retrieve the rest. 
 */
public void onSuccess(List<Object> content, String cursorposition, Boolean hasmoreentries);
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

public interface CopyFileOrFolderResponseListener {
/**
 * 
 * @param name The last component of the path (including extension). This never contains a slash. 
 * @param path The lowercased full path in the user's Dropbox. This always starts with a slash. 
 * @param timestamp_modificationdate The last time the file was modified on Dropbox. 
 * @param revision A unique identifier for the current revision of a file. This field is the same rev as elsewhere in the API and can be used to detect changes and avoid conflicts. 
 * @param size The file size in bytes. 
 * @param identifier A unique identifier for the file / folder. This field is optional. 
 */
public void onSuccess(String name, String path, String timestamp_modificationdate, String revision, Long size, String identifier);
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

public interface CreateFolderResponseListener {
/**
 * 
 * @param name The last component of the path (including extension). This never contains a slash. 
 * @param path The lowercased full path in the user's Dropbox. This always starts with a slash. 
 * @param timestamp_modificationdate The last time the file was modified on Dropbox. 
 * @param revision A unique identifier for the current revision of a file. This field is the same rev as elsewhere in the API and can be used to detect changes and avoid conflicts. 
 * @param size The file size in bytes. 
 * @param identifier A unique identifier for the file / folder. This field is optional. 
 */
public void onSuccess(String name, String path, String timestamp_modificationdate, String revision, Long size, String identifier);
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

public interface DeleteFileOrFolderResponseListener {
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

public interface GetAccountInfoResponseListener {
/**
 * 
 * @param accountidentifier The user's unique Dropbox ID. 
 * @param firstname The user's first name. 
 * @param lastname The user'S last name. 
 * @param username A name that can be used directly to represent the name of a user's Dropbox account. 
 * @param countryidentifier The user's two-letter country code, if available. Country codes are based on ISO 3166-1. This field is optional. 
 */
public void onSuccess(String accountidentifier, String firstname, String lastname, String username, String countryidentifier);
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

public interface GetFolderContentResponseListener {
/**
 * 
 * @param content The files and (direct) subfolders in the folder. 
 * @param cursorposition Pass the cursor into 'Continue with Folder Content' to see what's changed in the folder since your previous query. 
 * @param hasmoreentries If true, then there are more entries available. Pass the cursor to 'Continue with Folder Content' to retrieve the rest. 
 */
public void onSuccess(List<Object> content, String cursorposition, Boolean hasmoreentries);
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

public interface GetMetadataResponseListener {
/**
 * 
 * @param name The last component of the path (including extension). This never contains a slash. 
 * @param path The lowercased full path in the user's Dropbox. This always starts with a slash. 
 * @param timestamp_modificationdate The last time the file was modified on Dropbox. 
 * @param revision A unique identifier for the current revision of a file. This field is the same rev as elsewhere in the API and can be used to detect changes and avoid conflicts. 
 * @param size The file size in bytes. 
 * @param identifier A unique identifier for the file / folder. This field is optional. 
 */
public void onSuccess(String name, String path, String timestamp_modificationdate, String revision, Long size, String identifier);
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

public interface GetSpaceUsageResponseListener {
/**
 * 
 * @param usedquota The user's total space usage (bytes). 
 * @param totalquota The user's space allocation applies only to their individual account. 
 */
public void onSuccess(Long usedquota, Long totalquota);
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

public interface MoveFileOrFolderResponseListener {
/**
 * 
 * @param name The last component of the path (including extension). This never contains a slash. 
 * @param path The lowercased full path in the user's Dropbox. This always starts with a slash. 
 * @param timestamp_modificationdate The last time the file was modified on Dropbox. 
 * @param revision A unique identifier for the current revision of a file. This field is the same rev as elsewhere in the API and can be used to detect changes and avoid conflicts. 
 * @param size The file size in bytes. 
 * @param identifier A unique identifier for the file / folder. This field is optional. 
 */
public void onSuccess(String name, String path, String timestamp_modificationdate, String revision, Long size, String identifier);
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

}