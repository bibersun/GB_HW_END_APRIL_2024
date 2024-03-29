-- не вижу смысла разделять на две одинаковые по структуре таблицы. И вообще немного дополнил/изменил требования, так более логично, как мне кажется
-- так как схема классов предельна проста, то воспользовался стандартной фичей SQL Workbench
CREATE DATABASE IF NOT EXISTS Human_Friends;
USE Human_Friends;

DROP TABLE IF EXISTS animal_friend, animal_type, animal, a_command, animal_command;
CREATE TABLE animal_friend
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(45)
    );        

INSERT INTO animal_friend (name)
VALUES
	("Pets"), 
	("Pack_animals");    

SELECT * FROM animal_friend;

CREATE TABLE animal_type
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(45),
    animal_friend_id INT
    );    
    
ALTER TABLE animal_type 
ADD CONSTRAINT fk_animal_type FOREIGN KEY (animal_friend_id) REFERENCES animal_friend(id);    
    
INSERT INTO animal_type(name, animal_friend_id)
VALUES
	('Dog', 1),
    ('Cat', 1),
    ('Hamster', 1),
    ('Horse', 2),
    ('Camel', 2),
    ('Donkey', 2);
    
SELECT * FROM animal_type;

CREATE TABLE animal
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(45),
    type_id INT,
    birth_date DATE
    );
    
ALTER TABLE animal 
ADD CONSTRAINT fk_animal FOREIGN KEY (type_id) REFERENCES animal_type(id);

INSERT INTO animal(name, type_id, birth_date)
VALUES 
	('Fido', 1, '2020-01-01'),
    ('Whiskers', 2, '2019-05-15'),
    ('Hammy', 3, '2021-03-10'),
    ('Buddy', 1, '2018-12-10'),
    ('Smudge', 2, '2020-02-20'),
    ('Peanut', 3, '2021-08-01'),
    ('Bella', 1, '2019-11-11'),
    ('Oliver', 1, '2020-06-30'),
    ('Thunder', 4, '2015-07-21'),
    ('Sandy', 5, '2016-11-03'),
    ('Eeyore', 6, '2017-09-18'),
    ('Storm', 4, '2014-05-05'),
    ('Dune', 5, '2018-12-12'),
    ('Burro', 6, '2019-01-23'),
    ('Blaze', 4, '2016-02-29'),
    ('Sahara', 5, '2015-08-14');
    
SELECT * FROM animal;    

CREATE TABLE a_command
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(45)
    );        

INSERT INTO a_command (name)
VALUES
	("Sit"), 
	("Pounce"),
    ("Scratch"),
    ("Roll"),
    ("Spin"),
    ("Stay"),
    ("Meow"),
    ("Jump"),
    ("Trot"),
    ("Canter"),
    ("Gallop"),
    ("Walk"),
    ("Carry Load"),
    ("Bray"),
    ("Kick"),
    ("Run"),
    ("Fetch"),
    ("Hide"), 
    ("Paw"),
    ("Bark")
    ;    

SELECT * FROM a_command
ORDER BY name;

CREATE TABLE animal_command
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_id INT,
    a_command_id INT
    );        

ALTER TABLE animal_command 
ADD CONSTRAINT fk_animal_command_1 FOREIGN KEY (a_command_id) REFERENCES a_command(id);
ALTER TABLE animal_command 
ADD CONSTRAINT fk_animal_command_2 FOREIGN KEY (animal_id) REFERENCES animal(id);

INSERT INTO animal_command (animal_id, a_command_id)
VALUES
	(1, 1),
    (1, 6),
    (1, 17),
    (2, 1),
    (2, 2),
    (3, 4),
    (3, 18),
    (4, 1),
    (4, 19),
    (4, 20),
    (5, 1),
    (5, 2),
    (5, 3),
    (6, 4),
    (6, 5),
    (7, 1),
    (7, 6),
    (7, 4),
    (8, 7),
    (8, 3),
    (8, 8),
    (9, 9),
    (9, 10),
    (9, 11),
    (10, 12),
    (10, 13),
    (11, 12),
    (11, 13),
    (11, 14),
    (12, 9),
    (12, 10),
    (13, 12),
    (13, 1),
    (14, 12),
    (14, 14),
    (14, 15),
    (15, 9),
    (15, 8),
    (15, 11),
    (16, 12),
    (16, 16);

SELECT * FROM animal_command;

-- Единый запрос, всё собирающий, заодно как ответ на последний вопрос по SQL
SELECT a.name, a.birth_date, a_t.name as 'Type', a_f.name as 'Type_friends', GROUP_CONCAT(a_cm.name SEPARATOR ', ') as 'Command'
FROM animal a
JOIN animal_type a_t ON a.type_id = a_t.id
JOIN animal_friend a_f ON a_t.animal_friend_id = a_f.id
JOIN animal_command a_c ON a_c.animal_id = a.id
JOIN a_command a_cm ON a_cm.id = a_c.a_command_id
GROUP BY a.name, a.birth_date, a_t.name, a_f.name;

-- удалять - плохая практика, поэтому просто без верблюдов с объединением ослов и лошадей - то есть вьючные животные без верблюдов. При серьезном проектировании необходимо определить, на каком уровне убирать из зоны видимости - либо по типу животного, либо по самому животному
SELECT a.name, a.birth_date, GROUP_CONCAT(a_cm.name SEPARATOR ', ') as 'Command'
FROM animal a
JOIN animal_type a_t ON a.type_id = a_t.id
JOIN animal_friend a_f ON a_t.animal_friend_id = a_f.id
JOIN animal_command a_c ON a_c.animal_id = a.id
JOIN a_command a_cm ON a_cm.id = a_c.a_command_id
WHERE a_f.id = 2
	and a_t.id != 5
GROUP BY a.name, a.birth_date, a_t.name, a_f.name;

-- от 1 года до 3-х лет с выводом разницы с текущей датой в месяцах
SELECT a.name, a.birth_date, a_t.name as 'Type', a_f.name as 'Type_friends', TIMESTAMPDIFF(MONTH, a.birth_date, curdate()) as Delta_month, GROUP_CONCAT(a_cm.name SEPARATOR ', ') as 'Command'
FROM animal a
JOIN animal_type a_t ON a.type_id = a_t.id
JOIN animal_friend a_f ON a_t.animal_friend_id = a_f.id
JOIN animal_command a_c ON a_c.animal_id = a.id
JOIN a_command a_cm ON a_cm.id = a_c.a_command_id
WHERE TIMESTAMPDIFF(YEAR, a.birth_date, curdate()) BETWEEN 1 AND 3
GROUP BY a.name, a.birth_date, a_t.name, a_f.name, TIMESTAMPDIFF(MONTH, a.birth_date, curdate());


