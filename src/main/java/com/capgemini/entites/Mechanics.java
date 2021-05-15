package com.capgemini.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

import lombok.Data;

@Entity
@Data
public class Mechanics {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int Mechanics_id;
@Column(nullable=false)
private String Mechanics_name;
@Column(nullable=false)
private int Mechanics_age;
@Column(nullable=false,length=10)
private String Mechanics_mobile;
private LocalDate JoiningDate=LocalDate.now();
}
