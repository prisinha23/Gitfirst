package com.priyesh.Learn1.repository;

import com.priyesh.Learn1.EntityClass.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity ,Integer> {

    public Page<StudentEntity> findAll(Pageable pageable);
}
