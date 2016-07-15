package controller;

import entity.CityEntity;
import entity.CityPosEntity;
import entity.IndicatorDetailEntity;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.CityPosService;
import service.CityService;
import service.IndicatorDetailService;
import service.IndicatorService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.util.List;

/**
 * Created by yangchen on 16-6-23.
 */
@Controller
public class AnnalController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CityPosService cityPosService;

    @Autowired
    private IndicatorService indicatorService;

    @Autowired
    private IndicatorDetailService indicatorDetailService;

    @RequestMapping(value = "annal/{indicatorId}", method = RequestMethod.GET)
    public String getAnnal(){
        return "factors";
    }

    @RequestMapping(value = "json/annal/{indicatorId}", method = RequestMethod.GET, consumes="*")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getJsonAnnal(@PathVariable("indicatorId") String indicatorId){
        Map<String, Object> returnInfo = new HashMap<String, Object>();
        List<CityEntity> listCity = cityService.getAllCity();
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < listCity.size(); i ++){
            CityPosEntity cityPos = cityPosService.getCityPos(listCity.get(i).getCityId());
            IndicatorDetailEntity indicatorDetailEntity = indicatorDetailService.getIndicatorDetail(listCity.get(i).getCityId(), indicatorId);
            if(cityPos != null){
                Map<String, Object> single = new HashMap<String, Object>();
                String cityName = listCity.get(i).getCityName();
                String cityLng = cityPos.getCityLng();
                String cityLat = cityPos.getCityLat();
                List<Map<String, String>> listContent = new ArrayList<Map<String, String>>();
                Map<String, String> c1998 = new HashMap<String, String>();
                c1998.put("year", "1998");
                c1998.put("value", isNum(indicatorDetailEntity.getY1998()) == false ? "" : indicatorDetailEntity.getY1998());
                listContent.add(c1998);
                Map<String, String> c1999 = new HashMap<String, String>();
                c1999.put("year", "1999");
                c1999.put("value", isNum(indicatorDetailEntity.getY1999()) == false ? "" : indicatorDetailEntity.getY1999());
                listContent.add(c1999);
                Map<String, String> c2000 = new HashMap<String, String>();
                c2000.put("year", "2000");
                c2000.put("value", isNum(indicatorDetailEntity.getY2000()) == false ? "" : indicatorDetailEntity.getY2000());
                listContent.add(c2000);
                Map<String, String> c2001 = new HashMap<String, String>();
                c2001.put("year", "2001");
                c2001.put("value", isNum(indicatorDetailEntity.getY2001()) == false ? "" : indicatorDetailEntity.getY2001());
                listContent.add(c2001);
                Map<String, String> c2002 = new HashMap<String, String>();
                c2002.put("year", "2002");
                c2002.put("value", isNum(indicatorDetailEntity.getY2002()) == false ? "" : indicatorDetailEntity.getY2002());
                listContent.add(c2002);
                Map<String, String> c2003 = new HashMap<String, String>();
                c2003.put("year", "2003");
                c2003.put("value", isNum(indicatorDetailEntity.getY2003()) == false ? "" : indicatorDetailEntity.getY2003());
                listContent.add(c2003);
                Map<String, String> c2004 = new HashMap<String, String>();
                c2004.put("year", "2004");
                c2004.put("value", isNum(indicatorDetailEntity.getY2004()) == false ? "" : indicatorDetailEntity.getY2004());
                listContent.add(c2004);
                Map<String, String> c2005 = new HashMap<String, String>();
                c2005.put("year", "2005");
                c2005.put("value", isNum(indicatorDetailEntity.getY2005()) == false ? "" : indicatorDetailEntity.getY2005());
                listContent.add(c2005);
                Map<String, String> c2006 = new HashMap<String, String>();
                c2006.put("year", "2006");
                c2006.put("value", isNum(indicatorDetailEntity.getY2006()) == false ? "" : indicatorDetailEntity.getY2006());
                listContent.add(c2006);
                Map<String, String> c2007 = new HashMap<String, String>();
                c2007.put("year", "2007");
                c2007.put("value", isNum(indicatorDetailEntity.getY2007()) == false ? "" : indicatorDetailEntity.getY2007());
                listContent.add(c2007);
                Map<String, String> c2008 = new HashMap<String, String>();
                c2008.put("year", "2008");
                c2008.put("value", isNum(indicatorDetailEntity.getY2008()) == false ? "" : indicatorDetailEntity.getY2008());
                listContent.add(c2008);
                Map<String, String> c2009 = new HashMap<String, String>();
                c2009.put("year", "2009");
                c2009.put("value", isNum(indicatorDetailEntity.getY2009()) == false ? "" : indicatorDetailEntity.getY2009());
                listContent.add(c2009);
                Map<String, String> c2010 = new HashMap<String, String>();
                c2010.put("year", "2010");
                c2010.put("value", isNum(indicatorDetailEntity.getY2010()) == false ? "" : indicatorDetailEntity.getY2010());
                listContent.add(c2010);
                Map<String, String> c2011 = new HashMap<String, String>();
                c2011.put("year", "2011");
                c2011.put("value", isNum(indicatorDetailEntity.getY2011()) == false ? "" : indicatorDetailEntity.getY2011());
                listContent.add(c2011);
                Map<String, String> c2012 = new HashMap<String, String>();
                c2012.put("year", "2012");
                c2012.put("value", isNum(indicatorDetailEntity.getY2012()) == false ? "" : indicatorDetailEntity.getY2012());
                listContent.add(c2012);
                Map<String, String> c2013 = new HashMap<String, String>();
                c2013.put("year", "2013");
                c2013.put("value", isNum(indicatorDetailEntity.getY2013()) == false ? "" : indicatorDetailEntity.getY2013());
                listContent.add(c2013);
                single.put("city", cityName);
                single.put("lng", cityLng);
                single.put("lat", cityLat);
                single.put("content", listContent);
                result.add(single);
            }
        }
        returnInfo.put("Code", 0);
        returnInfo.put("Msg", "Success");
        returnInfo.put("results", result);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("allowed_cross_domains", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", " Accept, Content-Type");
        headers.add("Access-Control-Max-Age", "1728000");
        return new ResponseEntity<Map<String, Object>>(returnInfo, headers, HttpStatus.OK);
    }

    public boolean isNum(String msg){
        if(msg.isEmpty()){
            return true;
        }else {
            if (java.lang.Character.isDigit(msg.charAt(0))) {
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "putAnnal", method = RequestMethod.GET)
    public void setCityPos(){
        List<CityEntity> listCityEntity = cityService.getAllCity();
        for(int i = 0; i < listCityEntity.size(); i ++){
            CityPosEntity cityPosEntity = new CityPosEntity();
            String cityId = listCityEntity.get(i).getCityId();

            if(cityId != null){
                String cityName = listCityEntity.get(i).getCityName();
                String url = "http://api.map.baidu.com/geocoder/v2/?address="+ cityName +"&output=json&ak=X2FGKdTqlfoXvwXhdz8UYEko&callback=showLocation";
                String resource = getData(url);
                String[] r = resource.split("\\(|\\)");
                try {
                    if(r.length>1){
                        JSONObject resourceJson = new JSONObject(r[1]);
                        int status = resourceJson.getInt("status");
                        if(status == 0){
                            if(!resourceJson.isNull("result")){
                                JSONObject result = resourceJson.getJSONObject("result");
                                if(!result.isNull("location")){
                                    JSONObject location = result.getJSONObject("location");
                                    double lng = location.getDouble("lng");
                                    double lat = location.getDouble("lat");
                                    cityPosEntity.setCityId(cityId);
                                    cityPosEntity.setCityLng(lng+"");
                                    cityPosEntity.setCityLat(lat+"");
                                    cityPosService.createCityPos(cityPosEntity);
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getData(String urlString){
        String result = "";
        BufferedReader read = null;
        try{
            URL realurl = new URL(urlString);
            URLConnection connection = realurl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            for(String key : map.keySet()){
                System.out.println(key + "--->" + map.get(key));
            }
            read = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while((line = read.readLine()) != null){
                result += line;
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(read != null){
                try {
                    read.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
