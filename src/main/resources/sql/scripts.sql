create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

insert into  users values ('reddy', 'XXX' , '1');
insert into  authorities  values ('reddy', 'write');

create table customer (id serial primary key,
email varchar(45) not null,
pwd varchar(200) not null,
role varchar(45) not null
);


insert into customer (email,pwd,role)
 values ('xxxxxxxxyyyyyy@gmail.com','12345','admin')