package com.developer.employee_managment.controller;

import com.developer.employee_managment.entity.EmployeeEntity;
import com.developer.employee_managment.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@GetMapping
    public List<EmployeeEntity> findAllEmployee(){
        return employeeService.findallEmployee();
    }
@GetMapping("/{id}")
    public Optional<EmployeeEntity> findEmployeeById(@PathVariable("id")Long id){

        return employeeService.findById(id);
    }
@PostMapping
   public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity){

        return employeeService.saveEmployee(employeeEntity);
}
@PutMapping
public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.updateEmployee(employeeEntity);
}
@DeleteMapping("/{id}")
    public void DeleteEmployee(@PathVariable("id")Long id){

        employeeService.deleteEmployee(id);
}

    @PatchMapping("/{id}")
    public EmployeeEntity patchEmployee(@PathVariable("id") Long id, @RequestBody EmployeeEntity employeeEntity) {
        return employeeService.patchEmployee(id, employeeEntity);
    }

    @GetMapping("/byname/{name}")
    public ResponseEntity<?> findEmployeeByName(@PathVariable("name") String name) {
        Optional<EmployeeEntity> employeeOptional = employeeService.findByName(name);
        if (employeeOptional.isPresent()) {
            return ResponseEntity.ok(employeeOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
