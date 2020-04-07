package com.codecool.videoservice.repositories;

import com.codecool.videoservice.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Long, Video> {
}
