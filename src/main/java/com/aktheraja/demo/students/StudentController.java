package com.aktheraja.demo.students;

import com.aktheraja.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/student")
public class StudentController {
        private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public void saveStudents(@RequestParam("imageFile") MultipartFile imageFile,Student student ) {
        System.out.println(imageFile.getOriginalFilename());
       try{
        studentService.saveStudents(imageFile,student);}
       catch (ApiRequestException e){
           throw new ApiRequestException(e.getMessage() + "can not save details");
       }

    }
}
