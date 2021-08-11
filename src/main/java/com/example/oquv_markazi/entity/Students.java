package com.example.oquv_markazi.entity;

import com.example.oquv_markazi.entity.abstractEntity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Students extends AbstractEntity {
    @NotNull
    private String fullName;

    @NotNull
    private String phoneNumber;

    @ManyToOne
    private Groups groups;
//
//    @OneToMany(mappedBy = "students")
//    List<Payment> payments;
}
