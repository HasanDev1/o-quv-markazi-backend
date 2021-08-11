package com.example.oquv_markazi.servise.impl;

import com.example.oquv_markazi.entity.Course;
import com.example.oquv_markazi.payload.CourseRequest;
import com.example.oquv_markazi.repository.AttachmentRepository;
import com.example.oquv_markazi.repository.CourseRepository;
import com.example.oquv_markazi.servise.CourseServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseServise {
    private final AttachmentRepository attachmentRepository;
    private final CourseRepository courseRepository;
    @Override
    public boolean addCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setAttachment(attachmentRepository.getById(courseRequest.getAttachmentId()));
        courseRepository.save(course);
        return true;
    }
}
