package com.dukhnenko.spring_boot_app.controller;

import com.dukhnenko.spring_boot_app.entity.Employee;
import com.dukhnenko.spring_boot_app.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> showAllEmployees(){

        final List<Employee> employees = employeeService.getAllEmployees();

        return !CollectionUtils.isEmpty(employees)
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name = "id") int employeeId) {
        final Employee employee = employeeService.getEmployee(employeeId);

        return employee != null
                ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/employees/{id}")
    public  ResponseEntity<?> updateEmployee(@PathVariable(name = "id") int employeeId, @RequestBody Employee employee) {
        final boolean updated = employeeService.update(employee, employeeId);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(name = "id") int employeeId) {
        final boolean deleted = employeeService.deleteEmployee(employeeId);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
