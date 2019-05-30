package myapp.db;

import myapp.model.Course;
import myapp.service.impl.CourseServiceImpl;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import javax.naming.Context;
import java.util.Iterator;
import java.util.List;

public class Domain
{

    public static void main(String[] args) {
        CourseServiceImpl courseService = new CourseServiceImpl();
        courseService.testMethod();
    }
}