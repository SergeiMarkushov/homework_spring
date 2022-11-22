DROP TABLE users IF EXISTS;
CREATE TABLE IF NOT EXISTS users (id bigserial, name VARCHAR(255),  PRIMARY KEY (id));
insert into users (name) values ('Bob'), ('Jon'),('Jack'),('Julia');

DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial primary key, title VARCHAR(255), cost integer, user_id bigint references users (id));
insert into products (title, cost, user_id) values ('Milk', 90, 1), ('Soda', 50, 1),('Carrot', 80, 1),('Energy drink', 99, 1),('Water', 30, 1), ('PC', 90000, 1), ('PS4', 50000, 2),('TV', 80000, 2),('Skateboard', 9900, 2),('Glasses', 3000, 2), ('Apple', 9,2), ('Cream', 100, 2),('Sigarets', 180,3),('Lighter', 59,3),('Alcohol', 3000,3), ('Cup', 90,3), ('Mouse', 500,4),('Keyboard', 8000, 4),('Phone', 99000, 4),('Clock', 3000, 4);