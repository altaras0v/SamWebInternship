package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.BlobFile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * repository(CRUD) for BLOB files
 */
@Repository
public interface BlobFileRepository extends CrudRepository<BlobFile, Long>, JpaSpecificationExecutor<BlobFile> {
	/**
	 * Method that find file for this LessonFile(name and desc of file) in database
	 *
	 * @param id - id of Lesson File
	 * @return BlobFile (object with bytes and etc)
	 */
	BlobFile findByLessonFileId(long id);
	BlobFile findById(long id);
}
