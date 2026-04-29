CREATE OR REPLACE VIEW book_info_view AS
SELECT
    b.id AS book_id,
    b.title AS book_title,
    b.category AS book_category,
    b.book_state AS book_state,
    b.available_copies AS available_copies,
    CONCAT(a.name, ' ', a.surname) AS author_full_name,
    c.name AS country_name
FROM book b
         JOIN author a ON b.author_id = a.id
         JOIN country c ON a.country_id = c.id;