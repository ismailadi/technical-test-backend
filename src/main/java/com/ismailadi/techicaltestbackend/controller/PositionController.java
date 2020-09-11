package com.ismailadi.techicaltestbackend.controller;

import com.ismailadi.techicaltestbackend.exception.GetByIdException;
import com.ismailadi.techicaltestbackend.service.PositionService;
import com.ismailadi.techicaltestbackend.model.PositionsModel;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/positions")
@CrossOrigin()
public class PositionController {
    private PositionService repository;

    public PositionController(PositionService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<PositionsModel> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PositionsModel getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new GetByIdException(id, "Position"));
    }

    @PostMapping("")
    public PositionsModel insertEmployees(@RequestBody PositionsModel position) {
        return repository.save(position);
    }

    @DeleteMapping("/{id}")
    public Optional<PositionsModel> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }

}
