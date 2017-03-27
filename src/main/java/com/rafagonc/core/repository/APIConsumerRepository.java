package com.rafagonc.core.repository;

import com.rafagonc.core.models.APIConsumer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rafagonc on 27/03/17.
 */
public interface APIConsumerRepository extends CrudRepository<APIConsumer, Long> {

    APIConsumer findByKey(String key);

}
