package dao;

import entity.IndicatorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * Created by yangchen on 16-1-3.
 */
@Repository
public class IndicatorDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public IndicatorEntity getIndicator(String indicatorId){
        return entityManager.find(IndicatorEntity.class, indicatorId);
    }
}
