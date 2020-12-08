package com.example.demo.services;

import com.example.demo.Phrase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

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
    public String search(@ModelAttribute Phrase phrase) throws IOException {
        String url ="https://panoramafirm.pl/szukaj?k="+phrase.getPhrase();

        Document document = Jsoup.connect(url).get();
        Elements segment = document.select("li.card.company-item");
        System.out.println(segment.select("h2").text());
        return "results";
    }
}
