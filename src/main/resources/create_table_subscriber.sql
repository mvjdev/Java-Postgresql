DROP TABLE IF EXISTS subscriber;

CREATE TABLE IF NOT EXISTS subscriber(
    subscriber_id SERIAL PRIMARY KEY ,
    subscriber_name VARCHAR(200),
    subscriber_reference VARCHAR(100),
    borrow BOOLEAN
);

INSERT INTO subscriber (subscriber_name, subscriber_reference, borrowed_book_id, borrow)
VALUES
    ('Alice', uuid_generate_v4(), 1, TRUE), -- Alice emprunte le livre avec l'ID 1
    ('Bob', uuid_generate_v4(), NULL, FALSE), -- Bob n'emprunte aucun livre pour le moment
    ('Eve', uuid_generate_v4(), 3, TRUE); -- Eve emprunte le livre avec l'ID 3