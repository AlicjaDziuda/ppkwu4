package com.example.demo.endpoints;

import com.example.demo.Phrase;
import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String search(@ModelAttribute Phrase phrase, Model model) throws IOException {
        return service.search(phrase, model);
    }

    //endpoint do generowania vCard
    @RequestMapping(value = "/vcard/{result}", method = RequestMethod.GET)
    public ResponseEntity<Resource> generateFile(@PathVariable String result, Model model) throws IOException {
        return service.generateFile(result,model);
    }

}
