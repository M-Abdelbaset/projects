insert into user(id, name, birth_date) values(1, 'one', sysdate());
insert into user(id, name, birth_date) values(2, 'two', sysdate());
insert into user(id, name, birth_date) values(3, 'three', sysdate());

insert into post(id, message, user_id) values(1, 'post one', 1);
insert into post(id, message, user_id) values(2, 'post two', 1);
insert into post(id, message, user_id) values(3, 'post three', 1);
