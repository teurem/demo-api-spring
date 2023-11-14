-- Database: Online-Store

-- DROP DATABASE IF EXISTS "Online-Store";

CREATE DATABASE "Online-Store"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Kyrgyzstan.1251'
    LC_CTYPE = 'Russian_Kyrgyzstan.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
	create table roles (
		id integer,
		name varchar(50),
		primary key (id)
	);
	
	create table users_roles (
		user_id bigint not null,
		role_id int not null,
		primary key(user_id, role_id ),
		foreign key(user_id) references users(id),
		foreign key(role_id) references roles(id)
	);
	
	insert into roles (name, id)
	values
	('ROLE_USER', 2), ('ROLE_ADMIN', 1);
	
	insert into users_roles (user_id, role_id)
	values
	(2, 1), (3,2);