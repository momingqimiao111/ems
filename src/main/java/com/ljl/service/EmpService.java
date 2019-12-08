package com.ljl.service;


import com.ljl.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> queryByDeptId(String deptId, Integer page, Integer size);

    void deleteByDeptId(String deptId);

    Emp queryById(String id);

    void addEmp(Emp emp);

    void updateEmp(Emp emp);

    void deleteEmp(String id);

    Integer getPage(String deptId, Integer size);
}
