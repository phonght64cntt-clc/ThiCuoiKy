-- Categories
INSERT INTO categories (id, name) SELECT 1, 'Cake' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE id = 1);
INSERT INTO categories (id, name) SELECT 2, 'Cupcake' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE id = 2);
INSERT INTO categories (id, name) SELECT 3, 'Macaron' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE id = 3);
INSERT INTO categories (id, name) SELECT 4, 'Cookie' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE id = 4);
INSERT INTO categories (id, name) SELECT 5, 'Dessert' WHERE NOT EXISTS (SELECT 1 FROM categories WHERE id = 5);

UPDATE categories SET name = 'Cake' WHERE id = 1;
UPDATE categories SET name = 'Cupcake' WHERE id = 2;
UPDATE categories SET name = 'Macaron' WHERE id = 3;
UPDATE categories SET name = 'Cookie' WHERE id = 4;
UPDATE categories SET name = 'Dessert' WHERE id = 5;

-- Products used by the storefront. Prices are stored in VND for backend orders.
MERGE INTO products (id, name, description, price, image, is_active, category_id) KEY(id) VALUES
(1, 'Chocolate Cake', 'Rich chocolate sponge with smooth chocolate ganache.', 240000, 'img/products/Chocolate Cake.jpg', true, 1),
(2, 'Strawberry Cake', 'Soft vanilla cake with fresh strawberries and cream.', 220000, 'img/products/Strawberry Cake.jpg', true, 1),
(3, 'Red Velvet Cake', 'Classic red velvet with rich cream cheese frosting.', 250000, 'img/products/Red Velvet Cake.jpg', true, 1),
(4, 'Black Forest Cake', 'Chocolate cake layered with cherries and whipped cream.', 270000, 'img/products/Black Forest Cake.jpg', true, 1),
(5, 'Tiramisu Cake', 'Coffee-soaked cake with mascarpone cream and cocoa.', 280000, 'img/products/Tiramisu Cake.jpg', true, 1),
(6, 'Berry Celebration Cake', 'Special berry cake with light cream and fresh fruit.', 260000, 'img/products/Berry Celebration Cake.jpg', true, 1),

(7, 'Blueberry Cupcake', 'Fluffy cupcake with blueberry cream cheese frosting.', 35000, 'img/products/Blueberry Cupcake.jpg', true, 2),
(8, 'Chocolate Cupcake', 'Moist chocolate cupcake with creamy frosting.', 32000, 'img/products/Chocolate Cupcake.jpg', true, 2),
(9, 'Vanilla Cupcake', 'Soft vanilla cupcake with silky buttercream.', 30000, 'img/products/Vanilla Cupcake.jpg', true, 2),
(10, 'Strawberry Cupcake', 'Sweet strawberry cupcake with pink frosting.', 33000, 'img/products/Strawberry Cupcake.jpg', true, 2),
(11, 'Salted Caramel Cupcake', 'Caramel cupcake finished with salted caramel cream.', 36000, 'img/products/Salted Caramel Cupcake.jpg', true, 2),
(12, 'Matcha Cupcake', 'Matcha cupcake with creamy green tea frosting.', 34000, 'img/products/Matcha Cupcake.jpg', true, 2),

(13, 'Macaron Mix', 'Assorted French macarons with sweet filling.', 120000, 'img/products/Macaron Mix.jpg', true, 3),
(14, 'Raspberry Macaron', 'Sweet raspberry macarons with soft cream.', 120000, 'img/products/Raspberry Macaron.jpg', true, 3),
(15, 'Pistachio Macaron', 'Nutty pistachio macarons with delicate filling.', 125000, 'img/products/Pistachio Macaron.jpg', true, 3),
(16, 'Chocolate Macaron', 'Chocolate macarons with rich ganache filling.', 115000, 'img/products/Chocolate Macaron.jpg', true, 3),
(17, 'Vanilla Macaron', 'Classic vanilla macarons with smooth cream.', 110000, 'img/products/Vanilla Macaron.jpg', true, 3),
(18, 'Lemon Macaron', 'Bright lemon macarons with citrus filling.', 115000, 'img/products/Lemon Macaron.jpg', true, 3),

(19, 'Chocolate Cookie', 'Crisp cookies with chocolate chips inside.', 22000, 'img/products/Chocolate Cookie.jpg', true, 4),
(20, 'Chocolate Chip Cookie', 'Golden cookies packed with chocolate chips.', 24000, 'img/products/Chocolate Chip Cookie.jpg', true, 4),
(21, 'Oatmeal Raisin Cookie', 'Chewy oatmeal cookie with sweet raisins.', 23000, 'img/products/Oatmeal Raisin Cookie.jpg', true, 4),
(22, 'Double Chocolate Cookie', 'Deep chocolate cookie with extra chocolate chunks.', 26000, 'img/products/Double Chocolate Cookie.jpg', true, 4),
(23, 'Butter Cookie', 'Classic buttery cookie with a tender crumb.', 20000, 'img/products/Butter Cookie.jpg', true, 4),
(24, 'Almond Cookie', 'Crunchy almond cookie with a toasted nut finish.', 25000, 'img/products/Almond Cookie.jpg', true, 4),

(25, 'Lemon Tart', 'Tangy lemon filling with buttery tart crust.', 45000, 'img/products/Lemon Tart.jpg', true, 5),
(26, 'Fruit Tart', 'Colorful fruit tart with custard and crisp crust.', 52000, 'img/products/Fruit Tart.jpg', true, 5),
(27, 'Chocolate Mousse', 'Silky chocolate mousse with a rich cocoa taste.', 48000, 'img/products/Chocolate Mousse.jpg', true, 5),
(28, 'Panna Cotta', 'Creamy panna cotta with a delicate vanilla finish.', 46000, 'img/products/Panna Cotta.jpg', true, 5),
(29, 'Cheesecake Slice', 'Creamy cheesecake slice with a buttery base.', 55000, 'img/products/Cheesecake Slice.jpg', true, 5),
(30, 'Creme Brulee', 'Custard dessert with caramelized sugar topping.', 58000, 'img/products/Creme Brulee.jpg', true, 5);

-- Admin account (password: admin123)
INSERT INTO users (id, name, email, password, role)
SELECT 1, 'Admin', 'admin@bake.com', '$2a$10$xmO/1ZYwkf11uZmYh3ZuLObMiuX7lwoIhD1utU1Xh5NtGBloRTlY6', 'ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = 1);

UPDATE users
SET name = 'Admin',
    email = 'admin@bake.com',
    password = '$2a$10$xmO/1ZYwkf11uZmYh3ZuLObMiuX7lwoIhD1utU1Xh5NtGBloRTlY6',
    role = 'ADMIN'
WHERE id = 1;

ALTER TABLE categories ALTER COLUMN id RESTART WITH 6;
ALTER TABLE products ALTER COLUMN id RESTART WITH 31;
ALTER TABLE users ALTER COLUMN id RESTART WITH 3;
ALTER TABLE orders ALTER COLUMN id RESTART WITH 100000;
ALTER TABLE order_items ALTER COLUMN id RESTART WITH 100000;
