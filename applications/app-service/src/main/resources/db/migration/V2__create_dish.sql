CREATE TABLE dishes (
    dish_id BIGSERIAL PRIMARY KEY,
    dish_name VARCHAR(100) NOT NULL,
    dish_price NUMERIC(10,0) NOT NULL,
    dish_description VARCHAR(255) NOT NULL,
    dish_imgurl VARCHAR(255) NOT NULL,
    dish_category VARCHAR(50) NOT NULL,
    dish_active BOOLEAN NOT NULL,
    rest_id BIGINT NOT NULL
);