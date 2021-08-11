package com.example.oquv_markazi.entity;

import com.example.oquv_markazi.entity.abstractEntity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Teachers extends AbstractEntity {
    private String name;
//
//    @OneToMany(mappedBy = "teachers")
//    List<Groups> groups;

}
