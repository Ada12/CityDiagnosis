package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 16-1-7.
 */
@Entity
@Table(name = "indicator_detail", schema = "dbo", catalog = "CityDiagnosis")
public class IndicatorDetailEntity {
    private String id;
    private String cityId;
    private String indicatorId;
    private String y1998;
    private String y1999;
    private String y2000;
    private String y2001;
    private String y2002;
    private String y2003;
    private String y2004;
    private String y2005;
    private String y2006;
    private String y2007;
    private String y2008;
    private String y2009;
    private String y2010;
    private String y2011;
    private String y2012;
    private String y2013;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "indicator_id")
    public String getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(String indicatorId) {
        this.indicatorId = indicatorId;
    }

    @Basic
    @Column(name = "y1998")
    public String getY1998() {
        return y1998;
    }

    public void setY1998(String y1998) {
        this.y1998 = y1998;
    }

    @Basic
    @Column(name = "y1999")
    public String getY1999() {
        return y1999;
    }

    public void setY1999(String y1999) {
        this.y1999 = y1999;
    }

    @Basic
    @Column(name = "y2000")
    public String getY2000() {
        return y2000;
    }

    public void setY2000(String y2000) {
        this.y2000 = y2000;
    }

    @Basic
    @Column(name = "y2001")
    public String getY2001() {
        return y2001;
    }

    public void setY2001(String y2001) {
        this.y2001 = y2001;
    }

    @Basic
    @Column(name = "y2002")
    public String getY2002() {
        return y2002;
    }

    public void setY2002(String y2002) {
        this.y2002 = y2002;
    }

    @Basic
    @Column(name = "y2003")
    public String getY2003() {
        return y2003;
    }

    public void setY2003(String y2003) {
        this.y2003 = y2003;
    }

    @Basic
    @Column(name = "y2004")
    public String getY2004() {
        return y2004;
    }

    public void setY2004(String y2004) {
        this.y2004 = y2004;
    }

    @Basic
    @Column(name = "y2005")
    public String getY2005() {
        return y2005;
    }

    public void setY2005(String y2005) {
        this.y2005 = y2005;
    }

    @Basic
    @Column(name = "y2006")
    public String getY2006() {
        return y2006;
    }

    public void setY2006(String y2006) {
        this.y2006 = y2006;
    }

    @Basic
    @Column(name = "y2007")
    public String getY2007() {
        return y2007;
    }

    public void setY2007(String y2007) {
        this.y2007 = y2007;
    }

    @Basic
    @Column(name = "y2008")
    public String getY2008() {
        return y2008;
    }

    public void setY2008(String y2008) {
        this.y2008 = y2008;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndicatorDetailEntity that = (IndicatorDetailEntity) o;

        if (cityId != null ? !cityId.equals(that.cityId) : that.cityId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (indicatorId != null ? !indicatorId.equals(that.indicatorId) : that.indicatorId != null) return false;
        if (y1998 != null ? !y1998.equals(that.y1998) : that.y1998 != null) return false;
        if (y1999 != null ? !y1999.equals(that.y1999) : that.y1999 != null) return false;
        if (y2000 != null ? !y2000.equals(that.y2000) : that.y2000 != null) return false;
        if (y2001 != null ? !y2001.equals(that.y2001) : that.y2001 != null) return false;
        if (y2002 != null ? !y2002.equals(that.y2002) : that.y2002 != null) return false;
        if (y2003 != null ? !y2003.equals(that.y2003) : that.y2003 != null) return false;
        if (y2004 != null ? !y2004.equals(that.y2004) : that.y2004 != null) return false;
        if (y2005 != null ? !y2005.equals(that.y2005) : that.y2005 != null) return false;
        if (y2006 != null ? !y2006.equals(that.y2006) : that.y2006 != null) return false;
        if (y2007 != null ? !y2007.equals(that.y2007) : that.y2007 != null) return false;
        if (y2008 != null ? !y2008.equals(that.y2008) : that.y2008 != null) return false;
        if (y2009 != null ? !y2009.equals(that.y2009) : that.y2009 != null) return false;
        if (y2010 != null ? !y2010.equals(that.y2010) : that.y2010 != null) return false;
        if (y2011 != null ? !y2011.equals(that.y2011) : that.y2011 != null) return false;
        if (y2012 != null ? !y2012.equals(that.y2012) : that.y2012 != null) return false;
        if (y2013 != null ? !y2013.equals(that.y2013) : that.y2013 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (indicatorId != null ? indicatorId.hashCode() : 0);
        result = 31 * result + (y1998 != null ? y1998.hashCode() : 0);
        result = 31 * result + (y1999 != null ? y1999.hashCode() : 0);
        result = 31 * result + (y2000 != null ? y2000.hashCode() : 0);
        result = 31 * result + (y2001 != null ? y2001.hashCode() : 0);
        result = 31 * result + (y2002 != null ? y2002.hashCode() : 0);
        result = 31 * result + (y2003 != null ? y2003.hashCode() : 0);
        result = 31 * result + (y2004 != null ? y2004.hashCode() : 0);
        result = 31 * result + (y2005 != null ? y2005.hashCode() : 0);
        result = 31 * result + (y2006 != null ? y2006.hashCode() : 0);
        result = 31 * result + (y2007 != null ? y2007.hashCode() : 0);
        result = 31 * result + (y2008 != null ? y2008.hashCode() : 0);
        result = 31 * result + (y2009 != null ? y2009.hashCode() : 0);
        result = 31 * result + (y2010 != null ? y2010.hashCode() : 0);
        result = 31 * result + (y2011 != null ? y2011.hashCode() : 0);
        result = 31 * result + (y2012 != null ? y2012.hashCode() : 0);
        result = 31 * result + (y2013 != null ? y2013.hashCode() : 0);
        return result;
    }
}
