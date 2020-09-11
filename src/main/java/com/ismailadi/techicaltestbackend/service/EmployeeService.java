package com.ismailadi.techicaltestbackend.service;

import com.ismailadi.techicaltestbackend.model.EmployeesModel;
import com.ismailadi.techicaltestbackend.repository.EmployeesRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeesRepositories employeesRepository;

    public EmployeeService(EmployeesRepositories employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<EmployeesModel> findAll() {
        return employeesRepository.findAll();
    }

    public Optional<EmployeesModel> findById(Long id) {
        return employeesRepository.findById(id);
    }

    public Optional<EmployeesModel> deleteById(Long id) {
        employeesRepository.deleteById(id);
        return Optional.empty();
    }

    public EmployeesModel save(EmployeesModel employees) {
        if(employees.getId() == null){
            return employeesRepository.save(employees);
        }else{
            EmployeesModel employeesToUpdate = employeesRepository.getOne(employees.getId());
            employeesToUpdate.setNik(employees.getNik());
            employeesToUpdate.setName(employees.getName());
            employeesToUpdate.setDivisionId(employees.getDivisionId());
            employeesToUpdate.setPositionId(employees.getPositionId());
            employeesToUpdate.setLastPosition(employees.getLastPosition());
            employeesToUpdate.setType(employees.getType());
            return employeesRepository.save(employeesToUpdate);
        }
    }
}
