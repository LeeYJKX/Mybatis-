package com.bit.dao;

//接口 操作Student表

import com.bit.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询Student表的所有数据
    public List<Student> selectStudents();

    //插入方法 返回影响数据库的行数
    public int insertStudent(Student student);
}
