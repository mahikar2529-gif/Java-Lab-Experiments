CREATE DATABASE IF NOT EXISTS labdb;
USE labdb;

CREATE TABLE IF NOT EXISTS students (
    roll_no VARCHAR(20) PRIMARY KEY,
    name    VARCHAR(60) NOT NULL,
    course  VARCHAR(40) NOT NULL,
    email   VARCHAR(80),
    phone   VARCHAR(15)
);
