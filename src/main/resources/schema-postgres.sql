

DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS teams;
DROP TABLE IF EXISTS orgs_users;
DROP TABLE IF EXISTS organizations;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id serial PRIMARY KEY,
  name varchar(50) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  CONSTRAINT EMAIL_UNIQUE UNIQUE (email)
);

CREATE TABLE organizations (
  id serial PRIMARY KEY,
  name varchar(100) NOT NULL,
  admin_user_id integer NOT NULL,
  CONSTRAINT ORG_NAME_UNIQUE UNIQUE (admin_user_id,name),
  CONSTRAINT fk_admin_user_id FOREIGN KEY (admin_user_id) REFERENCES users (id)
);

CREATE TABLE orgs_users (
  org_id integer NOT NULL,
  user_id integer NOT NULL,
  disabled boolean DEFAULT NULL,
  PRIMARY KEY (org_id, user_id)
);

CREATE TABLE teams (
  id serial PRIMARY KEY,
  org_id integer NOT NULL,
  name varchar(100) NOT NULL,
  CONSTRAINT TEAM_NAME_UNIQUE UNIQUE (org_id,name),
  CONSTRAINT fk_team_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
);

CREATE TABLE projects (
  id serial PRIMARY KEY,
  org_id integer NOT NULL,
  name varchar(100) NOT NULL,
  CONSTRAINT NAME_UNIQUE UNIQUE (org_id,name),
  CONSTRAINT fk_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
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
