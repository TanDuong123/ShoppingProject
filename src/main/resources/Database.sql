create database Java5
go
use Java5
go

INSERT into categories values 
('C001',N'Quần áo nam'),
('C002',N'Giày dép'),
('C003',N'Phụ kiện'),
('C004',N'Quần áo trẻ em'),
('C005',N'Quần áo nữ');

INSERT into products ( product_id,name, image, quantity,category_id, size, color, price, available, decription) values 
('P001',N'Áo Thun Under Broken12','https://picsum.photos/200/300','100','C001','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P002',N'Áo Thun Under Broken2','https://picsum.photos/200/300','100','C001','38',N'Hồng','1200',1,N'Lorem ipsum is placeholder text commonly used in the graphic, print, and'),
('P003',N'Áo Thun Under Broken3','https://picsum.photos/200/300','100','C001','38',N'Tím','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P004',N'Áo Thun Under Broken4','https://picsum.photos/200/300','100','C001','38',N'Xanh lá','1200',1,N'Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.'),
('P005',N'Áo Thun Under Broken5','https://picsum.photos/200/300','100','C001','38',N'Hồng','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),

('P006',N'Mắt kính so 1 vũ trụ','https://picsum.photos/200/300','100','C003','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P007',N'Mũ lưỡi trai đính đá lộng lẫy','https://picsum.photos/200/300','100','C003','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P008',N'Túi LV 1 tỉ mốt','https://picsum.photos/200/300','100','C003','38',N'Xanh lá','1200',1,N'From its medieval origins to the digital era, learn everything there is to know about the ubiquitous lorem ipsum passage.'),
('P009',N'Vòng tay phong thủy hiệu Tinh Lâm','https://picsum.photos/200/300','100','C003','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P010',N'Pin con ó','https://picsum.photos/200/300','100','C003','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P011',N'Thắt lưng da cá sấu thật','https://picsum.photos/200/300','100','C003','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),

('P012',N'Giày nike','https://picsum.photos/200/300','100','C002','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P013',N'Giày adidas','https://picsum.photos/200/300','100','C002','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P014',N'Giày thượng đình HIEUTHUHAI','https://picsum.photos/200/300','100','C002','38',N'Xanh lá','1200',1,N'From its medieval origins to the digital era, learn everything there is to know about the ubiquitous lorem ipsum passage.'),
('P015',N'Dép CROSS','https://picsum.photos/200/300','100','C002','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P016',N'Giày  quai hậu học sinh','https://picsum.photos/200/300','100','C002','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),

('P017',N'Đầm dự tiệc','https://picsum.photos/200/300','100','C004','38',N'Xanh lá','1200',1,N'The purpose of lorem ipsum is to create a natural looking block of text (sentence, paragraph, page, etc.) that does not distract from the layout.'),
('P018',N'Áo bèo bèo','https://picsum.photos/200/300','100','C004','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P019',N'Áo mưa cánh dơi','https://picsum.photos/200/300','100','C004','38',N'Xanh lá','1200',1,N'From its medieval origins to the digital era, learn everything there is to know about the ubiquitous lorem ipsum passage.'),
('P020',N'Áo Thun Under Broken nữ','https://picsum.photos/200/300','100','C004','38',N'Xanh lá','1200',1,N'Áo Thun Under Broken Nhiều Màu Xanh Lá Vải Cotton Thời Trang Nam Nữ Ulzzang Unisex ldshoptato'),
('P021',N'Áo Thun Under Broken unnisex','https://picsum.photos/200/300','100','C004','38',N'Xanh lá','1200',1,N'From its medieval origins to the digital era, learn everything there is to know about the ubiquitous lorem ipsum passage.');

insert into users(user_name,password,activated,role,image,name,email,address,phone,zip_code,intimately) values
('tanduong','tan123',1,1,'',N'Dương Nhựt Tân','tanduong969@gmail.com',N'Quận Tân Bình','0977487711','',''),
('thanhtu','tu123',1,0,'',N'Ung Thanh Tú','thanhtu969@gmail.com',N'Quận Tân Bình','0977487712','','Silver'),
('vantu','vtu123',1,0,'',N'Tô Vận Tú','vantu@gmail.com',N'Quận Tân Bình','0977487713','','Gold'),
('phuongnga','nga123',1,0,'',N'Hồ Thị Phương Nga','phuongnga@gmail.com',N'Quận Tân Bình','0977487714','','Diamond'),
('truongan','an123',1,1,'',N'Nguyễn Trường An','truongan@gmail.com',N'Quận Tân Bình','0977487715','','')

INSERT into bills values 
('tanduong'),
('phuongnga'),
('thanhtu'),
('vantu'),
('truongan')



insert into bill_details values
(1,'P001',2,N'123 To Ky quan 12','05-12-2023',1),
(2,'P003',3,N'1 Tô ký Quận 12','05-15-2023',1),
(2,'P002',2,N'1 Tô ký Quận 12','05-15-2023',1),
(3,'P010',1,N'12 Tô ký Quận 12','05-14-2023',1),
(4,'P011',1,N'144 Tô ký Quận 12','05-15-2023',1),
(4,'P012',1,N'144 Tô ký Quận 12','05-15-2023',1),
(5,'P017',1,N'1 Trường chinh Quận 12','05-15-2023',1),
(6,'P013',3,N'1 Đông bắc Quận 12','05-19-2023',1),
(6,'P021',1,N'1 Đông bắc Quận 12','05-19-2023',1),
(7,'P018',2,N'19 Tô ký Quận 12','05-15-2023',1),
(7,'P015',2,N'19 Tô ký Quận 12','05-15-2023',1),
(7,'P003',1,N'19 Tô ký Quận 12','05-15-2023',1),
(8,'P009',1,N'11 Tô ký Quận 12','05-15-2023',1),
(8,'P013',1,N'11 Tô ký Quận 12','05-15-2023',1),
(8,'P020',1,N'11 Tô ký Quận 12','05-15-2023',1),
(8,'P016',1,'11 Tô ký Quận 12','05-15-2023',1);
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


insert into BillDetails (BillId, ProductId, Quantity, [Address], CreateDate, [State]) values
('B001','P001',2,N'123 To Ky quan 12','05-12-2023',1),
('B002','P003',3,N'1 Tô ký Quận 12','05-15-2023',1),
('B002','P002',2,N'1 Tô ký Quận 12','05-15-2023',1),
('B003','P010',1,N'12 Tô ký Quận 12','05-14-2023',1),
('B004','P011',1,N'144 Tô ký Quận 12','05-15-2023',1),
('B004','P012',1,N'144 Tô ký Quận 12','05-15-2023',1),
('B005','P017',1,N'1 Trường chinh Quận 12','05-15-2023',1),
('B006','P013',3,N'1 Đông bắc Quận 12','05-19-2023',1),
('B006','P021',1,N'1 Đông bắc Quận 12','05-19-2023',1),
('B007','P018',2,N'19 Tô ký Quận 12','05-15-2023',1),
('B007','P015',2,N'19 Tô ký Quận 12','05-15-2023',1),
('B007','P003',1,N'19 Tô ký Quận 12','05-15-2023',1),
('B008','P009',1,N'11 Tô ký Quận 12','05-15-2023',1),
('B008','P013',1,N'11 Tô ký Quận 12','05-15-2023',1),
('B008','P020',1,N'11 Tô ký Quận 12','05-15-2023',1),
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

delete from bill_details;
delete from bills;
delete from products;
delete from categories;
delete from users;
use Java5Lab
insert into accounts
values
('tanduong11',1,0,'tanduong969@gmail.com','Duyem Muy','123','product-1.jpg'),
('tanduong1',1,1,'tanduong969@gmail.com','Duyem Muy','123','product-2.jpg'),
('tanduong2',0,0,'tanduong969@gmail.com','Duyem Muy','123','product-3.jpg'),
('tanduong3',1,1,'tanduong969@gmail.com','Duyem Muy','123','product-4.jpg'),
('tanduong4',0,1,'tanduong969@gmail.com','Duyem Muy','123','product-5.jpg'),
('tanduong5',0,1,'tanduong969@gmail.com','Duyem Muy','123','product-6.jpg'),
('tanduong6',1,0,'tanduong969@gmail.com','Duyem Muy','123','product-7.jpg')

use Java5Lab
insert into departments
values('FPT'),
('ACB'),
('BCM'),
('CTG'),
('GVR'),
('MBB')

insert into employes(last_name,first_name,salary,phone_number,email,id)
values('Duong','Tan',12000,'090909009','tanduong969@gmail.com',1),
('Duong','Tan1',12000,'090909009','tanduong969@gmail.com',2),
('Duong','Tan2',12000,'090909009','tanduong969@gmail.com',3),
('Duong','Tan3',12000,'090909009','tanduong969@gmail.com',4),
('Duong','Tan4',12000,'090909009','tanduong969@gmail.com',5),
('Duong','Tan5',12000,'090909009','tanduong969@gmail.com',1),
('Duong','Tan6',12000,'090909009','tanduong969@gmail.com',2)

use Java5Lab

drop table report