package controller;

import entity.CityEntity;
import entity.CityPosEntity;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CityPosService;
import service.CityService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
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

    @RequestMapping(value = "annal/{indicatorId}", method = RequestMethod.GET)
    public String getAnnal(){
        return "annal";
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
