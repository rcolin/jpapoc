package org.ubick.jpapoc;

import org.ubick.jpapoc.model.perftests.KPIData;
import org.ubick.jpapoc.model.perftests.TimeSeries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainKPI {

    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        KPIData kpiData1 = new KPIData();
        kpiData1.setCCCVersion("2017.3");
        kpiData1.setLibVersion("G35");
        kpiData1.setIterateID(1L);
        kpiData1.setMetric("MaProc");
        kpiData1.setRef(true);
        kpiData1.setValue("43");
        kpiData1.setResultType("minute");
        kpiData1.setComment("test de commentaire");
        kpiData1.setCreateTime(new Date());

        em.persist(kpiData1);

        KPIData kpiData2 = new KPIData();
        kpiData2.setCCCVersion("2017.3");
        kpiData2.setLibVersion("G35");
        kpiData2.setIterateID(1L);
        kpiData2.setMetric("MaProc");
        kpiData2.setRef(true);
        kpiData2.setValue("43");
        kpiData2.setResultType("minute");
        kpiData2.setComment("test de commentaire");
        kpiData2.setCreateTime(new Date());

        Random r = new Random();

        for(int i = 0; i < 10; i++){
            TimeSeries tm = new TimeSeries();
            tm.setTimestamp(new Date());
            int v = r.nextInt(10);
            tm.setValue(Integer.toString(v));
            tm.setKpiData(kpiData2);
            kpiData2.getTimeSeries().add(tm);
        }

        em.persist(kpiData2);

        Query q = em.createQuery("select k from KPIData k");
        List<KPIData> kpiList = q.getResultList();
        for (KPIData kpi : kpiList) {
            System.out.println(kpi);
            if(kpi.getTimeSeries().size() > 0)
                for (TimeSeries t : kpi.getTimeSeries()) {
                    System.out.println(t);
                }
        }
        System.out.println("Size: " + kpiList.size());

        KPIData k = em.find(KPIData.class, 1L);
        System.out.println(k);

        kpiData2.setComment("new comment");
        em.persist(kpiData2);

        //query with parameter
        Query queryWithParam = em.createQuery("select t from TimeSeries t where t.timeSeriesId = :timeSeriesId");
        queryWithParam.setParameter("timeSeriesId", 3L);
        List<TimeSeries> tList = queryWithParam.getResultList();
        for (TimeSeries t: tList) {
            System.out.println("=> " + t);
        }

        List<TimeSeries> tList2  = em.createNamedQuery("TimeSeries.findByID").setParameter("timeSeriesId", 3L).getResultList();
        System.out.println("/////// : " + tList2.get(0));

        em.getTransaction().commit();
        em.close();

    }
}