CREATE DATABASE `petselect` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */

CREATE TABLE `blocked_ips` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `messages` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sent_on` datetime(6) NOT NULL,
  `text_content` text NOT NULL,
  `recipient_id` bigint DEFAULT NULL,
  `sender_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhdkwfnspwb3s60j27vpg0rpg6` (`recipient_id`),
  KEY `FK4ui4nnwntodh6wjvck53dbk9m` (`sender_id`),
  CONSTRAINT `FK4ui4nnwntodh6wjvck53dbk9m` FOREIGN KEY (`sender_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKhdkwfnspwb3s60j27vpg0rpg6` FOREIGN KEY (`recipient_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `organizations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `organization_type` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `province` smallint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `pet_types` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pet_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `pets` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age_months` int NOT NULL,
  `age_years` int NOT NULL,
  `been_in_shelter_since` date DEFAULT NULL,
  `breed` varchar(255) DEFAULT NULL,
  `description` text NOT NULL,
  `fur_coat` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `is_chipped` bit(1) DEFAULT NULL,
  `is_get_along_with_cats` bit(1) DEFAULT NULL,
  `is_get_along_with_dogs` bit(1) DEFAULT NULL,
  `is_get_along_with_kids` bit(1) DEFAULT NULL,
  `is_in_danger` bit(1) DEFAULT NULL,
  `is_spayed_neutered` bit(1) DEFAULT NULL,
  `is_special_needs` bit(1) DEFAULT NULL,
  `is_toilet_trained` bit(1) DEFAULT NULL,
  `is_vaccinated` bit(1) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `registered_on` datetime(6) NOT NULL,
  `size_in_kg` int NOT NULL,
  `temper` varchar(255) DEFAULT NULL,
  `author_id` bigint DEFAULT NULL,
  `pet_type_id` bigint DEFAULT NULL,
  `responsible_organization_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpfqvttchtchtptqyffm3sa2oa` (`author_id`),
  KEY `FKp02i0a9uttd4xu2o4x5u5wayl` (`pet_type_id`),
  KEY `FKr1jfuw82xlad3ebjhm1pnahy0` (`responsible_organization_id`),
  CONSTRAINT `FKp02i0a9uttd4xu2o4x5u5wayl` FOREIGN KEY (`pet_type_id`) REFERENCES `pet_types` (`id`),
  CONSTRAINT `FKpfqvttchtchtptqyffm3sa2oa` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKr1jfuw82xlad3ebjhm1pnahy0` FOREIGN KEY (`responsible_organization_id`) REFERENCES `organizations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `pets_added_to_favourites_by` (
  `pet_entity_id` bigint NOT NULL,
  `added_to_favourites_by_id` bigint NOT NULL,
  PRIMARY KEY (`pet_entity_id`,`added_to_favourites_by_id`),
  KEY `FKrwe7m4fchmwiyih2b8pjkvj8n` (`added_to_favourites_by_id`),
  CONSTRAINT `FKjw4ipgs0ejkrhklhk0laosey7` FOREIGN KEY (`pet_entity_id`) REFERENCES `pets` (`id`),
  CONSTRAINT `FKrwe7m4fchmwiyih2b8pjkvj8n` FOREIGN KEY (`added_to_favourites_by_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `pictures` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `publicid` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `url` text NOT NULL,
  `author_id` bigint DEFAULT NULL,
  `pet_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrndue6dq3063584yvjmpa09jc` (`author_id`),
  KEY `FKbvprv5hr8ey78rfkv3srhdp6g` (`pet_id`),
  CONSTRAINT `FKbvprv5hr8ey78rfkv3srhdp6g` FOREIGN KEY (`pet_id`) REFERENCES `pets` (`id`),
  CONSTRAINT `FKrndue6dq3063584yvjmpa09jc` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `reset_password_tokens` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_on` datetime(6) DEFAULT NULL,
  `expired` bit(1) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnwk79win0k7k6tlb6imjninfu` (`user_id`),
  CONSTRAINT `FKnwk79win0k7k6tlb6imjninfu` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `users_roles` (
  `user_entity_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  KEY `FKa62j07k5mhgifpp955h37ponj` (`roles_id`),
  KEY `FK7v417qhe0i2m9h8njggvciv00` (`user_entity_id`),
  CONSTRAINT `FK7v417qhe0i2m9h8njggvciv00` FOREIGN KEY (`user_entity_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKa62j07k5mhgifpp955h37ponj` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



