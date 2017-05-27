package org.ubick.jpapoc.model.perftests;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity TimeSeries
 */
@NamedQueries({
        @NamedQuery(
                name="TimeSeries.findByID",
                query="select t from TimeSeries t where t.timeSeriesId = :timeSeriesId")
})
@Entity
@Table(name = "TimeSeries")
public class TimeSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "TimeSeriesId")
    private Long timeSeriesId;

    @ManyToOne
    @JoinColumns({@JoinColumn(name="KPIDataID", referencedColumnName="KPIID")})
    //@MapsId("KPIID")
    //@JoinColumn(name = "KPIID")
    private KPIData kpiData;

    @Column(name = "Value")
    private String value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Timestamp", nullable = false)
    private Date timestamp;

    public Long getTimeSeriesId() {
        return timeSeriesId;
    }

    public void setTimeSeriesId(Long timeSeriesId) {
        this.timeSeriesId = timeSeriesId;
    }


    public KPIData getKpiData() {
        return kpiData;
    }

    public void setKpiData(KPIData kpiData) {
        this.kpiData = kpiData;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TimeSeries{" +
                "timeSeriesId=" + timeSeriesId +
                ", kpiDataId=" + kpiData.getKPIID() +
                ", value='" + value + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
