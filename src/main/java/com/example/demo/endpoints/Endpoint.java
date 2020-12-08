package com.example.demo.endpoints;

import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Endpoint {
    private Service service;
    //wstrzykiwanie obiektu Service
    @Autowired
    public Endpoint(Service service) {
        this.service = service;
    }

    @GetMapping("/")
    public String main() {
        return service.showHomePage();
    }
}
