show databases;
use fengminxia;
show tables;

select * from fmx_tea;
select * from fmx_user;
select * from fmx_stu;
select * from fmx_peixun;
select * from stu_program;
select * from stu_report1;
select * from stu_report2;
select * from stu_report3;

create table fmx_user(
   id int primary key auto_increment,
   username char(30) unique NOT NULL,
   pwd char(20) NOT NULL,
   pwd1 char(20),
   sname char(10),
   tname char(10),
   usergroup int(10) NOT NULL
);

create table fmx_stu(
   id int primary key auto_increment,
   username char(30) unique NOT NULL,
   sname char(20), 
   sage int(20),
   sclass char(20),
   pwd char(20) NOT NULL,
   sgender char(1),
   usergroup int(10) NOT NULL
);

create table fmx_tea(
   id int primary key auto_increment,
   username char(30) unique NOT NULL,
   tname char(20),
   tage int(20),
   pwd char(20) NOT NULL,
   tgender char(1),
   tschool char(20),
   usergroup int(10) NOT NULL
);

create table fmx_peixun(
   id int primary key auto_increment,
   username char(30) unique NOT NULL,
   name char(20) NOT NULL,
   age int(20),
   gender char(1),
   institution char(20),
   category char(20),
   time char(20),
   usergroup int(10) NOT NULL
);

create table stu_program(
   id int primary key auto_increment,
   username char(30) unique,
   sname char(20),
   title char(30) NOT NULL,
   guidetea char(20) NOT NULL,
   need varchar(500) NOT NULL,
   content varchar(800),
   resulttea char(10),
   resultadm char(10),
   prostate char(10),
   finish char(10),
   finishtime char(20),
   applytime char(20)
);
ALTER TABLE stu_program ALTER finish SET DEFAULT 'δ���';
ALTER TABLE stu_program ALTER resulttea SET DEFAULT '�����';
ALTER TABLE stu_program ALTER resultadm SET DEFAULT '�����';
ALTER TABLE stu_program ALTER prostate SET DEFAULT 'δ����';

create table stu_report1(
   id int primary key auto_increment,
   username char(30) unique NOT NULL,
   sname char(20) NOT NULL,
   title char(30) NOT NULL,
   guidetea char(20) NOT NULL,
   progress varchar(300),
   gain varchar(500),
   result char(30)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE stu_report1 ALTER result SET DEFAULT '�����';

create table stu_report2(
   id int primary key auto_increment,
   username char(30) unique NOT NULL,
   sname char(20) NOT NULL,
   title char(30) NOT NULL,
   guidetea char(20) NOT NULL,
   progress varchar(300),
   gain varchar(500),
   result char(30)
);
ALTER TABLE stu_report2 ALTER result SET DEFAULT '�����';

create table stu_report3(
   id int primary key auto_increment,
   username char(30) unique NOT NULL,
   sname char(20) NOT NULL,
   title char(30) NOT NULL,
   guidetea char(20) NOT NULL,
   progress varchar(300),
   gain varchar(500),
   result char(30)
);
ALTER TABLE stu_report3 ALTER result SET DEFAULT '�����';

insert into fmx_user(username,pwd,usergroup) values('admin','123456',1);

/*
update user set password='' where user='root';
desc tables; ��ʾ��ṹ
select * from table limit X,Y;  
unique�ɿգ�������һ�������һ�������ֶζ���;
primary key���ɿղ����ظ�����һ��������Զ�����������;
rimary key = unique + not null
update table set A='X' where Y='Z';
order by desc/asc
**/