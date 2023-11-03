CREATE DATABASE "Online-Store"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Kyrgyzstan.1251'
    LC_CTYPE = 'Russian_Kyrgyzstan.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
CREATE TABLE IF NOT EXISTS public.cars
(
    id integer NOT NULL DEFAULT nextval('cars_id_seq'::regclass),
    brand character varying(50) COLLATE pg_catalog."default" NOT NULL,
    model character varying(50) COLLATE pg_catalog."default" NOT NULL,
    year integer NOT NULL,
    cost integer NOT NULL,
    description character varying(200) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT cars_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.details
(
    id integer NOT NULL DEFAULT nextval('details_id_seq'::regclass),
    car_id integer,
    order_id integer,
    amount integer,
    price_for_one integer,
    CONSTRAINT details_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.orders
(
    id integer NOT NULL DEFAULT nextval('orders_id_seq'::regclass),
    dates date NOT NULL,
    sum integer NOT NULL,
    status character varying(30) COLLATE pg_catalog."default" NOT NULL,
    user_id integer,
    CONSTRAINT orders_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(50) COLLATE pg_catalog."default" NOT NULL,
    city character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT users_username_key UNIQUE (name)
);

ALTER TABLE IF EXISTS public.details
    ADD CONSTRAINT fk_car FOREIGN KEY (car_id)
    REFERENCES public.cars (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.details
    ADD CONSTRAINT fk_order FOREIGN KEY (order_id)
    REFERENCES public.orders (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.orders
    ADD CONSTRAINT fk_user FOREIGN KEY (user_id)
    REFERENCES public.users (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;