-- create schema if not exists task_02_2 default character set utf8mb4;


create table if not exists country
(
  id_country int auto_increment not null primary key,
  country    varchar(45)        not null
) ENGINE = InnoDB
  character set = utf8;


create table if not exists city
(
  id_city     int primary key not null auto_increment,
  city        varchar(45)     not null,
  fid_country int             not null,
  constraint FK_city_country
    foreign key (fid_country)
      references country (id_country)
      on delete no action
      on update no action
) ENGINE = InnoDB
  character set = utf8;


create table if not exists address
(
  id_address int         not null primary key auto_increment,
  street     varchar(45) NOT NULL,
  fid_city   int         not null,
  constraint FK_address_city
    foreign key (fid_city)
      references city (id_city)
      on delete no action
      on update no action

) ENGINE = InnoDB
  character set = utf8;


create table if not exists company
(
  id_company   int         not null primary key auto_increment,
  name_company varchar(60) not null
) ENGINE = InnoDB
  character set = utf8;


create table if not exists employee
(
  id_employee int         not null primary key auto_increment,
  first_name  varchar(45) not null,
  last_name   varchar(45) not null,
  fid_address int,
  constraint FK_employee_has_address
    foreign key (fid_address)
      references address (id_address)
      on delete no action
      on update no action
) ENGINE = InnoDB
  character set = utf8;


create table if not exists company_employee
(
  fid_company  int,
  fid_employee int,
  primary key (fid_company, fid_employee),
  constraint FK_company_employee_has_company
    foreign key (fid_company)
      references company (id_company)
      on delete no action
      on update no action,
  constraint FK_company_employee_has_employee
    foreign key (fid_employee)
      references employee (id_employee)
      on delete no action
      on update no action,
  position     varchar(45) not null

) engine = InnoDB
  character set = utf8;


create table if not exists company_address
(
  fid_company int not null,
  fid_address int not null,
  primary key (fid_company, fid_address),
  constraint FK_company_address_has_company
    foreign key (fid_company)
      references company (id_company)
      on delete no action
      on update no action,
  constraint FK_company_address_has_address
    foreign key (fid_address)
      references address (id_address)
      on delete no action
      on update no action
) engine = InnoDB
  character set = utf8;




