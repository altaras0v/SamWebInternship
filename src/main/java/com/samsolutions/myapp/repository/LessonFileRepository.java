package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.LessonFile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonFileRepository extends CrudRepository<LessonFile, Integer>, JpaSpecificationExecutor<LessonFile> {
	 List<LessonFile> findAllByLessonId(int id);
}
