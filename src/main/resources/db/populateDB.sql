DELETE
FROM user_roles;
DELETE
FROM vote;
DELETE
FROM dish;
DELETE
FROM menu;
DELETE
FROM meal;
DELETE
FROM restaurant;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO users (id, name, password)
VALUES (1, 'User', '$2a$12$Eq8c9Q.Jy0CBtGi5FI27eeGpLVT7mq8w63KXLaeO2lw86XoOMteze'),
       (2, 'Admin', '$2a$12$Eq8c9Q.Jy0CBtGi5FI27eeGpLVT7mq8w63KXLaeO2lw86XoOMteze');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2);

INSERT INTO meal (id, name)
VALUES (3, 'Окрошка'),
       (4, 'Борщ');

INSERT INTO restaurant (id, name)
VALUES (5, 'кафе'),
       (6, 'ресторан');

INSERT INTO menu (id, menudate, restaurant_id)
VALUES (7, '2020-09-13', 5),
       (8, '2020-09-13', 6);

INSERT INTO dish (id, meal_id, menu_id, price)
VALUES (9, 3, 7, 100),
       (10, 4, 7, 200),
       (11, 3, 8, 300),
       (12, 4, 8, 400);




