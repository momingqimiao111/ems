package com.ljl.controller;

import com.ljl.entity.City;
import com.ljl.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("queryAll")
    public String queryAll(Model model) {
        List<City> cities = cityService.queryAll();
        model.addAttribute("cities", cities);
        return "city";
    }

    @RequestMapping("hello")
    public String hello(HttpServletRequest request) {
        request.getSession().getServletContext().getMimeType(".png");
        return "index";
    }
}
