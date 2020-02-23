package com.aktheraja.demo.students;

import com.aktheraja.demo.exception.ApiRequestException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Component
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    int insertStudents(UUID studentId,Student student) {
        String sql ="" +
                "INSERT INTO students (" +
                "studentId," +
                "first_name, " +
                "last_name, " +
                "username ," +
                "email, "+
                "city ," +
                "state ," +
                "zip ," +
                "photo) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
      return  jdbcTemplate.update(
                sql,
                studentId,
                student.getFirstName(),
                student.getLastName(),
                student.getUserName(),
                student.getEmail(),
                student.getCity(),
                student.getZip(),
                student.getState(),
                student.getPhotoUrl()
                );
    }
    boolean isUserNameTaken(String username){
        String sql = "SELECT EXISTS (SELECT 1 FROM students WHERE username = ?)";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{username},
                ((resultSet, i) -> resultSet.getBoolean(1))
        );
    }

    void savePhotoImage(Student student,MultipartFile imageFile) {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        student.setPath(absolutePath + "/src/main/resources/static/photo/"+ imageFile.getOriginalFilename());
        try {
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(student.getPhotoUrl() );
            Files.write(path,bytes);
        }
        catch (IOException e){
            throw new  ApiRequestException(e.getMessage() + "photo an not be saved");
        }
    }
}

