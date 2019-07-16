package myapp.repository;

import myapp.model.BlobFile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlobFileRepository extends CrudRepository<BlobFile, Integer>, JpaSpecificationExecutor<BlobFile> {
	BlobFile findByLessonFileId(int id);
}
