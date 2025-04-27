package com.example.demo.controller;

import com.example.demo.model.Joke;
import com.example.demo.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jokes")
@RequiredArgsConstructor
public class JokeController {
    private final JokeService jokeService;

    // Получить все шутки
    @GetMapping
    public List<Joke> getAllJokes() {
        return jokeService.findAll();
    }

    // Получить 1 шутку по ID
    @GetMapping("/{id}")
    public ResponseEntity<Joke> getJokeById(@PathVariable Long id) {
        return jokeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Добавить шутку
    @PostMapping
    public Joke addJoke(@RequestBody Joke joke) {
        return jokeService.save(joke);
    }

    // Обновить шутку
    @PutMapping("/{id}")
    public ResponseEntity<Joke> updateJoke(
            @PathVariable Long id,
            @RequestBody Joke updatedJoke) {
        return ResponseEntity.ok(jokeService.update(id, updatedJoke));
    }

    // Удалить шутку
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJoke(@PathVariable Long id) {
        jokeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
