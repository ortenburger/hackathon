angular.module('app.directives', ['d3'])

.directive('d3Line', ['d3Service', '$log', function(d3Service,$log){
  return {
        restrict: 'EA',
        scope: {},
        link: function(scope, element, attrs) {
          d3Service.d3().then(function(d3) {
            var line;
            var roomJson;
            var vis = d3.select(element[0]).append("svg")
              .attr("width", 600)
              .attr("height", 400)
              .attr("class", "svg")
              .on("mousedown", mousedown)
              .on("mouseup", mouseup);

            for(var i=0;i<31;i++) {
              for(var j=0;j<21;j++) {
                circle = vis.append("circle")
                  .attr("cx", i*20)
                  .attr("cy", j*20)
                  .attr("r", 0.5)

              }
            }

            function mousedown(e) {
              e = e || window.event;
              e.stopPropagation();
              var m = d3.mouse(this);
              line = vis.append("line")
                .attr("x1", Math.round(m[0]/20)*20)
                .attr("y1", Math.round(m[1]/20)*20)
                .attr("x2", Math.round(m[0]/20)*20)
                .attr("y2", Math.round(m[1]/20)*20);

              vis.on("mousemove", mousemove);
            }

            function mousemove(e) {
              e = e || window.event;
              e.stopPropagation();
              var m = d3.mouse(this);
              line.attr("class", "line")
                .attr("x2", Math.round(m[0]/20)*20)
                .attr("y2", Math.round(m[1]/20)*20);
            }

            function mouseup(e) {
              e = e || window.event;
              e.stopPropagation();
              vis.on("mousemove", null);

              vis.selectAll('line').each(function(d,i) {
                  var line=d3.select(this);
                  $log.debug(line.attr('x1')+'/'+line.attr('y1')+' - '+line.attr('x2')+'/'+line.attr('y2'));
              });

            }

   //         roomJson = { "room" : [{
   //             "id": "1",
   //             "name": "room",
   //             "dimensions": {<int>,<int>,...,<int>},
          });
        }}
}]);
