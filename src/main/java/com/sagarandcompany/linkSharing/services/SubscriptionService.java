package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.Subscription;
import com.sagarandcompany.linkSharing.repository.SubscrptnRepository.SubscriptionRepositoryimpl;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import com.sagarandcompany.linkSharing.utility.SubscriptionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepositoryimpl subscriptionRepositoryimpl;


    @Value(" ${linksharing.subscription.success}")
    private String success;

    @Value("${linksharing.subscription.error}")
    private String error;

    public List<SubscriptionVO> getSubscriptions() throws InvocationTargetException, IllegalAccessException {
        return subscriptionRepositoryimpl.getSubscriptions();
    }

    public ResponseDTO getSubscription(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        Subscription subscription = subscriptionRepositoryimpl.get(id);
        if (subscription != null) {
            responseDTO.setStatus(true);
            SubscriptionVO subscriptionVO = new SubscriptionVO();
            subscriptionVO.setUser_id(subscription.getUser().getUser_id());
            subscriptionVO.setTopic_id(subscription.getTopic().getTopic_id());
            subscriptionVO.setSubscription_id(subscription.getSubscription_id());
            //BeanUtils.copyProperties(subscription, subscriptionVO);
            responseDTO.setData(subscriptionVO);
        }
        return responseDTO;
    }

    public ResponseDTO save(Subscription subscrptn) {
        ResponseDTO responseDTO = new ResponseDTO();
        Subscription savedSubscrptn = subscriptionRepositoryimpl.save(subscrptn);

        if (savedSubscrptn != null) {
            responseDTO.setMessageAndStatus(success, true);
        } else {
            responseDTO.setMessageAndStatus(error, false);
        }
        return responseDTO;
    }

    public ResponseDTO delete(Long id) {
        ResponseDTO responseDTO = new ResponseDTO(false);
        if (subscriptionRepositoryimpl.delete(id)) {
            responseDTO.setMessageAndStatus("Record Deleted Successfully", true);

        } else {
            responseDTO.setMessageAndStatus("Something wenr wrong", false);
        }
        return responseDTO;

    }
}
