package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by garich01 on 9/29/2017.
 */

@RestController
@RequestMapping("/ping")
public class Service {

    @RequestMapping(method= RequestMethod.GET)
    public String ping(){
        return "Hello World";
    }

}
