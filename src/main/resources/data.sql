
insert into users (id, name, email, password) values 
(1, 'SuperAdmin', 'superadmin@gmail.com', '$2a$10$p3PHnpoBAnzZiL8mr3gMieMhVVSb585ajC2ZsBB0kwb4KvZKFSdNi');

insert into users (id, name, email, password) values 
(2, 'Siva', 'siva@gmail.com', '$2a$10$UFEPYW7Rx1qZqdHajzOnB.VBR3rvm7OI7uSix4RadfQiNhkZOi2fi');


INSERT INTO organizations(id, name,	owner_user_id,created_by,created_date,updated_by,updated_date)
VALUES (1, 'Test Organization',1,1,'2016-11-02',NULL,NULL);

INSERT INTO organizations(id, name,	owner_user_id,created_by,created_date,updated_by,updated_date)
VALUES (2, 'SivaLabs',2,2,'2016-11-02',NULL,NULL);
