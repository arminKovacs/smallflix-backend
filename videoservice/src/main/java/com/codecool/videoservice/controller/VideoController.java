package com.codecool.videoservice.controller;

import com.codecool.videoservice.entity.Video;
import com.codecool.videoservice.model.Recommendation;
import com.codecool.videoservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/list-all")
    public List<Video> listAllVideos() {
        return videoService.getAll();
    }

    @GetMapping("/{id}")
    public HashMap<Video, List<Recommendation>> getVideoDetailsById(@PathVariable Long id) {
        return videoService.getDetailsById(id);
    }
}
