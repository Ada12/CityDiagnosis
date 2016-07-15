	
	var time = "201504301000";      //每隔五分钟自增
	var dataSource=[];
	
	//设定指标显示值
	document.getElementById('factor').innerHTML = "辆";
	
	//取完数据后再进行地图渲染
	setInterval("refresh()",10000);
	//用ajax取到json数据并得到数组。
	function refresh(){
		var url = "/json/taxi";
		$.ajax({ 
			  type: "get", 
			  url: url,
			  dataType: "json",
			  jsonp:"callback",
			  success: function (data) { 
							  dataSource = data.results;
							   }, 
							  error: function (XMLHttpRequest, textStatus, errorThrown) { 
							  //alert(errorThrown);
							 } 
						 });
		    
			getCityCenter();
			time = add(time);
			document.getElementById('time').innerHTML = time.substr(0,4)+"年"+time.substr(4,2)+"月"
														+time.substr(6,2)+"日"+time.substr(8,2)+":"+time.substr(10,2);
		
	 } 
	 //时间自增函数，每五分钟刷新一次数据
	 function add(time){
		 if(time.substr(10,2)<60&&time.substr(8,2)<24&&time.substr(6,2)<32){
			 time = parseInt(time)+5;
			 time = time.toString();
			 //小时进位
			 if(time.substr(10,2)==60){
				 time = parseInt(time)+100;
				 time = time.toString();
				 time = time.substr(0,10)+"00";
				 }
			 //天进位
			 if(time.substr(8,2)==24){
				 time = parseInt(time)+10000;
				 time = time.toString();
				 time = time.substr(0,8)+"0000";
			 }
			 //判断闰年，月进位
			 if(time.substr(4,2)=="02"){
				 var judge = parseInt(time.substr(0,4));
				 if(judge%4==0&&time.substr(6,2)==30){
					 //console.log(time.substr(4,2));
					 time = parseInt(time)+1000000;
					 time = time.toString();
					 time = time.substr(0,6)+"010000";
					 //console.log("29天");
				 }
				 else if(judge%4!=0&&time.substr(6,2)==29){
					 //console.log(time.substr(4,2));
					 time = parseInt(time)+1000000;
					 time = time.toString();
					 time = time.substr(0,6)+"010000";
					 //console.log("28天");
				 }
			 }
			 //判断月份天数，月进位
			 if((time.substr(4,2)=="04"&&time.substr(6,2)==31)||(time.substr(4,2)=="06"&&time.substr(6,2)==31)||(time.substr(4,2)=="09"&&time.substr(6,2)==31)
				 ||(time.substr(4,2)=="11"&&time.substr(6,2)==31)){
				 //console.log(time.substr(4,2));
				 time = parseInt(time)+1000000;
				 time = time.toString();
				 time = time.substr(0,6)+"010000";
				 //console.log("30天");
			 }
			 if((time.substr(4,2)=="01"&&time.substr(6,2)==32)||(time.substr(4,2)=="03"&&time.substr(6,2)==32)||(time.substr(4,2)=="05"&&time.substr(6,2)==32)
				 ||(time.substr(4,2)=="07"&&time.substr(6,2)==32)||(time.substr(4,2)=="08"&&time.substr(6,2)==32)||(time.substr(4,2)=="10"&&time.substr(6,2)==32)){
				// console.log(time.substr(4,2));
				 time = parseInt(time)+1000000;
				 time = time.toString();
				 time = time.substr(0,6)+"010000";
				 //console.log("31天");
			 }
			 //年进位
			 if(time.substr(4,2)==12&&time.substr(6,2)==32){
				 time = parseInt(time)+100000000;
				 time = time.toString();
				 time = time.substr(0,4)+"01010000";
			 } 
			 return time;
		 }
	 }
	
	// 创建Map实例
	var map = new BMap.Map('allmap');
	map.centerAndZoom(new BMap.Point(121.48,31.42), 10);
	map.setMapStyle({
	  styleJson:mapstyle
	});
	map.enableScrollWheelZoom(true); 


	// Mapv 点图层
	var mapv = new Mapv({
		drawTypeControl: true,
		map: map  // 百度地图的map实例
	});

		
	$("#zoomer").css("height","320");

	function getCityCenter() {
		//console.log("指标"+i_index);
		var data = [];
		for (var i = 0; i < dataSource.length; i++) {
			var taxi = dataSource[i];
			//console.log("i="+i);
				//console.log("j="+j);
			var taxiNum = taxi.count;
			data.push({
				lng: taxi.lng,
				lat: taxi.lat,
				count: taxiNum
			});
		}
		layer.set("data",data);
	};

	var data =[];
	var layer = new Mapv.Layer({
		zIndex: 3, // 图层的层级
		mapv: mapv, // 对应的mapv
		dataType: 'point', // 数据类型，point:点数据类型,polyline:线数据类型,polygon:面数据类型
		data: data,
		drawType: 'density', // 渲染数据方式, simple:普通的打点, [更多查看类参考](https://github.com/huiyan-fe/mapv/wiki/%E7%B1%BB%E5%8F%82%E8%80%83)
		// 渲染数据参数
		drawOptions: { // 绘制参数
			type: "rect", // 方形网格
			//type: "honeycomb", //蜂窝
			size: 50, // 网格大小
			unit: 'px', // 单位
			opacity: '0.5',
			//globalAlpha: 0.5, //蜂窝
			label: { // 是否显示文字标签
				show: true,
			},
			gradient: { // 显示的颜色渐变范围
				'0': 'blue',
				'0.6': 'cyan',
				'0.7': 'lime',
				'0.8': 'yellow',
				'1.0': 'red'
			},
		}
	});