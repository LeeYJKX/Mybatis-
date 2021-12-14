package com.bit;

import com.bit.dao.StudentDao;

import com.bit.domain.Student;
import com.bit.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelectStudents(){
        /*
        * 使用mybatis动态代理机制，使用SqlSession.getMapper(dao接口)
        * getMapper能获取dao接口对应的实现类对象.
        * */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //dao实现类对象
        List<Student> students = dao.selectStudents();
        for (Student stu:
             students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int nums = dao.insertStudent(new Student(1006, "李飞", "lifei@qq.com", 28));

        sqlSession.commit();
        System.out.println(nums);
        sqlSession.close();
    }
}
