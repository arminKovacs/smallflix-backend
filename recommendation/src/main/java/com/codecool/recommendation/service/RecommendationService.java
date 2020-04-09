package com.codecool.recommendation.service;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    public void saveRecommendation(Recommendation recommendation, Long videoId) {
        recommendation.setId(videoId);
        recommendationRepository.saveAndFlush(recommendation);
    }
}
