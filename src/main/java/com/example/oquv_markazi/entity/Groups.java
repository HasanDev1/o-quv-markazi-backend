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

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Groups extends AbstractEntity {
    @NotNull
    private String name;

    @ManyToOne
    private Teachers teachers;

//    @JsonIgnore
//    @OneToMany(mappedBy = "groups")
//    List<Students>students;
}
