-- liquibase formatted sql

-- changeset egor:1

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_OPERATOR')