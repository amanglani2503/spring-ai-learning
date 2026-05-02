package com.example.spring_ai_demo.controller;

import com.example.spring_ai_demo.service.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class ActorsController {

    @Autowired
    private ActorsService actorsService;

    @GetMapping("/movies")
    public String findMoviesByActor(@RequestParam String by){
        return actorsService.getMoviesByActor(by);
    }
}
