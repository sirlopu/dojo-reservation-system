CREATE DATABASE `dojo-reservation-system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `date_created` datetime(6) NOT NULL,
                        `last_updated` datetime(6) NOT NULL,
                        `full_name` varchar(255) NOT NULL,
                        `password_hash` varchar(255) DEFAULT NULL,
                        `username` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UK_echwfeobrupe0065agvdr9617` (`full_name`),
                        UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `reservation` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `date_created` datetime(6) NOT NULL,
                               `end_time` time NOT NULL,
                               `last_updated` datetime(6) NOT NULL,
                               `reservation_date` date NOT NULL,
                               `start_time` time NOT NULL,
                               `user_id` int NOT NULL,
                               `amenity_type` varchar(255) NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `FKm4oimk0l1757o9pwavorj6ljg` (`user_id`),
                               CONSTRAINT `FKm4oimk0l1757o9pwavorj6ljg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `capacity` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `capacity` int NOT NULL,
                            `amenity_type` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `primary_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `date_created` datetime(6) NOT NULL,
                        `last_updated` datetime(6) NOT NULL,
                        `full_name` varchar(255) NOT NULL,
                        `password_hash` varchar(255) DEFAULT NULL,
                        `username` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UK_echwfeobrupe0065agvdr9617` (`full_name`),
                        UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

