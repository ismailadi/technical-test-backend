package com.ismailadi.techicaltestbackend.service;

import com.ismailadi.techicaltestbackend.repository.PositionRepository;
import com.ismailadi.techicaltestbackend.model.PositionsModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<PositionsModel> findAll() {
        return positionRepository.findAll();
    }

    public Optional<PositionsModel> findById(Long id) {
        return positionRepository.findById(id);
    }

    public Optional<PositionsModel> deleteById(Long id) {
        positionRepository.deleteById(id);
        return Optional.empty();
    }

    public PositionsModel save(PositionsModel position) {
        return positionRepository.save(position);
    }
}
