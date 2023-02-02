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
user_id serial,
location VARCHAR(255),
description TEXT,
priority VARCHAR(255),
image_path VARCHAR(2000),
date_time TIMESTAMP
);
{
"userId": 7,
"location": "28 Rue de",
"description": "testissue",
"priority": "high",
"imagePath": "capture.PNG",
"dateTime": 2023-02-01 05:01:56.122
"status": "Open"

}

{
"adminId": 7,
"description": "testevent",
"endTime": "09:00",
"eventDate": "2023-02-07",
"startTime": "08:00"
}