CREATE DATABASE joke_bot_db;

-- Подключаемся к новой БД
\c joke_bot_db

-- Создаем схему
CREATE SCHEMA IF NOT EXISTS joke_bot;

-- Создаем последовательность для ID
CREATE SEQUENCE IF NOT EXISTS joke_bot.joke_id_seq;

-- Таблица анекдотов
CREATE TABLE IF NOT EXISTS joke_bot.joke (
                                             id BIGINT PRIMARY KEY DEFAULT nextval('joke_bot.joke_id_seq'),
    text TEXT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
    );

-- Таблица вызовов анекдотов
CREATE TABLE IF NOT EXISTS joke_bot.joke_call (
                                                  id BIGSERIAL PRIMARY KEY,
                                                  joke_id BIGINT NOT NULL REFERENCES joke_bot.joke(id),
    user_id BIGINT NOT NULL,
    called_at TIMESTAMP NOT NULL
    );