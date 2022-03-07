package com.nitin.springrest.Services;

import com.nitin.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    List<Course> list;

    public CourseServiceImpl() {

        list = new ArrayList<>();
        list.add(new Course(124, "Java Course", "This course is for Java aspirants"));
        list.add(new Course(235, "Spring Course", "This course is for Spring aspirants"));
    }


    @Override
    public List<Course> getCoures() {

        return list;
    }

    @Override
    public Course getCourse(int id) {
        Course c1 = null;
        for (Course c : list) {

            if (id == c.getId()) {
                c1 = c;
                break;
            }

        }

        return c1;
    }

    @Override
    public Course addCourse(Course course) {

        list.add(course);
        return course;
    }

    @Override
    public Course delCourse(int id) {
        Course c1 = null;
        for (Course c : list) {

            if (id == c.getId()) {
                c1=c;
                list.remove(c);
                break;
            }

        }

        return c1;
    }

    @Override
    public Course updateCourse(Course course) {

        Course c1 = null;
        for (Course c : list) {

            if (course.getId() == c.getId()) {
                c.setDesc(course.getDesc());
                c.setTitle(course.getTitle());
                break;
            }

        }

        return course;
    }
}

