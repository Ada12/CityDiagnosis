package dao;

import entity.IndexdetailEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by yangchen on 16-1-2.
 */
@Repository
public class IndexDetailDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createIndexDetail(IndexdetailEntity indexDetailInfo){
        entityManager.persist(indexDetailInfo);
    }



}
