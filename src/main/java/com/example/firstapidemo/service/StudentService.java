package com.example.firstapidemo.service;

import com.example.firstapidemo.dao.StudentDao;
import com.example.firstapidemo.dto.StudentDto;
import com.example.firstapidemo.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;

    public void createStudent(StudentDto studentDto){
        studentDao.save(toEntity(studentDto));
    }

    public List<StudentDto> listAllStudent(){
        return studentDao.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public StudentDto getStudentById(int id){
        return toDto(studentDao.findById(id).orElseThrow());
    }

    private StudentDto toDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getSchool()
        );
    }

    private Student toEntity(StudentDto studentDto){
        return new Student(
                studentDto.firstName(),
                studentDto.lastName(),
                studentDto.email(),
                studentDto.school());
    }

}
