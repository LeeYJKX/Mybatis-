package com.bit;

import com.bit.dao.StudentDao;
import com.bit.dao.impl.StudentDaoImpl;
import com.bit.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        /*
        * com.bit.dao.StudentDao
        *
        * 1.dao对象，类型是StudentDao，全限定名称是:com.bit.dao.StudentDao  和namespace一样
        *
        * 2.方法名称，selectStudents,这个方法就是mapper文件中的id值selectStudents
        *
        * 3.通过dao中方法的返回值也可以确定mybatis要调用的Sqlsession方法，
        * 如果weiList，调用的是Sqlsession.selectList()方法
        * 如果返回值int，或者是非List的，看mapper文件中的标签是<insert>还是<update>就会调用对应方法
        *
        * mybatis的动态代理：mybatis根据dao的方法调用，获取执行sql的语句信息
        *   mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象.
        *   完成SqlSession调用方法，访问数据库。
        * */
        for (Student stu:
             studentList) {
            System.out.println(stu);
        }
    }

    @Test
    public void testInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        int nums = dao.insertStudent(new Student(1005, "盾山", "dunshan@qq.com",20));
        System.out.println(nums);
    }
}
