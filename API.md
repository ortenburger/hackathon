API:

Abstract:
set/get room dimensions
set/get position phone
set/get position light source
set/get alarm:  (invalid fields interpreted as wildcards)
                * wakeup / jetlag
                * general inhouse
                * leaving house (weather warnings)
                        - set vrn directions/get recently used 
                        - get stations
set/get movie-mood-values: * later: AmbiLight
set/get music-mood-values: * later: lighting console
set/get mood-settings: * later: detect user-mood and counter
set start mode: - follow
                - movie
                - music
                - all on/off
                
Definition:             
{
  set_current_mode: <"follow","wake_up","movie","music","day_light">,
  
  room: [{
    id: <int>,
    name: "<string>",
    dimensions: [{<x>,<y>},...,{<x>,<y>}],
    user_position_list: [{id:<int>,x:<int>,y:<int>}],
    light_position_list: [{id:<int>,x:<int>,y:<int>,active:<boolean>,type: ["hue","boolean"]}],
          }],
          
  alarm: [{
    id: <int>,
    name: "<string>",
    type: {"wake_up","jetlag","inhouse","outhouse","outhouse_vrn"},
    time: {"JJJJ-MM-TT-HH-MM",weekly:<boolean>}
           },
    stations:[{elementID: <int>, shortName: <string>, longitude: <string>, distance: <float>, latitude: <string>, hafasID: <string>, longName: <string>},{...}]
         }],
           
  mood: [{
    type: <"follow","movie","music","mood","day_light">,
    hue: <int>,
    brightness: <int>,
    tbd: "tbd"
          }]
}

########################################################################

API RNV_Usage

########################################################################

API CloudRAIL

Part A:
Philips Hue
If Frontend Set-PhilipsHue:
    CreateUser
    * -> devicetype [string]#[string] ([application_name]#[devicename])

Part B: 
Netatmo
    * -> accesstoken [string]
    * <- device_list [array]
    * -> identifier [string]
    * <- list_measure [array[Co2]]

Part C:
AccuWeather
  * GetLocationsKeyByText
    * -> countryidentifier [string] (de)
    * -> searchquery [string] (mannheim)
    * -> apikey [string]
    * <- results [array]
  *GetDailyForecast maybe GetCurrentConditions
    * -> apikey [string]
    * -> forecasttime [sting] (1day)
    * -> locationidentifier [integer[ (see results-array) or nothing
    * <- default0 [array] or results [array]
        * check for rain* 

Part C*:
OpenWeatherMap-API

