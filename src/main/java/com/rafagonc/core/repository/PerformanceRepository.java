package com.rafagonc.core.repository;

import com.rafagonc.core.models.Performance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rafagonc on 26/03/17.
 */
public interface PerformanceRepository extends CrudRepository<Performance, Long> {

    public List<Performance> findAll();

}
