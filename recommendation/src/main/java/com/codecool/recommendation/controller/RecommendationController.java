package com.codecool.recommendation.controller;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.model.Video;
import com.codecool.recommendation.repository.RecommendationRepository;
import com.codecool.recommendation.service.VideosGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    private VideosGetter videosGetter;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @GetMapping("/{videoId}/list-all-recommendation")
    public List<Recommendation> getAllRecommendationsByVideoId(@PathVariable Long videoId) {
        return recommendationRepository.getAllByVideoId(videoId);
    }
}
