package com.example.oquv_markazi.payload;

import com.example.oquv_markazi.entity.Attachment;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRequest {

    private String name;

    @Column(columnDefinition = "TEXT")
    private String Description;

    private UUID attachmentId;
}
