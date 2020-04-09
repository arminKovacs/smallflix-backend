package com.codecool.videoservice.service;

import com.codecool.videoservice.entity.Video;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@Profile("initializer")
public class DataInitializer {

    @Autowired
    private VideoService videoService;

    @Bean
    public CommandLineRunner createVideos() {
        return args -> {
            Video video1 = Video.builder()
                    .name("Drumming video")
                    .url("https://www.youtube.com/watch?v=VNdiJnzlTbQ")
                    .build();

            Video video2 = Video.builder()
                    .name("Funny video")
                    .url("https://www.youtube.com/watch?v=2Ush-1esQ-4")
                    .build();

            Video video3 = Video.builder()
                    .name("Gaming video")
                    .url("https://www.youtube.com/watch?v=b65QC3JV3-w")
                    .build();

            List<Video> videos = Arrays.asList(video1, video2, video3);
            for (Video each : videos) {
                videoService.saveVideo(each);
            }
        };
    }
}
