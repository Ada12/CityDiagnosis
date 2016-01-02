package service;

import dao.IndexDetailDao;
import entity.IndexdetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangchen on 16-1-2.
 */
@Transactional
@Service
public class IndexDetailService {

    @Autowired
    private IndexDetailDao indexDetailDao;

    public void createIndexDetail(IndexdetailEntity indexDetailInfo){
        indexDetailDao.createIndexDetail(indexDetailInfo);
    }
}
