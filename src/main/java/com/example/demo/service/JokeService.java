package com.example.demo.service;

import com.example.demo.model.Joke;
import com.example.demo.repository.JokeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

    public Optional<Joke> findById(Long id) {
        return repository.findById(id);
    }

    public Joke save(Joke joke) {
        joke.setCreatedAt(LocalDateTime.now());
        return repository.save(joke);
    }

    public Joke update(Long id, Joke updatedJoke) {
        return repository.findById(id)
                .map(joke -> {
                    joke.setText(updatedJoke.getText());
                    joke.setUpdatedAt(LocalDateTime.now());
                    return repository.save(joke);
                })
                .orElseThrow(() -> new RuntimeException("Шутка не найдена"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // Метод для бота
    public Joke getRandomJoke() {
        List<Joke> jokes = repository.findAll();
        if (jokes.isEmpty()) return null;
        return jokes.get(new Random().nextInt(jokes.size()));
    }
}
