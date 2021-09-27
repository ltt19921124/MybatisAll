package com.msb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;

    //组合Emp对象的List集合
    private List<Emp> empList;

}
