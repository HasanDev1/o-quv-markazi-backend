package com.example.oquv_markazi.repository;

import com.example.oquv_markazi.entity.Admin;
import com.example.oquv_markazi.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, UUID> {
}
