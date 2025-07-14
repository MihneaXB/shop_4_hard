# create database web_shop character set utf8 collate utf8_general_ci;

insert into product_category_model(id, name) values(1, 'Electronice');
insert into product_category_model(id, name) values(2, 'Hardware');
insert into product_category_model(id, name) values(3, 'Software');

insert into product_model(id, description, imageurl, price, title, category_id) values (1, 'Cel mai performant uscator de par', 'https://dyson-h.assetsadobe2.com/is/image/content/dam/dyson/leap-petite-global/dynamic-media/personal-care/605cj-minus/T3_T4_113314-01.png?$responsive$&fmt=png-alpha&fit=stretch,1&wid=200', 1399.99, 'Dyson Supersonic hair dryer', 1);
insert into product_model(id, description, imageurl, price, title, category_id) values (2, 'Un aspirator de mana viabil pentru toti', 'https://dyson-h.assetsadobe2.com/is/image/content/dam/dyson/images/products/primary/446986-01.png?$responsive$&fmt=png-alpha&fit=stretch,1&wid=200', 3199.99, 'Aspirator Dyson V15 Detect Absolute', 1);
insert into product_model(id, description, imageurl, price, title, category_id) values (3, 'Inovatie in gama frigiderelor', 'https://s13emagst.akamaized.net/products/92169/92168502/images/res_dc1e76a413da6ca6b3515b87d4cc5bf9.png?width=720&height=720&hash=171A268C132726472C99968DE070E358', 32130.00, 'Side by Side Samsung', 1);
insert into product_model(id, description, imageurl, price, title, category_id) values (4, 'Cel mai performant procesor de gaming', 'https://s13emagst.akamaized.net/products/80724/80723311/images/res_c2425a8723d668083414f7bb6ad377ae.jpg?width=720&height=720&hash=F48DDC31BF76612C3788593FCE09E731', 2599.99, 'Ryzen 7 9800x3d', 2);
insert into product_model(id, description, imageurl, price, title, category_id) values (5, 'Cea mai puternica placa video', 'https://s13emagst.akamaized.net/products/89862/89861851/images/res_c210053247db2a7664b2a1eb85708716.jpg?width=720&height=720&hash=C82AF8ED7FA89DA622EC31F3D5D7BA8E', 16674.88, 'RTX 5090 Astral', 2);
insert into product_model(id, description, imageurl, price, title, category_id) values (6, 'Ram mai rapizi de atat nu gasesti', 'https://s13emagst.akamaized.net/products/46990/46989214/images/res_152df7b6b5e1550ca5d47ba02cf7615c.jpg?width=720&height=720&hash=9E9F9EADAAB9B8DE2E961AAC5DC300A3', 739.88, 'Trident Z5 DDR5', 2);



