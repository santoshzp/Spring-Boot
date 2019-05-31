package com.javainterviewpoint;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> 
{
    
}
