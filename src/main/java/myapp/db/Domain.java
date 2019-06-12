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
import static java.lang.Math.signum;

@Component
public class Domain {
    /*@Autowired
    static CourseRepository courseRepository;
*/
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Введите число e:");
        double e = num.nextDouble();
        int n = 0;
        double sum = 0;
        while (true) {
            n++;
            double numSer = 1 / pow(2, n) + 1 / pow(3, n);
            sum += numSer;
            if (Math.abs(numSer) >= e) {
                System.out.println(sum);
                break;
            }
        }


    }
}