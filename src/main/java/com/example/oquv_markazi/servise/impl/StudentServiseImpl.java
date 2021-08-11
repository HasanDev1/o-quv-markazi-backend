package com.example.oquv_markazi.servise.impl;

import com.example.oquv_markazi.entity.Groups;
import com.example.oquv_markazi.entity.Registrated;
import com.example.oquv_markazi.entity.Students;
import com.example.oquv_markazi.payload.StudentRequest;
import com.example.oquv_markazi.repository.GroupsRepository;
import com.example.oquv_markazi.repository.RegistratedRepository;
import com.example.oquv_markazi.repository.StudentRepository;
import com.example.oquv_markazi.servise.StudentService;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class StudentServiseImpl implements StudentService {
    private final RegistratedRepository registratedRepository;
    private final StudentRepository studentRepository;
    private final GroupsRepository groupsRepository;

    public StudentServiseImpl(RegistratedRepository registratedRepository, StudentRepository studentRepository, GroupsRepository groupsRepository) {
        this.registratedRepository = registratedRepository;
        this.studentRepository = studentRepository;
        this.groupsRepository = groupsRepository;
    }

    @Override
    public boolean addStudent(UUID registeredUuid, UUID groupUuid) {
        Registrated registrated = new Registrated();
        Students students =new Students();
        registrated = registratedRepository.getById(registeredUuid);
        students.setFullName(registrated.getFullName());
        students.setPhoneNumber(registrated.getPhoneNumber());
        students.setGroups(groupsRepository.findById(groupUuid).orElseThrow(() -> new RuntimeException("bunday guruh topilmadi")));
        studentRepository.save(students);
        registratedRepository.deleteById(registeredUuid);
        return true;
    }

    @Override
    public Page<StudentRequest> findAllByPage(int page, int size) throws NotFoundException {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<StudentRequest> studentRequests = studentRepository.findAllByPage(pageRequest);
        for (int i = 0; i < studentRequests.getContent().size(); i++) {
            System.out.println(i);
            studentRequests.getContent().get(i).setGroups(getGroupsByUUID(studentRepository.getGroupUUIDByStudentUUID(studentRequests.getContent().get(i).getId())));
        }
        return studentRequests;
    }


    public Groups getGroupsByUUID(String uuid){
        return groupsRepository.getById(UUID.fromString(uuid));
    }
}
