INSERT INTO country (name, continent) VALUES
                                          ('France', 'Europe'),
                                          ('Brazil', 'South America'),
                                          ('Canada', 'North America');

INSERT INTO author (created_at, updated_at, name, surname, country_id) VALUES
                                                                           (NOW(), NOW(), 'Victor', 'Hugo', 1),
                                                                           (NOW(), NOW(), 'Paulo', 'Coelho', 2),
                                                                           (NOW(), NOW(), 'Margaret', 'Atwood', 3);

INSERT INTO book (created_at, updated_at, title, category, author_id, book_state, available_copies) VALUES
                                                                                                        (NOW(), NOW(), 'Les Miserables', 'NOVEL', 1, 'GOOD', 4),
                                                                                                        (NOW(), NOW(), 'The Alchemist', 'NOVEL', 2, 'GOOD', 6),
                                                                                                        (NOW(), NOW(), 'The Handmaids Tale', 'NOVEL', 3, 'GOOD', 5);