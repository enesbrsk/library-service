package com.example.library.model;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@SuperBuilder
@NoArgsConstructor
public class User extends BaseEntity{
}
