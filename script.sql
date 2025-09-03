CREATE TABLE usuario (
                         id_usuario SERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(30) NOT NULL UNIQUE,
                         senha VARCHAR(255) NOT NULL,
                         role VARCHAR(50) NOT NULL
);