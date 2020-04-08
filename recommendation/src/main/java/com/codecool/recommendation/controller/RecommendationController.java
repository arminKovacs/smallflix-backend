package com.codecool.recommendation.controller;

import com.codecool.recommendation.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/test")
    public void test() {
        videoService.getAllVideos();
    }
}
