package com.ljl.service;


import com.ljl.dao.DeptDao;
import com.ljl.dao.EmpDao;
import com.ljl.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DeptServiceImp implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private EmpDao empDao;

    @Override
    public void addDept(Dept dept) {
        dept.setId(UUID.randomUUID().toString());
        deptDao.add(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public void deleteDept(String id) {
        empDao.deleteByDeptId(id);
        deptDao.delete(id);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Dept queryById(String id) {
        return deptDao.queryById(id);
    }
}
