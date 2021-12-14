package com.bit.dao;

import com.bit.domain.Student;
import com.bit.vo.QueryParam;
import com.sun.xml.internal.ws.server.ServerRtException;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public Student selectStudentById(Integer id);

    /*多个参数
    * 命名参数，在形参定义的前面加入@Param("自定义参数名称")
    * */
    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);

    /*
    * 多个参数，使用java对象作为接口中方法参数
    * */
    List<Student> selectMultiObject(QueryParam param);

    List<Student> selectMultiStudent(Student student);

    /*
    * 多个参数-简单类型的，按位置传值
    mybatis 3.4之前 使用#{0},#{1}
    之后 #{arg0},#{arg1}
     */

    List<Student> selectMultiPosition(String name,Integer age);

    /*
    多个参数，使用Map存放多个值*/
    List<Student> selectMultiByMap(Map<String,Object> map);

    List<Student> selectUse$(@Param("myname") String name);

    List<Student> selectUse$Order(@Param("colName") String colName);
}
