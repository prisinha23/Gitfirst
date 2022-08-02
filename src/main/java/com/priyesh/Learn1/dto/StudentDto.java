package com.priyesh.Learn1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String courseName;
    private LocalDateTime created;
    private LocalDateTime modified;
}
