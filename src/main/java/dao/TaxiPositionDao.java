package dao;

import entity.IndicatorDetailEntity;
import entity.TaxiPositionEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by yangchen on 16-6-28.
 */
@Repository
public class TaxiPositionDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<TaxiPositionEntity> getTaxiPosition(String timePoint){
        TypedQuery<TaxiPositionEntity> query;
        query = entityManager.createQuery("select t from TaxiPositionEntity t where t.time = :time", TaxiPositionEntity.class);
        query.setParameter("time", timePoint);
        List<TaxiPositionEntity> list = query.getResultList();
        return list;
    }

}
