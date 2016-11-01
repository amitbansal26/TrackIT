
DROP TABLE IF EXISTS invitations;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS teams;
DROP TABLE IF EXISTS orgs_users;
DROP TABLE IF EXISTS organizations;
DROP TABLE IF EXISTS users;

CREATE TABLE users 
(
  id serial PRIMARY KEY,
  name varchar(50) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  enabled boolean DEFAULT NULL,
  locked boolean DEFAULT NULL,
  activation_token varchar(100) DEFAULT NULL,
  forgot_password_token varchar(100) DEFAULT NULL,
  created_by integer DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by integer DEFAULT NULL,
  updated_date date DEFAULT NULL,
  CONSTRAINT EMAIL_UNIQUE UNIQUE (email)
);

CREATE TABLE organizations 
(
  id serial PRIMARY KEY,
  name varchar(100) NOT NULL,
  owner_user_id integer NOT NULL,
  created_by integer DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by integer DEFAULT NULL,
  updated_date date DEFAULT NULL,
  CONSTRAINT ORG_NAME_UNIQUE UNIQUE (owner_user_id,name),
  CONSTRAINT fk_owner_user_id FOREIGN KEY (owner_user_id) REFERENCES users (id)
);

CREATE TABLE orgs_users 
(
  org_id integer NOT NULL,
  user_id integer NOT NULL,
  disabled boolean DEFAULT NULL,
  PRIMARY KEY (org_id, user_id)
);

CREATE TABLE teams 
(
  id serial PRIMARY KEY,
  name varchar(100) NOT NULL,
  org_id integer NOT NULL,
  created_by integer DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by integer DEFAULT NULL,
  updated_date date DEFAULT NULL,
  CONSTRAINT TEAM_NAME_UNIQUE UNIQUE (org_id,name),
  CONSTRAINT fk_team_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
);

CREATE TABLE projects 
(
  id serial PRIMARY KEY,
  name varchar(100) NOT NULL,
  team_id integer NOT NULL,
  owner_user_id integer NOT NULL,
  created_by integer DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by integer DEFAULT NULL,
  updated_date date DEFAULT NULL,
  CONSTRAINT PROJ_NAME_UNIQUE UNIQUE (team_id,name),
  CONSTRAINT fk_proj_team_id FOREIGN KEY (team_id) REFERENCES teams (id),
  CONSTRAINT fk_proj_owner_user_id FOREIGN KEY (owner_user_id) REFERENCES users (id)
);

CREATE TABLE tasks (
  id serial PRIMARY KEY,
  title varchar(200) NOT NULL,
  description text,
  proj_id integer NOT NULL,
  assigned_user_id integer DEFAULT NULL,
  due_date date DEFAULT NULL,
  created_by integer DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by integer DEFAULT NULL,
  updated_date date DEFAULT NULL,
  CONSTRAINT fk_proj_task_id FOREIGN KEY (proj_id) REFERENCES projects (id),
  CONSTRAINT fk_task_user_id FOREIGN KEY (assigned_user_id) REFERENCES users (id)
);

CREATE TABLE invitations 
(
  id serial PRIMARY KEY,
  from_email varchar(100) NOT NULL,
  to_email varchar(100) NOT NULL,
  org_id integer NOT NULL,
  accepted boolean DEFAULT NULL,
  created_by integer DEFAULT NULL,
  created_date date DEFAULT NULL,
  updated_by integer DEFAULT NULL,
  updated_date date DEFAULT NULL,
  CONSTRAINT fk_invite_org_id FOREIGN KEY (org_id) REFERENCES organizations (id),
  CONSTRAINT fk_invite_from_email FOREIGN KEY (from_email) REFERENCES users (email)
  
);
