package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@SuperBuilder
@Getter
@NoArgsConstructor
public class Category extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> books;

}
