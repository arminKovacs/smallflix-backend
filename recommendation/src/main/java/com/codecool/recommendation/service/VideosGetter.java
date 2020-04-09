package com.codecool.recommendation.service;

import com.codecool.recommendation.model.Video;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideosGetter {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${videoservice.url}")
    private String baseUrl;

    public List<Video> getAllVideos() {
        ObjectMapper mapper = new ObjectMapper();
        List videosFromService = restTemplate.getForEntity(baseUrl + "/list-all", List.class).getBody();
        List<Video> videos = new ArrayList<>();
        assert videosFromService != null;
        for (Object each : videosFromService) {
            videos.add(mapper.convertValue(each, Video.class));
        }
        return videos;
    }
}
