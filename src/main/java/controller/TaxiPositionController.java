package controller;

import entity.TaxiPositionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.TaxiPositionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangchen on 16-6-28.
 */
@Controller
public class TaxiPositionController {
    @Autowired
    private TaxiPositionService taxiPositionService;

    @RequestMapping(value = "taxi", method = RequestMethod.GET)
    public String getTaxi(){
        return "taxi";
    }

    @RequestMapping(value = "json/taxi/{timePoint}", method = RequestMethod.GET, consumes="*")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getJsonAnnal(@PathVariable("timePoint") String timePoint){

        Map<String, Object> returnInfo = new HashMap<String, Object>();
        List<TaxiPositionEntity> list = taxiPositionService.getTaxiPosition(timePoint);
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        for(int i = 0; i < list.size(); i ++){
            Map<String, String> single = new HashMap<String, String>();
            single.put("lng", list.get(i).getLng());
            single.put("lat", list.get(i).getLat());
            single.put("count", list.get(i).getCount());
            result.add(single);
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
}
