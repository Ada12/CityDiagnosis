package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 16-1-2.
 */
@Entity
@Table(name = "indexdetail", schema = "dbo", catalog = "CityDiagnosis")
public class IndexdetailEntity {
    private int no;
    private String cityId;
    private String indexId;
    private String y2009;
    private String y2010;
    private String y2011;
    private String y2012;
    private String y2013;
    private String y2014;
    private String y2015;

    @Id
    @Column(name = "No")
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Basic
    @Column(name = "city_id")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "index_id")
    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    @Basic
    @Column(name = "y2009")
    public String getY2009() {
        return y2009;
    }

    public void setY2009(String y2009) {
        this.y2009 = y2009;
    }

    @Basic
    @Column(name = "y2010")
    public String getY2010() {
        return y2010;
    }

    public void setY2010(String y2010) {
        this.y2010 = y2010;
    }

    @Basic
    @Column(name = "y2011")
    public String getY2011() {
        return y2011;
    }

    public void setY2011(String y2011) {
        this.y2011 = y2011;
    }

    @Basic
    @Column(name = "y2012")
    public String getY2012() {
        return y2012;
    }

    public void setY2012(String y2012) {
        this.y2012 = y2012;
    }

    @Basic
    @Column(name = "y2013")
    public String getY2013() {
        return y2013;
    }

    public void setY2013(String y2013) {
        this.y2013 = y2013;
    }

    @Basic
    @Column(name = "y2014")
    public String getY2014() {
        return y2014;
    }

    public void setY2014(String y2014) {
        this.y2014 = y2014;
    }

    @Basic
    @Column(name = "y2015")
    public String getY2015() {
        return y2015;
    }

    public void setY2015(String y2015) {
        this.y2015 = y2015;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndexdetailEntity that = (IndexdetailEntity) o;

        if (no != that.no) return false;
        if (cityId != null ? !cityId.equals(that.cityId) : that.cityId != null) return false;
        if (indexId != null ? !indexId.equals(that.indexId) : that.indexId != null) return false;
        if (y2009 != null ? !y2009.equals(that.y2009) : that.y2009 != null) return false;
        if (y2010 != null ? !y2010.equals(that.y2010) : that.y2010 != null) return false;
        if (y2011 != null ? !y2011.equals(that.y2011) : that.y2011 != null) return false;
        if (y2012 != null ? !y2012.equals(that.y2012) : that.y2012 != null) return false;
        if (y2013 != null ? !y2013.equals(that.y2013) : that.y2013 != null) return false;
        if (y2014 != null ? !y2014.equals(that.y2014) : that.y2014 != null) return false;
        if (y2015 != null ? !y2015.equals(that.y2015) : that.y2015 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = no;
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (indexId != null ? indexId.hashCode() : 0);
        result = 31 * result + (y2009 != null ? y2009.hashCode() : 0);
        result = 31 * result + (y2010 != null ? y2010.hashCode() : 0);
        result = 31 * result + (y2011 != null ? y2011.hashCode() : 0);
        result = 31 * result + (y2012 != null ? y2012.hashCode() : 0);
        result = 31 * result + (y2013 != null ? y2013.hashCode() : 0);
        result = 31 * result + (y2014 != null ? y2014.hashCode() : 0);
        result = 31 * result + (y2015 != null ? y2015.hashCode() : 0);
        return result;
    }
}
