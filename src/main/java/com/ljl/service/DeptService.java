package com.ljl.service;


import com.ljl.entity.Dept;

import java.util.List;

public interface DeptService {
    void addDept(Dept dept);

    void updateDept(Dept dept);

    void deleteDept(String id);

    List<Dept> queryAll();

    Dept queryById(String id);
}
