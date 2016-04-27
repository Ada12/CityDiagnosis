<%--
  Created by IntelliJ IDEA.
  User: yangchen
  Date: 16-3-26
  Time: 下午8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script language="JavaScript" src="/js/chart/jquery.min.js"></script>
    <style type="text/css">
        ${demo.css}
    </style>
    <script type="text/javascript">
        function getResult(){
            var url = window.location.href;
            var content = url.split('/');
            var urlSend = "/json/multi/" + content[4] + "/" + content[5];
            $.get(urlSend, {Action:"get",Name:"yc"}, function (response, textStatus){
            $('#container').highcharts({
                colors: ["#2b908f", "#90ee7e", "#f45b5b", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
                chart: { backgroundColor: { linearGradient: { x1: 0, y1: 0, x2: 1, y2: 1 }, stops: [ [0, '#2a2a2b'], [1, '#3e3e40'] ] }, style: { fontFamily: "'Unica One', sans-serif" }, plotBorderColor: '#606063' },
                title: {
                    style: { color: '#E0E0E3', textTransform: 'uppercase', fontSize: '20px' },
                    text: response.results[0]['indicatorName'],
                    x: -20 //center
                },
                xAxis: {
                    gridLineColor: '#707073',
                    labels: {
                        style: {
                            color: '#E0E0E3'
                        }
                    },
                    lineColor: '#707073',
                    minorGridLineColor: '#505053',
                    tickColor: '#707073',
                    title: { style: { color: '#A0A0A3' } },
                    categories: [1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013]
                },
                yAxis: {
                    gridLineColor: '#707073', labels: { style: { color: '#E0E0E3' } }, lineColor: '#707073', minorGridLineColor: '#505053', tickColor: '#707073', tickWidth: 1, title: { style: { color: '#A0A0A3' } },
                    title: {
                        text: response.results[0]['indicatorName'] + " / " + response.results[0]['unit']
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    backgroundColor: 'rgba(0, 0, 0, 0.85)', style: { color: '#F0F0F0' },
                    valueSuffix: response.results[0]['unit']
                },
                legend: {
                    itemStyle: { color: '#E0E0E3' }, itemHoverStyle: { color: '#FFF' }, itemHiddenStyle: { color: '#606063' },
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle',
                    borderWidth: 0
                }
                });
                    var chart = $('#container').highcharts();
                    for(var i=0; i<response.results.length; i++){
                        chart.addSeries({
                                    name: response.results[i]["cityName"],
                                    data: [
                                        response.results[i]["y1998"] == ""? null : parseFloat(response.results[i]["y1998"]),
                                        response.results[i]["y1999"] == ""? null : parseFloat(response.results[i]["y1999"]),
                                        response.results[i]["y2000"] == ""? null : parseFloat(response.results[i]["y2000"]),
                                        response.results[i]["y2001"] == ""? null : parseFloat(response.results[i]["y2001"]),
                                        response.results[i]["y2002"] == ""? null : parseFloat(response.results[i]["y2002"]),
                                        response.results[i]["y2003"] == ""? null : parseFloat(response.results[i]["y2003"]),
                                        response.results[i]["y2004"] == ""? null : parseFloat(response.results[i]["y2004"]),
                                        response.results[i]["y2005"] == ""? null : parseFloat(response.results[i]["y2005"]),
                                        response.results[i]["y2006"] == ""? null : parseFloat(response.results[i]["y2006"]),
                                        response.results[i]["y2007"] == ""? null : parseFloat(response.results[i]["y2007"]),
                                        response.results[i]["y2008"] == ""? null : parseFloat(response.results[i]["y2008"]),
                                        response.results[i]["y2009"] == ""? null : parseFloat(response.results[i]["y2009"]),
                                        response.results[i]["y2010"] == ""? null : parseFloat(response.results[i]["y2010"]),
                                        response.results[i]["y2011"] == ""? null : parseFloat(response.results[i]["y2011"]),
                                        response.results[i]["y2012"] == ""? null : parseFloat(response.results[i]["y2012"]),
                                        response.results[i]["y2013"] == ""? null : parseFloat(response.results[i]["y2013"])
                                    ]
                                }
                        );
                    }

            })
        }

        $(document).ready(function(){
            $('#highcharts-0').click();
        });

    </script>
</head>
<body style="background-color: black" onload="getResult()">
<script language="JavaScript" src="/js/chart/highcharts.js"></script>
<script language="JavaScript" src="/js/chart/exporting.js"></script>
<!--<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>-->
<div id="container" style="height: 537px; margin: 0px auto"></div>
</body>
</html>