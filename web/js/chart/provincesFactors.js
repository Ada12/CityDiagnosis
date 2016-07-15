/* // 手动选指标
	var index_list = ["土地面积建成区","第一产业从业人员比重全市","第二产业从业人员比重全市","第三产业从业人员比重全市","第一产业占的比重",
	"第二产业占的比重","第三产业占的比重","人口密度","年末部人口","人均地区生产总值","地方财政收入","地方财政支出","医院卫生院床位数",
	"城市建设用地面积","居住用地面积","工业企业数","全年供水总量","全年用电总量","全部从业人员地区","工业用电","高等学校教师数","普通中学教师数",
	"小学教师数","医院数","医生数","铁路旅客运量","公路客运量","铁路货物运量","公路货运量","社会消费品零售总额","本地电话年末用户数","建成区绿化覆盖率"];
	var sel = document.getElementById('stylelist');
	for(var i=0; i<index_list.length;i++){
		var item = new  Option(index_list[i],i);
		sel.options.add(item);
	} 
	//年份刷新 
	var Ctrl = document.getElementById('yearControl');
	Ctrl.addEventListener("change", function (evt){
		  document.getElementById('yearValue').innerHTML=evt.target.value;
		  getCityCenter(0,evt.target.value);
        }); 

*/
	
	
	//从URL取id值，作为指标值
	//var id = GetQueryString(id);
	var id = 1;
	var url = "/json/annal/"+id;
	var dataSource=[];
	var yearV = 1998;
	var maxYear = 2013;
	
	//设定指标显示值
	var factorList = ["土地面积建成区","第一产业从业人员比重全市","第二产业从业人员比重全市","第三产业从业人员比重全市","第一产业占的比重",
	"第二产业占的比重","第三产业占的比重","人口密度","年末部人口","人均地区生产总值","地方财政收入","地方财政支出","医院卫生院床位数",
	"城市建设用地面积","居住用地面积","工业企业数","全年供水总量","全年用电总量","全部从业人员地区","工业用电","高等学校教师数","普通中学教师数",
	"小学教师数","医院数","医生数","铁路旅客运量","公路客运量","铁路货物运量","公路货运量","社会消费品零售总额","本地电话年末用户数","建成区绿化覆盖率"];
	document.getElementById('factor').innerHTML = factorList[id-1];
	
	//用ajax取到json数据并得到数组。
	$.ajax({ 
          type: "get", 
          url: url,
          dataType: "json",
		  jsonp:"callback",
          success: function (data) { 
						  dataSource = data.results;
						  
						  //取完数据后再进行轮播渲染
						  setInterval("refresh()",3000);
						  console.log("done");
                           }, 
                          error: function (XMLHttpRequest, textStatus, errorThrown) { 
                          alert(errorThrown); 
                         } 
                     });
	
	//获取地址栏参数
	function GetQueryString(name)
	{
		 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		 var r = window.location.search.substr(1).match(reg);
		 if(r!=null)return  unescape(r[2]); return null;
	}
	
	 function refresh(){
		getCityCenter(yearV);
		document.getElementById('yearValue').innerHTML = yearV;
		yearV ++;
		if(yearV == maxYear+1)
			yearV = 1998;
	 } 
	 //setInterval("refresh()",3000);
	
	// 创建Map实例
	var map = new BMap.Map('allmap');
	map.centerAndZoom(new BMap.Point(110,35), 5);
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

	function getCityCenter(year) {
		//console.log("指标"+i_index);
		var data = [];
		for (var i = 0; i < dataSource.length; i++) {
			var city = dataSource[i];
			//console.log("i="+i);
			for(var j=0;j<city.content.length;j++){
				//console.log("j="+j);
				var cityDetail = city.content[j];
				if(cityDetail.year==year&&cityDetail.value!=""){
					data.push({
						lng: city.lng,
						lat: city.lat,
						count: cityDetail.value
					});
				}  
			}
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