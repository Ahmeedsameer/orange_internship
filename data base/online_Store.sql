use online_store ;
create table customer (
name varchar(100),
email varchar(100) primary key ,
addres varchar(100),
phone varchar(100)
);
create table products (
name varchar(100),
ppid int primary key,
price int
);
create table orders (
oid int primary key ,
orderr_darte date,
customer_email varchar(100),
 FOREIGN KEY (customer_email) REFERENCES customer(email) 
);

create table order_product(
pid int,
oid int,
primary key(pid,oid),
  FOREIGN KEY (pid) REFERENCES products(ppid) ,
  FOREIGN KEY (oid) REFERENCES orders(oid) 
  );

