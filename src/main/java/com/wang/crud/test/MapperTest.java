package com.wang.crud.test;

import com.wang.crud.bean.Dept;
import com.wang.crud.bean.Employee;
import com.wang.crud.dao.DeptMapper;
import com.wang.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author zsw
 * @create 2021-11-30 20:07
 */
    /*
    1.推荐使用spring的单元测试，可以自动注入我们需要的组件
   2. @ContextConfiguration指定spring配置文件的位置
   3.直接使用autowired自动注入组件即可
    * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
//    @Autowired
//    DeptMapper deptMapper;
//    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
//    测试DepartmentMapper
    public void test(){
//     创建springIoc容器
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        从容器中获取mapper
        DeptMapper deptMapper = ioc.getBean(DeptMapper.class);
        System.out.println(deptMapper);
        employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
//        deptMapper.insertSelective(new Dept(null,"开发部"));
//        deptMapper.insertSelective(new Dept(null,"策划部"));
        int flag=0;
        for (int i = 0; i < 1000; i++) {
            String substring = UUID.randomUUID().toString().substring(0, 4);
            String name =substring +i;
            if (flag==0){
                employeeMapper.insertSelective(new Employee(null, substring +i, "M", substring +i+"@wang.com", 1));
                flag=1;
            }
            else {
                employeeMapper.insertSelective(new Employee(null, substring +i, "W", substring +i+"@wang.com", 2));
                 flag=0;
            }

        }
        System.out.println("批量完成");

    }


}
