create table category (
	category_id serial primary key,
	name varchar unique not null
);
create table ingredient (
	ingredient_id serial primary key,
	name varchar unique not null,
	category_id integer not null,
	foreign key (category_id) references category(category_id)
);
create table user_role (
	role_id serial primary key,
	name varchar unique not null
);
create table person (
	person_id serial primary key,
	username varchar unique not null,
	passwd varchar not null,
	first_name varchar,
	last_name varchar,
	role_id integer not null,
	foreign key (role_id) references user_role(role_id)
);
create table owned_ingredient (
	owned_id serial primary key,
	person_id integer not null,
	ingredient_id integer not null,
	quantity integer not null,
	foreign key (person_id) references person(person_id),
	foreign key (ingredient_id) references ingredient(ingredient_id)
);
create table dish (
	dish_id serial primary key,
	name varchar not null,
	quality integer not null check quality <= 5 and quality >= 0,
	recipe_id integer not null
);
create table person_dish (
	person_id integer not null,
	dish_id integer not null,
	foreign key (person_id) references person(person_id),
	foreign key (dish_id) references dish(dish_id)
);
create table token (
	token_id varchar primary key,
	person_id integer not null,
	foreign key (person_id) references person(person_id)
);