package com.example.demo.endpoints;

import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Endpoint {
    private Service service;
    //wstrzykiwanie obiektu Service
    @Autowired
    public Endpoint(Service service) {
        this.service = service;
    }
}
