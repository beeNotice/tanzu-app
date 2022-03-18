CREATE TABLE IF NOT EXISTS choice (
id bigint not null, 
name varchar(255), 
url varchar(255), 
primary key (id));

CREATE TABLE IF NOT EXISTS hello (
id bigint not null, 
a_id bigint, 
b_id bigint, 
primary key (id), 
constraint fk_hello_choice_a foreign key (a_id) references choice, 
constraint fk_hello_choice_b foreign key (b_id) references choice);