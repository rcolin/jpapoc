package org.ubick.jpapoc.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity KPIData
 */
@Entity
public class KPIData {

    @Id
    @GeneratedValue
    private String KPIID;

    private Integer IterateID;

    private Boolean isRef;

    private String comment;

    private String libVersion;

    private String CCCVersion;

    private String metric;

    private String value;

    private String unit;

    private String resultType;

    private List<TimeSeries> timeSeries = new ArrayList<>();




}
