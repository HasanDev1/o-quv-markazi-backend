package com.example.oquv_markazi.repository;

import com.example.oquv_markazi.entity.Groups;
import com.example.oquv_markazi.entity.Students;
import com.example.oquv_markazi.payload.StudentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Students, UUID> {
    @Query("select new com.example.oquv_markazi.payload.StudentRequest(s.id, s.fullName, s.phoneNumber, s.groups) from Students s")
    Page<StudentRequest>findAllByPage(Pageable pageable );

    @Query(value = "select CAST(s.groups_id as varchar) groups_id from students s where s.id = ?1", nativeQuery = true)
    String getGroupUUIDByStudentUUID(UUID studentUUID);

}
