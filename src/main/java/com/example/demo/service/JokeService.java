package com.example.demo.service;

import com.example.demo.model.Joke;
import com.example.demo.repository.JokeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class JokeService {
    private final JokeRepository repository;
    private final Random random = new Random();

    // Новый метод для получения всех анекдотов
    public List<Joke> findAllJokes() {
        return repository.findAll();
    }

    public Joke getRandomJoke() {
        List<Joke> jokes = repository.findAll();
        if (jokes.isEmpty()) return null;
        return jokes.get(random.nextInt(jokes.size()));
    }

    public Joke addJoke(Joke joke) {
        joke.setCreatedAt(LocalDateTime.now());
        return repository.save(joke);
    }
}