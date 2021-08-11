package com.example.oquv_markazi.repository;

import com.example.oquv_markazi.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
    Attachment findByHashId(String hashId);
}
