package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.Course;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * repository(CRUD) for course
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Long>, JpaSpecificationExecutor<Course> {
}
