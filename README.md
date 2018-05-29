# Programming-Assignment

MYSQL = DATABASE

-----------------------------------------------------------------------------

create database CollegeDatabase;

use CollegeDatabase;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


Create table branch (
branchId int (4) not null primary key AUTO_INCREMENT,
branchNAme varchar (20) not null,
branchAddress varchar (40) not null

)ENGINE=InnoDB DEFAULT CHARSET=utf8;


Create table courses (
courseId int (4) not null primary key AUTO_INCREMENT,
courseName varchar (20) not null,
courseBranchIdFK int (4) not null,
foreign key (courseBranchIdFK) references branch (branchId) on update cascade

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

Create table student (
studentId int (4) not null primary key AUTO_INCREMENT,
studentName varchar (40) not null,
studentAddress varchar (40) not null,
studentPhone int (13) not null,
studentEmail varchar (40) not null,
courseIdFK int (4) not null,
StudentNation varchar (40) not null,
foreign key (courseIdFK) references courses (courseId) on update cascade

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table faculty (
facultyId int (4) not null primary key AUTO_INCREMENT,
facultyName varchar (40) not null,
facultyAdress varchar (40) not null,
facultyPhone int (13) not null,
facultyEmail varchar (40) not null

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table login (
id int (4) not null primary key,
pass varchar (8) not null

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

insert into login values ('0001','123456');

insert into branch values ('0001','College1','First St 1 ');
insert into branch values ('0002','College2','Second st 2');
insert into branch values ('0003','College3','Zero st 0');


insert into courses values ('0010', 'IT', '0001');
insert into courses values ('0011','TV','0002');
insert into courses values ('0012','radio','0003');
insert into courses values ('0015','cinema','0001');
insert into courses values ('0014','PP','0003');

insert into student values ('1234','Victor Emo','1 Henry st','083123456','victoremo@hotmail.com','0010','Brazilian');
insert into student values ('1235','Dih Emo','1 John st','083122456','dihemo@gmail.com','0015','Japanese');
insert into student values ('1236','Bernardo GG','22 Bad  st','083124586','bernardogg@hotmail.com','0011','Chinise');
insert into student values ('1237','Felipe Bahia','2 Henry st','0834443456','felipeamabahia@hotmail.com','0012','Italian');
insert into student values ('1238','Paulo Diferentao','1 Peter st','083128656','paulodiferentao@gmail.com','0014','Italian');
insert into student values ('1239','Matheus Presidiario','1 Presidio st','089923456','matheuspresidiario@hotmail.com','0012','Irish');
insert into student values ('0171','Lula Papai','1 Presidio st','0831111456','lulapt@hotmail.com','0015','Polish');
insert into student values ('1222','Dilma Mae','1 Vento st','01713456','dilmapthotmail.com','0010','Brazilian');
insert into student values ('1211','Lala Silva','1 Lolo st','083555556','lala@hotmail.com','0011', 'American');
insert into student values ('1255','Bob Bob','1 Music st','083223456','bob@hotmail.com','0014','Italian');
insert into student values ('1252','Last Name','1 Last st','083123422','last@hotmail.com','0015','Irish');

insert into faculty values ('0012','John Paul','2 haha st','083123456','jownpaul@gmail.com');
insert into faculty values ('0013','Peter Bred','2 hehe st','083123456','peter@gmail.com');
insert into faculty values ('0014','Mary Lili','2 hoho st','083123456','mary@gmail.com');
insert into faculty values ('0015','Sarah Lops','2 papa st','083123456','sarah@gmail.com');
insert into faculty values ('0016','Laura Mendez','2 tata st','083123456','laura@gmail.com');
