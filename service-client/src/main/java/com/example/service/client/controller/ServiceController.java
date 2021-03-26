package com.example.service.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;


@RestController
public class ServiceController {

    @Autowired
    private RestOperations template;
	
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String getShipmentDetails(@RequestParam(value="name", defaultValue="0") String name) {
        ResponseEntity<String> result = template.postForEntity("http://localhost:8080/resource-server/hello",name,String.class);
        return result.getBody();
    }
    

}
