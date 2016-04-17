angular.module('app.services', [])

.factory('hueService', ['$soap', function($soap){
  var baseUrl='http://10.10.1.107:9998/ws/hue/';
  return {
      getAllLights: function() {
        return $soap.post(baseUrl,'getAllLights',{});
      }
  }
}]);

angular.module('angularSoap', [])
  .factory('$soap', ['$q', function($q) {
    return {
      post: function(url, action, params) {
        var deferred=$q.defer();
        var soapParams = new SOAPClientParameters();
  			for(var param in params){
  				soapParams.add(param, params[param]);
  			}

  			//Create Callback
  			var soapCallback = function(e){
  				if(e.constructor.toString().indexOf("function Error()") != -1){
  					deferred.reject("An error has occurred.");
  				} else {
            console.log(e);
  					deferred.resolve(e);
  				}
  			}

  			SOAPClient.invoke(url, action, soapParams, true, soapCallback);

  			return deferred.promise;
      }
    }
  }]);
angular.module('d3', [])
  .factory('d3Service', ['$document', '$q', '$rootScope',
    function($document, $q, $rootScope) {
      var d = $q.defer();
      function onScriptLoad() {
        // Load client in the browser
        $rootScope.$apply(function() { d.resolve(window.d3); });
      }
      // Create a script tag with d3 as the source
      // and call our onScriptLoad callback when it
      // has been loaded
      var scriptTag = $document[0].createElement('script');
      scriptTag.type = 'text/javascript';
      scriptTag.async = true;
      scriptTag.src = 'http://d3js.org/d3.v3.min.js';
      scriptTag.onreadystatechange = function () {
        if (this.readyState == 'complete') onScriptLoad();
      }
      scriptTag.onload = onScriptLoad;

      var s = $document[0].getElementsByTagName('body')[0];
      s.appendChild(scriptTag);

      return {
        d3: function() { return d.promise; }
      };
}]);
