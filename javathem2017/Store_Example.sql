--store get all student
create proc getStudents
as
begin
	select * from SINHVIEN
end
exec getStudents

--store add new student
create proc addStudent
(
	@mssv varchar(10),
	@hoten varchar(20),
	@ngaysinh datetime,
	@lop varchar(5),
	@gioitinh char(1)
)
as
begin
	insert into SINHVIEN(MSSV, HOTEN, NGAYSINH, LOP, GIOITINH)
	values (@mssv, @hoten, @ngaysinh, @lop, @gioitinh)
end
exec addStudent 'SV020', 'TRUONG VO KY', '04-14-1990', 'DH001', 'M'

--store update student's info
create proc updateStudent
(
	@mssv varchar(10),
	@hoten varchar(20)
)
as
begin
	update SINHVIEN
	set HOTEN = @hoten
	where MSSV = @mssv
end
exec updateStudent 'SV021','DUONG TIEU'

--store delete student
create proc deleteStudent
(
	@mssv varchar(10)
)
as
begin
	delete SINHVIEN
	where MSSV = @mssv
end
exec deleteStudent 'SV021'

--store count total student
create proc countStudent
(
	@amount int output
)
as
begin
	select @amount = count(*)
	from SINHVIEN
end
declare @amount int 
exec countStudent @amount output
select @amount


select * from SINHVIEN