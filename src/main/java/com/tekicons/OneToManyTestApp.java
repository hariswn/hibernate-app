package com.tekicons;

import com.tekicons.dao.CourseDao;
import com.tekicons.dao.TrainingCenterDao;
import com.tekicons.entity.onetomany.Course;
import com.tekicons.entity.onetomany.TrainingCenter;

import java.util.Arrays;
import java.util.List;

public class OneToManyTestApp {

    public static void main(String[] args) {

        TrainingCenterDao trainingCenterDao = new TrainingCenterDao();
        CourseDao courseDao = new CourseDao();

//        TrainingCenter trainingCenter = new TrainingCenter("TATA schools",  "tataschools@gmail.com");
//        List<Course> courses = Arrays.asList(new Course("Cloud Full Stack"),
//                new Course("Devops"),
//                new Course("Java Full Stack"),
//                new Course("Python Full Stack"),
//                new Course("UI design"),
//                new Course("Automation Testing"));
//        trainingCenter.setCourses(courses);
//        trainingCenterDao.saveTrainingCenter(trainingCenter);

        TrainingCenter dbTrainingCenter = trainingCenterDao.getTrainingCenter(8);
        System.out.println(dbTrainingCenter);
        List<Course> dbCourses = dbTrainingCenter.getCourses();
        System.out.println("Courses Size : " + dbCourses.size());


        // create some courses
//        Course tempCourse1 = new Course("Cloud Full Stack");
//        tempCourse1.setTrainingCenter(trainingCenter);
//        courseDao.saveCourse(tempCourse1);
//
//        Course tempCourse2 = new Course("Devops");
//        tempCourse2.setTrainingCenter(trainingCenter);
//        courseDao.saveCourse(tempCourse2);
//
//        Course tempCourse3 = new Course("Java Full Stack");
//        tempCourse3.setTrainingCenter(trainingCenter);
//        courseDao.saveCourse(tempCourse3);
    }
}
