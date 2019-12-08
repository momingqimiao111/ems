package com.ljl.controller;

import com.ljl.entity.Emp;
import com.ljl.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("emp")
public class EmpController {
    private static final Integer size = 4;
    @Autowired
    private EmpService empService;

    @RequestMapping("queryAll")
    public String queryAllByDeptId(String deptId, Model model, Integer page) {
        List<Emp> emps = empService.queryByDeptId(deptId, page, size);
        Integer maxPage = empService.getPage(deptId, size);
        model.addAttribute("emps", emps);
        model.addAttribute("maxPage", maxPage);
        return "/emp/emplist";
    }

    @RequestMapping("addEmp")
    public String addEmp(Emp emp) {
        empService.addEmp(emp);
        return "redirect:/emp/queryAll?deptId=" + emp.getDept().getId();
    }

    @RequestMapping("delete")
    public String delete(String id) {
        Emp emp = empService.queryById(id);
        empService.deleteEmp(id);
        return "redirect:/emp/queryAll?deptId=" + emp.getDept().getId();

    }

    @RequestMapping("selectOne")
    public String selectOne(String id, Model model) {
        Emp emp = empService.queryById(id);
        model.addAttribute("emp", emp);
        return "/emp/updateEmp";
    }

    @RequestMapping("update")
    public String update(Emp emp) {
        System.out.println(emp);
        empService.updateEmp(emp);
        return "redirect:/emp/queryAll?deptId=" + emp.getDept().getId();
    }

    @RequestMapping("deleteByDeptId")
    public String deleteByDeptId(String deptId) {
        empService.deleteByDeptId(deptId);
        return "redirect:/dept/queryAll";
    }
}
