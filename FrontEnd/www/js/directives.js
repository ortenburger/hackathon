angular.module('app.directives', ['d3'])

.directive('d3Line', ['d3Service', function(d3Service){
  return {
        restrict: 'EA',
        scope: {},
        link: function(scope, element, attrs) {
          d3Service.d3().then(function(d3) {
            var line;

            var vis = d3.select(element[0]).append("svg")
              .attr("width", 600)
              .attr("height", 400)
              .attr("class", "svg")
              .on("mousedown", mousedown)
              .on("mouseup", mouseup);

            function mousedown() {
              var m = d3.mouse(this);
              line = vis.append("line")
                .attr("x1", Math.round(m[0]/50)*50)
                .attr("y1", Math.round(m[1]/50)*50)
                .attr("x2", Math.round(m[0]/50)*50)
                .attr("y2", Math.round(m[1]/50)*50);

              console.log(Math.round(m[0]/50)*50);
              console.log(Math.round(m[1]/50)*50);

              vis.on("mousemove", mousemove);
            }

            function mousemove() {
              var m = d3.mouse(this);
              line.attr("class", "line")
                .attr("x2", Math.round(m[0]/50)*50)
                .attr("y2", Math.round(m[1]/50)*50);
            }

            function mouseup() {
              vis.on("mousemove", null);
            }
          });
        }}
}]);
