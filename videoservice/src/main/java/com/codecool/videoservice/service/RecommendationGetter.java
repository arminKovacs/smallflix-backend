package com.codecool.videoservice.service;

import com.codecool.videoservice.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecommendationGetter {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendation.url}")
    private String baseUrl;

    public List<Recommendation> getAllRecommendationForVideo(Long videoId) {
        return null;
    }
}
