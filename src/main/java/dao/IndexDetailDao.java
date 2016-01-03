package dao;

import entity.IndexdetailEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    public IndexdetailEntity getIndexDetail(String cityId, String indexId){
        TypedQuery<IndexdetailEntity> query;
        query = entityManager.createQuery("select i from IndexdetailEntity i where i.cityId = :cityId and i.indexId = :indexId", IndexdetailEntity.class);
        query.setParameter("cityId", cityId);
        query.setParameter("indexId", indexId);
        IndexdetailEntity indexdetailEntity = query.getSingleResult();
        return indexdetailEntity;
    }
}
