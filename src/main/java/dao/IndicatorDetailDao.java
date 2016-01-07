package dao;

import entity.IndicatorDetailEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by yangchen on 16-1-7.
 */
@Repository
public class IndicatorDetailDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public IndicatorDetailEntity getIndicatorDetail(String cityId, String indicatorId){
        TypedQuery<IndicatorDetailEntity> query;
        query = entityManager.createQuery("select i from IndicatorDetailEntity i where i.cityId = :cityId and i.indicatorId = :indicatorId", IndicatorDetailEntity.class);
        query.setParameter("cityId", cityId);
        query.setParameter("indicatorId", indicatorId);
        IndicatorDetailEntity indicatorDetailEntity = query.getSingleResult();
        return indicatorDetailEntity;
    }
}
