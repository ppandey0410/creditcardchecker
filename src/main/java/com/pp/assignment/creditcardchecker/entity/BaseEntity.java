package com.pp.assignment.creditcardchecker.entity;

import lombok.Getter;
import javax.persistence.*;

@Entity
@Getter
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
}
