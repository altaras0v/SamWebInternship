package myapp.service.api;

import myapp.model.BlobFile;
import org.springframework.stereotype.Service;

@Service
public interface BlobFileService {
	BlobFile getFileByLessonFileId(int id);

	void addFile(BlobFile blobFile);
}