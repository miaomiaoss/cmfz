/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/4 19:38:51                            */
/*==============================================================*/


drop table if exists admin;

drop table if exists album;

drop table if exists article;

drop table if exists banner;

drop table if exists chapter;

drop table if exists counter;

drop table if exists course;

drop table if exists guru;

drop table if exists menu;

drop table if exists user;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   id                   varchar(255) not null,
   name                 varchar(255),
   password             varchar(255),
   level                integer(255),
   primary key (id)
);

/*==============================================================*/
/* Table: album                                                 */
/*==============================================================*/
create table album
(
   id                   varchar(255) not null,
   name                 varchar(255),
   brodecast            varchar(255),
   author               varchar(255),
   count                int(5),
   coverpicture         varchar(255),
   score                double,
   contenet             varchar(2000),
   createtime           timestamp,
   status               integer(2),
   primary key (id)
);

/*==============================================================*/
/* Table: article                                                */
/*==============================================================*/
create table article
(
   id                   varchar(255) not null,
   title                varchar(255),
   author               varchar(255),
   articlepicture       varchar(255),
   createtime           timestamp,
   content              varchar(20000),
   primary key (id)
);

/*==============================================================*/
/* Table: banner                                                */
/*==============================================================*/
create table banner
(
   id                   varchar(255) not null,
   picname              varchar(255),
   picpath              varchar(255),
   description          varchar(255),
   status               int(1),
   createtime           timestamp,
   url                  varchar(255),
   primary key (id)
);

/*==============================================================*/
/* Table: chapter                                               */
/*==============================================================*/
create table chapter
(
   id                   varchar(255) not null,
   name                 varchar(255),
   size                 varchar(255),
   albumId              varchar(255),
   path                 varchar(255),
   length               varchar(255),
   times                integer(10),
   createtime           timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: counter                                               */
/*==============================================================*/
create table counter
(
   id                   varchar(255) not null,
   countname            varchar(255),
   count                int(255),
   userid               varchar(255),
   courseid             varchar(255),
   createtime           timestamp,
   lastesttime          timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   id                   varchar(255) not null,
   name                 varchar(255),
   status               varchar(255),
   userid               varchar(255),
   createtime           timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: guru                                                  */
/*==============================================================*/
create table guru
(
   id                   varchar(255) not null,
   dharmaname           varchar(255),
   photo                varchar(255),
   status               integer(2),
   createtime           timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   varchar(255) not null,
   title                varchar(255),
   href                 varchar(255),
   iconcls              varchar(255),
   parentid             varchar(255),
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(255) not null,
   photo                varchar(255),
   username             varchar(255),
   password             varchar(255),
   salt                 char(10),
   dharmaname           varchar(255),
   name                 varchar(255),
   sex                  int(1),
   province             varchar(255),
   city                 varchar(255),
   sign                 varchar(255),
   status               int(1),
   createtime           timestamp,
   primary key (id)
);


