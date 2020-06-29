
INSERT into recipes (recipe_id,name,description,image_path) values (201,'Mirchi Bajji','Deeply Fried stuffed Mirchi bajji','https://upload.wikimedia.org/wikipedia/commons/8/81/Mirapakaya_Bajji_or_Mirchi_Bhajji.JPG');
INSERT into recipes (recipe_id,name,description,image_path) values (202,'Chicken dum biryani','Chicken dum biryani','https://upload.wikimedia.org/wikipedia/commons/8/81/Mirapakaya_Bajji_or_Mirchi_Bhajji.JPG');
INSERT into recipes (recipe_id,name,description,image_path) values (203,'Indian Dosa','Indian Dosa served with coconut chutney and sambar','https://upload.wikimedia.org/wikipedia/commons/8/81/Mirapakaya_Bajji_or_Mirchi_Bhajji.JPG');
INSERT into recipes (recipe_id,name,description,image_path) values (204,'Pani puri','Pani puri with onions and mint water loaded with chole','https://upload.wikimedia.org/wikipedia/commons/8/81/Mirapakaya_Bajji_or_Mirchi_Bhajji.JPG');
INSERT into recipes (recipe_id,name,description,image_path) values (205,'Cheese Burger','Cheese burger loaded with fries','https://upload.wikimedia.org/wikipedia/commons/8/81/Mirapakaya_Bajji_or_Mirchi_Bhajji.JPG');



INSERT into ingredients (ingredient_id,name) values (101,'Onions');
INSERT into ingredients (ingredient_id,name) values (102,'Chillies');
INSERT into ingredients (ingredient_id,name) values (103,'flakes');
INSERT into ingredients (ingredient_id,name) values (104,'pasta'); 

INSERT into RECIPE_INGREDIENT  (id,recipe_id,ingredient_id,quantity) values (1001,201,101,3);
INSERT into RECIPE_INGREDIENT  (id,recipe_id,ingredient_id,quantity) values (1002,201,102,5);

INSERT into RECIPE_INGREDIENT  (id,recipe_id,ingredient_id,quantity) values (1003,202,102,3);
INSERT into RECIPE_INGREDIENT  (id,recipe_id,ingredient_id,quantity) values (1004,202,103,5);

INSERT into RECIPE_INGREDIENT  (id,recipe_id,ingredient_id,quantity) values (1005,203,102,3);
INSERT into RECIPE_INGREDIENT  (id,recipe_id,ingredient_id,quantity) values (1006,203,101,5);

INSERT into RECIPE_INGREDIENT  (id,recipe_id,ingredient_id,quantity) values (1007,204,101,3);
INSERT into RECIPE_INGREDIENT  (id,recipe_id,ingredient_id,quantity) values (1008,204,103,5);