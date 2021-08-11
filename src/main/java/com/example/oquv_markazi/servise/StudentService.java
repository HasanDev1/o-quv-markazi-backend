package com.example.oquv_markazi.servise;

import com.example.oquv_markazi.entity.Students;
import com.example.oquv_markazi.payload.StudentRequest;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    public boolean addStudent(UUID registeredUuid, UUID groupUuid);
    public Page<StudentRequest> findAllByPage(int page, int size) throws NotFoundException;
}
