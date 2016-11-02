
insert into users (id, name, email, password) values (1, 'superadmin', 'superadmin@gmail.com', 'superadmin');
insert into users (id, name, email, password) values (2, 'test', 'test@gmail.com', 'test');


INSERT INTO organizations(id, name,	owner_user_id,created_by,created_date,updated_by,updated_date)
VALUES (1, 'Test Organization',1,1,'2016-11-02',NULL,NULL);
