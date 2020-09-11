package com.ismailadi.techicaltestbackend.service;

import com.ismailadi.techicaltestbackend.model.DivisionsModel;
import com.ismailadi.techicaltestbackend.repository.DivisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionService {

    private final DivisionRepository divisionRepository;

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public List<DivisionsModel> findAll() {
        return divisionRepository.findAll();
    }

    public Optional<DivisionsModel> findById(Long id) {
        return divisionRepository.findById(id);
    }

    public Optional<DivisionsModel> deleteById(Long id) {
        divisionRepository.deleteById(id);
        return Optional.empty();
    }

    public DivisionsModel save(DivisionsModel division) {
        return divisionRepository.save(division);
    }
}
