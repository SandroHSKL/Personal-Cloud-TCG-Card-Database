-- Nutzer anlegen & Rechte vergeben
create user 'backend' identified with mysql_native_password by 'backend-pass';
grant select, insert, delete, update on kundenDB.* to 'backend';
