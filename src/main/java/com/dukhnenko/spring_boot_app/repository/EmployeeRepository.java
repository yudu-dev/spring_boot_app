package com.dukhnenko.spring_boot_app.repository;

import com.dukhnenko.spring_boot_app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
