package com.rawg.gameservice.controller;


import com.rawg.gameservice.error.ErrorInfo;
import com.rawg.gameservice.model.QueryString;
import com.rawg.gameservice.model.generated.Games;
import com.rawg.gameservice.model.generated.game.Game;
import com.rawg.gameservice.service.GameApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;


@RestController
@CrossOrigin(origins = "http://192.168.1.61:3000")
@RequestMapping
@Slf4j
public class GamesController {

    @Autowired
    private Environment env;

    @Autowired
    private GameApiService gameApiService;

    @Autowired
    private QueryString queryString;

    @Value("${allowed.origin}")
    private String allowedOrigin;

    @ExceptionHandler(value = {IllegalArgumentException.class,
            IllegalStateException.class, ResponseStatusException.class,
            HttpClientErrorException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorInfo handleConflict(RuntimeException e) {
        return new ErrorInfo(e);
    }

    @GetMapping(value = "/games", produces = {"application/json"})
    public Games getAllGames(@RequestParam(required = false) String page, String search,
                             String ordering, String dates, String page_size, String tags, HttpServletResponse response) {

        String query = queryString.getQueryString(page, search, ordering, dates, page_size, tags);
        log.info(query);
        return gameApiService
                .getAllGames(query);
    }


    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable String id) {
        return gameApiService.getGameById(id);
    }


    @GetMapping("/port")
    public String getPortNum() {
        return env.getProperty("eureka.instance.instance-id");
    }
}
