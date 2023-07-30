package com.example.logistics.controllers;

import com.example.logistics.dtos.ServiceDTO;
import com.example.logistics.models.Service;
import com.example.logistics.services.ServiceService;
import com.example.logistics.utils.ResponseHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/service")
public class ServiceController {

    @Autowired
    private ServiceService service;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getAllServices(){
        try {
            List<Service> serviceList = service.getAllServices();
            return ResponseHandler.getResponse("Service list successful.", true,HttpStatus.OK, serviceList);
        }catch (Exception exception){
            return ResponseHandler.getResponse(exception.getMessage(), false,HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

    @PostMapping(value = "/save")
    public ResponseEntity<Object> saveService(@RequestBody ServiceDTO serviceDTO){
        try {
            Service savedService = service.createService(serviceDTO);
            return ResponseHandler.getResponse("service created successful.", true,HttpStatus.CREATED, savedService);
        }catch (Exception exception){
            return ResponseHandler.getResponse(exception.getMessage(), false,HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
