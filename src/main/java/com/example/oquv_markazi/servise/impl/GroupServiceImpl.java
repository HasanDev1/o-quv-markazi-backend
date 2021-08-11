package com.example.oquv_markazi.servise.impl;

import com.example.oquv_markazi.entity.Groups;
import com.example.oquv_markazi.payload.GroupRequest;
import com.example.oquv_markazi.repository.GroupsRepository;
import com.example.oquv_markazi.repository.TeachersRepository;
import com.example.oquv_markazi.servise.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupsRepository groupsRepository;
    private final TeachersRepository teachersRepository;

    public GroupServiceImpl(GroupsRepository groupsRepository, TeachersRepository teachersRepository) {
        this.groupsRepository = groupsRepository;
        this.teachersRepository = teachersRepository;
    }

    @Override
    public boolean addGroup(GroupRequest groupRequest) {
        Groups groups = new Groups();
        groups.setName(groupRequest.getName());
        groups.setTeachers(teachersRepository.findById(groupRequest.getTeacherId()).orElseThrow(() -> new RuntimeException("not found Teacher")));
        groupsRepository.save(groups);
        return true;
    }
}
