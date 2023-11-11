CREATE TABLE IF NOT EXISTS employee (employee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL,
employee_role VARCHAR(255) DEFAULT 'normal' NOT NULL, employee_status VARCHAR(255));

CREATE TABLE IF NOT EXISTS customer (customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, street_address VARCHAR(255) NOT NULL,
zip_code VARCHAR(255) NOT NULL);

CREATE TABLE IF NOT EXISTS product (product_id INT NOT NULL  AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL,
price DECIMAL , product_size VARCHAR(255) NOT NULL);

CREATE TABLE IF NOT EXISTS "customerOrder" (
  order_id INT NOT NULL AUTO_INCREMENT,
  phone_number VARCHAR(255) NOT NULL,
  employee_id INT NOT NULL,
  order_status BIT,
  time_data DATE,
  PRIMARY KEY (order_id),
  CONSTRAINT fk_employee_order FOREIGN KEY (employee_id) REFERENCES employee (employee_id)
);

CREATE TABLE IF NOT EXISTS orderDetail (
detail_id INT NOT NULL AUTO_INCREMENT,
price_charged DECIMAL NOT NULL,
quantity INT NOT NULL,
product_id INT NOT NULL,
customer_id INT NOT NULL,
PRIMARY KEY (detail_id),
CONSTRAINT product_id FOREIGN KEY (product_id) REFERENCES product(product_id),
CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);
