package com.example.oquv_markazi.entity;

import com.example.oquv_markazi.entity.abstractEntity.AbstractEntity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment extends AbstractEntity {
    @NotNull
    private Double amount;
    @NotNull
    private String comment;

    @NotNull
    private String responsible;

    @ManyToOne
    private Students students;

}
