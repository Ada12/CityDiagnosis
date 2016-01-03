package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 16-1-3.
 */
@Entity
@Table(name = "Indicator", schema = "dbo", catalog = "CityDiagnosis")
public class IndicatorEntity {
    private String indexId;
    private String indexName;
    private String unit;

    @Id
    @Column(name = "index_id")
    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    @Basic
    @Column(name = "index_name")
    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
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

        if (indexId != null ? !indexId.equals(that.indexId) : that.indexId != null) return false;
        if (indexName != null ? !indexName.equals(that.indexName) : that.indexName != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = indexId != null ? indexId.hashCode() : 0;
        result = 31 * result + (indexName != null ? indexName.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}
