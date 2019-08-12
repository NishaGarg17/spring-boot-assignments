Create database if not exists db_ss_user_roles;

Use db_ss_user_roles;

create table if not exists `users`(
	`username` varchar(255) not null,
    `password` varchar(255) not null,
    `enabled` tinyint(1) not null,
    primary key (`username`)
);

create table `authorities`(
	`username` varchar(255) not null,
    `authority` varchar(50) not null,
    
    unique key (`username`,`authority`),
    foreign key(`username`) references `users`(`username`)
);

insert into `users` values('John','{noop}admin',1);
insert into `users` values('Anil','{noop}manager',1);
insert into `users` values('Nisha','{noop}employee',1);


insert into `authorities` values('John','ADMIN');
insert into `authorities` values('Anil','MANAGER');
insert into `authorities` values('Nisha','EMPLOYEE');


select * from `users`;
select * from `authorities`;