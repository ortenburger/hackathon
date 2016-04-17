# The FlowSpot Project

We create a Server-Client based solution to track your position in your flat to automatically adjust the lighting. Furthermore the lights are used as an alarm clock and to remind you of tasks like going to the bus at the right time (livetracking of departures), taking an umbrella along or based on the netatmo readouts to ventilate your room. The lights adjust their color temperature to brighten up the mood depending on the current weather. Sometimes in the future FlowSpot will utilize the smartphones front camera to detect the users mood and counteract it.
Prerequisites

  * Install 'ionics framework'
  * Install a JVM
  * Install 'python3'
  * Clone the project by git clone https://github.com/ortenburger/hackathon.git

## Usage

### Do some stuff

    Checkout project
    $> cd PROJECT_DIR
    get your geo-location to setup nearest rnv-stops by ./calcdiststation/calcdiststation.py (in float)
    ionics serve localhost
    open localhost:8100 to see the frontend simulation

## Bam it's on Baby! We RoCI{
