package myapp.db;

import myapp.AppConfig;

import myapp.model.Course;
import myapp.repository.CourseRepository;
import myapp.service.impl.CourseServiceImpl;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import java.util.Iterator;
import java.util.List;
@Component
public class Domain
{
    /*@Autowired
    static CourseRepository courseRepository;
*/
    public static void main(String[] args) {

        CourseServiceImpl courseService = new CourseServiceImpl();
        courseService.testMethod();

      /*  Result results = JUnitCore.runClasses(CalculatorTesf.class);
        for (Failure failure : results.getFailures()) {
            System.out.println("Тест не пройден: " + failure);
        }*/

      //ctrl+shift+T

    }
}