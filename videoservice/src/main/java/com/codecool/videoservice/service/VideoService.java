package com.codecool.videoservice.service;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.model.Recommendation;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private RecommendationGetter recommendationGetter;

    public void saveVideo(Video videoToSave) {
        videoRepository.save(videoToSave);
    }

    public List<Video> getAll() {
        return videoRepository.findAll();
    }

    public HashMap<Video, List<Recommendation>> getDetailsById(Long id) {
        HashMap<Video, List<Recommendation>> videoDetails = new HashMap<>();
        List<Recommendation> videosRecommendations = recommendationGetter.getAllRecommendationForVideo(id);
        Video videoToReturn = videoRepository.findById(id).orElse(null);
        videoDetails.put(videoToReturn, videosRecommendations);
        return videoDetails;
    }
}
