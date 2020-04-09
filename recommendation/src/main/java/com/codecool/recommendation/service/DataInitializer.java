package com.codecool.recommendation.service;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.model.Video;
import com.codecool.recommendation.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Profile("initializer")
public class DataInitializer {

    @Autowired
    private VideosGetter videosGetter;

    @Autowired
    private RecommendationService recommendationService;

    @Bean
    public CommandLineRunner createRecommendations() {
        List<Video> videos = videosGetter.getAllVideos();
        return args -> {
            Recommendation drumRecommendation = Recommendation.builder()
                    .comment("This is a cool drumming video! Keep it up!")
                    .rating(5)
                    .build();
            Long drumVideoId = videos.get(0).getId();
            recommendationService.saveRecommendation(drumRecommendation, drumVideoId);

            Recommendation funnyRecommendation = Recommendation.builder()
                    .comment("Ha ha very funny video! I love it!!")
                    .rating(5)
                    .build();
            Long funnyVideoId = videos.get(1).getId();
            recommendationService.saveRecommendation(funnyRecommendation, funnyVideoId);

            Recommendation gamingRecommendation = Recommendation.builder()
                    .comment("Nice gameplay bro!")
                    .rating(5)
                    .build();
            Long gamingId = videos.get(2).getId();
            recommendationService.saveRecommendation(gamingRecommendation, gamingId);
        };
    }
}
