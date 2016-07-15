package service;

import dao.TaxiPositionDao;
import entity.TaxiPositionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yangchen on 16-6-28.
 */
@Transactional
@Service
public class TaxiPositionService {
    @Autowired
    private TaxiPositionDao taxiPositionDao;

    public List<TaxiPositionEntity> getTaxiPosition(String timePoint){
        return taxiPositionDao.getTaxiPosition(timePoint);
    }
}