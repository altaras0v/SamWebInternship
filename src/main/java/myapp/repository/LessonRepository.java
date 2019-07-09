package myapp.repository;


import myapp.model.Lesson;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends CrudRepository<Lesson,Integer>,JpaSpecificationExecutor<Lesson> {
    List<Lesson> findAllByCourse_Id(int id);
    Lesson findById(int id);
}
