package com.bit.dao;

import com.bit.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();

    int insertStudent(Student student);
}
