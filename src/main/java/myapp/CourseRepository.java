package myapp;

import myapp.model.Course;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer>,JpaSpecificationExecutor<Course> {
      /*  @Query(value = "sele  ct name from Course ")
        Course findByName();*/
}
