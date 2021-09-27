package com.msb.mapper;

import com.msb.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    List<Emp> findAll();


    /**
     * 根据员工名字模糊匹配多个员工信息
     * @param ename
     * @return
     */
    List<Emp> findByEname(String ename);

    /**
     *
     * @param emp
     * @return
     */
    int addEmp(Emp emp);

    int updateEnameByEmpno(@Param("empno") int emp, @Param("ename") String ename);

    int deleteByEmpno(int emono);

}
