create database Java5
go
use Java5
go
create table Categories
(
 CategoryId varchar(10) primary key,
 Name nvarchar(50)
)
create table Products
(
	ProductId varchar(10) primary key,
	Name nvarchar(50) not null,
	Image nvarchar(200) not null,
	Quantity int not null,
	CategoryId varchar(10) not null,
	Size int not null,
	Color nvarchar(50),
	Price float not null,
	Available bit not null,
	Decription nvarchar(200)
	foreign key (CategoryId) references Categories(CategoryId)
)
go
create table Users
(
	UserId varchar(10) primary key,
	Password varchar(50) not null,
	Role bit not null,
	Image nvarchar(200),
	Name nvarchar(100) not null,
	Email varchar(100),
	Address nvarchar(200) not null,
	Phone varchar(20) not null,
	ZipCode varchar(10) not null,
	Intimately nvarchar(20)
)
go
create table Bills
(
	BillId varchar(10) primary key,
	UserId varchar(10) not null,
	foreign key (UserId) references Users(UserId)
)
go
create table BillDetails
(
	BillDetailId int primary key identity,
	BillId varchar(10) not null,
	ProductId varchar(10) not null,
	Quantity int not null,
	Address nvarchar(200),
	CreateDate datetime not null,
	State bit,
	foreign key (ProductId) references Products(ProductId),
	foreign key (BillId) references Bills(BillId)
)
create table Carts
(
	CartId varchar(10) primary key,
	ProductId varchar(10) not null,
	UserId varchar(10) not null,
	Quantity int not null,
	SaveDate datetime not null,
	foreign key (ProductId) references Products(ProductId),
	foreign key (UserId) references Users(UserId)
)

use Java5
drop table Carts
drop table BillDetails
drop table Bills
drop table Products
drop table Users
drop table Categories