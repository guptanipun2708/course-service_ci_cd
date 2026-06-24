package org.example.courseservice.service;


import org.example.courseservice.dto.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final List<Course> courses=new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
    }

    public List<Course> getAllCourses(){
        return courses;
    }
    public Optional<Course> getCourseById(int id) {
        return courses.stream()
                .filter(course->course.getId()==id)
                .findFirst();
    }

    public boolean updateCourse(int id, Course course) {
        return getCourseById(id).map(existingCourse -> {
            courses.remove(existingCourse);
            courses.add(course);
            return true;
        }).orElse(false);
    }

    public boolean deleteCourse(int id){
        return courses.removeIf(course-> course.getId()==id);
    }
}
