package com.example.logistics.serviceImplementors;

import com.example.logistics.dtos.ServiceDTO;
import com.example.logistics.repositories.ServiceRepository;
import com.example.logistics.services.ServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<com.example.logistics.models.Service> getAllServices() {
        System.out.println("getAllServices");
        return serviceRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }

    @Override
    public com.example.logistics.models.Service createService(ServiceDTO service) {
        System.out.println("createService");
        com.example.logistics.models.Service newService = new com.example.logistics.models.Service();
        BeanUtils.copyProperties(service, newService);
        return serviceRepository.save(newService);
    }

    @Override
    public Optional<com.example.logistics.models.Service> getServiceById(Long id) {
        System.out.println("getServiceById");
        return serviceRepository.findById(id);
    }

    @Override
    public com.example.logistics.models.Service updateService(ServiceDTO service,Long id) {
        System.out.println("updateService");
        Optional<com.example.logistics.models.Service> existingService = serviceRepository.findById(id);
        if(!existingService.isPresent()){
            return null;
        }
        com.example.logistics.models.Service newService = existingService.get();
        BeanUtils.copyProperties(service, newService);
        return serviceRepository.save(newService);
    }

    @Override
    public void deleteService(Long id) {
        System.out.println("deleteService");
        serviceRepository.deleteById(id);
    }
}
