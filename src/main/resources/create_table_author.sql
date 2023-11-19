DROP TABLE IF EXISTS author;

CREATE TABLE IF NOT EXISTS author(
    author_id SERIAL PRIMARY KEY ,
    author_name VARCHAR(200),
    gender_author CHAR(1)
);

INSERT INTO author (author_name, gender_author)
VALUES
    ('John Doe', 'M'),
    ('Jane Smith', 'F'),
    ('Alex Johnson', 'M');