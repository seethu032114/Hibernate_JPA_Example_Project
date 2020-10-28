insert into course(id,name) values (1001, 'JPA in 100 steps');
insert into course(id,name) values (1002, 'Java in 100 steps');
insert into course(id,name) values (1003, 'Springboot in 100 steps');
insert into course(id,name) values (1004, 'Spring in 100 steps');


insert into passport(id,number) values (3001,'E1234');
insert into passport(id,number) values (3002,'E1235');
insert into passport(id,number) values (3003,'E1236');


insert into student(id,name,passport_id) values (2001, 'Alex',3001);
insert into student(id,name,passport_id) values (2002, 'Eoin',3002);
insert into student(id,name,passport_id) values (2003, 'Ben',3003);



insert into review(id,rating,description,course_id) values (4001,'5','Excellent',1001);
insert into review(id,rating,description,course_id) values (4002,'4','Good',1001);
insert into review(id,rating,description,course_id) values (4003,'5','Excellent',1002);


insert into student_course(student_id, course_id) values (2001,1001);
insert into student_course(student_id, course_id) values (2002,1001);
insert into student_course(student_id, course_id) values (2001,1002);
insert into student_course(student_id, course_id) values (2002,1001);