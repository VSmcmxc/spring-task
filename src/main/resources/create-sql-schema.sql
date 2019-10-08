

CREATE TABLE role (
  id_role INT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id_role),
  UNIQUE KEY id_role_UNIQUE (id_role)
);

CREATE TABLE user (
  id_user int(11) NOT NULL AUTO_INCREMENT,
 user_name varchar(255) NOT NULL,
 user_email varchar(255) NOT NULL,
 user_password varchar(255) NOT NULL,
 id_role int(11) NOT NULL,
 user_subscription varchar(6) DEFAULT NULL,
  PRIMARY KEY (id_user),
  UNIQUE KEY d_user_UNIQUE (id_user),
  FOREIGN KEY (id_role) REFERENCES role (id_role)
          ON DELETE CASCADE
          ON UPDATE CASCADE
);

CREATE TABLE task (
  id_task int(11) NOT NULL AUTO_INCREMENT,
  id_user int(11) NOT NULL,
  task_description varchar(255) DEFAULT NULL,
  task_complete tinyint(4) DEFAULT '0',
  PRIMARY KEY (id_task),
  UNIQUE KEY id_task_UNIQUE` (id_task),
  CONSTRAINT id_user FOREIGN KEY (id_user) REFERENCES user (id_user) ON DELETE NO ACTION ON UPDATE NO ACTION
)




