create table country(
                        id bigserial primary key,
                        name varchar(100),
                        continent varchar(100)
);

create table author(
                       id bigserial primary key,
                       created_at timestamp,
                       updated_at timestamp,
                       name varchar(100),
                       surname varchar(100),
                       country_id bigint references country(id)
);

create table book(
                     id bigserial primary key,
                     created_at timestamp,
                     updated_at timestamp,
                     title varchar(200),
                     category varchar(50),
                     author_id bigint references author(id),
                     book_state  varchar(50),
                     available_copies integer
);