package com.example.res.server.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResourceServerController {

    @RequestMapping(value="/hello",method=RequestMethod.POST, produces={"text/plain"})
    public String getHello(@RequestBody String name) {
        return "Hello " + name;
    }
}
