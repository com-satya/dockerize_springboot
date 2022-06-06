package com.satya.Dockerize.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/v1/")
public class HomeController {

    @RequestMapping("msg/{name}")
    public String sayHello(@PathVariable String name){
        return "hello "+name;
    }

}
