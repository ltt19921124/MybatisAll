package com.msb.test;

import com.msb.mapper.EmpMapper;
import com.msb.mapper.EmpMapper2;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        sqlSession = factory.openSession();
    }

    @Test
    public void testFindByCondition() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEname("A");
//        emp.setEmpno(7839);
//        emp.setSal(3000.0);
//        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-04-02"));
//        emp.setHiredate(new Date());
        List<Emp> emps = mapper.findByCondition(emp);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }
    }

    @Test
    public void testFindByCondition2() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEname("A");
        emp.setEmpno(7839);
//        emp.setSal(3000.0);
//        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-04-02"));
//        emp.setHiredate(new Date());
        List<Emp> emps = mapper.findByCondition2(emp);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }
    }

    @Test
    public void testUpdateByCondition() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpno(7839);
        emp.setEname("TOM");
        emp.setSal(2350.0);
        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1984-04-02"));
//        emp.setHiredate(new Date());
        emp.setDeptno(20);
        mapper.updateEmpByCondition(emp);
        sqlSession.commit();
    }

    @Test
    public void testUpdateByCondition2() throws ParseException {
        EmpMapper2 mapper = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpno(7839);
        emp.setEname("TOM");
        emp.setSal(2350.0);
        emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse("1984-04-02"));
//        emp.setHiredate(new Date());
        emp.setDeptno(20);
        mapper.updateEmpByCondition(emp);
        sqlSession.commit();
    }

    @After
    public void release() {
        //关闭sqlSession
        sqlSession.close();
    }

}
