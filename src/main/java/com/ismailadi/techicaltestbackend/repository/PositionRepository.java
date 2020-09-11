package com.ismailadi.techicaltestbackend.repository;

import com.ismailadi.techicaltestbackend.model.PositionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PositionRepository extends JpaRepository<PositionsModel, Long> {

}
