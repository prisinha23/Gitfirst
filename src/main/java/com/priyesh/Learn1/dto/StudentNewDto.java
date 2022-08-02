package com.priyesh.Learn1.dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class StudentNewDto {

    private Integer id;
    @NotNull(message = "first name cannot be empty")
    @Size(min = 2 ,max=30 ,message = "first name must have 2 minimum and 30 max length")
    private String firstName;

    @NotNull(message = "last name cannot be empty")
    @Size(min = 2 ,max=30 ,message = "last name must have 2 minimum and 30 max length")
    private String lastName;
    @NotNull(message = "email cannot be empty")
    @Email
    private String email;
    private String contactNumber;
    private String courseName;
    private LocalDateTime created;
    private LocalDateTime modified;
}
