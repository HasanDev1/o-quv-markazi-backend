package com.example.oquv_markazi.payload;

import com.example.oquv_markazi.entity.Groups;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequest {
    private UUID id;

    private String fullName;

    private String phoneNumber;

    public StudentRequest(UUID id, String fullName, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    private Groups groups;
}
