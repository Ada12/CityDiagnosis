package controller;

import entity.CityEntity;
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
import service.IndicatorService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    @RequestMapping(value = "json/{cityId}/{indicatorId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getContent(@PathVariable("cityId") String cityId, @PathVariable("indicatorId") String indicatorId){
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, String> returnInfo = new HashMap<String, String>();
        String cityName = cityService.getCity(cityId);
        IndicatorEntity indicatorEntity = indicatorService.getIndicator(indicatorId);
        IndexdetailEntity indexdetailEntity = indexDetailService.getIndexDetail(cityId, indicatorId);
        returnInfo.put("cityName", cityName);
        returnInfo.put("indicatorName", indicatorEntity.getIndexName());
        returnInfo.put("unit", indicatorEntity.getUnit());
        returnInfo.put("y2009", indexdetailEntity.getY2009());
        returnInfo.put("y2010", indexdetailEntity.getY2010());
        returnInfo.put("y2011", indexdetailEntity.getY2011());
        returnInfo.put("y2012", indexdetailEntity.getY2012());
        returnInfo.put("y2013", indexdetailEntity.getY2013());
        result.put("Code", 0);
        result.put("Msg", "Success");
        result.put("results", returnInfo);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Origin", "http://localhost:8080");
        return new ResponseEntity<Map<String, Object>>(result, headers, HttpStatus.OK);
    }
}
