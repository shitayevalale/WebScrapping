package com.example.WebScraping.service;

import com.example.WebScraping.entity.User;
import com.example.WebScraping.repository.UserRepository;
import com.example.WebScraping.scrapper.DemoWebScrapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void dataParsing(String yearFrom, String yearTo, String operation) throws IOException {
        List<User> users = DemoWebScrapping.extractData();

        for (User u: users){
            System.out.println("saving the" + u.getName());
            userRepository.save(u);
        }
    }
    }

