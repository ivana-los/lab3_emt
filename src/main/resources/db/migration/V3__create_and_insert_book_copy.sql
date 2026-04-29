CREATE TABLE book_copy (
                           id BIGSERIAL PRIMARY KEY,
                           created_at TIMESTAMP,
                           updated_at TIMESTAMP,
                           book_id BIGINT NOT NULL,
                           rented BOOLEAN DEFAULT FALSE,

                           CONSTRAINT fk_book_copy_book
                               FOREIGN KEY (book_id)
                                   REFERENCES book(id)
);

INSERT INTO book_copy (created_at, updated_at, book_id, rented) VALUES
                                                                    (NOW(), NOW(), 1, FALSE),
                                                                    (NOW(), NOW(), 1, FALSE),
                                                                    (NOW(), NOW(), 2, FALSE),
                                                                    (NOW(), NOW(), 2, FALSE),
                                                                    (NOW(), NOW(), 2, FALSE),
                                                                    (NOW(), NOW(), 3, FALSE),
                                                                    (NOW(), NOW(), 3, FALSE),
                                                                    (NOW(), NOW(), 3, FALSE),
                                                                    (NOW(), NOW(), 3, FALSE),
                                                                    (NOW(), NOW(), 3, FALSE);