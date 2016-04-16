API:
http://jsonapi.org/format/

Abstract:
set/get room dimensions
set/get position phone
set/get position light source
set/get alarm: 	(invalid fields interpreted as wildcards)
				* wakeup / jetlag
				* general inhouse
				* leaving house (weather warnings)
						- set vrn directions/get recently used 
						- get route
set/get movie-mood-values: * later: AmbiLight
set/get music-mood-values: * later: lighting console
set/get mood-settings: * later: detect user-mood and counter
set start mode:	- follow
				- movie
				- music
				- all on/off
				
Definition:				
{
  "set_current_mode": <"follow","wake_up","movie","music","day_light">,
  
  "room": [{
    "id": "<int>",
    "name": "<string>",
    "dimensions": {<int>,<int>,...,<int>},
    "user_position_list": [{"id":<int>,"x":<int>,"y"<int>}],
    "light_position_list": [{"id":<int>,"x":<int>,"y"<int>,"active":<boolean>,"type: ["hue","boolean"]}],
		  }],
		  
  "alarm": [{
	"id": "<int>",
	"name": "<string>",
    "type": {"wake_up","jetlag","inhouse","outhouse","outhouse_vrn"},
    "time": {"JJJJ-MM-TT-HH-MM","weekly":<boolean>}
		   }],
		   
  "mood": [{
	"type": <"follow","movie","music","mood">,
	"hue": <int>,
	"brightness": <int>
		  }],
		  
  "setup_mood_type": [{
	"type": <"follow","movie","music","mood">,
	"tbd": "tbd"
					 }]
}
