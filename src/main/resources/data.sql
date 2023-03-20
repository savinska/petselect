-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization.using-basic-sql-scripts

INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'MODERATOR');
INSERT INTO roles (id, role)
VALUES (3, 'USER');


-- some test users
INSERT INTO users (id, first_name, last_name, email, password, country)
VALUES (1, 'Admin', 'Adminov', 'admin@mail.bg', '12345', 'BULGARIA');

INSERT INTO users (id, first_name, last_name, email, password, country)
VALUES (2,  'User', 'Userov', 'user@gmail.com', '12345', 'BULGARIA');

INSERT INTO users (id, first_name, last_name, email, password, country)
VALUES (3, 'Ivan', 'Ivanov','ivan@abv.bg', '12345','BULGARIA');


-- user roles
-- admin
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 1);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 2);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 3);
-- moderator
-- user
INSERT INTO users_roles(`user_entity_id`, `roles_id`)
VALUES (2, 2);
INSERT INTO users_roles(`user_entity_id`, `roles_id`)
VALUES (2, 3);
-- user
INSERT INTO users_roles(`user_entity_id`, `roles_id`)
VALUES (3, 3);
-- user roles



