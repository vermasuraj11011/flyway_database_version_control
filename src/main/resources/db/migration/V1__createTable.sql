

CREATE TABLE users(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    username varchar(40) NOT NULL,
    `name` varchar(40) NOT NULL,
    `email` varchar(60) NOT NULL,
    PRIMARY KEY  (id),
    UNIQUE KEY	UK_username (username)
)ENGINE=InnoDB Default charset=utf8