package com.example.logistics.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> getResponse(String message, Boolean isSuccess, HttpStatus status, Object data){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status",status.value());
        map.put("isSuccess",isSuccess);
        map.put("message",message);
        map.put("data",data);
        return new ResponseEntity<Object>(map,status);
    }
}
