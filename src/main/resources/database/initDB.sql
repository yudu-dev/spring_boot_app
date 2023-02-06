DROP SEQUENCE IF EXISTS employees_employee_id_seq CASCADE;
CREATE SEQUENCE employees_employee_id_seq;

DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
    employee_id INTEGER PRIMARY KEY DEFAULT nextval('employees_employee_id_seq'),
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    department varchar(30) NOT NULL,
    salary INT NOT NULL);
