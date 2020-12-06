CREATE TABLE IF NOT EXISTS buyers (
    id INTEGER,
    company_name VARCHAR(100),
    street1 VARCHAR(120),
    street2 VARCHAR(120),
    city VARCHAR(50),
    country VARCHAR(50),
    zip VARCHAR(15),
    phone VARCHAR(20),
    email VARCHAR(255),
    primary key(id)
);

CREATE TABLE IF NOT EXISTS sellers (
    id INTEGER,
    company_name VARCHAR(100),
    street1 VARCHAR(120),
    street2 VARCHAR(120),
    city VARCHAR(50),
    country VARCHAR(50),
    zip VARCHAR(15),
    phone VARCHAR(20),
    email VARCHAR(255),
    primary key(id)
);

CREATE SEQUENCE ent_seq START 2;