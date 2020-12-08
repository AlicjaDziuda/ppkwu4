package com.example.demo.services;

import org.springframework.ui.Model;

@org.springframework.stereotype.Service
public class Service {

    //strona główna - wyszukiwarka
    public String showHomePage(){
        return "index";
    }
}
