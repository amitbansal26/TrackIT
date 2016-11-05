
insert into users (id, name, email, password) values 
(1, 'SuperAdmin', 'superadmin@gmail.com', '$2a$10$p3PHnpoBAnzZiL8mr3gMieMhVVSb585ajC2ZsBB0kwb4KvZKFSdNi'),
(2, 'Siva', 'siva@gmail.com', '$2a$10$UFEPYW7Rx1qZqdHajzOnB.VBR3rvm7OI7uSix4RadfQiNhkZOi2fi'),
(3, 'Prasad', 'prasad@gmail.com', '$2a$10$kVM/Sv4g0I.snKeVCyAIzuqUqMphIHRlGlmgrCz7W6Xx4ciZgzc6K'),
(4, 'Neha', 'neha@gmail.com', '$2a$10$Sew7RYYZyeyni51JWBOAiO9BCz/YVksRqv6iSbILqtN9hJC7KqAfe'),
(5, 'Ramu', 'ramu@gmail.com', '$2a$10$E3GbWx.jFxiigLjEb58lxuTLsBYRmTHxlBgtBa4mrIDtai0oLBdKW'),
(6, 'Suman', 'suman@gmail.com', '$2a$10$9r12CrRMSt6OwlH/FFcVyeth8ItDWPHS21WljHxFcZ5wq/FC2wh7W')
;

INSERT INTO organizations(id, name,	owner_user_id,created_by,created_date,updated_by,updated_date) VALUES 
(1, 'Test Organization',1,1,'2016-11-02',NULL,NULL),
(2, 'SivaLabs',2,2,'2016-11-02',NULL,NULL),
(3, 'CCC',4,4,'2016-11-02',NULL,NULL),
(4, 'VoiceIT',5,5,'2016-11-02',NULL,NULL)
;

INSERT INTO orgs_users(org_id, user_id, disabled) values 
(1, 1, false),
(1, 2, false),
(2, 1, false),
(2, 2, false),
(2, 5, false),
(3, 4, false),
(4, 5, false),
(4, 2, false)
;

INSERT INTO teams (id,name,org_id,created_by,created_date,updated_by,updated_date) VALUES 
(1,'JBloggerTeam',2,2,'2016-11-02',NULL,NULL),
(2,'TrackITTeam',2,2,'2016-11-02',NULL,NULL),
(3,'ApexTeam',3,4,'2016-11-02',NULL,NULL),
(4,'VoiceOverIP',4,5,'2016-11-02',NULL,NULL)
;

INSERT INTO teams_users(team_id, user_id, disabled) values 
(1, 2, false),
(2, 2, false),
(2, 5, false),
(3, 4, false),
(4, 2, false),
(4, 5, false)
;

INSERT INTO projects(id,name,team_id,owner_user_id,created_by,created_date,updated_by,updated_date) VALUES
(1, 'JBlogger Iteration 1',1,2,2,'2016-11-02',NULL,NULL),
(2, 'JBlogger Iteration 2',1,2,2,'2016-11-02',NULL,NULL),
(3, 'TrackIT Iteration 1',2,2,2,'2016-11-02',NULL,NULL),
(4, 'TrackIT Iteration 2',2,2,2,'2016-11-02',NULL,NULL),
(5, 'ApexTeam Phase 1',3,4,4,'2016-11-02',NULL,NULL),
(6, 'VoiceXML Builder',4,5,5,'2016-11-02',NULL,NULL)
;

INSERT INTO tasks (id,title,description,proj_id,assigned_user_id,due_date,created_by,created_date,updated_by,updated_date) VALUES
(1,'Create Database Schema','Setup initial schema for JBlogger',1,2,null,2,'2016-11-02',NULL,NULL),
(2,'Setup maven project','Setup initial project with maven build configuration',1,2,null,2,'2016-11-02',NULL,NULL),
(3,'Create Database Schema','Setup initial project with maven build configuration',2,2,null,2,'2016-11-02',NULL,NULL),
(4,'Setup maven project','Setup initial schema for JBlogger',2,2,null,2,'2016-11-02',NULL,NULL)
;

INSERT INTO tags (id,name,org_id,created_by,created_date,updated_by,updated_date) VALUES
(1,'Deffered',1,1,'2016-11-02',NULL,NULL),
(2,'Design Pending',1,1,'2016-11-02',NULL,NULL),
(3,'Business Approval Pending',1,1,'2016-11-02',NULL,NULL),
(4,'Completed',1,1,'2016-11-02',NULL,NULL),
(5,'Ready To Deploy',1,1,'2016-11-02',NULL,NULL),

(6,'Deffered',2,2,'2016-11-02',NULL,NULL),
(7,'Design Pending',2,2,'2016-11-02',NULL,NULL),
(8,'Business Approval Pending',2,2,'2016-11-02',NULL,NULL),
(9,'Completed',2,2,'2016-11-02',NULL,NULL),
(10,'Ready To Deploy',2,2,'2016-11-02',NULL,NULL)

;
