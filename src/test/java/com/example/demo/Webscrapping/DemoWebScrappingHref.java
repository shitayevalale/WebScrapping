package com.example.demo.Webscrapping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoWebScrappingHref {

    public static void main(String[] args) throws IOException, InterruptedException {


        String url = "https://jovemnerd.com.br/";

        Document doc = Jsoup.connect(url).get();

        List<Element> artigos = doc.getElementsByClass("info");

        List<Element> as = new ArrayList<>();
        List<String> hrefs = new ArrayList<>();


        artigos.forEach(element -> {
            as.add(element.getElementsByTag("a").first());
        });


        as.forEach(element -> {
            hrefs.add(element.attr("href"));
        });
        hrefs.forEach(s -> {
            System.out.println("URL: "  + s);
        });
    }

}
