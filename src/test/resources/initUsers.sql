INSERT INTO users
(id, archive, email, name, password, role, activate_code)
VALUES (1, false, 'petr@mail.ru', 'petr', 'pass', 'CLIENT', NULL);

INSERT INTO users
(id, archive, email, name, password, role, activate_code)
VALUES (2, false, 'tom@mail.ru', 'tom', 'pass', 'MANAGER', NULL);

INSERT INTO users
(id, archive, email, name, password, role, activate_code)
VALUES (3, false, 'admin@mail.ru', 'admin', 'adminpass', 'ADMIN', NULL);

ALTER SEQUENCE user_seq RESTART WITH 4;