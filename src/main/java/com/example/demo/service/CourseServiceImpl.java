package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.Course;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public String upsert(Course course) {
        Course savedCourse = courseRepo.save(course);
        if (savedCourse.getCid() != null) {
            return "Course with id " + savedCourse.getCid() + " is saved successfully.";
        } else {
            return "Failed to save the course.";
        }
    }

    @Override
    public Course getById(Integer cid) {
         Optional<Course> findById = courseRepo.findById(cid);
            if(findById.isPresent()) {
                return findById.get();
            } 
            return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public String deleteById(Integer cid) {
        if (courseRepo.existsById(cid)) {
            courseRepo.deleteById(cid);
            return "Course with id " + cid + " is deleted successfully.";
        } else {
            return "Course with id " + cid + " does not exist.";
        }
    }

}
