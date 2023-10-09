package com.example.logistics.controllers;

import com.example.logistics.dtos.ServiceDTO;
import com.example.logistics.models.Service;
import com.example.logistics.services.ServiceService;
import com.example.logistics.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("${apiPrefix}/service")
public class ServiceController {

    @Autowired
    private ServiceService service;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getAllServices(){
        try {
            List<Service> serviceList = service.getAllServices();
            return ResponseHandler.getResponse("Service list successful.", true,1,HttpStatus.OK, serviceList);
        }catch (Exception exception){
            return ResponseHandler.getResponse(exception.getMessage(), false,0,HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getServiceById(@PathVariable Long id){
        try {
            String message = "Service details retrieved successful.";
            Optional<Service> serviceDetails = service.getServiceById(id);
            if(!serviceDetails.isPresent()){
                message = "Service Not found";
            }
            return  ResponseHandler.getResponse(message,true,!serviceDetails.isPresent() ?0:1,HttpStatus.OK,serviceDetails);
        }catch (Exception exception){
            return  ResponseHandler.getResponse(exception.getMessage(),false,0,HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }



    @PostMapping(value = "/save")
    public ResponseEntity<Object> saveService(@RequestBody ServiceDTO serviceDTO){
        try {
            Service savedService = service.createService(serviceDTO);
            return ResponseHandler.getResponse("Service created successful.", true,1,HttpStatus.CREATED, savedService);
        }catch (Exception exception){
            return ResponseHandler.getResponse(exception.getMessage(), false,0,HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping(value = "/{id}/update")
    public ResponseEntity<Object> updateService(@RequestBody ServiceDTO serviceDTO,@PathVariable Long id){
        try {
            Service updatedService = service.updateService(serviceDTO,id);
            if(updatedService == null){
                return ResponseHandler.getResponse("Service not found.",true,0,HttpStatus.OK,null);
            }
            return ResponseHandler.getResponse("Service updated successful.",true,1,HttpStatus.OK,updatedService);
        }catch (Exception exception){
            return ResponseHandler.getResponse(exception.getMessage(),false,0,HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

    @DeleteMapping(value = "/{id}/remove")
    public ResponseEntity<Object> deleteService(@PathVariable Long id){
        try {
            Optional<com.example.logistics.models.Service> existingService = service.getServiceById(id);
            if (!existingService.isPresent()) {
                return ResponseHandler.getResponse("Service not found.",true,0,HttpStatus.OK,null);
            }
            service.deleteService(id);
            return ResponseHandler.getResponse("Service deleted.",true,1,HttpStatus.OK,null);
        }catch (Exception exception){
            return ResponseHandler.getResponse(exception.getMessage(),false,0,HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
    }

}
