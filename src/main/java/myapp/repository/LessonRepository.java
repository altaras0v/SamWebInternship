package myapp.repository;


import myapp.model.Lesson;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends CrudRepository<Lesson,Integer>,JpaSpecificationExecutor<Lesson> {
    List<Lesson> findAllByCourseId(int id);
    Lesson findById(int id);
}
