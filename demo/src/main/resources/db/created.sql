--계정 생성
create role jwl with login password 'asd123';
--DB생성 권한 부여
alter user jwl with createdb;
--슈퍼유저 권한 부여
alter user jwl with superuser;
--role 생성 권한 부여
alter user jwl with createrole;

--스키마 생성
create database catchcarddb;

--스키마에 모든권한 부여
grant all privileges on database catchcarddb to jwl;