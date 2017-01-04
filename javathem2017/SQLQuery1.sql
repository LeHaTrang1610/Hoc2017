select * from student;

create proc getStudent
as 
begin
	select * from student;
end
exec getStudent;

create proc getSome
as
begin
	select mssv,hoten,lop from student
end

exec getSome


create proc findStudent
(
	@mssv varchar(10)
)
as
begin 
	select hoten from student
	where @mssv = mssv;
end

exec findStudent 'SV101'


create proc insertStudent
(
	@mssv varchar(10),
	@hoten varchar(20),
	@ngaysinh datetime,
	@lop varchar(5),
	@gioitinh char(1)	
)
as
begin 
	insert student(mssv,hoten,ngaysinh,lop,gioitinh)
	Values(@mssv,@hoten,@ngaysinh,@lop,@gioitinh)
end

exec insertStudent 'SV111','phan anh','2016-08-9','k20','n';


alter proc updateStudent
(
	@mssv varchar(10),
	@hoten varchar(20)
)
as
begin 
	update student
	set hoten = @hoten
	where @mssv = mssv;
end

exec updateStudent 't20','Nguyen Sieu Nhan'
select*from student;

create proc deleteStudent
(
	@mssv varchar(10)
)
as
begin 
	delete from student
	where @mssv = mssv;
end

exec deleteStudent 't109'

select * from student;