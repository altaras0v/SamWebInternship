package myapp.repository;

import myapp.model.Lesson;
import myapp.model.LessonFile;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonFileRepository extends CrudRepository<LessonFile,Integer>,JpaSpecificationExecutor<LessonFile> {
    LessonFile findById(int id);
    LessonFile findByLesson_Id(int id);
}
