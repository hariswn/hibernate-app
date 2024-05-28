package com.tekicons;

import com.tekicons.dao.InstructorDao;
import com.tekicons.entity.onetoone.Instructor;
import com.tekicons.entity.onetoone.InstructorDetail;

public class OneToOneTestApp {

    public static void main(String[] args) {

        Instructor instructor = new Instructor("harry", "p", "java.with.harry@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("http://www.javawithharry.com", "Techie");
        // associate the objects
        instructorDetail.setInstructor(instructor);
        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        // when you get instructorDetail then hibernate also saves instructor info
        InstructorDao instructorDao = new InstructorDao();
        instructorDao.saveInstructor(instructor);
    }
}
