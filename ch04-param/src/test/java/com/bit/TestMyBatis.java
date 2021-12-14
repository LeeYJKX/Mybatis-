package com.bit;

import com.bit.dao.StudentDao;

import com.bit.domain.Student;
import com.bit.utils.MyBatisUtils;
import com.bit.vo.QueryParam;
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
    public void testSelectMultiObject(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiObject(new QueryParam("张三",28));
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("张三");
        student.setAge(28);
        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiPosition(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiPosition("李四",20);
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiByMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<String,Object> data = new HashMap<>();
        data.put("myname","张三");
        data.put("age",28);

        List<Student> students = dao.selectMultiByMap(data);
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUse$(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);



        List<Student> students = dao.selectUse$("'李四'");//${}的原理是连接字符串，#{}是利用?做占位符
        //List<Student> students = dao.selectUse$("';dropt table student;'");//${}的原理是连接字符串，安全隐患   #{}是利用?做占位符,
        //List<Student> students = dao.selectUse$("'李四';dropt table student;");//${}的原理是连接字符串，#{}是利用?做占位符
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUse$Order(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$Order("email");
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }


}
