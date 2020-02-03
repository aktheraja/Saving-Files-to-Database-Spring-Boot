package com.aktheraja.demo.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentDao studentDao;
    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void saveStudents(Student student) {
        if(studentDao.isUserNameTaken( student.getUserName())){

        }
        studentDao.insertStudents(student);
    }
}
