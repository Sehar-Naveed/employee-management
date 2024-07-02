package com.developer.employee_managment.impl;

import com.developer.employee_managment.entity.EmployeeEntity;
import com.developer.employee_managment.repository.EmployeeRepository;
import com.developer.employee_managment.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> findallEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployee(Long id) {
      employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeEntity patchEmployee(Long id, EmployeeEntity employeeEntity) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeEntity existingEmployee = optionalEmployee.get();


            if (employeeEntity.getName() != null) {
                existingEmployee.setName(employeeEntity.getName());
            }
            if (employeeEntity.getGender() != null) {
                existingEmployee.setGender(employeeEntity.getGender());
            }
            if (employeeEntity.getDateOfBirth() != null) {
                existingEmployee.setDateOfBirth(employeeEntity.getDateOfBirth());
            }
            if (employeeEntity.getAddress() != null) {
                existingEmployee.setAddress(employeeEntity.getAddress());
            }


            return employeeRepository.save(existingEmployee);
        } else {

            throw new RuntimeException("Employee with id " + id + " not found");
        }
    }

    @Override
    public Optional<EmployeeEntity> findByName(String name) {
        return employeeRepository.findByName(name);


    }
}