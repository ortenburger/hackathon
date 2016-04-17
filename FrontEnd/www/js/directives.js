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
            .on("mouseup", null);

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
            // var m = d3.mouse(this);
            // line = vis.append("line")
            //   .attr("x1", Math.round(m[0]/20)*20)
            //   .attr("y1", Math.round(m[1]/20)*20)
            //   .attr("x2", Math.round(m[0]/20)*20)
            //   .attr("y2", Math.round(m[1]/20)*20);
            //
            // vis.on("mousemove", mousemove);
            // vis.on("mousedown", null);
            vis.on("mouseup", mouseup);
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
            vis.on("mousedown", null);

            var points=[];
            vis.selectAll('line').each(function() {
              var line=d3.select(this);
              points.push({
                x1: line.attr('x1'),
                y1: line.attr('y1'),
                x2: line.attr('x2'),
                y2: line.attr('y2')
              });
            });
            if(points.length>0) {
              var lastPoint=points[points.length-1];
              if(lastPoint.x1==lastPoint.x2&&lastPoint.y1==lastPoint.y2) {
                vis.on("mousedown",mousedown);
                vis.on("mouseup",null);
                vis.selectAll("line").remove();
                return;
              }
            }
            var sanityCheck=points.length>0;
            points.forEach(function(point) {
              sanityCheck&=point.x1!=point.x2||point.y1!=point.y2;
              sanityCheck&=points.filter(function(point2) {
                  return point2.x1==point.x2&&point2.y1==point.y2;
                }).length==1;
            });
            if(sanityCheck) {
              vis.on("mouseup",null);
              $log.debug("Room complete:");
              $log.debug(points);
            }else {
              var m = d3.mouse(this);
              line = vis.append("line")
                .attr("x1", Math.round(m[0]/20)*20)
                .attr("y1", Math.round(m[1]/20)*20)
                .attr("x2", Math.round(m[0]/20)*20)
                .attr("y2", Math.round(m[1]/20)*20);

              vis.on("mousemove", mousemove);
            }
          }

          //         roomJson = { "room" : [{
          //             "id": "1",
          //             "name": "room",
          //             "dimensions": {<int>,<int>,...,<int>},
        });
      }}
  }]);
