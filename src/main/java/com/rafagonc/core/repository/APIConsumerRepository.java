package com.rafagonc.core.repository;

import com.rafagonc.core.models.APIConsumer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by rafagonc on 27/03/17.
 */
public interface APIConsumerRepository extends CrudRepository<APIConsumer, Long> {

    @Query("SELECT * FROM APIConsumer WHERE key LIKE :key")
    APIConsumer findByKey(@Param("key") String key);

}
