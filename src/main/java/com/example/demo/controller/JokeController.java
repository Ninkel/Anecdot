package com.example.demo.controller;

import com.example.demo.model.Joke;
import com.example.demo.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jokes")
@RequiredArgsConstructor
public class JokeController {
    private final JokeService jokeService;

    @GetMapping
    public List<Joke> getAllJokes() {
        return jokeService.findAllJokes(); // Изменено на findAllJokes()
    }

    @PostMapping
    public Joke addJoke(@RequestBody Joke joke) {
        return jokeService.addJoke(joke);
    }
}