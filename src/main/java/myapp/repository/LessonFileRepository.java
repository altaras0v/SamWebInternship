package myapp.repository;

import myapp.model.Lesson;
import myapp.model.LessonFile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonFileRepository extends CrudRepository<LessonFile,Integer>,JpaSpecificationExecutor<LessonFile> {
    LessonFile findById(int id);
    List<LessonFile> findAllByLessonId(int id);
}
