package myapp.db;

import myapp.CourseRepository;
import myapp.model.Course;
import myapp.service.impl.CourseServiceImpl;
import org.hibernate.Session;

import javax.transaction.Transactional;

public class Domain {
    public static void main(String[] args) {

        CourseServiceImpl c1 = new CourseServiceImpl();
        c1.testMethod();
    }
}
