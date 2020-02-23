package com.aktheraja.demo.students;

import com.aktheraja.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentDao studentDao;
    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    void saveStudents(MultipartFile imageFile,Student student) {

      saveStudents(imageFile,null,student);
    }
    void saveStudents(MultipartFile imageFile,UUID studentId,Student student){
        UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());
        studentDao.savePhotoImage(student, imageFile);
        studentDao.insertStudents(newStudentId,student);
        if(studentDao.isUserNameTaken( student.getUserName())){
            throw new ApiRequestException(student.getUserName() + " is taken");
        }

    }
}
