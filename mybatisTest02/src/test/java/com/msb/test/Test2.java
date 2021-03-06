package com.msb.test;

import com.msb.mapper.DeptMapper;
import com.msb.mapper.EmpMapper;
import com.msb.pojo.Dept;
import com.msb.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test2 {

    private SqlSession sqlSession;

    @Before
    public void init() {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);
        sqlSession = factory.openSession();
    }
    @Test
    public void testAddDept() {
        DeptMapper deptmapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"JAVA","北京");
        System.out.println(dept.getDeptno());
        deptmapper.addDept(dept);
        sqlSession.commit();
        System.out.println(dept.getDeptno());

    }

    @Test
    public void testAddDept2() {
        DeptMapper deptmapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null,"JAVA","北京");
        System.out.println(dept.getDeptno());
        deptmapper.addDept(dept);
        sqlSession.commit();
        System.out.println(dept.getDeptno());

    }



    @After
    public void release() {
        //关闭sqlSession
        sqlSession.close();
    }

}
