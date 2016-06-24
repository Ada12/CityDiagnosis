package dao;

import entity.CityEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<CityEntity> getAllCity(){
        TypedQuery<CityEntity> query;
        query = entityManager.createQuery("select c from CityEntity c ", CityEntity.class);
        List<CityEntity> listCityEntity = query.getResultList();
        return listCityEntity;
    }

}
