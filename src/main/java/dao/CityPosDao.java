package dao;

import entity.CityPosEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by yangchen on 16-6-23.
 */
@Repository
public class CityPosDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public CityPosEntity getCityPos(String cityId){
        CityPosEntity cityPosEntity = entityManager.find(CityPosEntity.class, cityId);
        return cityPosEntity;
    }

    public void createCityPos(CityPosEntity cityPosEntity){
        entityManager.persist(cityPosEntity);
    }
}
