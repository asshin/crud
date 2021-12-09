package com.wang.crud.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.crud.bean.Employee;
import com.wang.crud.bean.Msg;
import com.wang.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zsw
 * @create 2021-12-01 11:40
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/")
    public  String index(){
//返回请求名
        return "index";
    }

      @RequestMapping("/emps")
      @ResponseBody
      public Msg getEmpsWithJson(@RequestParam(value ="pn",defaultValue = "1")Integer pn){
          PageHelper.startPage(pn,5);
          List<Employee> list = employeeService.getAll();
          System.out.println(employeeService);

          PageInfo page = new PageInfo(list, 5);

          System.out.println(page.getNavigatepageNums().toString());
          System.out.println(Msg.success().add("pageInfo", page));
          return  Msg.success().add("pageInfo",page);
      }

      @RequestMapping(value="/saveEmp",method= RequestMethod.POST)
      @ResponseBody
      public  Msg saveEmp(Employee employee){
        employeeService.saveEmp(employee);

        return  Msg.success();
      }
//    @RequestMapping("/emps1")
//    public String getemps(@RequestParam(value ="pn",defaultValue = "1")Integer pn, Model model){
//        List<Employee> list = employeeService.getAll();
//        PageHelper.startPage(1,5);
//        PageInfo page = new PageInfo(list, 5);
//        model.addAttribute("pageInfo",page);
//        System.out.println("successful");
//        return "list";
//    }

}
