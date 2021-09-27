package com.msb.mapper;

import com.msb.pojo.Dept;

public interface DeptMapper {

    Dept findDeptJoinEmpsByDeptno(int deptno);

}
