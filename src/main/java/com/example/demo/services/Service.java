package com.example.demo.services;

import com.example.demo.Phrase;
import com.example.demo.Result;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public String search(@ModelAttribute Phrase phrase, Model model) throws IOException {
        String url ="https://panoramafirm.pl/szukaj?k="+phrase.getPhrase();
        List<Result> allResults = new ArrayList<>();
        Document document = Jsoup.connect(url).get();
        Elements results = document.select("li.card.company-item");
        for (Element res : results) {
            Result result = new Result();
            result.setName(res.select("h2").text());
            result.setAddress(res.select("div.address").text());
            result.setPhone(res.select("a.icon-telephone").attr("title"));
            result.setEmail(res.select("a.ajax-modal-link").attr("data-company-email"));
            allResults.add(result);
        }
        model.addAttribute("results", allResults);
        return "results";
    }
}
