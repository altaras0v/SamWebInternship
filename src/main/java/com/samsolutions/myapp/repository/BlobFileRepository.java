package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.BlobFile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlobFileRepository extends CrudRepository<BlobFile, Long>, JpaSpecificationExecutor<BlobFile> {
	BlobFile findByLessonFileId(long id);
}
