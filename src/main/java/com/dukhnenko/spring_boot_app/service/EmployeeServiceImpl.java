package com.dukhnenko.spring_boot_app.service;

import com.dukhnenko.spring_boot_app.repository.EmployeeRepository;
import com.dukhnenko.spring_boot_app.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public boolean update(Employee employee, int employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employee.setEmployeeId(employeeId);
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return employeeRepository.getById(employeeId);
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        }
        return false;
    }
}
