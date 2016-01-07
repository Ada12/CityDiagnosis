<%--
  Created by IntelliJ IDEA.
  User: yangchen
  Date: 16-1-3
  Time: 下午12:59
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
            var urlSend = "/json/" + content[3] + "/" + content[4];
            $.get(urlSend, {Action:"get",Name:"yc"}, function (response, textStatus){
//                var y1 = response.results["y1996"] == null? null : parseFloat(response.results["y1996"]);
//                var y2 = response.results["y1997"] == null? null : parseFloat(response.results["y1997"]);
//                var y3 = response.results["y1998"] == null? null : parseFloat(response.results["y1998"]);
//                var y4 = response.results["y1999"] == null? null : parseFloat(response.results["y1999"]);
//                var y5 = response.results["y2000"] == null? null : parseFloat(response.results["y2000"]);
//                var y6 = response.results["y2001"] == null? null : parseFloat(response.results["y2001"]);
//                var y7 = response.results["y2002"] == null? null : parseFloat(response.results["y2002"]);
//                var y8 = response.results["y2003"] == null? null : parseFloat(response.results["y2003"]);
//                var y9 = response.results["y2004"] == null? null : parseFloat(response.results["y2004"]);
//                var y10 = response.results["y2005"] == null? null : parseFloat(response.results["y2005"]);
//                var y11 = response.results["y2006"] == null? null : parseFloat(response.results["y2006"]);
//                var y12 = response.results["y2007"] == null? null : parseFloat(response.results["y2007"]);
//                var y13 = response.results["y2008"] == null? null : parseFloat(response.results["y2008"]);
//                var y14 = response.results["y2009"] == null? null : parseFloat(response.results["y2009"]);
//                var y15 = response.results["y2010"] == null? null : parseFloat(response.results["y2010"]);
//                var y16 = response.results["y2011"] == null? null : parseFloat(response.results["y2011"]);
//                var y17 = response.results["y2012"] == null? null : parseFloat(response.results["y2012"]);
//                var y18 = response.results["y2013"] == null? null : parseFloat(response.results["y2013"]);


                var y1 = response.results["y1996"] == ""? null : parseFloat(response.results["y1996"]);
                var y2 = response.results["y1997"] == ""? null : parseFloat(response.results["y1997"]);
                var y3 = response.results["y1998"] == ""? null : parseFloat(response.results["y1998"]);
                var y4 = response.results["y1999"] == ""? null : parseFloat(response.results["y1999"]);
                var y5 = response.results["y2000"] == ""? null : parseFloat(response.results["y2000"]);
                var y6 = response.results["y2001"] == ""? null : parseFloat(response.results["y2001"]);
                var y7 = response.results["y2002"] == ""? null : parseFloat(response.results["y2002"]);
                var y8 = response.results["y2003"] == ""? null : parseFloat(response.results["y2003"]);
                var y9 = response.results["y2004"] == ""? null : parseFloat(response.results["y2004"]);
                var y10 = response.results["y2005"] == ""? null : parseFloat(response.results["y2005"]);
                var y11 = response.results["y2006"] == ""? null : parseFloat(response.results["y2006"]);
                var y12 = response.results["y2007"] == ""? null : parseFloat(response.results["y2007"]);
                var y13 = response.results["y2008"] == ""? null : parseFloat(response.results["y2008"]);
                var y14 = response.results["y2009"] == ""? null : parseFloat(response.results["y2009"]);
                var y15 = response.results["y2010"] == ""? null : parseFloat(response.results["y2010"]);
                var y16 = response.results["y2011"] == ""? null : parseFloat(response.results["y2011"]);
                var y17 = response.results["y2012"] == ""? null : parseFloat(response.results["y2012"]);
                var y18 = response.results["y2013"] == ""? null : parseFloat(response.results["y2013"]);




                $('#container').highcharts({
                            colors: ["#2b908f", "#90ee7e", "#f45b5b", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
                                "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
                            chart: {
                                type: 'area',
//                                renderTo: 'container',
//                                events: {
//                                    load: function(event) {
//                                        this.series[0].update({
//                                            type: 'areaspline'
//                                        });
//                                    }
//                                },
                                backgroundColor: {
                                    linearGradient: { x1: 0, y1: 0, x2: 1, y2: 1 },
                                    stops: [
                                        [0, '#2a2a2b'],
                                        [1, '#3e3e40']
                                    ]
                                },
                                style: {
                                    fontFamily: "'Unica One', sans-serif"
                                },
                                plotBorderColor: '#606063'
                            },
                            title: {
                                style: {
                                    color: '#E0E0E3',
                                    textTransform: 'uppercase',
                                    fontSize: '20px'
                                },
                                text: response.results['cityName'] + ": " + response.results['indicatorName']
                            },
                            subtitle: {
                                style: {
                                    color: '#E0E0E3',
                                    textTransform: 'uppercase'
                                }
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
                                title: {
                                    style: {
                                        color: '#A0A0A3'
                                    }
                                },
                                categories:[
                                        1996,
                                        1997,
                                        1998,
                                        1999,
                                        2000,
                                        2001,
                                        2002,
                                        2003,
                                        2004,
                                        2005,
                                        2006,
                                        2007,
                                        2008,
                                        2009,
                                        2010,
                                        2011,
                                        2012,
                                        2013
                                ]
                            },
                            yAxis: {
                                gridLineColor: '#707073',
                                labels: {
                                    style: {
                                        color: '#E0E0E3'
                                    }
//                                    formatter: function() { return this.value; }
                                },
                                lineColor: '#707073',
                                minorGridLineColor: '#505053',
                                tickColor: '#707073',
                                tickWidth: 1,
                                title: {
                                    style: {
                                        color: '#A0A0A3'
                                    },
                                    text: response.results['unit']
                                }
                            },
                            tooltip: {
                                backgroundColor: 'rgba(0, 0, 0, 0.85)',
                                style: {
                                    color: '#F0F0F0'
                                }
//                                formatter: function() {
//                                    return '<b>'+ this.series.name +'</b><br/>'+
//                                            this.x +': '+ this.y;
//                                }
                            },
                            plotOptions: {
                                series: {
                                    dataLabels: {
                                        color: '#B0B0B3'
                                    },
                                    marker: {
                                        lineColor: '#333'
                                    },
                                    area: { fillOpacity: 0.5 }
                                },
                                boxplot: {
                                    fillColor: '#505053'
                                },
                                candlestick: {
                                    lineColor: 'white'
                                },
                                errorbar: {
                                    color: 'white'
                                }
                            },
                            legend: {
                                itemStyle: {
                                    color: '#E0E0E3'
                                },
                                itemHoverStyle: {
                                    color: '#FFF'
                                },
                                itemHiddenStyle: {
                                    color: '#606063'
                                }
                               // layout: 'vertical', align: 'left', verticalAlign: 'top', x: 150, y: 100, floating: true, borderWidth: 1
                            },
                            credits: {
                                style: {
                                    color: '#666'
                                }
                            },
                            labels: {
                                style: {
                                    color: '#707073'
                                }
                            },
                            drilldown: {
                                activeAxisLabelStyle: {
                                    color: '#F0F0F3'
                                },
                                activeDataLabelStyle: {
                                    color: '#F0F0F3'
                                }
                            },
                            navigation: {
                                buttonOptions: {
                                    symbolStroke: '#DDDDDD',
                                    theme: {
                                        fill: '#505053'
                                    }
                                }
                            },
// scroll charts
                            rangeSelector: {
                                buttonTheme: {
                                    fill: '#505053',
                                    stroke: '#000000',
                                    style: {
                                        color: '#CCC'
                                    },
                                    states: {
                                        hover: {
                                            fill: '#707073',
                                            stroke: '#000000',
                                            style: {
                                                color: 'white'
                                            }
                                        },
                                        select: {
                                            fill: '#000003',
                                            stroke: '#000000',
                                            style: {
                                                color: 'white'
                                            }
                                        }
                                    }
                                },
                                inputBoxBorderColor: '#505053',
                                inputStyle: {
                                    backgroundColor: '#333',
                                    color: 'silver'
                                },
                                labelStyle: {
                                    color: 'silver'
                                }
                            },
                            navigator: {
                                handles: {
                                    backgroundColor: '#666',
                                    borderColor: '#AAA'
                                },
                                outlineColor: '#CCC',
                                maskFill: 'rgba(255,255,255,0.1)',
                                series: {
                                    color: '#7798BF',
                                    lineColor: '#A6C7ED'
                                },
                                xAxis: {
                                    gridLineColor: '#505053'
                                }
                            },
                            scrollbar: {
                                barBackgroundColor: '#808083',
                                barBorderColor: '#808083',
                                buttonArrowColor: '#CCC',
                                buttonBackgroundColor: '#606063',
                                buttonBorderColor: '#606063',
                                rifleColor: '#FFF',
                                trackBackgroundColor: '#404043',
                                trackBorderColor: '#404043'
                            },
// special colors for some of the
                            legendBackgroundColor: 'rgba(0, 0, 0, 0.5)',
                            background2: '#505053',
                            dataLabelsColor: '#B0B0B3',
                            textColor: '#C0C0C0',
                            contrastTextColor: '#F0F0F3',
                            maskColor: 'rgba(255,255,255,0.3)',

                            series: [{
                                //change indicator
                                name: response.results['indicatorName'],
                                //change indicator detail
                                data: [y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, y11, y12, y13, y14, y14, y16, y17, y18],
                                //threshold: null
                            }]
                        }
                );
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
