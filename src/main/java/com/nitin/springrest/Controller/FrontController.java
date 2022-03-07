package com.nitin.springrest.Controller;

import com.nitin.springrest.Services.CourseService;
import com.nitin.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Since we are making REST calls here
public class FrontController {

    // declare variable for parent class of CourseServiceImpl
    @Autowired   // Spring wil create object of CourseServiceImpl and inject it here.
    private CourseService courseService;

    // Adding /home
    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String getHome() {

        return "This is home";

    }

    // get details of all courses
    @RequestMapping(path = "/courses", method = RequestMethod.GET)
    public List<Course> getCourses() {

        // basically we are calling  getCoures method on courseService object. But since CourseService doesn't have any method implementation so it will
        // call method implementation from child class which is CourseServiceImpl. This is called Runtime PolyMorphism.
        return this.courseService.getCoures();

    }

    // Get detail of course by id
    @RequestMapping(path = "/courses/{courseId}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable int courseId) {

        return this.courseService.getCourse(courseId);
    }

    // Adding course provided by user
    @RequestMapping(path = "/courses", method = RequestMethod.POST)
    public Course addCourse(@RequestBody Course c) {
        return this.courseService.addCourse(c);
    }

    //deleting course
    @RequestMapping(path = "/courses/{courseId}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> delCourse(@PathVariable int courseId) {

//        return this.courseService.delCourse(courseId);

        try {
            this.courseService.delCourse(courseId);
            return new ResponseEntity<>(HttpStatus.OK);


        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //Update Course as passed by user\
    @RequestMapping(path = "/courses", method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course c) {
        return this.courseService.updateCourse(c);
    }


}
