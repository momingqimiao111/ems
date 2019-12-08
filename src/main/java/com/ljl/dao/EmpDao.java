package com.ljl.dao;


import com.ljl.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EmpDao extends BaseDao<Emp> {
    List<Emp> queryByDeptId(@Param("deptId") String deptId,
                            @Param("begin") Integer begin,
                            @Param("size") Integer size);

    void deleteByDeptId(String deptId);

    Integer queryCount(String deptId);
}
