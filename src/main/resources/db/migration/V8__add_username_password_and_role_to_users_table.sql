CREATE TABLE IF NOT EXISTS users (
                                     id         BIGSERIAL PRIMARY KEY,
                                     name       VARCHAR(255),
    surname    VARCHAR(255),
    email      VARCHAR(255),
    username   VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    role       VARCHAR(50),
    updated_at TIMESTAMP
    );