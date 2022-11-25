package com.example.library.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "images")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseEntity{
    private String imageUrl;
}

