package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.model.BlobFile;
import org.springframework.stereotype.Service;

@Service
public interface BlobFileService {
	BlobFile getFileByLessonFileId(int id);

	void addFile(BlobFile blobFile);
}