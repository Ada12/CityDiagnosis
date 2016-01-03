package dao;

import entity.CityEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by yangchen on 16-1-2.
 */
@Repository
public class CityDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public String getCity(String cityId){
        CityEntity cityInfo = entityManager.find(CityEntity.class, cityId);
        return cityInfo.getCityName();
    }

}
