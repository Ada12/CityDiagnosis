package controller;

import entity.IndexdetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.IndexDetailService;

/**
 * Created by yangchen on 16-1-2.
 */
@Controller
public class MainController {

    @Autowired
    private IndexDetailService indexDetailService;

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

}
