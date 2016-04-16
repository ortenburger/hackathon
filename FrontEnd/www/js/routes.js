angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    
  

      .state('menu.home', {
    url: '/page2',
    views: {
      'side-menu21': {
        templateUrl: 'templates/home.html',
        controller: 'homeCtrl'
      }
    }
  })

  .state('menu.wakeUpAlarm', {
    url: '/page5',
    views: {
      'side-menu21': {
        templateUrl: 'templates/wakeUpAlarm.html',
        controller: 'wakeUpAlarmCtrl'
      }
    }
  })

  .state('menu.departureAlarmVRN', {
    url: '/page6',
    views: {
      'side-menu21': {
        templateUrl: 'templates/departureAlarmVRN.html',
        controller: 'departureAlarmVRNCtrl'
      }
    }
  })

  .state('menu.lightMusic', {
    url: '/page7',
    views: {
      'side-menu21': {
        templateUrl: 'templates/lightMusic.html',
        controller: 'lightMusicCtrl'
      }
    }
  })

  .state('menu.configuration', {
    url: '/page8',
    views: {
      'side-menu21': {
        templateUrl: 'templates/configuration.html',
        controller: 'configurationCtrl'
      }
    }
  })

  .state('menu', {
    url: '/side-menu21',
    templateUrl: 'templates/menu.html',
    abstract:true
  })

$urlRouterProvider.otherwise('/side-menu21/page2')

  

});