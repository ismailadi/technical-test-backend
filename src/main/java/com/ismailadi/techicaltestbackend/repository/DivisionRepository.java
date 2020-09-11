package com.ismailadi.techicaltestbackend.repository;

import com.ismailadi.techicaltestbackend.model.DivisionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DivisionRepository extends JpaRepository<DivisionsModel, Long> {

}
