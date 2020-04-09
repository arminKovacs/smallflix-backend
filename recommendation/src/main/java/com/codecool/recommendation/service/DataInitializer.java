package com.codecool.recommendation.service;

import com.codecool.recommendation.model.Video;
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

    @Bean
    public CommandLineRunner createVideos() {
        List videos = videosGetter.getAllVideos();
        for (Object each : videos) {
            System.out.println(each);
            return args -> {

            }
        };
    }
}
