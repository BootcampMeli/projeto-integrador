INSERT INTO `role` (`id`, `role_name`)
SELECT * FROM (SELECT NULL, 'ROLE_SUPERVISOR') AS tmp
WHERE NOT EXISTS (SELECT role_name FROM role WHERE role_name = 'ROLE_SUPERVISOR') LIMIT 1;

INSERT INTO `role` (`id`, `role_name`)
SELECT * FROM (SELECT NULL, 'ROLE_BUYER') AS tmp
WHERE NOT EXISTS (SELECT role_name FROM role WHERE role_name = 'ROLE_BUYER') LIMIT 1;

INSERT INTO `role` (`id`, `role_name`)
SELECT * FROM (SELECT NULL, 'ROLE_SELLER') AS tmp
WHERE NOT EXISTS (SELECT role_name FROM role WHERE role_name = 'ROLE_SELLER') LIMIT 1;

INSERT INTO `role` (`id`, `role_name`)
SELECT * FROM (SELECT NULL, 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (SELECT role_name FROM role WHERE role_name = 'ROLE_ADMIN') LIMIT 1;

INSERT INTO `role` (`id`, `role_name`)
SELECT * FROM (SELECT NULL, 'ROLE_EMPLOYEE') AS tmp
WHERE NOT EXISTS (SELECT role_name FROM role WHERE role_name = 'ROLE_EMPLOYEE') LIMIT 1;


-- # US01 - Initial values
--
-- # Insert Warehouses
--

INSERT INTO `warehouse` (`id`,`name`) VALUES (1,'Nordeste');
INSERT INTO `warehouse` (`id`,`name`) VALUES (2,'SãoPaulo1');
INSERT INTO `warehouse` (`id`,`name`) VALUES (3,'SãoPaulo2');
INSERT INTO `warehouse` (`id`,`name`) VALUES (4,'SãoPaulo3');
INSERT INTO `warehouse` (`id`,`name`) VALUES (5,'SãoPaulo4');
INSERT INTO `warehouse` (`id`,`name`) VALUES (6,'MinasGerais1');
--
-- # Insert Sections
--
INSERT INTO `section` (`id`,`max_temperature`,`min_temperature`,`section_code`,`warehouse_id`) VALUES (1,20,10,'1',1);
INSERT INTO `section` (`id`,`max_temperature`,`min_temperature`,`section_code`,`warehouse_id`) VALUES (2,10,0,'2',1);
INSERT INTO `section` (`id`,`max_temperature`,`min_temperature`,`section_code`,`warehouse_id`) VALUES (3,0,-10,'3',1);
INSERT INTO `section` (`id`,`max_temperature`,`min_temperature`,`section_code`,`warehouse_id`) VALUES (4,20,10,'1',2);
INSERT INTO `section` (`id`,`max_temperature`,`min_temperature`,`section_code`,`warehouse_id`) VALUES (5,10,0,'2',2);
INSERT INTO `section` (`id`,`max_temperature`,`min_temperature`,`section_code`,`warehouse_id`) VALUES (6,0,-10,'3',2);
INSERT INTO `section` (`id`,`max_temperature`,`min_temperature`,`section_code`,`warehouse_id`) VALUES (7,20,10,'1',3);
INSERT INTO `section` (`id`,`max_temperature`,`min_temperature`,`section_code`,`warehouse_id`) VALUES (8,10,0,'2',3);
INSERT INTO `section` (`id`,`max_temperature`,`min_temperature`,`section_code`,`warehouse_id`) VALUES (9,0,-10,'3',3);
--
--
-- # Insert Users

INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (1,'sandro@warehouse.com','Sandro','954ght4h6','sandro');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (2,'paulo@warehouse.com','Paulo','39v4785n','paulo');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (3,'elisa@warehouse.com','Elisa','30b469u8','elisa');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (4,'maria@warehouse.com','Maria','2xein4988','maria');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (5,'ricardo@warehouse.com','Ricardo','3onf7rty','ricardo');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (6,'joao@warehouse.com','João','dfo3289gh5','joao');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (7,'sabrina@warehouse.com','Sabrina','1qas346g','sabrina');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (8,'bruno@warehouse.com','Bruno','954ght4h6','bruno');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (9,'roberta@warehouse.com','Roberta','108vn375y','roberta');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (10,'jose@warehouse.com','José','290478ty','jose');
INSERT INTO `user` (`id`,`email`,`name`,`password`,`username`) VALUES (11,'isadora@warehouse.com','Isaadora','230947n85','isadora');
--
-- # Insert Employee
--
INSERT INTO `employee` (`id`,`warehouse_id`) VALUES (1, 2);
INSERT INTO `employee` (`id`,`warehouse_id`) VALUES (2, 2);
INSERT INTO `employee` (`id`,`warehouse_id`) VALUES (3, 1);
INSERT INTO `employee` (`id`,`warehouse_id`) VALUES (4, 1);
--
-- # Insert Sellers
--
INSERT INTO `seller` (`id`) VALUES (5);
INSERT INTO `seller` (`id`) VALUES (6);
INSERT INTO `seller` (`id`) VALUES (7);
--
-- # Insert Buyers
--
INSERT INTO `buyer` (`id`) VALUES (8);
INSERT INTO `buyer` (`id`) VALUES (9);
INSERT INTO `buyer` (`id`) VALUES (10);
INSERT INTO `buyer` (`id`) VALUES (11);
--
-- # Insert Products
--
INSERT INTO `product` (`id`,`description`,`name`,`price`,`rating`,`seller_id`) VALUES (1,'danoninho do dinossauro','Danone',20,10,5);
INSERT INTO `product` (`id`,`description`,`name`,`price`,`rating`,`seller_id`) VALUES (2,'bolo caseiro','Bolo',12,9,5);
INSERT INTO `product` (`id`,`description`,`name`,`price`,`rating`,`seller_id`) VALUES (3,'alface crespa','Alface',2,7,6);
INSERT INTO `product` (`id`,`description`,`name`,`price`,`rating`,`seller_id`) VALUES (4,'repolho roxo','Repolho',5,8,6);
INSERT INTO `product` (`id`,`description`,`name`,`price`,`rating`,`seller_id`) VALUES (5,'picanha do zé','Picanha',35,10,7);
INSERT INTO `product` (`id`,`description`,`name`,`price`,`rating`,`seller_id`) VALUES (6,'gelo','Gelo',8,7,7);
INSERT INTO `product` (`id`,`description`,`name`,`price`,`rating`,`seller_id`) VALUES (7,'batata tinha','Batata',5,7.5,5);
INSERT INTO `product` (`id`,`description`,`name`,`price`,`rating`,`seller_id`) VALUES (8,'pipoca','Pipoca',3,7,6);
--
-- # Insert Supervisors
--
INSERT INTO `supervisor` (`id`) VALUES (1);
INSERT INTO `supervisor` (`id`) VALUES (2);
--
-- # Insert Inbound Orders
--
INSERT INTO `inbound_order` (`id`,`order_date`,`section_id`,`supervisor_id`) VALUES (1,'2021-07-02',1,1);
INSERT INTO `inbound_order` (`id`,`order_date`,`section_id`,`supervisor_id`) VALUES (2,'2021-07-02',1,1);
INSERT INTO `inbound_order` (`id`,`order_date`,`section_id`,`supervisor_id`) VALUES (3,'2021-07-02',2,1);
INSERT INTO `inbound_order` (`id`,`order_date`,`section_id`,`supervisor_id`) VALUES (4,'2021-07-02',3,1);
INSERT INTO `inbound_order` (`id`,`order_date`,`section_id`,`supervisor_id`) VALUES (5,'2021-07-02',1,1);
--
-- # Insert Batches
--
INSERT INTO `batch` (`id`,`current_quantity`,`current_temperature`,`due_date`,`initial_quantity`,`manufacturing_date`,`manufacturing_time`,`max_temperature`,`min_temperature`,`product_id`) VALUES (1,12,12,'2021-08-12',2,'2012-05-12','2012-05-01 01:12:00.000000',15,10,1);
INSERT INTO `batch` (`id`,`current_quantity`,`current_temperature`,`due_date`,`initial_quantity`,`manufacturing_date`,`manufacturing_time`,`max_temperature`,`min_temperature`,`product_id`) VALUES (2,5,7,'2021-08-15',1,'2012-05-25','2012-05-25 09:15:00.000000',11,5,2);
INSERT INTO `batch` (`id`,`current_quantity`,`current_temperature`,`due_date`,`initial_quantity`,`manufacturing_date`,`manufacturing_time`,`max_temperature`,`min_temperature`,`product_id`) VALUES (3,15,3,'2021-08-12',8,'2012-06-23','2012-06-23 04:55:33.000000',0,-6,3);
INSERT INTO `batch` (`id`,`current_quantity`,`current_temperature`,`due_date`,`initial_quantity`,`manufacturing_date`,`manufacturing_time`,`max_temperature`,`min_temperature`,`product_id`) VALUES (4,6,18,'2021-07-22',2,'2012-06-22','2012-06-22 05:33:00.000000',20,15,4);
INSERT INTO `batch` (`id`,`current_quantity`,`current_temperature`,`due_date`,`initial_quantity`,`manufacturing_date`,`manufacturing_time`,`max_temperature`,`min_temperature`,`product_id`) VALUES (5,7,-2,'2021-09-01',1,'2012-06-07','2012-06-07 07:15:00.000000',0,-5,5);
--
-- # Create inboundo order 1 to batch stock 1
--
INSERT INTO `inbound_order_batch_stock` (`inbound_order_id`, `batch_stock_id`) VALUES ('1', '1');
--
-- # US02 - Update values and conditions
--
-- # Update section codes
--
UPDATE `g3projdb`.`section` SET `section_code` = 'RS', `max_temperature` = 5, `min_temperature` = 0   WHERE (`section_code` = '2');
UPDATE `g3projdb`.`section` SET `section_code` = 'FF', `max_temperature` = -10, `min_temperature` = -25   WHERE (`section_code` = '3');
UPDATE `g3projdb`.`section` SET `section_code` = 'FS', `max_temperature` = 10, `min_temperature` = 4  WHERE (`section_code` = '1');
--

-- # Set Roles to Users
-- Supervisor
INSERT INTO user_role VALUES(1, 1);
INSERT INTO user_role VALUES(2, 1);
-- Admin
INSERT INTO user_role VALUES(1, 4);
INSERT INTO user_role VALUES(2, 4);
-- Seller
INSERT INTO user_role VALUES(5, 3);
INSERT INTO user_role VALUES(6, 3);
INSERT INTO user_role VALUES(7, 3);
-- Buyer
INSERT INTO user_role VALUES(8, 2);
INSERT INTO user_role VALUES(9, 2);
INSERT INTO user_role VALUES(10, 2);
INSERT INTO user_role VALUES(11, 2);
