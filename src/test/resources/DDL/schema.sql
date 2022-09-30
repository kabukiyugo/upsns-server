CREATE SCHEMA IF NOT EXISTS upload_sns;

DROP TABLE IF EXISTS upload_sns.article_use_tag;
DROP TABLE IF EXISTS upload_sns.access_log;
DROP TABLE IF EXISTS upload_sns.tag;
DROP TABLE IF EXISTS upload_sns.favorite;
DROP TABLE IF EXISTS upload_sns.reply;
DROP TABLE IF EXISTS upload_sns.article;
DROP TABLE IF EXISTS upload_sns.image;
DROP TABLE IF EXISTS upload_sns.user;

CREATE TABLE upload_sns.user (
	id serial NOT NULL AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	furigana varchar(255) NOT NULL,
	mail varchar(255) NOT NULL,
	tel_no varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	role varchar(255) NULL,
	insert_time timestamp NOT NULL,
	update_time timestamp NULL,
	icon_image_path varchar(255) NOT NULL,
	comment varchar(255) NULL,
	cognito_id varchar(255) NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE upload_sns.image (
	id serial NOT NULL AUTO_INCREMENT,
	image_file_path varchar(255) NOT NULL,
	insert_time timestamp NOT NULL,
	update_time timestamp NULL,
	CONSTRAINT images_pk PRIMARY KEY (id)
);

CREATE TABLE upload_sns.article (
	id serial NOT NULL AUTO_INCREMENT,
	title varchar(255) NOT NULL,
	body varchar NULL,
	user_id int NOT NULL,
	insert_time timestamp NOT NULL,
	update_time timestamp NULL,
	image_id int NULL,
	CONSTRAINT articles_pk PRIMARY KEY (id),
	CONSTRAINT article_fk_image_id FOREIGN KEY (image_id) REFERENCES upload_sns.image(id),
	CONSTRAINT article_fk_user_id FOREIGN KEY (user_id) REFERENCES upload_sns.user(id) ON DELETE CASCADE
);

CREATE TABLE upload_sns.favorite (
	id serial NOT NULL AUTO_INCREMENT,
	push_user_id int NOT NULL,
	article_id int NOT NULL,
	insert_time timestamp NOT NULL,
	update_time timestamp NULL,
	CONSTRAINT favorite_pk PRIMARY KEY (id),
	CONSTRAINT favorite_fk_article_id FOREIGN KEY (article_id) REFERENCES upload_sns.article(id) ON DELETE CASCADE,
	CONSTRAINT favorite_fk_push_user_id FOREIGN KEY (push_user_id) REFERENCES upload_sns.user(id) ON DELETE CASCADE
);

CREATE TABLE upload_sns.reply (
	id serial NOT NULL AUTO_INCREMENT,
	comment varchar NOT NULL,
	user_id int NOT NULL,
	parent_id int NULL,
	insert_time timestamp NOT NULL,
	article_id int NOT NULL,
	CONSTRAINT reply_pk PRIMARY KEY (id),
	CONSTRAINT reply_fk_aticle_id FOREIGN KEY (article_id) REFERENCES upload_sns.article(id) ON DELETE CASCADE,
	CONSTRAINT reply_fk_parent_id FOREIGN KEY (parent_id) REFERENCES upload_sns.reply(id) ON DELETE SET NULL,
	CONSTRAINT reply_fk_user_id FOREIGN KEY (user_id) REFERENCES upload_sns.user(id) ON DELETE CASCADE
);

CREATE TABLE upload_sns.tag (
	id serial NOT NULL AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	insert_time timestamp NOT NULL,
	update_time timestamp NULL,
	CONSTRAINT tags_pk PRIMARY KEY (id)
);

CREATE TABLE upload_sns.article_use_tag (
	article_id int NOT NULL,
	tag_id int NOT NULL,
	CONSTRAINT article_use_tag_pk PRIMARY KEY (article_id, tag_id),
	CONSTRAINT fk_article_id FOREIGN KEY (article_id) REFERENCES upload_sns.article(id) ON DELETE CASCADE,
	CONSTRAINT fk_tag_id FOREIGN KEY (tag_id) REFERENCES upload_sns.tag(id) ON DELETE CASCADE
);

-- CREATE TABLE upload_sns.access_log (
-- 	id serial NOT NULL,
-- 	access_uri varchar(255) NOT NULL,
-- 	user_id int NOT NULL,
-- 	insert_time timestamp NOT NULL,
-- 	CONSTRAINT access_log_pk PRIMARY KEY (id),
-- 	CONSTRAINT access_log_fk_user_id FOREIGN KEY (user_id) REFERENCES upload_sns.user(id) ON DELETE CASCADE
-- );