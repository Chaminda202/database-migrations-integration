CREATE TABLE IF NOT EXISTS student (
  id int NOT NULL AUTO_INCREMENT,
  age int DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  occupation varchar(255) DEFAULT NULL,
  salary decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;