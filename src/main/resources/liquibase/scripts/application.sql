-- liquibase formatted sql

-- changeset egor:1


create table users (
    id bigserial UNIQUE,
    username varchar,
    password varchar,
    name varchar,
    phone varchar
);

create table bids (
    id bigserial,
    status varchar,
    user_message varchar,
    user_id int8,
    creation_date date,
    foreign key (user_id) references users(id)
);

create table roles (
    id serial UNIQUE,
    name varchar
);

create table users_roles (
    user_id int8 not null,
    role_id int8 not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_OPERATOR')