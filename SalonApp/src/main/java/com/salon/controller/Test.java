package com.salon.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * AuthTest
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/test")
public class Test {

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String authtest() {
        return "{\"message\" : \"Hello Auth\"}";
    }
    
}