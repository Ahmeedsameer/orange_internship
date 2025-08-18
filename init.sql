USE online_store;

CREATE TABLE customer (
  name VARCHAR(100),
  email VARCHAR(100) PRIMARY KEY,
  addres VARCHAR(100),
  phone VARCHAR(100)
);

CREATE TABLE products (
  name VARCHAR(100),
  ppid INT PRIMARY KEY,
  price INT
);

CREATE TABLE orders (
  oid INT PRIMARY KEY,
  orderr_darte DATE,
  customer_email VARCHAR(100),
  FOREIGN KEY (customer_email) REFERENCES customer(email)
);

CREATE TABLE order_product (
  pid INT,
  oid INT,
  PRIMARY KEY(pid, oid),
  FOREIGN KEY (pid) REFERENCES products(ppid),
  FOREIGN KEY (oid) REFERENCES orders(oid)
);
