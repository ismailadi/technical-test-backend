package com.ismailadi.techicaltestbackend.controller;

import com.ismailadi.techicaltestbackend.exception.GetByIdException;
import com.ismailadi.techicaltestbackend.model.EmployeesModel;
import com.ismailadi.techicaltestbackend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@CrossOrigin()
public class EmployeesController {
    private EmployeeService repository;

    public EmployeesController(EmployeeService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<EmployeesModel> getAll() {
        return repository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<EmployeesModel> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("")
    public EmployeesModel insertEmployees(@RequestBody EmployeesModel employees) {
        return repository.save(employees);
    }

    @DeleteMapping("/{id}")
    public Optional<EmployeesModel> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }


}
