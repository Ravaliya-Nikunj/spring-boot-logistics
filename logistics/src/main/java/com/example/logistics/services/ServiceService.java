package com.example.logistics.services;

import com.example.logistics.dtos.ServiceDTO;
import com.example.logistics.models.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    List<Service> getAllServices();

    Service createService(ServiceDTO service);

    Optional<Service> getServiceById(Long id);

    Service updateService(ServiceDTO serviceDTO,Long id);

    void deleteService(Long id);
}
