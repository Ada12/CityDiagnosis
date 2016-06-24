package service;

import dao.CityPosDao;
import entity.CityPosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangchen on 16-6-23.
 */
@Transactional
@Service
public class CityPosService {

    @Autowired
    private CityPosDao cityPosDao;

    public CityPosEntity getCityPos(String cityId){
        return cityPosDao.getCityPos(cityId);
    }

    public void createCityPos(CityPosEntity cityPosEntity){
        cityPosDao.createCityPos(cityPosEntity);
    }
}
