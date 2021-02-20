package com.example.service.client.controller;


import com.example.service.client.feign.ResourceServerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.http.ResponseEntity;


@RestController
public class ServiceController {

    @Autowired
    private ResourceServerFeign feign;
	
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String getShipmentDetails(@RequestParam(value="name", defaultValue="0") String name) {
        return feign.getHello(name);
    }

}
