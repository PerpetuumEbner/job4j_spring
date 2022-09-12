CREATE TABLE types
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE rules
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE accidents
(
    id      SERIAL PRIMARY KEY,
    name    TEXT,
    text    TEXT,
    address TEXT,
    type_id INT NOT NULL REFERENCES types (id)
);

CREATE TABLE IF NOT EXISTS accidents_rules
(
    accident_id INT NOT NULL REFERENCES accidents (id),
    rule_id     INT NOT NULL REFERENCES rules (id)
)