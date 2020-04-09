package com.codecool.recommendation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {

    @GeneratedValue
    @Id
    private Long id;
    private int rating;
    private String comment;
    private Long videoId;

}
