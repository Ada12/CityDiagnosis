package service;

import dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangchen on 16-1-2.
 */
@Transactional
@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    public String getCity(String cityId){
        return cityDao.getCity(cityId);
    }

}
