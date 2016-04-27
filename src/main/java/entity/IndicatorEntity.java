package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 16-1-7.
 */
@Entity
@Table(name = "Indicator", schema = "dbo", catalog = "CityDiagnosis")
public class IndicatorEntity {
    private String indicatorId;
    private String indicatorName;
    private String unit;

    @Id
    @Column(name = "indicator_id")
    public String getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(String indicatorId) {
        this.indicatorId = indicatorId;
    }

    @Basic
    @Column(name = "indicator_name")
    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndicatorEntity that = (IndicatorEntity) o;

        if (indicatorId != null ? !indicatorId.equals(that.indicatorId) : that.indicatorId != null) return false;
        if (indicatorName != null ? !indicatorName.equals(that.indicatorName) : that.indicatorName != null)
            return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = indicatorId != null ? indicatorId.hashCode() : 0;
        result = 31 * result + (indicatorName != null ? indicatorName.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
