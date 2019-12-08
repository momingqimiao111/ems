package com.ljl.service;


import com.ljl.dao.EmpDao;
import com.ljl.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceImp implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> queryByDeptId(String deptId, Integer page, Integer size) {

        return empDao.queryByDeptId(deptId, (page - 1) * size, size);
    }

    @Override
    public void deleteByDeptId(String deptId) {
        empDao.deleteByDeptId(deptId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Emp queryById(String id) {
        return empDao.queryById(id);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.add(emp);
    }

    @Override
    public void updateEmp(Emp emp) {
        empDao.update(emp);
    }

    @Override
    public void deleteEmp(String id) {
        empDao.delete(id);
    }

    @Override
    public Integer getPage(String deptId, Integer size) {
        Integer count = empDao.queryCount(deptId);
        if (count == null)
            count = 0;
        Integer page = count % size == 0 ? count / size : count / size + 1;
        if (page == 0)
            page = 1;
        return page;
    }
}
