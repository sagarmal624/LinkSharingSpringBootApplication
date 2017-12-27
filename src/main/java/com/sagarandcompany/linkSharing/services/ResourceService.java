package com.sagarandcompany.linkSharing.services;

import com.sagarandcompany.linkSharing.domains.LinkResource;
import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.repository.ResourceRepository.documentResource.DocumentResourceRepositoryImpl;
import com.sagarandcompany.linkSharing.repository.ResourceRepository.linkResource.LinkResourceRepositoryImpl;
import com.sagarandcompany.linkSharing.utility.ResourceVO;
import com.sagarandcompany.linkSharing.utility.ResponseDTO;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @Autowired
    LinkResourceRepositoryImpl linkResourceRepository;

    @Autowired
    DocumentResourceRepositoryImpl documentResourceRepository;


    @Value("${linksharing.resource.success}")
    private String success;

    @Value("${linksharing.resource.error}")
    private String error;


    public ResponseDTO save(Resource resource) {
        ResponseDTO responseDTO = new ResponseDTO();
        Resource savedresource = null;
        if (resource instanceof LinkResource)
            savedresource = linkResourceRepository.save(resource);
        else
            savedresource = documentResourceRepository.save(resource);

        if (savedresource != null) {
            responseDTO.setMessageAndStatus(success, true);
        } else {
            responseDTO.setMessageAndStatus(error, false);
        }
        return responseDTO;
    }

    public ResponseDTO get(Long id) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO();
        ResourceVO resourceVO = new ResourceVO();
        Resource resource = linkResourceRepository.get(id);
        if (resource instanceof LinkResource) {
            BeanUtils.copyProperties(resourceVO, resource);
        }
        else
        {
            BeanUtils.copyProperties(resourceVO, resource);

        }

        responseDTO.setData(resourceVO);
        return responseDTO;
    }
}
