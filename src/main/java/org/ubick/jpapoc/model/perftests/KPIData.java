package org.ubick.jpapoc.model.perftests;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entity KPIData
 */
@Entity
@Table(name = "KPIData")
public class KPIData{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "KPIID")
    private Long KPIID;

    @Column(name = "IterateID", nullable = false)
    private Long iterateID;

    @Column(name = "IsRef", nullable = false)
    private Boolean isRef;

    @Column(name = "LibVersion", nullable = false)
    private String libVersion;

    @Column(name = "CCCVersion", nullable = false)
    private String CCCVersion;

    @Column(name = "Metric", nullable = false)
    private String metric;

    @Column(name = "Value")
    private String value;

    @Column(name = "ResultType")//minute, percent etc...
    private String resultType;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<TimeSeries> timeSeries = new ArrayList<TimeSeries>();

    @Column(name = "Comment")
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createTime", nullable = false)
    private Date createTime;

    public Long getKPIID() {
        return KPIID;
    }

    public void setKPIID(Long KPIID) {
        this.KPIID = KPIID;
    }

    public Long getIterateID() {
        return iterateID;
    }

    public void setIterateID(Long iterateID) {
        this.iterateID = iterateID;
    }

    public Boolean getRef() {
        return isRef;
    }

    public void setRef(Boolean ref) {
        isRef = ref;
    }

    public String getLibVersion() {
        return libVersion;
    }

    public void setLibVersion(String libVersion) {
        this.libVersion = libVersion;
    }

    public String getCCCVersion() {
        return CCCVersion;
    }

    public void setCCCVersion(String CCCVersion) {
        this.CCCVersion = CCCVersion;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public List<TimeSeries> getTimeSeries() {
        return timeSeries;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "KPIData{" +
                "KPIID=" + KPIID +
                ", iterateID=" + iterateID +
                ", isRef=" + isRef +
                ", libVersion='" + libVersion + '\'' +
                ", CCCVersion='" + CCCVersion + '\'' +
                ", metric='" + metric + '\'' +
                ", value='" + value + '\'' +
                ", resultType='" + resultType + '\'' +
                ", timeSeries=" + timeSeries.size() +
                ", comment='" + comment + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
