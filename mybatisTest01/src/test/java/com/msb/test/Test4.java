package com.msb.test;

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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 {

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
        sqlSession = factory.openSession(true);
    }

    @Test
    public void testInsert() {
//        Emp emp = new Emp(null,"按住","SALESMAN",7839,new Date(),3100.0,200.0,10);
        Emp emp = new Emp(null,"anan2","SALESMAN",7936,new Date(),1300.0,200.0,10);
        int rows = sqlSession.insert("addEmp", emp);
        System.out.println(rows);
    }

    @Test
    public void testUpdate() {
//        Emp emp = new Emp(null,"按住","SALESMAN",7839,new Date(),3100.0,200.0,10);
        Emp emp = new Emp();
        emp.setEname("明明");
        emp.setEmpno(7934);
        int rows = sqlSession.insert("updateEmp", emp);
        System.out.println(rows);
    }

    @Test
    public void delete() {

        int rows = sqlSession.delete("deleteEmp", 7936);
        System.out.println(rows);

    }


    @After
    public void release() {
        //关闭sqlSession
        sqlSession.close();
    }

}
