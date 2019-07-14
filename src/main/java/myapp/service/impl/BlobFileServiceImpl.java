package myapp.service.impl;

import myapp.model.BlobFile;
import myapp.repository.BlobFileRepository;
import myapp.service.api.BlobFileService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@ComponentScan(basePackages = {"myapp"})
public class BlobFileServiceImpl implements BlobFileService {

    private  static final org.slf4j.Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    final BlobFileRepository blobFileRepository;

    @Autowired
    public BlobFileServiceImpl(BlobFileRepository blobFileRepository) {
        this.blobFileRepository = blobFileRepository;
    }

    // TODO: 14.07.2019 Make Tests 
    @Override
    @Transactional
    public BlobFile getFileByLessonFileId(int id) {
        BlobFile blobFile = blobFileRepository.findByLessonFileId(id);
        return blobFile;
    }

    @Override
    @Transactional
    public void addFile(BlobFile blobFile) {
        blobFileRepository.save(blobFile);
    }
}
