package com.ljl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("upload")
public class UploadController {
    @RequestMapping("upload")
    public String upload(MultipartFile aaa, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/files");
        aaa.transferTo(new File(realPath, aaa.getOriginalFilename()));
        return "redirect:/index.jsp";
    }
}
