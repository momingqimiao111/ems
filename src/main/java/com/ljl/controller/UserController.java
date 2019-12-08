package com.ljl.controller;

import com.ljl.entity.User;
import com.ljl.service.UserService;
import com.ljl.util.SecurityCode;
import com.ljl.util.SecurityImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getCode")
    public String getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String securityCode = SecurityCode.getSecurityCode();
        HttpSession session = request.getSession();
        session.setAttribute("securityCode", securityCode);
        BufferedImage createImage = SecurityImage.createImage(securityCode);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(createImage, "png", outputStream);
        return null;
    }

    @RequestMapping("regist")
    public String regist(User user, String code, HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
        String securityCode = (String) session.getAttribute("securityCode");
        if (securityCode.equalsIgnoreCase(code)) {
            try {
                userService.regist(user);
                return "redirect:/user/login.jsp";
            } catch (Exception e) {
                return "redirect:/user/regist.jsp?errormsg=" + URLEncoder.encode(e.getMessage(), "UTF-8");
            }

        } else {
            return "redirect:/user/regist.jsp?errormsg=" + URLEncoder.encode("验证码错误!", "UTF-8");
        }
    }

    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
        try {
            User user = userService.login(username, password);
            session.setAttribute("user", user);
            return "redirect:/dept/queryAll";
        } catch (Exception e) {
            return "redirect:/user/login.jsp?errormsg=" + URLEncoder.encode(e.getMessage(), "UTF-8");
        }
    }

}
