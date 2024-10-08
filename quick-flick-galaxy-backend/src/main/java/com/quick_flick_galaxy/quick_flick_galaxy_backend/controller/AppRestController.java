package com.quick_flick_galaxy.quick_flick_galaxy_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

    @GetMapping("/")
    public String hola(){

        return "Hola mundo!";
    }
}
