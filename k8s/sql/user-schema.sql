CREATE TABLE public.users (
	id int8 NOT NULL,
	amount_of_posts int4 NOT NULL,
	username varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);
