package com.example.service.client.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.http.ResponseEntity;


@RestController
@Configuration
public class ServiceController {

    @Autowired
    @Qualifier("myRestTemplate")
    public RestOperations template;
	
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String getShipmentDetails(@RequestParam(value="name", defaultValue="0") String name) {
        ResponseEntity<String> result = template.postForEntity("http://localhost:8080/api/hello",name,String.class);
        return result.getBody();
    }
    

}
