  -- 1 分
  create database mycup;
  go

  use mycup;

  -- 5 分
  create table cup
  (
     id int identity primary key,
     name varchar(20) not null,
     price money check ( price > 0 ),
     birth datetime default getdate()
  );

  -- 3 分
  insert into cup (name, price, birth) values ('高脚杯', 22.3, '2020-10-11');
  insert into cup (name, price, birth) values ('啤酒杯', 14.3, '2020-12-11');
  insert into cup (name, price, birth) values ('茶水杯', 93.3, '2020-11-11');