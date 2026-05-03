CREATE TABLE restaurant_employee (
    reem_id BIGSERIAL PRIMARY KEY,
    rest_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT uk_restaurant_employee UNIQUE (rest_id, user_id)
);