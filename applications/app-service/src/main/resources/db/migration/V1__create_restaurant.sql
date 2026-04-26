CREATE TABLE restaurants (
    rest_id BIGSERIAL PRIMARY KEY,
    rest_name VARCHAR(100) NOT NULL,
    rest_nit VARCHAR(100) NOT NULL UNIQUE,
    rest_address VARCHAR(100) NOT NULL,
    rest_phone VARCHAR(13) NOT NULL,
    rest_logourl VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL
);