package com.wang.crud.controller;

import com.wang.crud.bean.Dept;
import com.wang.crud.bean.Msg;
import com.wang.crud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zsw
 * @create 2021-12-03 17:03
 */
@Controller
public class DeptController {
    @Autowired
    DeptService deptService;
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getAllDept(){
        List<Dept> depts = deptService.getDepts();
        return Msg.success().add("dept",depts);
    }
}
