-- Supprimer les tables si elles existent
DROP TABLE IF EXISTS book, author, subscriber;

-- Supprimer le type enum s'il existe
DROP TYPE IF EXISTS Topic;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Supprimer le type enum s'il existe

-- Créer le type enum Topic
CREATE TYPE Topic AS ENUM ('COMEDY', 'ROMANCE', 'OTHER');

-- Créer la table Author
CREATE TABLE IF NOT EXISTS author (
      author_id SERIAL PRIMARY KEY,
      author_name VARCHAR(200),
      gender_author CHAR(1)
);

-- Créer la table Book
CREATE TABLE IF NOT EXISTS book (
    id SERIAL PRIMARY KEY,
    book_id VARCHAR(100),
    book_name VARCHAR(50),
    topic VARCHAR(50),
    page_number INT,
    release_date TIMESTAMP,
    author_id INT,
    is_borrow BOOLEAN,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author (author_id)
);

-- Créer la table Subscriber
CREATE TABLE IF NOT EXISTS subscriber (
          subscriber_id SERIAL PRIMARY KEY,
          subscriber_name VARCHAR(200),
          subscriber_reference VARCHAR(200),
          borrowed_book_id INT REFERENCES book (id), -- Référence à l'ID du livre emprunté
          borrow BOOLEAN
);

-- Ajouter des données à la table Author
INSERT INTO author (author_name, gender_author)
VALUES
    ('John Doe', 'M'),
    ('Jane Smith', 'F'),
    ('Alex Johnson', 'M');

-- Ajouter des données à la table Book
INSERT INTO book (book_id, book_name, topic, page_number, release_date, author_id, is_borrow)
VALUES
    (1, 'Book1', 'COMEDY', 200, '2023-01-01', 1, TRUE),
    (2, 'Book2', 'ROMANCE', 300, '2022-05-15', 2, FALSE),
    (3, 'Book3', 'OTHER', 250, '2023-10-20', 3, TRUE);


-- Ajouter des données à la table Subscriber
INSERT INTO subscriber (subscriber_name, subscriber_reference, borrowed_book_id, borrow)
VALUES
    ('Alice', 'REF001', 1, TRUE), -- Alice emprunte le livre avec l'ID 1
    ('Bob', 'REF002', NULL, FALSE), -- Bob n'emprunte aucun livre pour le moment
    ('Eve', 'REF003', 3, TRUE); -- Eve emprunte le livre avec l'ID 3