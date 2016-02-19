create table users
(
	id int not null primary key auto_increment,
	username varchar(100) not null,
	password varchar(40) not null
)ENGINE=MYISAM DEFAULT CHARSET=UTF8;