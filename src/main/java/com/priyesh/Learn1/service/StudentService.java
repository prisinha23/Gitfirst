package com.priyesh.Learn1.service;

import com.priyesh.Learn1.dto.StudentDto;
import com.priyesh.Learn1.dto.StudentExistingDto;
import com.priyesh.Learn1.dto.StudentNewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    StudentDto addStudent(StudentNewDto studentNewDto);
    StudentDto updateStudent(StudentExistingDto studentExistingDto);
    void deleteStudent(Integer studentId);
    StudentDto getStudentByID(Integer studentId);
    Page<StudentDto> getAllStudents(Pageable pageable);
}
