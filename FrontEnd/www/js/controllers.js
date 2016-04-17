angular.module('app.controllers', [])

.controller('homeCtrl', function($scope) {

})

.controller('wakeUpAlarmCtrl', function($scope, ionicTimePicker) {

$scope.opentimer=function(){
  console.log("scope click");
  var ipObj1 = {
  callback: function (val) {      //Mandatory
  if (typeof (val) === 'undefined') {
    console.log('Time not selected');
  } else {
     $scope.selectedTime = new Date(val * 1000);
    console.log('Selected epoch is : ', val, 'and the time is ', selectedTime.getUTCHours(), 'H :', selectedTime.getUTCMinutes(), 'M');
  }
  },
  inputTime: 50400,   //Optional
  format: 24,         //Optional
  step: 5,           //Optional
  setLabel: 'Set'    //Optional
  };
ionicTimePicker.openTimePicker(ipObj1);

};

})

.controller('departureAlarmVRNCtrl', function($scope) {

})

.controller('lightMusicCtrl', function($scope) {

})

.controller('configurationCtrl', function($scope) {



      $scope.checkMComBtn = function(comment_count) {
        var intValue = parseInt(comment_count) || 0;
        console.log('intValue ' , intValue);

        if (intValue > 0) {
          return 1;
        }
      }

})

.controller('connectToLampCtrl', function($scope, hueService) {
  $scope.hueService=hueService;
})


.controller('positionLampsCtrl', function($scope) {

})
