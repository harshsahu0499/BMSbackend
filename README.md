# BuildingManagementSystem

This is the backend of the project BMS. Written in Java.

# :)

create database bmsdb;

CREATE TABLE users (
id serial primary key,
first_name varchar(100) not null,
last_name varchar(100) not null,
building_number varchar(100) not null,
house_number varchar(100) not null,
email_address varchar(255) not null,
phone_number varchar(100) not null
);

create table admin

create table users - check password encrypt and varchar size of fields


CREATE TABLE reports (
id SERIAL PRIMARY KEY,
user_id VARCHAR(255),
location VARCHAR(255),
description TEXT,
priority VARCHAR(255),
image_path VARCHAR(255),
date_time TIMESTAMP
);