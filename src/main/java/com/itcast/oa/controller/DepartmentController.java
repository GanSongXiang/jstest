package com.itcast.oa.controller;

import com.itcast.oa.domain.Department;
import com.itcast.oa.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ichoice on 2017/2/18.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    IDepartmentService departmentService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Department> getALL(){
        return departmentService.getAll();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void deleteDepart(Long id){
        departmentService.delete(id);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(Department department){
        departmentService.save(department);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public void update(Department department){
        departmentService.update(department);
    }
}
