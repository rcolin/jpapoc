package org.ubick.jpapoc.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Celine on 26/05/2017.
 */
public class TimeSeries {

    @Id
    @GeneratedValue
    private Integer timeSeriesId;

    @ManyToMany
    private KPIData kpiData;

    private String value;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

}
