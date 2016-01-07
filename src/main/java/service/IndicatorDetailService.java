package service;

import dao.IndicatorDetailDao;
import entity.IndicatorDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangchen on 16-1-7.
 */
@Transactional
@Service
public class IndicatorDetailService {
    @Autowired
    private IndicatorDetailDao indicatorDetailDao;

    public IndicatorDetailEntity getIndicatorDetail(String cityId, String indicatorId){
        return  indicatorDetailDao.getIndicatorDetail(cityId, indicatorId);
    }
}
