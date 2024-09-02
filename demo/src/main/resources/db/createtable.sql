--drop table category;
create table category (
	idx SERIAL not null,
	title VARCHAR(50),
	contents VARCHAR(100),
	constraint category_pk primary key (idx)
);
--drop table subcategory;
create table subcategory (
	idx SERIAL not null,
	title VARCHAR(50),
	contents VARCHAR(100),
	constraint subcategory_pk primary key (idx)
);
--drop table carduser;
create table carduser(
	idx SERIAL not null,
	userid VARCHAR(50),
	userpwd VARCHAR(100),
	usertype VARCHAR(50),
	cardreset_day VARCHAR(10),
	constraint carduser_pk primary key (idx)
);
--drop table sincard;
create table sincard(
	idx SERIAL not null, 
	title VARCHAR(50),
	price INT default 0,
	inday VARCHAR(20),
	contents VARCHAR(100),
	category_idx INT,
	subcategory_idx INT,
	carduser_idx INT,
	card_stat VARCHAR(1),
	constraint sincard_pk primary key (idx),
	constraint sincard_fk_category foreign KEY(category_idx) references "category"(idx) on delete cascade on update CASCADE,
	constraint sincard_fk_subcategory foreign KEY(subcategory_idx) references "subcategory"(idx) on delete cascade on update cascade,
	constraint sincard_fk_carduser foreign KEY(carduser_idx) references "carduser"(idx) on delete cascade on update cascade
);
--drop table bupcard;
create table bupcard(
	IDX SERIAL not null,
	TITLE VARCHAR(50),
	PRICE INT default 0,
	INDAY VARCHAR(20),
	contents VARCHAR(100),
	category_idx INT,
	subcategory_idx INT,
	carduser_idx INT,
	card_stat VARCHAR(1),
	constraint bupcard_pk primary key (idx),
	constraint bupcard_fk_category foreign KEY(category_idx) references "category"(idx) on delete cascade on update CASCADE,
	constraint bupcard_fk_subcategory foreign KEY(subcategory_idx) references "subcategory"(idx) on delete cascade on update cascade,
	constraint bupcard_fk_carduser foreign KEY(carduser_idx) references "carduser"(idx) on delete cascade on update cascade
);