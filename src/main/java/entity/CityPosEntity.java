package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 16-6-23.
 */
@Entity
@Table(name = "city_pos", schema = "dbo", catalog = "CityDiagnosis")
public class CityPosEntity {
    private String cityId;
    private String cityLng;
    private String cityLat;

    @Id
    @Column(name = "city_id")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "city_lng")
    public String getCityLng() {
        return cityLng;
    }

    public void setCityLng(String cityLng) {
        this.cityLng = cityLng;
    }

    @Basic
    @Column(name = "city_lat")
    public String getCityLat() {
        return cityLat;
    }

    public void setCityLat(String cityLat) {
        this.cityLat = cityLat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityPosEntity that = (CityPosEntity) o;

        if (cityId != null ? !cityId.equals(that.cityId) : that.cityId != null) return false;
        if (cityLat != null ? !cityLat.equals(that.cityLat) : that.cityLat != null) return false;
        if (cityLng != null ? !cityLng.equals(that.cityLng) : that.cityLng != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId != null ? cityId.hashCode() : 0;
        result = 31 * result + (cityLng != null ? cityLng.hashCode() : 0);
        result = 31 * result + (cityLat != null ? cityLat.hashCode() : 0);
        return result;
    }
}
