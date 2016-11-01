

DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS teams;
DROP TABLE IF EXISTS orgs_users;
DROP TABLE IF EXISTS organizations;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY EMAIL_UNIQUE (email)
);

CREATE TABLE organizations (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  admin_user_id int(11) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY ORG_NAME_UNIQUE (admin_user_id,name),
  CONSTRAINT fk_admin_user_id FOREIGN KEY (admin_user_id) REFERENCES users (id)
);

CREATE TABLE orgs_users (
  org_id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  disabled tinyint(1) DEFAULT NULL,
  PRIMARY KEY (org_id,user_id)
);


CREATE TABLE teams (
  id int(11) NOT NULL AUTO_INCREMENT,
  org_id int(11) NOT NULL,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY TEAM_NAME_UNIQUE (org_id,name),
  CONSTRAINT fk_team_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
);


CREATE TABLE projects (
  id int(11) NOT NULL AUTO_INCREMENT,
  org_id int(11) NOT NULL,
  name varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY NAME_UNIQUE (org_id,name),
  CONSTRAINT fk_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
);

CREATE TABLE tasks (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(200) NOT NULL,
  description longtext,
  proj_id int(11) NOT NULL,
  assigned_user_id int(11) DEFAULT NULL,
  due_date date DEFAULT NULL,
  created_by int(11) DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by int(11) DEFAULT NULL,
  updated_date date DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_proj_task_id FOREIGN KEY (proj_id) REFERENCES projects (id),
  CONSTRAINT fk_task_user_id FOREIGN KEY (assigned_user_id) REFERENCES users (id)
);
