package com.example.demo.endpoints;

import com.example.demo.Phrase;
import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class Endpoint {
    private Service service;
    //wstrzykiwanie obiektu Service
    @Autowired
    public Endpoint(Service service) {
        this.service = service;
    }

    //endpoint dla strony głównej z wyszukiwarką
    @GetMapping("/")
    public String main(Model model) {
        return service.showHomePage(model);
    }

    //endpoint dla strony z wyszukanymi pozycjami
    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public String search(@ModelAttribute Phrase phrase) throws IOException {
        return service.search(phrase);
    }

}
