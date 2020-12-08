package com.example.demo.services;

import com.example.demo.Phrase;
import org.springframework.ui.Model;

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
    public String search(){
        return "results";
    }
}
