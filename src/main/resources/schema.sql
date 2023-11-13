CREATE TABLE IF NOT EXISTS employee (employee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL,
employee_role VARCHAR(255) DEFAULT 'normal' NOT NULL, employee_status VARCHAR(255));

CREATE TABLE IF NOT EXISTS customer (phone_number INT NOT NULL PRIMARY KEY,name VARCHAR(255) NOT NULL, street_address VARCHAR(255) NOT NULL,
zip_code VARCHAR(255) NOT NULL);

CREATE TABLE IF NOT EXISTS product (product_id INT NOT NULL  AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL,
price DECIMAL , product_size VARCHAR(255) NOT NULL);


INSERT INTO product (product_id,name,price,product_size) VALUES
(1,'Soda', 3.25, '2 Liter bottle'),
(2,'Pizza - small Pepperoni', 7.35, '8 inch'),
(3,'Pizza - medium Pepperoni', 9.35, '12 inch'),
(4,'Pizza - large Pepperoni', 14.00, '18 inch'),
(5,'Pizza - small house special', 8.50, '8 inch'),
(6,'Pizza - medium house special', 10.50, '12 inch'),
(7,'Pizza - large house special', 16.00, '18 inch');