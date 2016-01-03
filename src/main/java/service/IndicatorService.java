package service;

import dao.IndicatorDao;
import entity.IndicatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by yangchen on 16-1-3.
 */
@Transactional
@Service
public class IndicatorService {

    @Autowired
    private IndicatorDao indicatorDao;

    public IndicatorEntity getIndicator(String indicatorId){
        return indicatorDao.getIndicator(indicatorId);
    }

}
