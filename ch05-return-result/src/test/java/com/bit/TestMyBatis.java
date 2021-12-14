package com.bit;

import com.bit.dao.StudentDao;

import com.bit.domain.MyStudent;
import com.bit.domain.Student;
import com.bit.utils.MyBatisUtils;
import com.bit.vo.QueryParam;
import com.bit.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void selectStudentById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1002);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectMultiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("李四", 20);
        for (Student stu:
             students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectViewStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent student = dao.selectStudentReturnViewStudent(1005);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectCount(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int counts = dao.countStudent();
        System.out.println(counts);
        sqlSession.close();
    }

    //返回Map
    @Test
    public void testSelectMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println(map);
        sqlSession.close();
    }

    //==============================resultMap
    @Test
    public void testSelectAllStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudent();
        System.out.println(students);
        sqlSession.close();
    }

    @Test
    public void testSelectMyStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectMyStudent();
        System.out.println(students);
        sqlSession.close();
    }

    @Test
    public void testSelectDiffColProperty(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectDiffColProperty();
        System.out.println(students);
        sqlSession.close();
    }

    //like的第一种写法
    @Test
    public void testSelectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);
        System.out.println(students);
        sqlSession.close();
    }

    //like的第二种写法
    @Test
    public void testSelectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "李";
        List<Student> students = dao.selectLikeTwo(name);
        System.out.println(students);
        sqlSession.close();
    }

}
