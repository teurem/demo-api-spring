-- Database: SubaruShop

-- DROP DATABASE IF EXISTS "SubaruShop";

CREATE DATABASE "SubaruShop"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Kyrgyzstan.1251'
    LC_CTYPE = 'Russian_Kyrgyzstan.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE "SubaruShop"
    IS 'neobis 2 week project';
	
CREATE TABLE cars (
	id integer,
	brand text,
	model text,
	year date,
	cost numeric,
	description text
);

CREATE TABLE users (
	id integer,
	name text,
	surname text,
	adress text,
	phone_number integer,
	email text,
	login text,
	password text,
	role boolean
);

CREATE TABLE orders (
	id integer,
	dat date,
	summa numeric,
	status text,
	client_id integer
);

CREATE TABLE details (
	id integer,
	car_id integer,
	order_id integer,
	amount int,
	price_for_one numeric
);
