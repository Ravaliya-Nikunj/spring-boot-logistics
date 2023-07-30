package com.example.logistics.serviceImplementors;

import com.example.logistics.dtos.ServiceDTO;
import com.example.logistics.repositories.ServiceRepository;
import com.example.logistics.services.ServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<com.example.logistics.models.Service> getAllServices() {
            return serviceRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }

    @Override
    public com.example.logistics.models.Service createService(ServiceDTO service) {
        System.out.println("Hello there"+service);
        com.example.logistics.models.Service newService = new com.example.logistics.models.Service();
        BeanUtils.copyProperties(service, newService);
        System.out.println(newService);
        return serviceRepository.save(newService);
    }
}
