package com.msb.mapper;

import com.msb.pojo.Emp;

import java.util.List;

public interface EmpMapper2 {

    List<Emp> findByCondition(Emp emp);
    List<Emp> findByCondition2(Emp emp);
    int updateEmpByCondition(Emp emp);
    int updateEmpByCondition2(Emp emp);
}
