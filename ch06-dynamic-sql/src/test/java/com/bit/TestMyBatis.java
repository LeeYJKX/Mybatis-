package com.bit;

import com.bit.dao.StudentDao;

import com.bit.domain.Student;
import com.bit.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void testSelectStudentIf(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students = dao.selectStudentIf(student);
        for (Student stu:
             students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testfor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        //String sql = "select * from student where id in (1001,1002,1003)";
        String sql = "select * from student where id in";

        StringBuilder builder = new StringBuilder("");
        int init=0;
        int length = list.size();
        builder.append("(");
        for(Integer i:list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        sql = sql + builder.toString();
        System.out.println(sql);
    }


    @Test
    public void testSelectForeach(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        List<Student> students = dao.selectForeachOne(list);
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectForTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> stulist = new ArrayList<>();
        Student s1=new Student();
        Student s2=new Student();
        s1.setId(1002);
        s2.setId(1005);
        stulist.add(s1);
        stulist.add(s2);
        List<Student> students = dao.selectForeachTwo(stulist);
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectAllPageHelper(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //加入PageHelper的分页

        PageHelper.startPage(1,3);//第几页，每页有几行


        List<Student> students = dao.selectAll();
        for (Student stu:
                students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

}
