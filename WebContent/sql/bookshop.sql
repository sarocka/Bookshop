DROP SCHEMA IF EXISTS bookshop;
CREATE SCHEMA bookshop DEFAULT CHARACTER SET utf8;
USE bookshop;


CREATE TABLE books (
	id INT AUTO_INCREMENT,
    title VARCHAR(40) NOT NULL, 
    isbn INT UNIQUE NOT NULL,
    price DOUBLE NOT NULL, 
    cover VARCHAR(10) NOT NULL, 
    rating DOUBLE NOT NULL, 
    publisher VARCHAR(40) NOT NULL, 
    writer VARCHAR(20) NOT NULL,
    available_in_stock INT NOT NULL,
    sold INT,
   
    PRIMARY KEY (id)
);
CREATE TABLE users (
	id INT AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL, 
    password VARCHAR(20) NOT NULL,
   
    PRIMARY KEY (id)
);



CREATE TABLE wish (
	user_id INT,
	book_id INT,
	
	PRIMARY KEY(user_id, book_id),
	
	FOREIGN KEY (user_id) REFERENCES users(id),
		
	FOREIGN KEY (book_id) REFERENCES books(id)
		
); 

CREATE TABLE bought (
	user_id INT,
	book_id INT,
	
	PRIMARY KEY(user_id, book_id),
	
	FOREIGN KEY (user_id) REFERENCES users(id),
		
	FOREIGN KEY (book_id) REFERENCES books(id)
		
); 
INSERT INTO books (id, title, isbn, price, cover, rating, publisher, writer,available_in_stock) VALUES (1,"Flaubert's Parrot", 4589, 10.99,"hardcover",4.7,"Jonathan Cape","Julian Barnes",10);
INSERT INTO books (id, title, isbn, price, cover, rating, publisher, writer,available_in_stock) VALUES (2,"The Late Mattia Pascalt", 4689, 9.99,"paperback",4.6,"Oxford University Press","Luigi Pirandello" ,10);
INSERT INTO books (id, title, isbn, price, cover, rating, publisher, writer,available_in_stock) VALUES (3,"The Temple of the Gold Pavilion", 4587, 12.99,"hardcover",4.7,"Random House USA Inc","Yukio Mishima",10);
INSERT INTO bookshop.books (id, title, isbn, price, cover, rating, publisher, writer,available_in_stock) VALUES (4,"Migrations", 9589, 10.99,"hardcover",4.7,"Prosveta","Milos Crnjanski",10);
INSERT INTO bookshop.books (id, title, isbn, price, cover, rating, publisher, writer,available_in_stock) VALUES (5,"How to Quiet a Vampire ", 4600, 8.99,"paperback",4.6,"Solaris","Borislav Pekic" ,10);
INSERT INTO bookshop.books (id, title, isbn, price, cover, rating, publisher, writer,available_in_stock) VALUES (6,"Hamlet", 1587, 12.99,"hardcover",4.5,"Wordsworth Library","Wiliam Shakespeare",10);
INSERT INTO bookshop.books (id, title, isbn, price, cover, rating, publisher, writer,available_in_stock) VALUES (7,"Norwegian wood", 9587, 10.99,"hardcover",4.7,"Geopoetika","Haruki Murakami",10);
INSERT INTO bookshop.books (id, title, isbn, price, cover, rating, publisher, writer,available_in_stock) VALUES (8,"Finn Soeborg", 4680, 8.99,"paperback",4.6,"Nolit","Alfred" ,10);
INSERT INTO bookshop.books (id, title, isbn, price, cover, rating, publisher, writer,available_in_stock) VALUES (9,"Lagum", 2587, 12.99,"hardcover",4.5,"Prosveta","Svetlana V. Jankovic",10);
