package myapp.repository;

import myapp.model.Course;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedCoursesNameRepository extends CrudRepository<Course,Integer>,JpaSpecificationExecutor<Course> {
    Optional<Course> findByname(String fName);

  //  List<Course> findFirst2ByFirstNameStartsWithOrderByFirstName(String firstNameStartsWith);
}
