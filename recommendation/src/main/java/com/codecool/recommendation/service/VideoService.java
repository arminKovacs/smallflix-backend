package com.codecool.recommendation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${videoservice.url}")
    private String baseUrl;

    public List getAllVideos() {
        List videos = restTemplate.getForEntity(baseUrl + "/list-all", List.class).getBody();
        for (Object each : videos) {
            System.out.println(each);
        }
        return videos;
    }
}
