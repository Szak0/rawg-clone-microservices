package com.rawg.gameservice.model;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;


@Component
@Slf4j
public class QueryString {

    @Value("${external.game.url}")
    private String GAME_URL;


    private static final List<String> orderingParams = Arrays
            .asList("released", "added", "created", "rating", "name",
                    "-released", "-added", "-created", "-rating", "-name", "");


    public String getQueryString(String pageNumber, String searchString,
                                 String ordering, String dates, String page_size, String tags) {

        if (pageNumber == null) {
            pageNumber = "1";
        }
        if (searchString == null) {
            searchString = "";
        }
        if (ordering == null) {
            ordering = "";
        }
        if (dates == null) {
            dates = "";
        }
        if (page_size == null) {
            page_size = "10";
        }
        if (tags == null) {
            tags = "";
        }

        String tagsPath = "&tags=" + tags;

        String fullPath = "?page=" + pageNumber
                + "&search=" + searchString + "&ordering=" + ordering
                + "&dates=" + dates + "&page_size=" + page_size;

        if (tags.equals("")) {
            return GAME_URL
                    + fullPath;
        } else {
            return GAME_URL
                    + fullPath + tagsPath;
        }
    }

}
