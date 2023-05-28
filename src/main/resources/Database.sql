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
	Activated bit not null,
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
	BillId varchar(10) primary key identity,
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
insert into Carts(CartId, ProductId, UserId, Quantity, SaveDate) values
('C001','P001','U001',1,'01-13-2023'),
('C002','P002','U002',4,'02-13-2023'),
('C003','P003','U003',1,'05-21-2023'),
('C004','P001','U004',1,'01-13-2023'),
('C005','P004','U001',2,'05-19-2023'),
('C006','P001','U005',1,'05-13-2023'),
('C007','P011','U003',1,'04-13-2023'),
('C008','P021','U004',1,'03-12-2023'),
('C009','P012','U006',1,'01-13-2023');

select * from Carts
INSERT [dbo].[Users] (UserId, [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U001', '123', 0, 'https://i.pravatar.cc/?img=2','An' ,'an9923@gmail.com', N'HCM', '0999831623','abcdf','aaa' );
INSERT [dbo].[Users] ([UserId], [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U002', '123', 1, 'https://i.pravatar.cc/?img=2','Tan' ,'tan3312@gmail.com', N'HCM', '0359831623','abadf','baa' );
INSERT [dbo].[Users] ([UserId], [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U003', '123', 1, 'https://i.pravatar.cc/?img=2','Nga' ,'nga262@gmail.com', N'HCM', '0988831623','aacdf','caa' );
INSERT [dbo].[Users] ([UserId], [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U004', '123', 0, 'https://i.pravatar.cc/?img=2','Nhan' ,'nhan923@gmail.com', N'HCM', '0912831623','cbcdf','ava' );
INSERT [dbo].[Users] ([UserId], [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U005', '123', 1, 'https://i.pravatar.cc/?img=2','Hoa' ,'Hoa123@gmail.com', N'HCM', '0912835223','fhgdc','vaa' );
INSERT [dbo].[Users] ([UserId], [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U006', '123', 0, 'https://i.pravatar.cc/?img=2','Dung' ,'Dung2211@gmail.com', N'HCM', '0989871623','vvvdf','iua' );
INSERT [dbo].[Users] ([UserId], [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U007', '123', 1, 'https://i.pravatar.cc/?img=2','Tai' ,'tai3311@gmail.com', N'HCM', '09213316233','abtdf','zxc' );
INSERT [dbo].[Users] ([UserId], [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U008', '123', 1, 'https://i.pravatar.cc/?img=2','Na' ,'na232@gmail.com', N'HCM', '0933811223','erddf','reaa' );
INSERT [dbo].[Users] ([UserId], [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U009', '123', 0, 'https://i.pravatar.cc/?img=2','Hung' ,'hung233@gmail.com', N'HCM', '0989331623','ahfdf','hha' );
INSERT [dbo].[Users] ([UserId], [Password], [Role], [Image], [Name], [Email], [Address], [Phone], [ZipCode],[Intimately]) VALUES ('U010', '123', 0, 'https://i.pravatar.cc/?img=2','Yen' ,'yen123@gmail.com', N'HCM', '0912383162','abdf','aaa' );

INSERT into Bills ( BillId,UserId) values 
('B001','U001'),
('B002','U002'),
('B003','U003'),
('B004','U004'),
('B005','U005'),
('B006','U006'),
('B007','U007'),
('B008','U008');

INSERT into categories values 
('C001','quần áo nam'),
('C002','Giày dép'),
('C003','Phụ kiện'),
('C004','Quần áo trẻ em'),
('C005','Quần áo nữ');


INSERT into products ( product_id, name, image, quantity,category_id, size, color, price, available, decription) values 
('P001','Áo Thun Under Broken12','https://picsum.photos/200/300','100','C001','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P002','Áo Thun Under Broken2','https://picsum.photos/200/300','100','C001','38','Hồng','1200',1,'Lorem ipsum is placeholder text commonly used in the graphic, print, and'),
('P003','Áo Thun Under Broken3','https://picsum.photos/200/300','100','C001','38','Tím','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P004','Áo Thun Under Broken4','https://picsum.photos/200/300','100','C001','38','Xanh lá','1200',1,'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.'),
('P005','Áo Thun Under Broken5','https://picsum.photos/200/300','100','C001','38','Hồng','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),

('P006','Mắt kính so 1 vũ trụ','https://picsum.photos/200/300','100','C003','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P007','Mũ lưỡi trai đính đá lộng lẫy','https://picsum.photos/200/300','100','C003','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P008','Túi LV 1 tỉ mốt','https://picsum.photos/200/300','100','C003','38','Xanh lá','1200',1,'From its medieval origins to the digital era, learn everything there is to know about the ubiquitous lorem ipsum passage.'),
('P009','Vòng tay phong thủy hiệu Tinh Lâm','https://picsum.photos/200/300','100','C003','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P010','Pin con ó','https://picsum.photos/200/300','100','C003','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P011','Thắt lưng da cá sấu thật','https://picsum.photos/200/300','100','C003','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),

('P012','Giày nike','https://picsum.photos/200/300','100','C002','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P013','Giày adidas','https://picsum.photos/200/300','100','C002','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P014','Giày thượng đình HIEUTHUHAI','https://picsum.photos/200/300','100','C002','38','Xanh lá','1200',1,'From its medieval origins to the digital era, learn everything there is to know about the ubiquitous lorem ipsum passage.'),
('P015','Dép CROSS','https://picsum.photos/200/300','100','C002','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P016','Giày  quai hậu học sinh','https://picsum.photos/200/300','100','C002','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),

('P017','Đầm dự tiệc','https://picsum.photos/200/300','100','C004','38','Xanh lá','1200',1,'The purpose of lorem ipsum is to create a natural looking block of text (sentence, paragraph, page, etc.) that does not distract from the layout.'),
('P018','Áo bèo bèo','https://picsum.photos/200/300','100','C004','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P019','Áo mưa cánh dơi','https://picsum.photos/200/300','100','C004','38','Xanh lá','1200',1,'From its medieval origins to the digital era, learn everything there is to know about the ubiquitous lorem ipsum passage.'),
('P020','Áo Thun Under Broken nữ','https://picsum.photos/200/300','100','C004','38','Xanh lá','1200',1,'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P021','Áo Thun Under Broken unnisex','https://picsum.photos/200/300','100','C004','38','Xanh lá','1200',1,'From its medieval origins to the digital era, learn everything there is to know about the ubiquitous lorem ipsum passage.');


insert into BillDetails (BillId, ProductId, Quantity, [Address], CreateDate, [State]) values
('B001','P001',2,'123 To Ky quan 12','05-12-2023',1),
('B002','P003',3,'1 Tô ký Quận 12','05-15-2023',1),
('B002','P002',2,'1 Tô ký Quận 12','05-15-2023',1),
('B003','P010',1,'12 Tô ký Quận 12','05-14-2023',1),
('B004','P011',1,'144 Tô ký Quận 12','05-15-2023',1),
('B004','P012',1,'144 Tô ký Quận 12','05-15-2023',1),
('B005','P017',1,'1 Trường chinh Quận 12','05-15-2023',1),
('B006','P013',3,'1 Đông bắc Quận 12','05-19-2023',1),
('B006','P021',1,'1 Đông bắc Quận 12','05-19-2023',1),
('B007','P018',2,'19 Tô ký Quận 12','05-15-2023',1),
('B007','P015',2,'19 Tô ký Quận 12','05-15-2023',1),
('B007','P003',1,'19 Tô ký Quận 12','05-15-2023',1),
('B008','P009',1,'11 Tô ký Quận 12','05-15-2023',1),
('B008','P013',1,'11 Tô ký Quận 12','05-15-2023',1),
('B008','P020',1,'11 Tô ký Quận 12','05-15-2023',1),
('B008','P016',1,'11 Tô ký Quận 12','05-15-2023',1);

use Java5
select *from BillDetails
drop table bill_details
create database Java5Lab

drop table bill_details
drop table bills
drop table products
drop table categories
drop table users
