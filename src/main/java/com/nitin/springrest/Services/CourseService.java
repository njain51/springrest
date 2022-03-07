package com.nitin.springrest.Services;

import com.nitin.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {

    public List<Course> getCoures();

    public Course getCourse(int id);

    public Course addCourse(Course course);

    public Course delCourse(int id);

    public Course updateCourse(Course course);

}
