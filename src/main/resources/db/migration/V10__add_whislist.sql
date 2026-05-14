CREATE TABLE wishlist (
                          id BIGSERIAL PRIMARY KEY,
                          user_id BIGINT UNIQUE,
                          created_at TIMESTAMP,
                          updated_at TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE wishlist_books (
                                wishlist_id BIGINT,
                                book_id BIGINT,
                                PRIMARY KEY (wishlist_id, book_id),
                                FOREIGN KEY (wishlist_id) REFERENCES wishlist(id),
                                FOREIGN KEY (book_id) REFERENCES book(id)
);