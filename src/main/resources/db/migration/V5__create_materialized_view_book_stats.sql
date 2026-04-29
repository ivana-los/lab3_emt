CREATE MATERIALIZED VIEW book_category_stats AS
SELECT
    b.category AS category,
    COUNT(b.id) AS total_books,
    SUM(b.available_copies) AS total_available_copies,
    SUM(CASE WHEN b.book_state != 'GOOD' THEN 1 ELSE 0 END) AS not_good_books
FROM book b
GROUP BY b.category;

-- Optional: create index for faster queries
CREATE INDEX idx_book_category_stats_category ON book_category_stats(category);