package com.aktheraja.demo.students;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    int insertStudents(Student student) {
        String sql ="" +
                "INSERT INTO students (" +
                "first_name, " +
                "last_name, " +
                "username ," +
                "email, "+
                "city ," +
                "state ," +
                "zip ," +
                "photo) " +
                "VALUES (?,?,?,?,?,?,?,?)";
      return  jdbcTemplate.update(
                sql,
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
}
