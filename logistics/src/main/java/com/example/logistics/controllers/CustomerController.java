package com.example.logistics.controllers;

import com.example.logistics.dtos.CustomerDTO;
import com.example.logistics.models.Customer;
import com.example.logistics.services.CustomerService;
import com.example.logistics.utils.ResponseHandler;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${apiPrefix}/user")
public class CustomerController {
    @Value("${otp}")
    private String otp;

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/register")
    public ResponseEntity<Object> register(@RequestBody @Valid CustomerDTO customerDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                Map<String, String> errors = new HashMap<>();
                for (FieldError error : bindingResult.getFieldErrors()) {
                    System.out.println("=====================" + error + "=======================");
                    errors.put(error.getField(), error.getDefaultMessage());
                }
                return ResponseHandler.getResponse("Validation Error.", true, 0, HttpStatus.UNPROCESSABLE_ENTITY,
                        errors);
            }
             Customer newCustomer = new Customer();
             BeanUtils.copyProperties(customerDTO,newCustomer);
             newCustomer.setOtp(otp);
             newCustomer.setOtpSendDate(String.valueOf(System.currentTimeMillis() /
             1000));
             customerService.register(newCustomer);
            return ResponseHandler.getResponse("OTP sent.", true, 1, HttpStatus.OK, null);
        } catch (Exception exception) {
            return ResponseHandler.getResponse(exception.getMessage(), false, 0, HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }
}
