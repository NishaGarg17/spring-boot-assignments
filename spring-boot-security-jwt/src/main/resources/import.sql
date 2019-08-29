insert into `authority`(name) values('ROLE_ADMIN');
insert into `authority`(name) values('ROLE_MANAGER');
insert into `authority`(name) values('ROLE_EMPLOYEE');

insert into `user`(email,username,enabled,password) values('john@gmail.com','John',1,'{noop}admin');
insert into `user`(email,username,enabled,password) values('anil@gmail.com','Anil',1,'{noop}manager');
insert into `user`(email,username,enabled,password) values('nisha@gmail.com','Nisha',1,'{noop}employee');



