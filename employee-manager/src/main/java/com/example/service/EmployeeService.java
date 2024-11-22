package com.example.service;

import com.example.exception.UserNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repo.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    public Employee updateEmployee(Employee employee){
       return repo.save(employee);
    }

    public void deleteEmployee(Long id){
        repo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return repo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("Could not find user with ID " + id));
    }

}
