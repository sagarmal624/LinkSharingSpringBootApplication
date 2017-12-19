package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.Subscription;
import com.sagarandcompany.linkSharing.repository.SubscrptnRepository.SubscriptionRepositoryimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepositoryimpl subscriptionRepositoryimpl;

    public Map save(Subscription subscrptn) {

        Subscription savedSubscrptn = subscriptionRepositoryimpl.save(subscrptn);
        Map<String, Object> map = new HashMap<>();
        if (savedSubscrptn != null) {
            map.put("message", "Record  Successfuly stored");
            map.put("status", true);
        } else {
            map.put("message", "Record not Successfuly stored");
            map.put("status", false);
        }
       return  map;
    }
}
