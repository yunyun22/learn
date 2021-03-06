CREATE database school;
use school;
ALTER DATABASE school CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


alter table students convert to character set utf8mb4 collate utf8mb4_bin; 
alter table courses convert to character set utf8mb4 collate utf8mb4_bin; 
alter table scores convert to character set utf8mb4 collate utf8mb4_bin; 
alter table teachers convert to character set utf8mb4 collate utf8mb4_bin; 


CREATE TABLE students
(sno VARCHAR(3) NOT NULL, 
sname VARCHAR(4) NOT NULL,
ssex VARCHAR(2) NOT NULL, 
sbirthday DATETIME,
class VARCHAR(5));

CREATE TABLE courses
(cno VARCHAR(5) NOT NULL, 
cname VARCHAR(10) NOT NULL, 
tno VARCHAR(10) NOT NULL);

CREATE TABLE scores 
(sno VARCHAR(3) NOT NULL, 
cno VARCHAR(5) NOT NULL, 
degree NUMERIC(10, 1) NOT NULL) ;

CREATE TABLE teachers 
(tno VARCHAR(3) NOT NULL, 
tname VARCHAR(4) NOT NULL, tsex VARCHAR(2) NOT NULL, 
tbirthday DATETIME NOT NULL, prof VARCHAR(6), 
depart VARCHAR(10) NOT NULL);

INSERT INTO STUDENTS (SNO,SNAME,SSEX,SBIRTHDAY,CLASS) VALUES (108 ,'曾华' ,'男' ,'1977-09-01',95033);
INSERT INTO STUDENTS (SNO,SNAME,SSEX,SBIRTHDAY,CLASS) VALUES (105 ,'匡明' ,'男' ,'1975-10-02',95031);
INSERT INTO STUDENTS (SNO,SNAME,SSEX,SBIRTHDAY,CLASS) VALUES (107 ,'王丽' ,'女' ,'1976-01-23',95033);
INSERT INTO STUDENTS (SNO,SNAME,SSEX,SBIRTHDAY,CLASS) VALUES (101 ,'李军' ,'男' ,'1976-02-20',95033);
INSERT INTO STUDENTS (SNO,SNAME,SSEX,SBIRTHDAY,CLASS) VALUES (109 ,'王芳' ,'女' ,'1975-02-10',95031);
INSERT INTO STUDENTS (SNO,SNAME,SSEX,SBIRTHDAY,CLASS) VALUES (103 ,'陆君' ,'男' ,'1974-06-03',95031);

INSERT INTO COURSES(CNO,CNAME,TNO)VALUES ('3-105' ,'计算机导论',825);
INSERT INTO COURSES(CNO,CNAME,TNO)VALUES ('3-245' ,'操作系统' ,804);
INSERT INTO COURSES(CNO,CNAME,TNO)VALUES ('6-166' ,'数据电路' ,856);
INSERT INTO COURSES(CNO,CNAME,TNO)VALUES ('9-888' ,'高等数学' ,100);

INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (103,'3-245',86);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (105,'3-245',75);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (109,'3-245',68);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (103,'3-105',92);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (105,'3-105',88);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (109,'3-105',76);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (101,'3-105',64);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (107,'3-105',91);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (108,'3-105',78);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (101,'6-166',85);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (107,'6-106',79);
INSERT INTO SCORES(SNO,CNO,DEGREE)VALUES (108,'6-166',81);

INSERT INTO TEACHERS(TNO,TNAME,TSEX,TBIRTHDAY,PROF,DEPART) VALUES (804,'李诚','男','1958-12-02','副教授','计算机系');
INSERT INTO TEACHERS(TNO,TNAME,TSEX,TBIRTHDAY,PROF,DEPART) VALUES (856,'张旭','男','1969-03-12','讲师','电子工程系');
INSERT INTO TEACHERS(TNO,TNAME,TSEX,TBIRTHDAY,PROF,DEPART) VALUES (825,'王萍','女','1972-05-05','助教','计算机系');
INSERT INTO TEACHERS(TNO,TNAME,TSEX,TBIRTHDAY,PROF,DEPART) VALUES (831,'刘冰','女','1977-08-14','助教','电子工程系');

--1、 查询Student表中的所有记录的Sname、Ssex和Class列。
select *from students;
--2、 查询教师所有的单位即不重复的Depart列。
select distinct depart from teachers;
--3、 查询Student表的所有记录。
select *from students;
--4、 查询Score表中成绩在60到80之间的所有记录。
select * from scores where degree between 60 and 80;
--5、 查询Score表中成绩为85，86或88的记录。
select * from scores where degree in  (85,86,88);
--6、 查询Student表中“95031”班或性别为“女”的同学记录。
select *from students where class=95031 and ssex='女';
--7、 以Class降序查询Student表的所有记录。
select * from students order by class DESC;
--8、 以Cno升序、Degree降序查询Score表的所有记录。
select * from scores order by cno ASC,degree DESC;
--9、 查询“95031”班的学生人数。
select count(*) from students where class=95031;
--10、查询Score表中的最高分的学生学号和课程号。
select * from scores where degree = (select max(degree) from scores);
--11、查询‘3-105’号课程的平均分。
select avg(degree) from scores where cno='3-105';
--12、查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。
--原始
select avg(degree) from scores where cno=(select cno from scores where cno like '3%' group by cno having count(cno)>5);
select avg(degree),cno  from scores where cno like '3%' group by cno having count(cno)>5;
--13、查询最低分大于70，最高分小于90的Sno列。
select sno from scores group by sno having min(degree)>70 and max(degree)<90;
--14、查询所有学生的Sname、Cno和Degree列。
select * from students;
select * from scores;
select * from students natural left outer join scores
select * from courses;
select student.sname,sco.cno,sco.degree  from students student,scores sco  where student.sno= sco.sno;
--15、查询所有学生的Sno、Cname和Degree列。
select sco.sno,cou.cname,sco.degree from scores sco,courses cou where sco.cno=cou.cno;
--16、查询所有学生的Sname、Cname和Degree列。
select stu.sname,cou.cname,sco.degree from students stu,scores sco,courses cou where stu.sno=sco.sno and sco.cno=cou.cno;
--17、查询“95033”班所选课程的平均分。
--18、假设使用如下命令建立了一个grade表：
drop table grade;
create table grade(low TINYINT,upp TINYINT,rank char(1));
insert into grade(low,upp,rank) values(90,100,"A");
insert into grade values(80,89,"B");
insert into grade values(70,79,"C");
insert into grade values(60,69,"D");
insert into grade values(0,59,"E");
commit;
--现查询所有同学的Sno、Cno和rank列。   内关联，两个表能确定位唯一记录
select * from scores sco,grade gra where sco.degree>=gra.low and sco.degree<=gra.upp; 
--19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
select * from scores where cno='3-105' and degree> (select degree from scores where cno='3-105' and sno='109');
--20、查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。
select * from scores where sno in(select sno from scores group by sno having count(sno)>1) and degree<(select max(degree) from scores);
--21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
select *from  scores where degree>(select degree from scores where sno=109 and cno='3-105');
--22、查询和学号为108的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
select * from  students where  YEAR(sbirthday) =(select distinct YEAR(sbirthday)  from students where sno=108);
--23、查询“张旭“教师任课的学生成绩。
select *from scores s,courses c,teachers t where s.cno=c.cno and c.tno=t.tno and tname='张旭';
--24、查询选修某课程的同学人数多于5人的教师姓名。
select * from teachers t,scores s,courses c where t.tno=c.tno and s.cno=c.cno and c.cno = ( select cno from scores group by cno having count(cno)>5);
--25、查询95033班和95031班全体学生的记录。
select * from students where class=95033 or class=95031;
--26、查询存在有85分以上成绩的课程Cno.
select distinct cno from scores where degree>=85;
--27、查询出“计算机系“教师所教课程的成绩表
select * from  scores s,teachers t,courses c where s.cno=c.cno and c.tno=t.tno and depart='计算机系';
--28、查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。
select tname,prof from teachers where depart='计算机系'  and prof not in(select prof from teachers where depart='电子工程系') 
union select tname,prof from teachers where depart='电子工程系'  and prof not in(select prof from teachers where depart='计算机系')
--29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。
select * from  scores where degree>(select min(degree) from scores where cno='3-245') and cno='3-105' order by degree DESC
select * from scores where cno='3-105' and degree>any(select degree from scores where cno='3-245')
--30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno、Sno和Degree.
select * from scores where cno='3-105' and degree>all(select degree from scores where cno='3-245')
select * from  scores where degree>(select max(degree) from scores where cno='3-245') and cno='3-105' order by degree DESC
--31、查询所有教师和同学的name、sex和birthday.
select * from teachers
select *from students
(select tname as name,tsex as sex,tbirthday as birthday,'老师' as shenfen from teachers) union (select sname as name ,ssex as sex,sbirthday as birthday,'学生' as shenfen from students)
--32、查询所有“女”教师和“女”同学的name、sex和birthday.
(select tname as name,tsex as sex,tbirthday as birthday,'老师' as shenfen from teachers where tsex='女') 
union (select sname as name ,ssex as sex,sbirthday as birthday,'学生' as shenfen from students where ssex='女');
--33、查询成绩比该课程平均成绩低的同学的成绩表。
select *from scores s1,(select cno,avg(degree) as avgdegree from scores group by cno) s2 where s1.cno=s2.cno and degree<avgdegree
select * from scores a where degree<(select avg(degree) from scores b where b.cno =a.cno )
--34、查询所有任课教师的Tname和Depart.
select * from teachers where tno  in(select tno from courses )
select *,tname  from teachers
--35  查询所有未讲课的教师的Tname和Depart. 
select *from courses
select * from teachers where tno not in(select tno from courses )
--36、查询至少有2名男生的班号。
select sno from students where ssex='男' group by sno having count(ssex)>=2
--37、查询Student表中不姓“王”的同学记录。
select * from students where sno not in(select sno from students where sname like '王%')
--38、查询Student表中每个学生的姓名和年龄。
--39、查询Student表中最大和最小的Sbirthday日期值。
select max(sbirthday),min(sbirthday) from students
--40、以班号和年龄从大到小的顺序查询Student表中的全部记录。
select *from students order by sno,sbirthday
--41、查询“男”教师及其所上的课程。
select *from teachers
--42、查询最高分同学的Sno、Cno和Degree列。
select max(degree) from scores s
select * from scores
--43、查询和“李军”同性别的所有同学的Sname.
select * from students where ssex = (select ssex from students where sname='李军')
--44、查询和“李军”同性别并同班的同学Sname.
select * from students  s,(select * from students where sname='李军') s1 where s.ssex=s1.ssex and s.class=s1.class
--45、查询所有选修“计算机导论”课程的“男”同学的成绩表
select * from students s1,scores s2,courses c where s1.sno=s2.sno and s2.cno=c.cno and c.cname='计算机导论' and s1.ssex='男'






