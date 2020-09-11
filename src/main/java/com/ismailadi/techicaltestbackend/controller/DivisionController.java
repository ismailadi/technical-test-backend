package com.ismailadi.techicaltestbackend.controller;

import com.ismailadi.techicaltestbackend.exception.GetByIdException;
import com.ismailadi.techicaltestbackend.model.DivisionsModel;
import com.ismailadi.techicaltestbackend.service.DivisionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/divisions")
@CrossOrigin()
public class DivisionController {
    private DivisionService repository;

    public DivisionController(DivisionService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<DivisionsModel> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DivisionsModel getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new GetByIdException(id, "Division"));
    }

    @PostMapping("")
    public DivisionsModel insertEmployees(@RequestBody DivisionsModel division) {
        return repository.save(division);
    }

    @DeleteMapping("/{id}")
    public Optional<DivisionsModel> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }

}
