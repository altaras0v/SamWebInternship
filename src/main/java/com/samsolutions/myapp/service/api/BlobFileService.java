package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.model.BlobFile;
import org.springframework.stereotype.Service;

@Service
public interface BlobFileService {
	BlobFile getFileByLessonFileId(long id);

	void addFile(BlobFile blobFile);
}