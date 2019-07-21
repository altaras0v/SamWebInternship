package com.samsolutions.myapp.repository;


import com.samsolutions.myapp.model.Lesson;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for lesson
 */
@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long>, JpaSpecificationExecutor<Lesson> {
	/**
	 * Get all lessons id database for this course
	 * @param id - course id
	 * @return - list with Lessons
	 */
	List<Lesson> findAllByCourseId(long id);
}
