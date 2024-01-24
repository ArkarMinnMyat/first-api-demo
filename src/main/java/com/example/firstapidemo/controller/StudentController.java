package com.example.firstapidemo.controller;

import com.example.firstapidemo.dto.StudentDto;
import com.example.firstapidemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student/student-list")
    public List<StudentDto> listAllStudent(){
        return studentService.listAllStudent();
    }
    @GetMapping("/student")
    public ResponseEntity<StudentDto> findStudent(@RequestParam int id){
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }
}
