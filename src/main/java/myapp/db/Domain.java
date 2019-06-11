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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

@Component
public class Domain {
    /*@Autowired
    static CourseRepository courseRepository;
*/
    public static void main(String[] args) {
        BigInteger pr;
        pr = BigInteger.valueOf(1);
        for (int i = 1; i <= 200; i++) {
            int squar = (int) pow(i, 2);
            System.out.println(pr.multiply(BigInteger.valueOf(squar)));
        }
    }
}