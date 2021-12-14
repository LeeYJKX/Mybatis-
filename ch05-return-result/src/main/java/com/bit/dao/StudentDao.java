package com.bit.dao;

import com.bit.domain.MyStudent;
import com.bit.domain.Student;
import com.bit.vo.QueryParam;
import com.bit.vo.ViewStudent;
import com.sun.xml.internal.ws.server.ServerRtException;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student selectStudentById(Integer id);

    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);


    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

    int countStudent();

    //定义一个方法，返回map
    Map<Object,Object> selectMapById(Integer id);

    /*
    * 使用resultMap定义映射关系
    * */
    List<Student> selectAllStudent();

    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffColProperty();

    /*第一种模糊查询,在java代码中来指定like的内容*/
    List<Student> selectLikeOne(String name);
    /*name就是“李”,在mapper中拼接这个like "%" 李 "%"*/
    List<Student> selectLikeTwo(String name);
}
