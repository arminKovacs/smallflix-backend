package com.codecool.recommendation.service;

import com.codecool.recommendation.entity.Recommendation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@RequiredArgsConstructor
@Profile("initializer")
public class DataInitializer {

    @Autowired
    private RecommendationService recommendationService;

    @Bean
    public CommandLineRunner createRecommendations() {
        return args -> {
            Recommendation drumRecommendation = Recommendation.builder()
                    .comment("This is a cool drumming video! Keep it up!")
                    .rating(5)
                    .build();
            recommendationService.saveRecommendation(drumRecommendation, 1L);

            Recommendation funnyRecommendation = Recommendation.builder()
                    .comment("Ha ha very funny video! I love it!!")
                    .rating(5)
                    .build();
            recommendationService.saveRecommendation(funnyRecommendation, 2L);

            Recommendation gamingRecommendation = Recommendation.builder()
                    .comment("Nice gameplay bro!")
                    .rating(5)
                    .build();
            recommendationService.saveRecommendation(gamingRecommendation, 3L);
        };
    }
}
