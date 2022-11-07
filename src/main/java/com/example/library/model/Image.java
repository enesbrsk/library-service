package com.example.library.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "images")
@Getter
@SuperBuilder
@NoArgsConstructor
public class Image extends BaseEntity {

    private String imageUrl;


}
