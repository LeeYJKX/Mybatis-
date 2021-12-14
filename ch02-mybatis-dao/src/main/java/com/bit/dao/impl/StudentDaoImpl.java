package com.bit.dao.impl;

import com.bit.dao.StudentDao;
import com.bit.domain.Student;
import com.bit.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int insertStudent(Student student) {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bit.dao.StudentDao.insertStudent";
        //执行sql语句
        int nums = sqlSession.insert(sqlId, student);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        return nums;
    }

    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.bit.dao.StudentDao.selectStudents";
        //执行sql语句
        List<Student> students = sqlSession.selectList(sqlId);

        sqlSession.close();
        return students;
    }


}
