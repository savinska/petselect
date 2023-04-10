-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization.using-basic-sql-scripts

INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'MODERATOR');
INSERT INTO roles (id, role)
VALUES (3, 'USER');


-- some test users
INSERT INTO users (id, first_name, last_name, email, password, country)
VALUES (1, 'Admin', 'Adminov', 'admin@mail.bg', '$2a$10$X0bmFFvzS.gCu77fKAdutukLeQkG2l5lMpPy56GjkJC1DuN91WSPS', 'BULGARIA');

INSERT INTO users (id, first_name, last_name, email, password, country)
VALUES (2,  'User', 'Userov', 'user@gmail.com', '$2a$10$X0bmFFvzS.gCu77fKAdutukLeQkG2l5lMpPy56GjkJC1DuN91WSPS', 'BULGARIA');

INSERT INTO users (id, first_name, last_name, email, password, country)
VALUES (3, 'Ivan', 'Ivanov','ivan@abv.bg', '$2a$10$X0bmFFvzS.gCu77fKAdutukLeQkG2l5lMpPy56GjkJC1DuN91WSPS','BULGARIA');


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

-- pet types
INSERT INTO pet_types(id, pet_type)
VALUES (1, 'CAT');
INSERT INTO pet_types(id, pet_type)
VALUES (2, 'DOG');
-- pet types

-- pets
INSERT INTO pets(id, age_months, age_years, breed, `description`, fur_coat, gender, is_chipped, is_get_along_with_cats, is_get_along_with_dogs, is_get_along_with_kids, is_in_danger, is_spayed_neutered,is_special_needs, is_toilet_trained, is_vaccinated,  location, `name`, registered_on, size_in_kg, temper, author_id, pet_type_id)
VALUES (1, 7, 0,'MIX', 'Rila is the most wonderful dog in the world! She was abandoned with her sister as a puppy and the villagers want to kill them.', 'MEDIUM_HAIR', 'FEMALE', true, false, true, true, true, true, false,false, true, 'STREETS', 'Rila', '2023/04/07 18:50:43', 12, 'CALM', 1, 2);
INSERT INTO pets(id, age_months, age_years, breed, `description`, fur_coat, gender, is_chipped, is_get_along_with_cats, is_get_along_with_dogs, is_get_along_with_kids, is_in_danger, is_spayed_neutered,is_special_needs, is_toilet_trained, is_vaccinated,  location, `name`, registered_on, size_in_kg, temper, author_id, pet_type_id)
VALUES (2, 7, 0,'MIX', 'Lady iis the most wonderful dog in the world! She was abandoned with her sister as a puppy and the villagers want to kill them.', 'MEDIUM_HAIR', 'FEMALE', true, false, true, true, true, true, false,false, true, 'STREETS', 'Lady', '2023/03/08 18:55:02', 11, 'ENERGETIC', 2, 2);
INSERT INTO pets(id, age_months, age_years, breed, `description`, fur_coat, gender, is_chipped, is_get_along_with_cats, is_get_along_with_dogs, is_get_along_with_kids, is_in_danger, is_spayed_neutered,is_special_needs, is_toilet_trained, is_vaccinated,  location, `name`, registered_on, size_in_kg, temper, author_id, pet_type_id)
VALUES (3, 3, 5,'MIX', 'Bango is handsome, lovely, clever and obedient - a real gem! He was found in the streets as a puppy and currently is in foster care', 'MEDIUM_HAIR', 'MALE', true, false, true, true, true, true, false,false, true, 'FOSTER', 'Bango', '2023/04/07 18:50:43', 12, 'CALM', 1, 2);
INSERT INTO pets(id, age_months, age_years, breed, `description`, fur_coat, gender, is_chipped, is_get_along_with_cats, is_get_along_with_dogs, is_get_along_with_kids, is_in_danger, is_spayed_neutered,is_special_needs, is_toilet_trained, is_vaccinated,  location, `name`, registered_on, size_in_kg, temper, author_id, pet_type_id)
VALUES (4, 5, 7,'MIX', 'Agi is super sweet girl! She escaped sure death in the streets of Sofia, when she was rescued from some bad children that were torturing her.', 'SHORT_HAIR', 'FEMALE', true, false, true, true, true, true, false,false, true, 'SHELTER', 'Agi', '2023/03/08 18:55:02', 11, 'ENERGETIC', 2, 2);
INSERT INTO pets(id, age_months, age_years, breed, `description`, fur_coat, gender, is_chipped, is_get_along_with_cats, is_get_along_with_dogs, is_get_along_with_kids, is_in_danger, is_spayed_neutered,is_special_needs, is_toilet_trained, is_vaccinated,  location, `name`, registered_on, size_in_kg, temper, author_id, pet_type_id)
VALUES (5, 1, 4,'MIX', 'Topcho loves cuddles and treats. He is a a very loving boy! He was found as a stray kitten and since then he has been living in the shelter', 'SHORT_HAIR', 'MALE', true, false, false, true, false, true, false,false, true, 'SHELTER', 'Topcho', '2023/04/08 12:00:35', 9, 'PLAYFUL', 1, 1);
INSERT INTO pets(id, age_months, age_years, breed, `description`, fur_coat, gender, is_chipped, is_get_along_with_cats, is_get_along_with_dogs, is_get_along_with_kids, is_in_danger, is_spayed_neutered,is_special_needs, is_toilet_trained, is_vaccinated,  location, `name`, registered_on, size_in_kg, temper, author_id, pet_type_id)
VALUES (6, 8, 6,'MIX', 'Naiden is a fine gentleman with a calm lovely temper. His owner died and now we are looking to re-home him', 'SHORT_HAIR', 'MALE', true, false, false, true, false, true, false,false, true, 'SHELTER', 'Naiden', '2023/04/08 12:00:35', 9, 'PLAYFUL', 1, 1);
INSERT INTO pets(id, age_months, age_years, breed, `description`, fur_coat, gender, is_chipped, is_get_along_with_cats, is_get_along_with_dogs, is_get_along_with_kids, is_in_danger, is_spayed_neutered,is_special_needs, is_toilet_trained, is_vaccinated,  location, `name`, registered_on, size_in_kg, temper, author_id, pet_type_id)
VALUES (7, 0, 2,'MIX', 'Muro is a young, playful and very energetic boy! He was found as a stray kitten and since then he has been living in the streets', 'SHORT_HAIR', 'MALE', true, false, false, true, false, true, false,false, true, 'SHELTER', 'Muro', '2023/04/08 12:00:35', 9, 'CALM', 2, 1);
INSERT INTO pets(id, age_months, age_years, breed, `description`, fur_coat, gender, is_chipped, is_get_along_with_cats, is_get_along_with_dogs, is_get_along_with_kids, is_in_danger, is_spayed_neutered,is_special_needs, is_toilet_trained, is_vaccinated,  location, `name`, registered_on, size_in_kg, temper, author_id, pet_type_id)
VALUES (8, 3, 1,'MIX', 'Vyara is a lovely, playful and very sweet girl! She was found pregnant and all of her kittens were adopted', 'SHORT_HAIR', 'FEMALE', false, true, false, true, true, true, false,false, true, 'STREETS', 'Vyara', '2023/04/05 09:05:10', 6, 'CALM', 2, 1);
-- pets

-- pictures
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (1, 'j0wy90tnkgvsawzakt2b', 'Topcho', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681042637/j0wy90tnkgvsawzakt2b.jpg', 1, 5);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (2, 'iq96oz07c3m23cqdrpsr', 'Rila', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681042128/iq96oz07c3m23cqdrpsr.jpg', 1, 1);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (3, 'tasl6mzcglxwx7wlc4z5', 'Rila1', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681053841/tasl6mzcglxwx7wlc4z5.jpg', 1, 1);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (4, 'fx3i5uplfm8vxtbdzltx', 'Rila2', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681053840/fx3i5uplfm8vxtbdzltx.jpg', 1, 1);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (5, 'hmdshvzf6exo9c31rvte', 'Lady', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681042692/hmdshvzf6exo9c31rvte.jpg', 1, 2);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (6, 'sbxdj49ksr5oqrduy7fb', 'Vyara', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681042662/sbxdj49ksr5oqrduy7fb.jpg', 1, 8);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (7, 'bxokdjtklbi3n8v4gqnz', 'Bango', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681053838/bxokdjtklbi3n8v4gqnz.jpg', 1, 3);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (8, 'wisaeebq69s0imdgkk3a', 'Nayden', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681053840/wisaeebq69s0imdgkk3a.jpg', 1, 6);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (9, 'ok1oxqwscwtgwm8sszfk', 'Agi', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681053842/ok1oxqwscwtgwm8sszfk.jpg', 1, 4);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (10, 'jtk09jpiyfqvhnuy7bjk', 'Agi1', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681053842/jtk09jpiyfqvhnuy7bjk.jpg', 1, 4);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (11, 'onpo8bxauxqkexbigtof', 'Muro', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681053838/onpo8bxauxqkexbigtof.jpg', 1, 7);
INSERT INTO pictures(id, publicid, title, url, author_id, pet_id)
VALUES (12, 'mlinykqz9i317nc3odor', 'Nayden1', 'https://res.cloudinary.com/dfwy21fku/image/upload/v1681053838/mlinykqz9i317nc3odor.jpg', 1, 6);
-- pictures