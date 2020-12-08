package com.example.demo.services;

import com.example.demo.Phrase;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@org.springframework.stereotype.Service
public class Service {

    //strona główna - wyszukiwarka
    public String showHomePage(Model model){
        Phrase phrase = new Phrase();
        phrase.setPhrase("");
        model.addAttribute("phrase", phrase);
        return "index";
    }

    //strona z wyszukanymi pozycjami
    public String search(@ModelAttribute Phrase phrase){
        String url ="https://panoramafirm.pl/szukaj?k="+phrase.getPhrase(); 
        System.out.println(url);
        return "results";
    }
}
