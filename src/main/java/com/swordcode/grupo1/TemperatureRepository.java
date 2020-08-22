package com.swordcode.grupo1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Date;

public interface TemperatureRepository extends CrudRepository<Temperature, Long> {
    @Query("select max(t.celsius) from Temperature t where t.dateMeasured >= ?1 and t.dateMeasured <= ?2")
    public BigDecimal getMaxCelsisuInADateRange(Date startDate, Date endDate);

    @Query("select min(t.celsius) from Temperature t where t.dateMeasured >= ?1 and t.dateMeasured <= ?2")
    public BigDecimal getMinCelsisuInADateRange(Date startDate, Date endDate);
}
