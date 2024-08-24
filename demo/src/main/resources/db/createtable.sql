create table category (
	idx SERIAL not null,
	title VARCHAR(50),
	contents VARCHAR(100),
	constraint category_pk primary key (idx)
);
--drop table sincard;
create table sincard(
	idx SERIAL not null, 
	title VARCHAR(50),
	price INT default 0,
	inday VARCHAR(20),
	contents VARCHAR(100),
	category_idx INT,
	constraint sincard_pk primary key (idx),
	constraint sincard_fk_category foreign KEY(category_idx) references "category"(idx) on delete cascade on update CASCADE
);
--drop table bupcard;
create table bupcard(
	IDX SERIAL not null,
	TITLE VARCHAR(50),
	PRICE INT default 0,
	INDAY VARCHAR(20),
	contents VARCHAR(100),
	category_idx INT,
	constraint bupcard_pk primary key (idx),
	constraint bupcard_fk_category foreign KEY(category_idx) references "category"(idx) on delete cascade on update CASCADE
);