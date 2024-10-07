--liquibase formatted sql

--changeset ByCooper:1
create TABLE users (
  id BIGINT PRIMARY KEY NOT NULL,
  username VARCHAR,
  email VARCHAR NOT NULL,
  first_name VARCHAR(200),
  last_name VARCHAR(200),
  phone VARCHAR(20),
  role VARCHAR,
  image VARCHAR,
  password VARCHAR(100) NOT NULL
);

--changeset ByCooper:2
create TABLE ads (
  id BIGINT PRIMARY KEY NOT NULL,
  author_id BIGINT NOT NULL,
  image VARCHAR,
  price INTEGER,
  title VARCHAR,
  description VARCHAR,
  FOREIGN KEY (author_id) REFERENCES users(id)
);

--changeset ByCooper:3
create TABLE comments (
  id BIGINT PRIMARY KEY NOT NULL,
  author_id BIGINT NOT NULL,
  author_image VARCHAR,
  author_first_name VARCHAR,
  created_at BIGINT,
  text VARCHAR,
  ad_id BIGINT NOT NULL,
  FOREIGN KEY (author_id) REFERENCES users(id),
  FOREIGN KEY (ad_id) REFERENCES ads(id)
);

--changeset ByCooper:4
create TABLE avatar(
    id BIGINT PRIMARY KEY NOT NULL,
    file_path VARCHAR,
    file_size BIGINT,
    media_type VARCHAR,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

--changeset ByCooper:5
create TABLE image(
    id BIGINT PRIMARY KEY NOT NULL,
    file_path VARCHAR,
    file_size BIGINT,
    media_type VARCHAR,
    ad_id BIGINT NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads(id)
    );

--FOREIGN KEY (author_id) REFERENCES authors(id)