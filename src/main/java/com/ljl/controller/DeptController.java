package com.ljl.controller;


import com.ljl.entity.Dept;
import com.ljl.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("queryAll")
    public String queryAll(Model model) {
        List<Dept> depts = deptService.queryAll();
        model.addAttribute("depts", depts);
        return "dept/deptlist";
    }

    @RequestMapping("selectOne")
    public String selectOne(String id, Model model) {
        Dept dept = deptService.queryById(id);
        model.addAttribute("dept", dept);
        return "dept/updateDept";
    }

    @RequestMapping("update")
    public String update(Dept dept) {
        deptService.updateDept(dept);
        return "redirect:/dept/queryAll";
    }

    @RequestMapping("delete")
    public String delete(String id) {
        deptService.deleteDept(id);
        return "redirect:/dept/queryAll";
    }

    @RequestMapping("addDept")
    public String addDept(Dept dept) {
        deptService.addDept(dept);
        return "redirect:/dept/queryAll";
    }

    @RequestMapping("getDept")
    @ResponseBody
    public List<Dept> getDept() {
        List<Dept> depts = deptService.queryAll();
        return depts;
    }

}
