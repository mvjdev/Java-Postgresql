DROP TABLE IF EXISTS book;

DROP TYPE IF EXISTS Topic;

CREATE TYPE Topic AS ENUM ('COMEDY', 'ROMANCE', 'OTHER');

CREATE TABLE IF NOT EXISTS book (
    id SERIAL PRIMARY KEY ,
    book_id VARCHAR(200),
    book_name VARCHAR (50),
    topic Topic,
    page_number INT,
    release_date TIMESTAMP,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author (author_id),
    is_borrow BOOLEAN,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author (author_id)
);

INSERT INTO book (book_id, book_name, topic, page_number, release_date, author_id, is_borrow)
VALUES
    (uuid_generate_v4(), 'Book1', 'COMEDY', 200, '2023-01-01', 1, TRUE),
    (uuid_generate_v4(), 'Book2', 'ROMANCE', 300, '2022-05-15', 2, FALSE),
    (uuid_generate_v4(), 'Book3', 'OTHER', 250, '2023-10-20', 3, TRUE);