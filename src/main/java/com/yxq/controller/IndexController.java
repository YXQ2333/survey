package com.yxq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author yxq
 * @date 2020/7/26 3:29
 */
@Controller
public class IndexController {
    // 加载初始化json文件
    @Value("classpath:init.json")
    private Resource resource;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/menu")
    @ResponseBody
    public void menu(HttpServletResponse response) {
        BufferedReader bufferedReader = null;
        try {
            File file = resource.getFile();
            bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
//            System.out.println(sb.toString());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
