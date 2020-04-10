package com.codecool.videoservice.service;

import com.codecool.videoservice.model.Recommendation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationGetter {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendation.url}")
    private String baseUrl;

    public List<Recommendation> getAllRecommendationForVideo(Long videoId) {
        ObjectMapper mapper = new ObjectMapper();
        List recommendationService = restTemplate.getForEntity(baseUrl + videoId + "/list-all-recommendation",
                List.class).getBody();
        List<Recommendation> recommendations = new ArrayList<>();
        assert recommendationService != null;
        for (Object each : recommendationService) {
            recommendations.add(mapper.convertValue(each, Recommendation.class));
        }
        return recommendations;
    }

}
