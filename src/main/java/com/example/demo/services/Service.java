package com.example.demo.services;

import com.example.demo.Phrase;
import com.example.demo.Result;
import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.property.Address;
import ezvcard.property.Revision;
import ezvcard.property.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    List<Result> allResults = new ArrayList<>();
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
        Document document = Jsoup.connect(url).get();
        Elements results = document.select("li.card.company-item");
        int counter = 0;
        for (Element res : results) {
            Result result = new Result();
            result.setName(res.select("h2").text());
            result.setAddress(res.select("div.address").text());
            result.setPhone(res.select("a.icon-telephone").attr("title"));
            result.setEmail(res.select("a.ajax-modal-link").attr("data-company-email"));
            result.setWebsite(res.select("a.icon-website").attr("href"));
            result.setLat(res.select("a.icon-check-point").attr("data-lat"));
            result.setLon(res.select("a.icon-check-point").attr("data-lon"));
            counter++;
            allResults.add(result);
        }
        model.addAttribute("results", allResults);
        return "results";
    }

    //generator vCarda
    @ResponseBody
    public String generateFile(@PathVariable String result, Model model) throws IOException {

        return "xxx";
    }
}
