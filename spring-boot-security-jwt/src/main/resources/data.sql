-- Create Database If Not Exists `db_user`;


Create table If Not Exists `Role`(
	`name` varchar(32),
	primary key(`name`) 
);

Create table If Not Exists `User`(
        `user_name` varchar(255), 
        `passoword` varchar(68) not null,
        `role_name` varchar(32) not null,
        primary key(`user_name`),
        foreign key (`role_name`) references Role(`name`)
 );
