CREATE SCHEMA IF NOT EXISTS joke_bot;

CREATE TABLE joke_bot.joke (
                               id BIGSERIAL PRIMARY KEY,
                               text TEXT NOT NULL,
                               created_at TIMESTAMP,
                               updated_at TIMESTAMP
);