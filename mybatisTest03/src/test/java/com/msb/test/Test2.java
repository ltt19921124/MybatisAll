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
import java.text.ParseException;
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

    /*@Test
    public void testOnetoOne() throws ParseException {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.findEmpJoinDeptByEmpno(7499);
        System.out.println(emp);
    }
*/
    @Test
    public void test() {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp byEmpno = mapper.findByEmpno(7654);
        System.out.println(byEmpno);

        EmpMapper mapper2 = sqlSession.getMapper(EmpMapper.class);
        Emp byEmpno2 = mapper2.findByEmpno(7654);
        System.out.println(byEmpno);

        System.out.println(byEmpno==byEmpno2);
        System.out.println(mapper==mapper2);

    }

    @After
    public void release() {
        //关闭sqlSession
        sqlSession.close();
    }

}
