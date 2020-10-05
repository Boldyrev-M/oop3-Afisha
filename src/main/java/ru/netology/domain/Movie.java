package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data

public class Movie {
    private int id;
    private String name;
    private String imageUrl;
    private String genre;
    private String descriptionUrl;
//    private Date dateAdded;
}
