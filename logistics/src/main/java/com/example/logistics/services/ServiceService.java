package com.example.logistics.services;

import com.example.logistics.dtos.ServiceDTO;
import com.example.logistics.models.Service;

import java.util.List;

public interface ServiceService {
    List<Service> getAllServices();

    Service createService(ServiceDTO service);
}
