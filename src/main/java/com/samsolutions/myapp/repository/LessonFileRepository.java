package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.LessonFile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonFileRepository extends CrudRepository<LessonFile, Long>, JpaSpecificationExecutor<LessonFile> {
	 List<LessonFile> findAllByLessonId(long id);
}
