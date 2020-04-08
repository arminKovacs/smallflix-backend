package com.codecool.videoservice.service;

import com.codecool.videoservice.entity.Video;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class VideoServiceTest {

    @Autowired
    private VideoService videoService;

    @Test
    public void testVideoPersistInJPA() {
        Video firstVideo = Video.builder()
                .name("First video")
                .url("youtube.com")
                .build();
        videoService.saveVideo(firstVideo);
        assertEquals(1, videoService.getAll().size());
    }

}