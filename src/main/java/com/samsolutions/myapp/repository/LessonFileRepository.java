package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.LessonFile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Repository for LessonFile(name and description for file)
 */
@Repository
public interface LessonFileRepository extends CrudRepository<LessonFile, Long>, JpaSpecificationExecutor<LessonFile> {
	/**
	 * Get all LessonFile for this lesson from database
	 * @param id - lesson id
	 * @return list with LessonFiles
	 */
	 List<LessonFile> findAllByLessonId(long id);
}
