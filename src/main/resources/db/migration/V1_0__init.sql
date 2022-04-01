DROP TABLE IF EXISTS hello;
DROP TABLE IF EXISTS choice;
DROP TABLE IF EXISTS config;

CREATE TABLE choice (id BIGINT not null, name VARCHAR(255), url VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE hello (id BIGINT not null, a_id BIGINT, b_id BIGINT, PRIMARY KEY (id));
CREATE TABLE config (name VARCHAR(255), val VARCHAR(255), PRIMARY KEY (name));

ALTER TABLE hello ADD CONSTRAINT fk_hello_choice_a FOREIGN KEY (a_id) REFERENCES choice;
ALTER TABLE hello ADD CONSTRAINT fk_hello_choice_b FOREIGN KEY (b_id) REFERENCES choice;

INSERT INTO choice(id, name, url) VALUES 
(1, 'Cat', '/images/cat.gif'),
(2, 'Dog', '/images/dog.gif'),
(3, 'Ski', '/images/ski.gif'),
(4, 'Snowboard', '/images/snowboard.gif'),
(5, 'Beach', '/images/beach.gif'),
(6, 'Mountain', '/images/mountain.gif');

INSERT INTO hello(id, a_id, b_id) VALUES 
(1, 1, 2),
(2, 3, 4),
(3, 5, 6);

INSERT INTO config(name, val) VALUES 
('ENV', 'DEV'),
('COLOR', '#669999');