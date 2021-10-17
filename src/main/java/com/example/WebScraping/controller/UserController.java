package com.example.WebScraping.controller;

import com.example.WebScraping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getData")
    public void getData(@RequestParam("from") String yearFrom, @RequestParam("to") String yearTo,
                        @RequestParam("operation") String operation) throws IOException {
        userService.dataParsing(yearFrom, yearTo, operation);
    }
}
