create database escuela;
use escuela;
create user 'yo'@'localhost' identified by '123456789';
create user 'yo'@'127.0.0.1' identified by '123456789';
grant all privileges on escuela.* to 'yo'@'localhost';
grant all privileges on escuela.* to 'yo'@'127.0.0.1';
flush privileges;