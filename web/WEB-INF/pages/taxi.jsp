<!DOCTYPE html>
<html>
<head>
    <title>create a map</title>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=1XjLLEhZhQNUzd93EjU5nOGQ"></script>
	<script type="text/javascript" src="http://huiyan-fe.github.io/mapv/dist/Mapv.js"></script>
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
</head>

<body>
<div style = "opacity: 0.7;
   position: absolute;
   top: 10px;
   left: 10px;
   background-color: #000000;
   z-index: 1">
			<p style="color:#ffffff;">出租车：<span id="factor" >--</span></p >
			<!-- <select id="stylelist" onchange="getCityCenter(this.value)"></select> -->
			<!-- <select id="stylelist"></select> -->
			<p style="color:#ffffff;">时间：<span id="time" >--</span></p >
			<!-- <input id="yearControl" class ="sliderbar" type="range" max=2 min=0 value=0 step=1/> -->
</div>

<div id="allmap"></div>

</body>

 <script type="text/javascript" src="/js/chart/mapstyle.js"></script>
 <script type="text/javascript" src="/js/chart/taxi.js"></script>

</html>