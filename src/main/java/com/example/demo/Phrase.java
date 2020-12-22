package com.example.demo;
//klasa symbolizująca wpisaną frazę w wyszukiwarkę
public class Phrase {
    String phrase;
    int page;
    public Phrase() { }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
    
    public int getPage(){
        return page;
    }

    public void setPage(int page){
        this.page = page;
    }
}
