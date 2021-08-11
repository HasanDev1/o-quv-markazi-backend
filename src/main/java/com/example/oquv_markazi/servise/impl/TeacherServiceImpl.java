package com.example.oquv_markazi.servise.impl;

import com.example.oquv_markazi.entity.Teachers;
import com.example.oquv_markazi.payload.TeacherRequest;
import com.example.oquv_markazi.repository.TeachersRepository;
import com.example.oquv_markazi.servise.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeachersRepository teachersRepository;
    @Override
    public boolean addTeacher(TeacherRequest teacherRequest) {
        Teachers teachers = new Teachers();
        teachers.setName(teacherRequest.getName());
        teachersRepository.save(teachers);
        return true;
    }
}
