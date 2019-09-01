insert into `authority`(name) values('ROLE_ADMIN');
insert into `authority`(name) values('ROLE_MANAGER');
insert into `authority`(name) values('ROLE_EMPLOYEE');

insert into `user`(email,username,enabled,password) values('john@gmail.com','John',1,'{noop}admin');
insert into `user`(email,username,enabled,password) values('anil@gmail.com','Anil',1,'{noop}manager');
insert into `user`(email,username,enabled,password) values('nisha@gmail.com','Nisha',1,'{noop}employee');

insert into `user_authorities`(users_id, authorities_id) values((select id from user where email = 'john@gmail.com'), (select id from authority where name = 'ROLE_ADMIN'))
insert into `user_authorities`(users_id, authorities_id) values((select id from user where email = 'anil@gmail.com'), (select id from authority where name = 'ROLE_MANAGER'))
insert into `user_authorities`(users_id, authorities_id) values((select id from user where email = 'nisha@gmail.com'), (select id from authority where name = 'ROLE_EMPLOYEE'))