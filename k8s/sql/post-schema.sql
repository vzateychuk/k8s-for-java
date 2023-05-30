CREATE TABLE public.posts (
	id int8 NOT NULL,
	author_id int8 NOT NULL,
	posted_at date NULL,
	"text" varchar(255) NULL,
	CONSTRAINT posts_pkey PRIMARY KEY (id)
);
