package com.rawg.gameservice.service;

import com.rawg.gameservice.model.generated.Games;
import com.rawg.gameservice.model.generated.game.Game;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateRequestCustomizer;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.Cookie;
import java.util.Arrays;

@Service
@Slf4j
public class GameApiService {

    @Autowired
    private Environment env;

    @Value("${external.game.url}")
    private String GAME_URL;

    public Games getAllGames(String queryString) {
        RestTemplate template = new RestTemplate();

        try {
            ResponseEntity<Games> gamesResponseEntity = template
                    .exchange(queryString,
                            HttpMethod.GET, null, Games.class);
            log.info("Request on port: " + env.getProperty("server.port"));
            log.info("Request sent to: " + queryString);
            return gamesResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Game getGameById(String id) {
        RestTemplate template = new RestTemplate();

        var queryString = GAME_URL + "/" + id;
        try {
            ResponseEntity<Game> gameResponseEntity = template
                    .exchange(queryString, HttpMethod.GET, null, Game.class);
            return gameResponseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


}
