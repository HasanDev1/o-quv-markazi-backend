package com.example.oquv_markazi.entity;

import com.example.oquv_markazi.entity.abstractEntity.AbstractEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Registrated extends AbstractEntity {
    @NotNull
    private String fullName;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String courseType;
}
