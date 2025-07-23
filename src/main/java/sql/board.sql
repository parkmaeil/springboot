create database bootcamp;
-- num, title, writer, date(String), count
drop table board;

create table board(
   num int not null primary key auto_increment,
   title varchar(200) not null,
   writer varchar(200) not null,
   date datetime default now(),
   count int default 0
);
insert into board(title, writer)
values('스프링','관리자');
insert into board(title, writer)
values('MVC','박매일');

select * from board;
