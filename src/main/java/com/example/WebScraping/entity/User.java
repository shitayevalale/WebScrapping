package com.example.WebScraping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Element;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String FIN;

    private String name;

    private String surname;

    private String gender;

    private String DOB;

    private String NOB;//number of births-doğulanlarin sayı

    private String NOD;//number of dead-ölenlerin sayı

    private boolean MaritalStatus;//aile veziyyeti

    public boolean active;

//    public User(Element element, Element element1, String text) {
//    }
//
//    public User(String text, String text1, String text2) {
//    }

//    public User(String text, String text1, String text2, String text3) {
//    }

    public User(String text, String text1, String text2, String text3, String text4, String text5, String text6) {
    }
}
