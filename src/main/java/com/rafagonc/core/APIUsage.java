package com.rafagonc.core;

import com.rafagonc.core.exceptions.APIDenyException;
import com.rafagonc.core.models.APIConsumer;
import com.rafagonc.core.repository.APIConsumerRepository;

/**
 * Created by rafagonc on 26/03/17.
 */
public class APIUsage {

    public static void track(String masterKey, String text, APIConsumerRepository apiConsumerRepository) throws APIDenyException {
        APIConsumer apiConsumer = apiConsumerRepository.findByKey(masterKey);
        if (apiConsumer == null) {
            throw new APIDenyException("Invalid Credentials");
        } else {
            Integer calls = apiConsumer.getCalls();
            apiConsumer.setCalls(++calls);
            apiConsumerRepository.save(apiConsumer);
        }
    }

}
