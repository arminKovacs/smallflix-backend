package com.codecool.videoservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String url;

}
