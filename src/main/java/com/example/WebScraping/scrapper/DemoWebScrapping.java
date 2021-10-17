package com.example.WebScraping.scrapper;

import com.example.WebScraping.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoWebScrapping {
    public static List<User> extractData() throws IOException {
        //String url ="https://www.stat.gov.az/source/demoqraphy/";
        String url = "https://www.nfl.com/stats/player-stats/";
        Document doc = Jsoup.connect(url).get();
        Element table = doc.getElementsByClass("d3-o-table d3-o-table--detailed d3-o-player-stats--detailed d3-o-table--sortable").first();
        Element tbody = table.getElementsByTag("tbody").first();
        List<Element> players = tbody.getElementsByTag("tr");
        List<User> playersObjects = new ArrayList<>();
        for (Element player : players) {
            List<Element> attributes = player.getElementsByTag("td");
            User user = new User();

            user.setFIN(attributes.get(0).text());
            user.setName(attributes.get(0).text());
            user.setSurname(attributes.get(0).text());
            user.setGender(attributes.get(0).text());
            user.setDOB(attributes.get(0).text());
            user.setNOB(attributes.get(0).text());
            user.setNOD(attributes.get(0).text());
            //  user.setMaritalStatus();
            playersObjects.add(user);
        }

        return playersObjects;
    }


    public static void main(String[] args) throws IOException {

        String url = "https://www.nfl.com/stats/player-stats/";
        Document doc = Jsoup.connect(url).get();
        Element table = doc.getElementsByClass("d3-o-table d3-o-table--detailed d3-o-player-stats--detailed d3-o-table--sortable").first();
        Element tbody = table.getElementsByTag("tbody").first();
        List<Element> players = tbody.getElementsByTag("tr");
        List<User> playersObjects = new ArrayList<>();
        //7 - Iterando por cada tr e convertendo-o em um Passing. Em seguida inserindo-o na lista de Passings
        for (Element player: players) {
            List<Element> attributes = player.getElementsByTag("td");
            User user = new User(
                    attributes.get(0).text(),
                    attributes.get(1).text(),
                    attributes.get(2).text(),
                    attributes.get(3).text(),
                    attributes.get(4).text(),
                    attributes.get(5).text(),
                    attributes.get(6).text()
            );
            playersObjects.add(user);
        }
    }

    private static void converterToJson(User user){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(user);
            System.out.println("object in JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
