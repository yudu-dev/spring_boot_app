package com.dukhnenko.spring_boot_app.service;

import com.dukhnenko.spring_boot_app.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    boolean update(Employee employee, int employeeId);

    Employee getEmployee(int employeeId);

    boolean deleteEmployee(int employeeId);

}
