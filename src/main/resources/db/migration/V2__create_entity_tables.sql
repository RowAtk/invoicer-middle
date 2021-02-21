CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    company_name VARCHAR(100),
    street1 VARCHAR(120),
    street2 VARCHAR(120),
    city VARCHAR(50),
    country VARCHAR(50),
    zip VARCHAR(15),
    phone VARCHAR(20),
    email VARCHAR(255),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS buyers (
    id SERIAL,
    user_id INTEGER,
    company_name VARCHAR(100),
    street1 VARCHAR(120),
    street2 VARCHAR(120),
    city VARCHAR(50),
    country VARCHAR(50),
    zip VARCHAR(15),
    phone VARCHAR(20),
    email VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

