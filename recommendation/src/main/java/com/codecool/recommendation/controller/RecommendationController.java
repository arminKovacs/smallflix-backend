package com.codecool.recommendation.controller;

import com.codecool.recommendation.model.Video;
import com.codecool.recommendation.service.VideosGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    private VideosGetter videosGetter;

    @GetMapping("/test")
    public List<Video> test() {
        return videosGetter.getAllVideos();
    }
}
