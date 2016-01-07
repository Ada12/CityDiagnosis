package controller;

import entity.CityEntity;
import entity.IndicatorDetailEntity;
import entity.IndicatorEntity;
import entity.IndexdetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CityService;
import service.IndexDetailService;
import service.IndicatorDetailService;
import service.IndicatorService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Created by yangchen on 16-1-2.
 */
@Controller
public class MainController {

    @Autowired
    private IndexDetailService indexDetailService;
    @Autowired
    private CityService cityService;
    @Autowired
    private IndicatorService indicatorService;
    @Autowired
    private IndicatorDetailService indicatorDetailService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(){
        IndexdetailEntity entity = new IndexdetailEntity();
        entity.setCityId("5");
        entity.setIndexId("1");
        entity.setY2009("15");
        entity.setY2010("15");
        entity.setY2011("15");
        entity.setY2012("12");
        indexDetailService.createIndexDetail(entity);
        return "test";
    }

    @RequestMapping(value = "{cityId}/{indicatorId}", method = RequestMethod.GET)
    public String getMain(){
        return "main";
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
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

    @RequestMapping(value = "json/{cityId}/{indicatorId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getContent(@PathVariable("cityId") String cityId, @PathVariable("indicatorId") String indicatorId){
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, String> returnInfo = new HashMap<String, String>();
        String cityName = cityService.getCity(cityId);
        IndicatorEntity indicatorEntity = indicatorService.getIndicator(indicatorId);
        IndicatorDetailEntity indicatorDetailEntity = indicatorDetailService.getIndicatorDetail(cityId, indicatorId);
        returnInfo.put("cityName", cityName);
        returnInfo.put("cityName", cityName);
        returnInfo.put("indicatorName", indicatorEntity.getIndexName());
        returnInfo.put("unit", indicatorEntity.getUnit());
        returnInfo.put("y1996", isNum(indicatorDetailEntity.getY1996()) == false? "":indicatorDetailEntity.getY1996());
        returnInfo.put("y1997", isNum(indicatorDetailEntity.getY1997()) == false? "":indicatorDetailEntity.getY1997());
        returnInfo.put("y1998", isNum(indicatorDetailEntity.getY1998()) == false? "":indicatorDetailEntity.getY1998());
        returnInfo.put("y1999", isNum(indicatorDetailEntity.getY1999()) == false? "":indicatorDetailEntity.getY1999());
        returnInfo.put("y2000", isNum(indicatorDetailEntity.getY2000()) == false? "":indicatorDetailEntity.getY2000());
        returnInfo.put("y2001", isNum(indicatorDetailEntity.getY2001()) == false? "":indicatorDetailEntity.getY2001());
        returnInfo.put("y2002", isNum(indicatorDetailEntity.getY2002()) == false? "":indicatorDetailEntity.getY2002());
        returnInfo.put("y2003", isNum(indicatorDetailEntity.getY2003()) == false? "":indicatorDetailEntity.getY2003());
        returnInfo.put("y2004", isNum(indicatorDetailEntity.getY2004()) == false? "":indicatorDetailEntity.getY2004());
        returnInfo.put("y2005", isNum(indicatorDetailEntity.getY2005()) == false? "":indicatorDetailEntity.getY2005());
        returnInfo.put("y2006", isNum(indicatorDetailEntity.getY2006()) == false? "":indicatorDetailEntity.getY2006());
        returnInfo.put("y2007", isNum(indicatorDetailEntity.getY2007()) == false? "":indicatorDetailEntity.getY2007());
        returnInfo.put("y2008", isNum(indicatorDetailEntity.getY2008()) == false? "":indicatorDetailEntity.getY2008());
        returnInfo.put("y2009", isNum(indicatorDetailEntity.getY2009()) == false? "":indicatorDetailEntity.getY2009());
        returnInfo.put("y2010", isNum(indicatorDetailEntity.getY2010()) == false? "":indicatorDetailEntity.getY2010());
        returnInfo.put("y2011", isNum(indicatorDetailEntity.getY2011()) == false? "":indicatorDetailEntity.getY2011());
        returnInfo.put("y2012", isNum(indicatorDetailEntity.getY2012()) == false? "":indicatorDetailEntity.getY2012());
        returnInfo.put("y2013", isNum(indicatorDetailEntity.getY2013()) == false? "":indicatorDetailEntity.getY2013());
        result.put("Code", 0);
        result.put("Msg", "Success");
        result.put("results", returnInfo);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Origin", "http://localhost:8080");
        return new ResponseEntity<Map<String, Object>>(result, headers, HttpStatus.OK);
    }
}
