package com.priyesh.Learn1.service;

import com.priyesh.Learn1.EntityClass.StudentEntity;
import com.priyesh.Learn1.dto.StudentDto;
import com.priyesh.Learn1.dto.StudentExistingDto;
import com.priyesh.Learn1.dto.StudentNewDto;
import com.priyesh.Learn1.exception.ResourceNotFoundException;
import com.priyesh.Learn1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto addStudent(StudentNewDto studentNewDto) {
        StudentEntity student=new StudentEntity();
        student.setId(studentNewDto.getId());
        student.setFirst_name(studentNewDto.getFirstName());
        student.setLast_name(studentNewDto.getLastName());
        student.setEmail_id(studentNewDto.getEmail());
        student.setContact_number(studentNewDto.getContactNumber());
        student.setCourse_name(studentNewDto.getCourseName());

        student = studentRepository.save(student);

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirst_name());
        studentDto.setLastName(student.getLast_name());
        studentDto.setEmail(student.getEmail_id());
        studentDto.setContactNumber(student.getContact_number());
        studentDto.setCourseName(student.getCourse_name());
        studentDto.setCreated(student.getCreated());
        studentDto.setModified(student.getModified());
        return studentDto;
    }

    @Override
    public StudentDto updateStudent(StudentExistingDto studentExistingDto) {
        Optional<StudentEntity> studentOpt= studentRepository.findById(studentExistingDto.getId());
        if (studentOpt.isPresent()){
            throw new ResourceNotFoundException("Student not found");
        }
        StudentEntity student = studentOpt.get();
        student.setFirst_name(studentExistingDto.getFirstName());
        student.setLast_name(studentExistingDto.getLastName());
        student.setEmail_id(studentExistingDto.getEmail());
        student.setContact_number(studentExistingDto.getContactNumber());
        student.setCourse_name(studentExistingDto.getCourseName());

        student = studentRepository.save(student);

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirst_name());
        studentDto.setLastName(student.getLast_name());
        studentDto.setEmail(student.getEmail_id());
        studentDto.setContactNumber(student.getContact_number());
        studentDto.setCourseName(student.getCourse_name());
        studentDto.setCreated(student.getCreated());
        studentDto.setModified(student.getModified());
        return studentDto;
    }

    @Override
    public void deleteStudent(Integer studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }
        Optional<StudentEntity> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        studentRepository.deleteById(studentId);

    }

    @Override
    public StudentDto getStudentByID(Integer studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("studentId must not be null");
        }

        Optional<StudentEntity> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        StudentEntity student = studentOpt.get();

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirst_name());
        studentDto.setLastName(student.getLast_name());
        studentDto.setEmail(student.getEmail_id());
        studentDto.setContactNumber(student.getContact_number());
        studentDto.setCourseName(student.getCourse_name());
        studentDto.setCreated(student.getCreated());
        studentDto.setModified(student.getModified());
        return studentDto;
    }

    @Override
    public Page<StudentDto> getAllStudents(Pageable pageable) {
        Page<StudentEntity> studentsPage = studentRepository.findAll(pageable);

        List<StudentDto> studentsDto = new ArrayList<>();
        Page<StudentDto> studentsDtoPage = new PageImpl<>(studentsDto, pageable, 0);

        if (studentsPage != null && !studentsPage.isEmpty()) {

            studentsPage.getContent().forEach(student -> {
                StudentDto studentDto = new StudentDto();
                studentDto.setId(student.getId());
                studentDto.setFirstName(student.getFirst_name());
                studentDto.setLastName(student.getLast_name());
                studentDto.setEmail(student.getEmail_id());
                studentDto.setContactNumber(student.getContact_number());
                studentDto.setCourseName(student.getCourse_name());
                studentDto.setCreated(student.getCreated());
                studentDto.setModified(student.getModified());

                studentsDto.add(studentDto);
            });
            studentsDtoPage =
                    new PageImpl<>(studentsDto, pageable, studentsPage.getTotalElements());
        }
        return studentsDtoPage;
    }
}
