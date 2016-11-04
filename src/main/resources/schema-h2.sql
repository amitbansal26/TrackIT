
DROP TABLE IF EXISTS invitations;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS teams_users;
DROP TABLE IF EXISTS teams;
DROP TABLE IF EXISTS orgs_users;
DROP TABLE IF EXISTS organizations;
DROP TABLE IF EXISTS users;

CREATE TABLE users 
(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  enabled tinyint(1) DEFAULT NULL,
  locked tinyint(1) DEFAULT NULL,
  activation_token varchar(100) DEFAULT NULL,
  forgot_password_token varchar(100) DEFAULT NULL,
  created_by int(11) DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by int(11) DEFAULT NULL,
  updated_date date DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY EMAIL_UNIQUE (email)
);

CREATE TABLE organizations 
(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  owner_user_id int(11) NOT NULL,
  created_by int(11) DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by int(11) DEFAULT NULL,
  updated_date date DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY ORG_NAME_UNIQUE (owner_user_id,name),
  CONSTRAINT fk_owner_user_id FOREIGN KEY (owner_user_id) REFERENCES users (id)
);

CREATE TABLE orgs_users 
(
  org_id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  disabled tinyint(1) DEFAULT NULL,
  PRIMARY KEY (org_id,user_id)
);


CREATE TABLE teams 
(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  org_id int(11) NOT NULL,
  created_by int(11) DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by int(11) DEFAULT NULL,
  updated_date date DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY TEAM_NAME_UNIQUE (org_id,name),
  CONSTRAINT fk_team_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
);

CREATE TABLE teams_users 
(
  team_id int(11) NOT NULL,
  user_id int(11) NOT NULL,
  disabled tinyint(1) DEFAULT NULL,
  PRIMARY KEY (team_id,user_id)
);

CREATE TABLE projects 
(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  team_id int(11) NOT NULL,
  owner_user_id int(11) NOT NULL,
  created_by int(11) DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by int(11) DEFAULT NULL,
  updated_date date DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY TEAM_PROJ_NAME_UNIQUE (team_id,name),
  CONSTRAINT fk_proj_team_id FOREIGN KEY (team_id) REFERENCES teams (id),
  CONSTRAINT fk_proj_owner_user_id FOREIGN KEY (owner_user_id) REFERENCES users (id)
);

CREATE TABLE tasks 
(
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

CREATE TABLE invitations 
(
  id int(11) NOT NULL AUTO_INCREMENT,
  from_email varchar(100) NOT NULL,
  to_email varchar(100) NOT NULL,
  org_id int(11) NOT NULL,
  invitation_code varchar(100) NOT NULL,
  accepted tinyint(1) DEFAULT NULL,
  created_by int(11) DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by int(11) DEFAULT NULL,
  updated_date date DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_invite_org_id FOREIGN KEY (org_id) REFERENCES organizations (id),
  CONSTRAINT fk_invite_from_email FOREIGN KEY (from_email) REFERENCES users (email)  
);
