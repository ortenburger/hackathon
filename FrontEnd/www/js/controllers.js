angular.module('app.controllers', [])

.controller('homeCtrl', function($scope) {

})

.controller('wakeUpAlarmCtrl', function($scope) {

})

.controller('departureAlarmVRNCtrl', function($scope) {

})

.controller('lightMusicCtrl', function($scope) {

})

.controller('configurationCtrl', function($scope) {

})

.controller('connectToLampCtrl', function($scope, hueService) {
  $scope.hueService=hueService;
})


.controller('positionLampsCtrl', function($scope) {

})
