package com.developer.employee_managment.service;

import com.developer.employee_managment.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeEntity> findallEmployee();
    Optional<EmployeeEntity> findById(Long id);
    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
    void deleteEmployee(Long id);
    EmployeeEntity patchEmployee(Long id, EmployeeEntity employeeEntity);
    Optional<EmployeeEntity> findByName(String name);
}
